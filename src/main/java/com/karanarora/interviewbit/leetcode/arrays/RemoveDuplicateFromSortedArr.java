package com.karanarora.interviewbit.leetcode.arrays;

/**
 * @author gs-karora on 10/08/20
 */
public class RemoveDuplicateFromSortedArr {

    public int removeDuplicates(int[] nums) {

      int uniqueLength = 0;
      int number = nums[0];
      int duplicateCount = 0;
      int size = nums.length;
      for (int i = 1; i < size; i++) {

        if (nums[i] == number) {

          duplicateCount++;

        } else if (duplicateCount > 0){
//          uniqueLength++;
          number = nums[i];
          nums[i-duplicateCount] = number;
          duplicateCount = 0;
        } else {
          uniqueLength++;
        }
      }
        uniqueLength++;
      return uniqueLength;
    }


}
