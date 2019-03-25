package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by kreddy on 2/20/18.
 */
public class MaximumBitonicSubarraySum {

  public static void main (String[] args) {
    //code
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while(tc-- > 0) {
      int N = sc.nextInt();
      if (N > 0) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
          nums[i] = sc.nextInt();
        }
        System.out.println(maxBitonicSum(nums, N));
      }
    }
  }

  private static long maxBitonicSum(int[] ar, int n) {
    if(n<=1)
      return ar[0];
    long sum=ar[0];
    long maxSum=-1;
    boolean incOrDec= ar[1]>ar[0] ? true:false;
    int i=1;
    for(;i<n;i++){
      if(incOrDec){
        if(ar[i]>ar[i-1]){
          sum+=ar[i];
        }else{
          if(ar[i]!=ar[i-1])
            sum+=ar[i];
          else{
            maxSum=Math.max(sum, maxSum);
            sum=ar[i];
          }

          incOrDec=false;
        }
      }else{
        if(ar[i]<ar[i-1]){
          sum+=ar[i];
        }else{
          maxSum=Math.max(maxSum, sum);
          sum=ar[i];
          if(ar[i-1]!=ar[i])
            sum+=ar[i-1];
          incOrDec=true;
        }
      }
      //   print("["+sum+"]");
    }
    return Math.max(maxSum, sum);
  }
}
