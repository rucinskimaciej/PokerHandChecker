package online.rumac.main.controller.figure;

import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.model.card.Card;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.card.Suit;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FourOfAKindTest {

    @Test
    void fourOfAKind() {
        // given
        Card.Builder cardBuilder = new Card.Builder();
        PokerHand hand = new PokerHand.Builder().build(Set.of(
               cardBuilder.value(CardValue.K).suit(Suit.H).build(),
               cardBuilder.value(CardValue.FOUR).suit(Suit.D).build(),
               cardBuilder.value(CardValue.FOUR).suit(Suit.C).build(),
               cardBuilder.value(CardValue.FOUR).suit(Suit.H).build(),
               cardBuilder.value(CardValue.FOUR).suit(Suit.S).build()
        ));
        // when
        PokerFigure expected = PokerFigure.FOUR_OF_A_KIND;
        PokerFigure actual = hand.getPokerFigure();

        // then
        assertEquals(expected, actual);

    }


}