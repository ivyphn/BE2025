/*
  
Q2 - Calculate the square
  
Write a function solution that, given two integers A and B, returns the maximum number of repeated square root operations 
that can be performed using the numbers from the interval [A..B] (both ends included) as starting points. 
Square root operations can be performed as long as the result is still an integer.

For example, given A = 10, B = 20, the function should return 2. 
Starting with the integer 16, two square root operations can be performed: sqrt(16) = 4 and then sqrt(4) = 2.

Given A = 6000 and B = 7000, the function should return 3. 
Starting with integer 6561, three square root operations can be performed: sqrt(6561) = 81, sqrt(81) = 9 and sqrt(9) = 3.

Write an efficient algorithm for the following assumptions:
A and B are integers within the range [2..1,000,000,000];
A ≤ B.
 
 */


package session27homework;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        System.out.println(q2.solution(6000, 7000)); 
    }

    public int solution(int A, int B) {
        System.out.println("Print");

        List<Integer> numList = new LinkedList<>();
        List<Integer> sqrtList = new LinkedList<>();

        if (A <= B) {
            int start = (int) Math.ceil(Math.sqrt(A));
            int end = (int) Math.floor(Math.sqrt(B));

            for (int i = start; i <= end; i++) {
                numList.add(i); 
            }
        }

        System.out.println("Numbers between sqrt(A) and sqrt(B): " + numList);

        for (int i = 0; i < numList.size(); i++) {
            int count = countSqrt(numList.get(i));
            sqrtList.add(count);
        }
        
        int maxCount = 0;
        for (int i = 0; i < numList.size(); i++) {
            int count = sqrtList.get(i);
            if (count > maxCount) {
                maxCount = count;
            }
        }
       return maxCount+1; 

    }

    public static int countSqrt(int n) {
        int count = 0;
        double root = n;

        while (true) {
            double sqrt = Math.sqrt(root);
            if (sqrt == Math.floor(sqrt)) {
                count++;
                root = sqrt;
            } else {
                break;
            }
        }
        return count;
    }
}
