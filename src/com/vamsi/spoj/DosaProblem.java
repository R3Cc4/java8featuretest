package com.vamsi.spoj;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



/*Lalith is going to have dinner and he has  N dosas in front of him with their prices represented by sequence of integers a1,a2,a3...an. 
And he has decided to eat in a different manner . You are free to replace the price of any dosa with any positive integer. 
How many prices(integers) must be replaced to make the resulting sequence strictly increasing?
Input
The first line of the test case contains an integer N - the number of dosas.
The next line contains N space separated integers where the ith integer is ai , representing thr price of i-th dosa.
Output
Output the minimal number of prices(integers) that should be replaced to make the sequence strictly increasing.
Constraints
0 < N <= 10^6
0 < ai <= 10^9
Sample Input #01
6
1 7 10 2 20 22
Sample Output #01
1
Sample Input #02
5
1 2 2 3 4 
Sample Output #02
3
Explanation 
In the first sample input, we can replace 2 with any integer between 11 and 19 to make the price sequence strictly increasing, hence the output is 1. 
In the second sample input, we can obtain 1, 2, 3, 4, 5 by changing the last three elements of the price sequence.
12 
10 11 12 10 9 15 16 22 21 19 20 21 
 */
public class DosaProblem {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
  Integer dosaCount = 12;
  Integer[] input = {10, 11, 12, 10, 9, 15, 16, 22, 21, 19, 20, 21} ;  
      
   boolean x = false;
   Integer count = 0;
   Integer random = 24;
  
   
        
  List<Integer> output= IntStream.range(0, input.length)
   .filter(i -> {
      
       if(i==0){
           
           return false;
       }
       if(i>0 && i<input.length-1){
           if(input[i]<=input[i-1] || input[i]+1==input[i+1]){
               return true;
           }
       }
       if(i==input.length-1){
           
           if(input[i]==input[i-1]|| input[i-1]+1==input[i]){
               return true;
           }
       }
       return false;
       
   })
   .mapToObj(y-> input[y])
   .collect(Collectors.toList());
   output.stream().forEach(System.out::println);
   System.out.println("output size =="+output.size());
    }

}
