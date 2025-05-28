/*
Q1 - Binary gap
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two 
binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary 
representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
Write a function:
class Solution { public int solution (int N); }
that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. 
Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps. Write an efficient algorithm for the following assumptions:
• N is an integer within the range [1..2,147,483,647].

Q2 - Same sum dice
There are two sets of traditional six-faced dice, represented by two arrays A and B consisting of N and M integers respectively. Each array element has a value
between 1 and 6, inclusive, representing the value of the corresponding die.
Write a function:
class Solution {public int solution (int[] A, int[] B);}
that, given two arrays A and B, returns the minimum number of dice to be turned in order to make the sums of dice in both sets equal, or -1 if this is not possible.
Examples:
1. Given A = [5], B = [1, 1, 6], the function should return 1. We have to turn the third die in B from 6 to 3; then the arrays will have the same sums (5=1+1+3).
2. Given A = [2, 3, 1, 1, 2], B = [5, 4, 6], the function should return 2. We can turn last two dice in B to get [5, 1, 3]; then the arrays will have the same sums.
3. Given A = [5, 4, 1, 2, 6, 5], B = [2], the function should return 6. We can turn five dice in A to get [1, 1, 1, 1, 1, 1] and one dice in B to get [6]; then the arrays will have the same sums.
4. Given A = [1, 2, 3, 4, 3, 2, 1], B = [6], the function should return -1, because it is not possible for the arrays to have the same sums. Write an efficient algorithm for the following assumptions:
- N and M are integers within the range [1..100,000];
- each element of arrays A and B is an integer within the range [1..6].
*/


package session16homework;

public class Main {      
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] numbers = {9, 529, 20, 15, 32, 1041};

        System.out.println("Q1 - Binary gap");
        for (int number : numbers) {
            int gap = solution.solution(number);
            System.out.println("Number: " + number +
                    "; Binary: " + Integer.toBinaryString(number) +
                    "; Longest binary gap: " + gap);
        }

        Solution2 solution2 = new Solution2();

        int[] A = {2, 3, 1, 1, 2};
        int[] B = {5, 4, 6};

        int minFlip = solution2.solution(A, B);
        System.out.println("Q2 - Min flip");
        System.out.println("Min flip: " + minFlip);
    }
}

class Solution {
    public int solution(int N) {
        String binaryForm = Integer.toBinaryString(N); 
        int currentGap = 0; 
        int maxGap = 0;     
        boolean seenOne = false; 

        for (char c : binaryForm.toCharArray()) {
            if (c == '1') {
                if (seenOne == true) {
                    maxGap = Math.max(maxGap, currentGap); 
                }
                seenOne = true;   
                currentGap = 0; 
            } else if (seenOne == true) {
                currentGap = currentGap + 1; 
            }
        }

        return maxGap;
    }
}

class Solution2 {
    public int solution(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;

        for (int value : A) {
            sumA = sumA + value;
        }

        for (int value : B) {
            sumB = sumB + value;
        }

        if (sumA == sumB) {
            return 0; 
        }

        int[] maxArray;
        int[] minArray;
        int difference;

        if (sumA > sumB) {
            maxArray = A;
            minArray = B;
            difference = sumA - sumB;
        } else {
            maxArray = B;
            minArray = A;
            difference = sumB - sumA;
        }

        int[] counts = new int[6]; 

        //  how much each die in maxArray can decrease
        for (int value : maxArray) {
            int change = value - 1; // Max reduction possible
            counts[change] = counts[change] + 1;
        }
        // [5, 4, 6]
        // [0, 0, 0, 1, 0, 0]
        // [0, 0, 0, 1, 1, 1]

        // how much each die in minArray can increase
        for (int value : minArray) {
            int change = 6 - value; 
            counts[change] = counts[change] + 1;
        }
        
	      // [2, 3, 1, 1, 2]
	      // [0, 0, 0, 1, 2, 2]
	     //+[0, 0, 0, 1, 1, 1]
	      //[0, 0, 0, 2, 3, 3]

        int flipCount = 0;

        for (int change = 5; change >= 1; change = change - 1) {
            while (counts[change] > 0 && difference > 0) {
                difference = difference - change;
                counts[change] = counts[change] - 1;
                flipCount = flipCount + 1;

                if (difference <= 0) {
                    return flipCount;
                }
            }
        }

        return -1; 
    }
}
