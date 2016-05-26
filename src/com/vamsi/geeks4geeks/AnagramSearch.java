package com.vamsi.geeks4geeks;

import java.util.Arrays;


public class AnagramSearch {

    private String searchString;
    private String inputString;
    public AnagramSearch(String inputString, String searchString){
        this.searchString = searchString;
        this.inputString = inputString;
        
    }
    
    public String findAnagram(String inputString, String searchString){
        String result = "";
        int matchCount = 0;
        String matchIndex = "";
        String reverseSearch = new StringBuilder(searchString).reverse().toString();
       // System.out.println("reverse String =="+ reverseSearch);
        if(inputString.contains(searchString)||inputString.contains(reverseSearch)){
        for(int i=0;i<inputString.length();i++){
            
            boolean found = false;
            
            if(inputString.charAt(i)==searchString.charAt(0)) {
                
                for (int j =0; j<searchString.length();j++){
                    if(inputString.charAt(i+j) != searchString.charAt(j)){
                        found = false;
                        break;
                    }
                    if(j==searchString.length()-1){
                        found =true;
                        matchCount++;
                        matchIndex= matchIndex+i+" ";
                    }
                }
                         
            }
            
            if(inputString.charAt(i)==reverseSearch.charAt(0)) {
                
                for (int j =0; j<reverseSearch.length();j++){
                    if(inputString.charAt(i+j) != reverseSearch.charAt(j)){
                        found = false;
                        break;
                    }
                    if(j==reverseSearch.length()-1){
                        found =true;
                        matchCount++;
                        matchIndex= matchIndex+i+" ";
                    }
                }  
                
            }
            
            
        }
        }
        result = matchCount+" "+matchIndex;
      
        return result;
    }
    public static void main(String [] args){
        
        //AnagramSearch anagramSearch  = new AnagramSearch(args[0], args[1]);
        AnagramSearch anagramSearch  = new AnagramSearch("abcbaxycbazxy", "abc");
      String resultString=  anagramSearch.findAnagram(anagramSearch.inputString, anagramSearch.searchString);
      System.out.println("Anagram REsult =="+resultString);
        
    }
    
}
