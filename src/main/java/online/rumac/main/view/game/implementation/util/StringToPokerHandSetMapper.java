package online.rumac.main.view.game.implementation.util;

import online.rumac.main.model.hand.PokerHand;

import java.util.*;
import java.util.stream.Collectors;

public interface StringToPokerHandSetMapper {

    default List<PokerHand> mapToPokerHandList(String s, int playersCount) {
        List<List<String>> listOfStringCardList = splitStringToPHStringLists(s, playersCount);

        return forceSingleOccurrenceOfHand(mapList(listOfStringCardList));

    }

    private static List<PokerHand> mapList (List<List<String>> list) {
        return list.stream()
                .map(PokerHand::build)
                .collect(Collectors.toList());
    }

    private static List<PokerHand> forceSingleOccurrenceOfHand(List<PokerHand> set) {
        return List.copyOf(new LinkedHashSet<>(set));
    }

    private static List<List<String>> splitStringToPHStringLists(String string, int playersCount) {
        String[] strings = string.split(" ");

        return splitStringArrayToListOfStringArrays(strings, playersCount);

    }

    private static List<List<String>> splitStringArrayToListOfStringArrays(String[] strings, int playersCount) {
        assert strings.length % playersCount == 0;

        int splitter = strings.length / playersCount;

        List<List<String>> outputList = new LinkedList<>();
        splitArrayToMultipleArraysInList(outputList, strings, splitter);

        return outputList;
    }

    private static void splitArrayToMultipleArraysInList(List<List<String>> outputList, String[] strings, int splitter) {
        for (int i = 0; i < strings.length; i += splitter) {
            String[] tempArr = Arrays.copyOfRange(strings, i, i + splitter);
            outputList.add(Arrays.asList(tempArr));
        }
    }
}
