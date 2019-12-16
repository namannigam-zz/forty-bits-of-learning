package edu.forty.bits.ps.competitive.browserstack;

public class MathBookParser {

    //
    //    Maths Workbook Parser
    //    Imagine a Maths equation represented in a grid or table (similar to Math books used in
    // school). Each cell in the grid is used to write in either a number, a mathematical operator or
    // be blank. An jdk.exception to this is when we need to write a divisional
    // expression. Here's an example,
    //
    //    enter image description here
    //
    //    The above equation would be represented as
    //
    // 4	+	2	*	3
    //    _	_	_
    // 2
    //    Notice the 3 consecutive underscores '_' used to represent a single division operator.
    //
    //            Problem
    //    The math expression will be given to you in a comma separated
    // format where the full expression will evaluate to one value.
    // Valid mathematical operators that can be given are, +, *, - and _ (underscore). The '_'
    // operator will signify the division operator. The equation needs to be evaluated using the
    // standard BODMAS rules.
    //
    //    The above example will be represented as
    //
    //            Input,
    //
    // 4, +, 2, *, 3
    //    _, _, _,,,
    //            2,,,,
    //    And the output should be,
    //
    //            9
    //    Multiple levels of division will need to be supported as well e.g.
    //
    //    multiple division levels
    //
    //    would be represented as
    //
    // 6
    //    _
    // 2
    //    _
    // 3
    //    These would need to be evaluated from top to down, i.e. (6/2)/3. Therefore the output would
    // be
    // 1
    //    Your solution must also be able to detect hanging expressions as well as invalid
    // expressions. Some examples of these are,
    //
    //            4	+	2	*	3
    //    _	_
    //    Or
    //
    // 4	+	2	*
    //    _	_	_
    //    For invalid expressions your solution must output the string
    // INVALID EXPRESSION.
    //
    //            Sample Input
    // 4, +, 2, *, 3
    //    _, _, _,,,
    //            2,,,,
    //    Sample Output
    // 9
    //    Note: Your code should be able to convert the sample input into the sample output. However,
    // this is not enough to pass the challenge, because the code will be run on multiple test cases.
    // Therefore, your code must solve this problem statement.

}
