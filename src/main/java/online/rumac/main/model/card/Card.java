package online.rumac.main.model.card;

import java.util.Objects;

public class Card {
    private final Suit suit;
    private final CardValue cardValue;

    private Card(CardValue cardValue, Suit suit) {
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public static Card build(CardValue cardValue, Suit suit) {
        return new Card(cardValue, suit);
    }

    public static Card build(String valueSuit) {
        String valueStr = valueSuit.substring(0, valueSuit.length() - 1);
        String suitStr = valueSuit.substring(valueSuit.length() - 1);

        CardValue value;
        try {
            value = CardValue.valueOf(valueStr);
        } catch (IllegalArgumentException e) {
            if ("T".equals(valueStr)) {
                valueStr = "10";
            }
            value = CardValue.values()[Integer.parseInt(valueStr) - 2];
        }
        Suit suit = Suit.valueOf(suitStr);
        return Card.build(value, suit);
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
                getCardValue() == card.getCardValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getCardValue());
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

}
