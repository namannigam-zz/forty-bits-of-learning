package edu.forty.bits.ds.string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BasicStringUtility {

  private static void equalsCheck() {
    String good = "good";
    String anotherGood = "good";
    System.out.println(good == anotherGood); // reference comparison, not value

    String goodFromCharacters = "" + 'g' + 'o' + 'o' + 'd';
    System.out.println(good == goodFromCharacters);

    char[] chars = {'g', 'o', 'o', 'd'};
    String characters = "" + chars[0] + chars[1] + chars[2] + chars[3];
    System.out.println(good.equals(characters));
  }

  private static void splitString() {
    String str = "India (IND)";
    System.out.println(str.indexOf('('));
    System.out.println(str.indexOf(')'));
    System.out.println(str.substring(str.indexOf('(') + 1, str.indexOf(')')));
    System.out.println(str.split(" ")[1]);
  }

  // This is a O(nlogn) approach of sorting a com.stackoverflow.nullpointer.string irrespective of
  // any further conditions
  public static String sortString(String input) {
    char[] chars = input.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public static int spacesInString(char[] chars, int length) {
    return (int) IntStream.range(0, length).filter(i -> chars[i] == ' ').count();
  }

  public static int spacesInString(String chars, int length) {
    return (int) IntStream.range(0, length).filter(i -> chars.charAt(i) == ' ').count();
  }

  public static int getCharNumber(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    if (a <= c && c <= z) {
      return c - a;
    } else {
      return -1;
    }
  }

  public int[] buildCharFrequencyTable(String phrase) {
    int[] chars = new int[getCharNumber('a') - getCharNumber('z') + 1];
    for (char ch : phrase.toCharArray()) {
      int num = getCharNumber(ch);
      if (num != -1) {
        chars[num]++;
      }
    }
    return chars;
  }
}
