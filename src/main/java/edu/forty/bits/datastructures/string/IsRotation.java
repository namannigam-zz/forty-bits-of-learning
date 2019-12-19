package edu.forty.bits.datastructures.string;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given
 * two strings s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
 * usSubstring (e.g. "waterbottle" is a rotation of "erbottlewat")
 */
public class IsRotation {

    // Logically 'xy' rotates to 'yx' and to make sure a string yx is a rotation of xy,
    // you can confirm id 'yx' is a substring of "x'yx'y"
    boolean isRotation(String s1, String s2) {
        String temp = s1 + s1;
        return IsSubstring.isSubstring(temp, s2) != -1;
        //    return IsSubstring.isSubstringUsingIndexOf(temp, s2);
    }
}