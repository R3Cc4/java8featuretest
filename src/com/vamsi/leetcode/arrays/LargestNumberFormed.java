package com.vamsi.leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;


public class LargestNumberFormed {

    
    public static void main(String[] args)
    {
      
      int[] numbers = {2,4,6,34,65,23,54,6,8,65,98};
      for(int number:numbers){
       System.out.println(number); 
      }
      String largestNumber = largestNumber(numbers);
      System.out.println("Largest Number Formed!="+largestNumber);
      System.out.print("program End");
    }
    
    public static String largestNumber(int[] num) {        
        Comparator<Long> comp = new Comparator<Long>() {

            @Override
            public int compare(Long i1, Long i2) {
                String r1 = i1+""+i2;
                String r2 = i2+""+i1;

                if (Long.parseLong(r1)>Long.parseLong(r2)) {
                    return -1;
                } else {
                    return 1;
                }
            }

        };

        Long[] array = convert(num);
        Arrays.sort(array, comp);
        //handle all "0" case
        if (array[0]==0l) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Long number : array) {
            sb.append(number);
        }
        return sb.toString();
    }

    private static Long[] convert(int[] num) {
        Long[] array = new Long[num.length];
       for (int i=0; i<num.length; i++) {
           array[i] = (long)num[i];
       }
       return array;
    }
    
}
