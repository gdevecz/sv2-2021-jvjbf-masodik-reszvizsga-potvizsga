package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {

    private List<String> sentences= new ArrayList<>();

    public void addSentence(String sentence) {
        if(isSentenceValid(sentence)) {
            sentences.add(sentence);
        }
    }

    private boolean isSentenceValid(String sentence) {
        if (!Character.isUpperCase(sentence.charAt(0))) {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        if (!".!?".contains(sentence.substring(sentence.length() - 1))) {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
        return true;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public String findLongestSentence() {
        if(sentences.isEmpty()) {
            throw new IllegalStateException("The list of sentences is empty.");
        }
        String longest = sentences.get(0);
        for (String sentence : sentences) {
            if (longest.length() < sentence.length()) {
                longest = sentence;
            }
        }
        return longest;
    }
}
