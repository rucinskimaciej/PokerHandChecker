package online.rumac.main.controller.figure;

import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.model.card.Card;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.card.Suit;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FullHouseCheckTest {

    @Test
    void isFullHouse() {
        // given
        Card.Builder cardBuilder = new Card.Builder();

        Set<Card> cards = Set.of(
                cardBuilder.value(CardValue.FIVE).suit(Suit.H).build(),
                cardBuilder.value(CardValue.FIVE).suit(Suit.C).build(),
                cardBuilder.value(CardValue.FOUR).suit(Suit.C).build(),
                cardBuilder.value(CardValue.FOUR).suit(Suit.H).build(),
                cardBuilder.value(CardValue.FOUR).suit(Suit.S).build()
        );
        PokerHand hand = new PokerHand.Builder().build(cards);

        // when
        PokerFigure expected = PokerFigure.FULL_HOUSE;
        PokerFigure actual = hand.getPokerFigure();

        // then
        assertEquals(expected, actual);
    }

}