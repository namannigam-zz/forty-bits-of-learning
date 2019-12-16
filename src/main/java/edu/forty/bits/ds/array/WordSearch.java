package edu.forty.bits.ds.array;

public class WordSearch {

    private static void wordSearch(String word, int lineNumber) {
    /* If not a Java reserved word, insert word into the database,
    indicating that it is referenced on line lineNumber */

        // all Java reserved words; word at end guarantees
        String[] javaReservedWord = {
                "abstract",
                "assert",
                "boolean",
                "break",
                "byte",
                "case",
                "catch",
                "char",
                "class",
                "const",
                "continue",
                "default",
                "do",
                "double",
                "else",
                "enum",
                "extends",
                "false",
                "final",
                "finally",
                "float",
                "for",
                "goto",
                "if",
                "implements",
                "import",
                "instanceof",
                "int",
                "interface",
                "long",
                "native",
                "new",
                "null",
                "package",
                "private",
                "protected",
                "public",
                "return",
                "short",
                "static",
                "strictfp",
                "super",
                "switch",
                "synchronized",
                "this",
                "throw",
                "throws",
                "transient",
                "true",
                "try",
                "void",
                "volatile",
                "while",
                "word"
        };

        int i = 0; // termination of for loop

        // traverse javaReservedWord and see if any entry matches word
        for (i = javaReservedWord.length; !word.equals(javaReservedWord[i]); i--) ;

        System.out.println(i + javaReservedWord[i]);
        // matches a reserved word, so don't wordSearch to database
        if (i < javaReservedWord.length - 1) return;

    /* doesn't match a reserved word, so proceed by searching to see if
    word is already in database */
    }
}
