package com.vamsi.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*** Part - I
***Given an array of integers, find two numbers such that they add up to a specific target number.
***The function twoSum should return indices of the two numbers such that they add up to the target, 
***where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
***You may assume that each input would have exactly one solution.
***Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2 
***/

/*** Part - II
 * Datastructure Design.
 * 
 *Design and implement a TwoSum class. It should support the following operations: add and find.
  add - Add the number to an internal data structure. find - Find if there exists any pair of numbers which sum is equal to the value.
  For example, add(1); add(3); add(5); find(4) -> true find(7) -> false
 * <p>TODO Detailed description of the class.(if needed)</p>
 *
 * @author TODO
 * @version TODO
 */

public class TwoSum {
    
    Map<Integer,Integer> inputs = new HashMap<Integer,Integer>();
    
    public void add(Integer key){
        
        if (inputs.containsKey(key)){
            inputs.put(key, inputs.get(key)+1);
        }else{
            inputs.put(key, 1);
        }
        
    }
    
    public boolean find(Integer target){
        
        for(Entry<Integer, Integer> entry:inputs.entrySet()){
            int key = entry.getKey();
            int value= entry.getValue();
            int targetVal = target-key;
            
            if(inputs.containsKey(targetVal)){
             
                if(targetVal == key){
                    return value>1;
                }else{
                    return true;
                }
                
            }
            
        }
        
        return false;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] numbers ={3,6,8,9,12,14,1,2,7,23};
        
        TwoSum twosum = new  TwoSum();
        int[] results = twosum.twoSum(numbers, 15);
        String result="{";
        for(int i : results){
        result+=" "+i+" ";
        }
        
        twosum.add(3);
        twosum.add(4);
        twosum.add(5);
        twosum.add(3);
        twosum.add(7);
        twosum.add(8);
        
        System.out.println(result+"}");
        System.out.println("finding 12 ==? expected true answer is ="+twosum.find(12));
        System.out.println("finding 6 ==? expected true answer is ="+twosum.find(6));    
        System.out.println("finding 18 ==? expected false answer is ="+twosum.find(18));
    }
    
    public int[] twoSum(int[] numbers, int target){
        
        int[] indexes ={0,0};
               
       if(numbers == null || numbers.length==0){
           
           return indexes;
           
       }
        
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
       
       for(int i = 0;i<numbers.length;i++){
           
           if(map.containsKey(numbers[i])){
               
               indexes[0]=map.get(numbers[i]);
               indexes[1]=i+1;
               break;
               
               
           }else {
               map.put(target-numbers[i], i+1);
           }
           
           
           
       }
       
       
        return indexes;
    }

}
