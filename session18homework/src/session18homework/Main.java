/*
Session18
Hw practice thuật toán tham lam (greedy algorithm)
Cho các loại mệnh giá tiền sau . 1, 2, 5, 10, 20, 50, 100, 200, 500.
Hãy viết function :  
int solution changeMoney(int money);  
Input sẽ là số tiền cần đổi. Output sẽ return số tờ tiền ít nhất cần để đổi dc số tiền input.
*/

package session18homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount of money: ");
        int money = scanner.nextInt();

        Solution.changeMoney(money);
    }
}

class Solution {
    public static void changeMoney(int money) {
        int[] moneyArray = {500, 200, 100, 50, 20, 10, 5, 2, 1}; 

        System.out.println("Change breakdown:");
        
        for (int i = 0; i < moneyArray.length; i = i + 1) {
            int count = money / moneyArray[i];
            
            if (count > 0) {
                System.out.println(moneyArray[i] + " x " + count);
                
                money = money % moneyArray[i];
            }
        }
    }
}


