package online.rumac.main.model.card;

public enum CardValue {
    TWO ("2"),
    THREE ("3"),
    FOUR ("4"),
    FIVE ("5"),
    SIX ("6"),
    SEVEN ("7"),
    EIGHT ("8"),
    NINE ("9"),
    TEN ("10"),
    J ("J"),
    Q ("Q"),
    K ("K"),
    A ("A");

    public final String cardValue;

    CardValue(String cardValue) {
        this.cardValue = cardValue;
    }

    public String getCardValue() {
        return cardValue;
    }
}