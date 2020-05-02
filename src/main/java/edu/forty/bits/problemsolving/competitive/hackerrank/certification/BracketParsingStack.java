package edu.forty.bits.problemsolving.competitive.hackerrank.certification;

import java.util.LinkedList;
import java.util.Scanner;

public class BracketParsingStack {

    public static void main(String[] args) {
        Parser parser = new Parser();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }
        in.close();
    }

    static class Parser {

        boolean isBalanced(final String charSequence) {
            LinkedList<Character> stack = new LinkedList<>();
            for (char ch : charSequence.toCharArray()) {
                if ((ch == '}' || ch == ')') && stack.isEmpty()) return false;
                if (ch == '}' && stack.peek() != '{') return false;
                if (ch == ')' && stack.peek() != '(') return false;
                if ((ch == '{' || ch == '(')) stack.push(ch);
                else stack.pop();
            }
            return stack.isEmpty();
        }
    }
}