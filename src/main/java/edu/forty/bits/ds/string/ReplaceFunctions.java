package org.practice.learning.string;

public class ReplaceFunctions {

    // input  "ABC12345DEFG"
    // output "ABConetwothreefourfiveDEFG"
    public static void convertNumbersToName(String input) {
        String newStr = ""; /// not to modify the original com.stackoverflow.nullpointer.string
        String[] words = new String[]{"zero", "one", "two", "three", "four", "five"};
        for (char c : input.toCharArray()) {
            int i = c - '0';
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    newStr = input.replace(Character.toString(c), words[j]);
                    input = newStr;
                }
            }
        }
        System.out.println(newStr);
    }

    /**
     * String str = "Happy OLD days are HERE again" replace all capital words with "abc"
     * output would be as "Happy abc days are abc again"
     * @param str
     * @return
     */
    public static String replaceCaps(String str) {
        str = str.replaceAll("(\\b*)[A-Z]+(\\b*)", "$1abc$2");
        return str;
    }
}