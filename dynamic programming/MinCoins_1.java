//MINIMUM COINS POSSIBLE
import java.util.Scanner;

public class MinCoins_1 {
    public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the change amount:");
            int n=sc.nextInt();
            System.out.println("Enter the number of types of coins:");
            int x=sc.nextInt();
            int[] coins = new int[x];
            System.out.println("Enter the "+x+" coins:");
            for (int i=0;i<x;i++){
                coins[i]=sc.nextInt();
                }
            int result=minChange(n,coins);
            if (result!=Integer.MAX_VALUE)  //if combination possible
            System.out.println("In minimum coins required: "+result);
            else                    //if combination not possible
            System.out.println(-1);     
        }
    }

    //the recursive function 
    static int minChange(int n,int a[]){
        if(n==0){       //If the sum of coins combination exactly equal to change required this works. 
            return 0;       //It stops the recursion function in case of change possible. 
        }
        int ans=Integer.MAX_VALUE;  
        for(int i=0;i<a.length;i++){
            if (n-a[i] >= 0){      //It stops the recursion function in case of change not possible with that combination.
                int subAns=minChange(n-a[i],a);     //recursion call 
                if(subAns!=Integer.MAX_VALUE && subAns+1<ans){  //subAns!=Integer.MAX_VALUE this cond false for coins combination which doesnt not possible to give sum target(n),if the subAns is min value then recursion makes ans=subAns.
                    ans=subAns+1;   //think about only first level of tree.
                }
            }
        }
        return ans;
    }
}


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*

NOTE:
1. IN RECURSION FUNCTION:
        1.1 subAns value will be MAXVALUE if the combination doesnt give change.
        1.2 subAns value will change if the combination will give change. Because of the cond if(n==0) return 0;

2. THE COMPLEXITY IS WORST O(M^N).WE CAN DECREASE TIME COMPLEXITY USING "DYNAMIC PROGRAMMING" BECAUSE WE ARE REPEATING SOME TASKS.



QUESTION:

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
*/
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

