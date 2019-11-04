package edu.forty.bits.ps.competitive.hackerearth.easy.august18;

import java.util.Scanner;

/**
 *Team Rocket is back again and this time they have come with  pokemon with strengths  .  They know that Pikachu has strength  and they are now training hard to fight against Pikachu.
 *
 * Boss has given Team Rocket's pokemon special secret training number  (a real number). This has increased the strength of all the Pokemon by a factor of  , i.e. the new strengths of the  pokemon are  respectively. However pokemon do not like their strength being a real number and they have all rounded their strengths down to the greatest integer less than or equal to their strength.
 *
 * After this special secret training, Team Rocket has claimed that the total sum of strengths of all the  pokemon has become exactly  and can beat Pikachu now. Pikachu doesn't like this and hence he wants to know the secret number  ( he knows the value of  and  ). Can you help Pikachu by telling him the value of  or tell that it is not possible to have any such ? Since Pikachu doesn't like floating point numbers, he wants to know the greatest integer less than or equal to . You can assume that if there exist any such integer, then it is always unique.
 *
 * Input Format :
 *
 * The first line contains a single integer  denoting number of testcases in a single test file. Each testcase contains two integers  and .
 *
 * Output Format :
 *
 * Ouput a single integer denoting the output or  if there is no possible value of .
 */
public class PickachuFloorProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            float n = scanner.nextLong();
            float p = scanner.nextFloat();
            float sum = (n * (n + 1)) / 2;
            System.out.println((int) Math.floor(p / sum));

        }
    }
}