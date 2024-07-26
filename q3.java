// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
 public class Knapsack {
    public static void main(String[] args) {
        int[] weights={1,2,3};
        int[] values={10,15,40};
        int capacity=6;
        int maxValue=knapsack(weights, values, capacity);
        System.out.println("Max value in knapsack= "+ maxValue);
    }
    public static int knapsack(int[] weights, int[] values, int capacity){
        int n=weights.length;
        int[] dp= new int[capacity+1];
        for(int i=0; i<n; i++){
            for(int w=capacity; w>=weights[i];w--){
                dp[w]=Math.max(dp[w], dp[w-weights[i]]+values[i]);
            }
        }
        return dp[capacity];
    }
}
