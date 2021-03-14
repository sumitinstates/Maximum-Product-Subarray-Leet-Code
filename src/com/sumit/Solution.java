package com.sumit;

public class Solution {
	
	/*
	 * Time Complexity is o(n) because of only one for loop
	 * Space Complexity is 1 as we are not creating any new array or anything.
	 * 
	 */
   public static int maxProduct(int[] nums) {
        
        int max = nums[0];
        int min = nums[0];
        int product = nums[0];
            
        for(int i = 1 ; i<nums.length ;i++)
        {
        	/*
        	 * Here we are checking if number is negative or not.
        	 * If it is negative then we are multiplying the current number
        	 * with last minimum product to find the new maximum product.
        	 * 
        	 * because let's say:
        	 * if current number in array is -4.
        	 * and last min product was -10 and max was -3;
        	 * if we multiply -4 with -3 then it becomes -12 and 
        	 * when we multiply -4 with -10 then it becomes 40.
        	 * So it means, the last max number that was -3, now becomes
        	 * min, as it becomes -12 and last min product that was -10, becomes
        	 * max that is 40 now after product.
        	 * 
        	 * so if we multiply negative value with max = it becomes min and vice versa.
        	 * 
        	 * so if number is negative, swap the last maximum and minimum product in order
        	 * to compare right max and min product.
        	 * 
        	 */
            if(nums[i]>0)
            { 
            	//if number is positive
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            } 
            else 
            {
            	//if number is negative
            	max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], max * nums[i]);
            }  
            
            product = Math.max(max,product);
        }
        
        return product;
    }
   
   public static void main(String[] args) {
	int [] a = {2,3,-2,4};
	
	int [] b = {-2,0,-1};
	
	int [] c = {1,-3,-4};
	
	System.out.println(Solution.maxProduct(a));
	
	System.out.println(Solution.maxProduct(b));
	
	System.out.println(Solution.maxProduct(c));
}

}
