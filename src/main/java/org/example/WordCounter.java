package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {


    public static Map<String, Integer> calculatedWord(String text) {

        if (text == null || text.trim().isEmpty()) {
            return new HashMap<>();
        }


        Map<String, Integer> wordCount = new HashMap<>();


        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");


        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }
}
