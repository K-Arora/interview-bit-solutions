package com.karanarora.interviewbit.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author gs-karora on 19/12/20
 */
public class EasyQuestionsLeetCode {



  public void rotate1(int[] nums, int k) {

    k = k % nums.length;

    for (int j = 0; j < k; j++) {
      int lastElement = nums[nums.length - 1];
      for (int i = nums.length; i > 0; i--) {

        nums[i] = nums[i - 1];
      }
      nums[0] = lastElement;

    }
  }

  public void rotate2(int[] nums, int k) {

    k = k % nums.length;

    for (int j = 0; j < k; j++) {
      int lastElement = nums[nums.length - 1];
      for (int i = nums.length; i > 0; i--) {

        nums[i] = nums[i - 1];
      }
      nums[0] = lastElement;

    }
  }

  public boolean containsDuplicate1(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      if (set.contains(i))
        return true;
      else
        set.add(i);
    }
    return false;
  }
}
