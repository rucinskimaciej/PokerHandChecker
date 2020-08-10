package online.rumac.main.model.card;

import online.rumac.main.model.exceptions.IllegalCardValueException;

import java.util.Objects;

public class Card {
    private final Suit suit;
    private final CardValue cardValue;

    private Card(Builder builder) {
        this.cardValue = builder.value;
        this.suit = builder.suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        String card = String.format("%s%s", cardValue.getCardValue(), suit);
        if (card.length() == 2 || card.contains(CardValue.TEN.cardValue)) {
            return card;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getSuit() == card.getSuit() &&
                getValue() == card.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getValue());
    }


    public static class Builder {

        private Suit suit;
        private CardValue value;

        public Builder suit(Suit suit) {
            this.suit = suit;
            return this;
        }

        public Builder suit(String suit) {
            Suit suitMapped = mapStringToSuit(suit);
            return suit(suitMapped);
        }

        private Suit mapStringToSuit(String suit) {
            return Suit.valueOf(suit);
        }

        public Builder value(CardValue value) {
            this.value = value;
            return this;
        }

        public Builder value(String value) throws IllegalCardValueException {
            CardValue valueMapped = mapStringToValue(value);
            return value(valueMapped);
        }

        private CardValue mapStringToValue(String value) throws IllegalCardValueException { // ON WHICH LEVEL SHOULD THIS EXCEPTION BE HANDLED WITH TRY/CATCH?
            String v = "T".equals(value) ? "10" : value;
            int index;
            try {
                if (isNumber(v)) {
                    index = Integer.parseInt(v) - 2;
                    if (index >= 0 && index <= 8) {
                        return CardValue.values()[index];
                    }
                } else {
                    return CardValue.valueOf(v);
                }
                throw new IllegalCardValueException();
            } catch (IllegalArgumentException e) {
                throw new IllegalCardValueException(String.format("%s - %s", value, "card value does not match"));
            }
        }

        private boolean isNumber(String s) {
            if (s == null) {
                return false;
            }
            try {
                int i = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
        public Builder card(Card card) {
            this.suit = card.suit;
            this.value = card.cardValue;
            return this;
        }

        public Builder card(String card) throws IllegalCardValueException {
            String suitStr = card.substring(card.length() - 1);
            String valueStr = card.substring(0, card.length() - 1);
            this.suit = suit(suitStr).suit;
            this.value = value(valueStr).value;
            return this;
        }

        public Card build() {
            return new Card(this);
        }

    }

}
