package leetCode;

import java.util.*;

class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        double max=0;
        for(int i=0;i<k;i++){
            max+=(double)nums[i];
        }
        for(int i=k;i<nums.length;i++){
            double temp=(double)max+nums[i]-nums[i-k];
            max= Math.max(max,temp);
        }
        return max/k;

    }


    public static void main(String[] args) {
        HashSet<Integer> integers = new HashSet<>();
        for (Integer integer : integers) {

        }
    }
}
