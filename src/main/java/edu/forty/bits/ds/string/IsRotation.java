package edu.forty.bits.ds.string;

// `isSubstring` checks is one com.stackoverflow.nullpointer.string is a substring of another, for s1 and s2,
// write code to check is s2 is a rotation of s1 by calling the given method only once
public class IsRotation {

    // xy rotates to yx
    // to make sure a com.stackoverflow.nullpointer.string yx is a rotation of xy, you can confirm if yx is a substring of x'yx'y
    private static boolean isRotation(String s1, String s2) {
        String temp = s1 + s1;
        return IsSubstring.isSubstring(temp, s2) != -1;
    }
}