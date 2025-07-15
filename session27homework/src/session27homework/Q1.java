/*
 
Q1 - 6 digits
 
Task description
Given six digits, find the earliest valid time that can be displayed on a digital clock (in 24-hour format) using those digits. 
For example, given digits 1, 8, 3, 2, 6, 4 the earliest valid time is "12:36:48". Note that "12:34:68" is not a valid time.
Write a function:
class Solution { public String solution (int A, int B, int C, int D, int E, int F); }
that, given six integers A, B, C, D, E and F, returns the earliest valid time in "HH:MM: SS" string format, 
or "NOT POSSIBLE" if it is not possible to display a valid time using all six integers.
For example, given 1, 8, 3, 2, 6, 4 the function should return "12:36:48".
Given 0, 0, 0, 0, 0, 0, the function should return "00:00:00".
Given 0, 0, 0, 7, 8, 9, the function should return "07:08:09".
Given 2, 4, 5, 9, 5, 9, the function should return "NOT POSSIBLE".
Assume that:
A, B, C, D, E and F are integers within the range [0..9].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

         A    B    C    D    E    F 
Array   [0]  [1]  [2]  [3]  [4]  [5]
 */

package session27homework;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.solution(1, 8, 3, 2, 6, 4)); 
        System.out.println(q1.solution(0, 0, 0, 0, 0, 0));
        System.out.println(q1.solution(0, 0, 0, 7, 8, 9));
        System.out.println(q1.solution(2, 4, 5, 9, 5, 9));
    }

    public String solution(int A, int B, int C, int D, int E, int F) {
        int[] digits = {A, B, C, D, E, F};
        List<String> validTimes = new LinkedList<>();

        timeGenerating(digits, 0, validTimes);

        if (validTimes.isEmpty()) {
            return "NOT POSSIBLE";
        }

        Collections.sort(validTimes);
        return validTimes.get(0);
    }

    public void timeGenerating(int[] arr, int index, List<String> validTimes) {
        if (index == arr.length) {
            int hh = arr[0] * 10 + arr[1];
            int mm = arr[2] * 10 + arr[3];
            int ss = arr[4] * 10 + arr[5];

            if (hh < 24 && mm < 60 && ss < 60) {
                String time = String.format("%02d:%02d:%02d", hh, mm, ss);
                validTimes.add(time);
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            timeGenerating(arr, index + 1, validTimes);
            swap(arr, i, index);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tempVar = arr[i];
        arr[i] = arr[j];
        arr[j] = tempVar;
    }
}
