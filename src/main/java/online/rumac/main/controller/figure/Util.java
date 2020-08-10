package online.rumac.main.controller.figure;

import online.rumac.main.model.card.Card;
import online.rumac.main.model.card.CardComparator;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.card.Suit;
import online.rumac.main.model.hand.PokerHand;

import java.util.*;
import java.util.stream.Collectors;

public class Util {

    public static boolean ofOneSuit(PokerHand hand) {
        Iterator<Card> cards = hand.getCards().iterator();
        Suit suit = cards.next().getSuit();
        while (cards.hasNext()) {
            if (!suit.equals(cards.next().getSuit())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isStraightType(PokerHand hand) {
        Integer[] cardValues = hand.getCards().stream()
                .sorted((c1, c2) -> new CardComparator().compare(c1, c2))
                .map(c -> c.getValue().ordinal())
                .toArray(Integer[]::new);
        return cardValues[0] + 4 == cardValues[cardValues.length - 1];
    }

    public static int findListWithBiggestMaxValue(List<Integer> a, List<Integer> b) {
        var aSorted = a.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        var bSorted = b.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i < aSorted.size(); i++) {
            int comparator = Integer.compare(aSorted.get(i), bSorted.get(i));
            if (comparator != 0) {
                return comparator;
            }
        }
        return 0;
    }

    public static Card getHighCard(Set<Card> cards) {
        return cards.stream().max(new CardComparator()).get();
    }

    public static int compareByHighCard(PokerHand hand1, PokerHand hand2) {
        List<Integer> listOrdinal1 =  hand1.getCards().stream()
                .map(c -> c.getValue().ordinal())
                .collect(Collectors.toList());

        List<Integer> listOrdinal2 = hand2.getCards().stream()
                .map(c -> c.getValue().ordinal())
                .collect(Collectors.toList());

        return findListWithBiggestMaxValue(listOrdinal1, listOrdinal2);
    }

    public static Map<CardValue, Integer> mapCardValues(Set<Card> cards) {
        Map<CardValue, Integer> map = new HashMap<>(cards.size());
        cards.forEach(c -> map.merge(c.getValue(), 1, Integer::sum));
        return map;
    }

    public static Map<CardValue, Integer> mapCardValues(PokerHand hand) {
        return hand.getCardValueMap();
    }

    public static Map<CardValue, Integer> mapCardValues(Map<CardValue, Integer> cardValuesMap, List<Integer> countOfRelevantCards) {
        return cardValuesMap.entrySet().stream()
                .filter(es -> countOfRelevantCards.contains(es.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (es1, es2) -> es1, LinkedHashMap::new));
    }

    public static Map<CardValue, Integer> mapCardValues(PokerHand hand, List<Integer> countOfRelevantCards) {
        return mapCardValues(hand.getCardValueMap(), countOfRelevantCards);
    }

    public static Map<CardValue, Integer> mapCardValues(PokerHand hand, Integer countOfRelevantCards) {
        return mapCardValues(hand, List.of(countOfRelevantCards));
    }

    public static List<Integer> cardValuesCountAsList(Map<CardValue, Integer> mapCardValues) {
        return mapCardValues.keySet().stream().map(Enum::ordinal).collect(Collectors.toList());
    }

    public static int getHighestWinningFigureCard(PokerHand o1, PokerHand o2, int countOfRelevantCards) {
        assertArgumentsAreAcceptable(o1, o2, countOfRelevantCards);

        Map<CardValue, Integer> o1CardValueMap = mapCardValues(o1, countOfRelevantCards);
        Map<CardValue, Integer> o2CardValueMap = mapCardValues(o2, countOfRelevantCards);
        CardValue o1highestWiningThree = o1CardValueMap.keySet().iterator().next();
        CardValue o2highestWiningThree = o2CardValueMap.keySet().iterator().next();
        return o1highestWiningThree.compareTo(o2highestWiningThree);
    }

    private static void assertArgumentsAreAcceptable(PokerHand o1, PokerHand o2, int countOfRelevantCards) {
        assert o1 != null && o2 != null && countOfRelevantCards > 0;
        assert o1.getPokerFigure() == o2.getPokerFigure();

        PokerFigure figure = o1.getPokerFigure();
        Set<PokerFigure> acceptablePokerFigures = Set.of(
                PokerFigure.FOUR_OF_A_KIND,
                PokerFigure.FULL_HOUSE,
                PokerFigure.THREE_OF_A_KIND,
                PokerFigure.ONE_PAIR
        );

        assert acceptablePokerFigures.contains(figure);
    }
}
