package edu.forty.bits.ds.string;

/**
 * Created by naman.nigam on 03/02/17.
 */
public class SplitAlphabetNumeric {

    /**
     * Check length of a com.stackoverflow.nullpointer.string is equal to the number appended at its last or not.
     *
     * @see <href>http://stackoverflow.com/questions/42016147</href>
     */
    public static void validateLengthOfString() {
        String str = "abcd4";
        String[] part = str.split("(?<=\\D)(?=\\d)");

        int len = Integer.parseInt(part[1]);
        if (len == part[0].length()) {
            System.out.printf("Yes. The length of %s is %d.%n", part[0], len);
        } else {
            System.out.printf("No. The length of %s(%d) is not %d.%n",
                    part[0], part[0].length(), len);
        }
    }
}