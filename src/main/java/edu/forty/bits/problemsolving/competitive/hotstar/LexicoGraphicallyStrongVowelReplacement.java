package edu.forty.bits.problemsolving.competitive.hotstar;

public class LexicoGraphicallyStrongVowelReplacement {

    public static void main(String args[]) {

        java.util.Map<Character, Character> initialToFinalCharacter = new java.util.HashMap<>();
        initialToFinalCharacter.put('a', 'b');
        initialToFinalCharacter.put('e', 'f');
        initialToFinalCharacter.put('i', 'j');
        initialToFinalCharacter.put('o', 'p');
        initialToFinalCharacter.put('u', 'v');

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            String S = scanner.next();
            int Q = scanner.nextInt();

            if (Q == 0 || countVowels(S) == 0) {
                System.out.println(S);
            } else {
                for (Integer x : indexOfVowels(S, Q)) {
                    S = S.substring(0, x) + initialToFinalCharacter.get(S.charAt(x)) + S.substring(x + 1);
                    // possibly a regex might help overcome the timeouts
                }
                System.out.println(S);
            }
        }
    }

    // Returns the indexes of vowels in str
    private static java.util.List<Integer> indexOfVowels(String str, int count) {
        return java.util.stream.IntStream.range(0, str.length())
                .filter(i -> isVowel(str.charAt(i)))
                .boxed()
                .limit(count)
                .collect(java.util.stream.Collectors.toList());
    }

    // Returns count of vowels in str
    private static int countVowels(String str) {
        return (int)
                java.util.stream.IntStream.range(0, str.length())
                        .filter(i -> isVowel(str.charAt(i)))
                        .count();
    }

    // Function to check the Vowel
    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
