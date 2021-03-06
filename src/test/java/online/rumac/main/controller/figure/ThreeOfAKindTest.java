package online.rumac.main.controller.figure;

import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.model.card.Card;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.card.Suit;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeOfAKindTest {

    @Test
    void threeOfAKind() {
        // given
        Card.Builder cardBuilder = new Card.Builder();

        PokerHand hand = new PokerHand.Builder().build(Set.of(
                cardBuilder.value(CardValue.FIVE).suit(Suit.H).build(),
                cardBuilder.value(CardValue.J).suit(Suit.C).build(),
                cardBuilder.value(CardValue.FOUR).suit(Suit.C).build(),
                cardBuilder.value(CardValue.FOUR).suit(Suit.H).build(),
                cardBuilder.value(CardValue.FOUR).suit(Suit.S).build()
        ));

        // when
        PokerFigure expected = PokerFigure.THREE_OF_A_KIND;
        PokerFigure actual = hand.getPokerFigure();

        // then
        assertEquals(expected, actual);    }

}