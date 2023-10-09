package check;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array of size n, find all elements that appear more than n/3 times.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,2]
 * Output: [1,2]
 */

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequencies.computeIfPresent(nums[i], (k,v)-> ++v);
            frequencies.putIfAbsent(nums[i], 1);
        }
        int target = nums.length/3;
        List<Integer> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> pair : frequencies.entrySet()){
            if (pair.getValue() > target){
                list.add(pair.getKey());
            }
        }
        return list;
    }
}
