package com.karanarora.interviewbit;

/**
 * @author gs-karora on 17/11/20
 */
public class Solution {
  public int[] twoSum(int[] nums, int target) {

    int[] result = new int[2];
    result[0] = Integer.MIN_VALUE;
    result[1] = Integer.MIN_VALUE;

    for (int outer = 0; outer < nums.length - 1; outer++) {

      // System.out.println("i "+outer);


      for (int inner = outer + 1; inner < nums.length; inner++) {

        // System.out.println("outer "+outer+"  inner  "+inner);
        // similarly optimizattion for inerr loop
        if (nums[outer] + nums[inner] == target) {

          result[0] = outer;
          result[1] = inner;
          return result;
        }
      }

    }
    return result;
  }


  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

    return perform(word1, word2);
  }

  private boolean perform(String[] word1, String[] word2) {
    String result1 = "";
    String result2 = "";


    for (int i = 0; (i < word1.length || i < word2.length); i++) {

      if (word1.length > i)
        result1 = result1.concat(word1[i]);

      if (word2.length > i)
        result2 = result2.concat(word2[i]);
    }

    return result1.equals(result2);
  }
}
