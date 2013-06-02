package linkedin;

import java.util.ArrayList;
import java.util.Collections;


public class TwoSum {
    /**
     * Stores @param input in an internal data structure.
     */
    ArrayList<Integer> list = new ArrayList<Integer>();
    void store(int input){
        list.add(input);
    
    }
 
    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param test, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     */
    boolean test(int val){
       Collections.sort(list);
       
       int start = 0;
       int end = list.size()-1;
       
       while(start < end){
           if(list.get(start) + list.get(end) < val){
               
               start++;
           }
           else if( list.get(start) + list.get(end) > val){
               end--;
           }
           else{
               return true;
           }
       
       
       }
       return false;
    
    }
}















