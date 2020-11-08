		import java.util.*;

		public class Activity1_2 {
		    public static void main(String[] args) {
		    	// TODO Auto-generated method stub
		        
		        int[] nums = {10, 77, 10, 54, -11, 10};
		        System.out.println("Original Array: " + Arrays.toString(nums));
		        
		        //Set constants
		        int a = 10;
		        int sum = 30;

		        //Print result
		        System.out.println("Result: " + result(nums, a, sum));
		    }

		    public static boolean result(int[] n, int a, int sum) {
		        int temp = 0;
		        //Loop through array
		        for (int number : n) {
		            //If value is 10
		            if (number == a) {
		                //Add them
		                temp += a;
		            }

		            //Sum should not be more than 30
		            if (temp > sum) {
		                break;
		            }
		        }

		        //Return true if condition satisfies
		        return temp == sum;
		    }
		}

