package com.karanarora.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Link to the question - https://www.interviewbit.com/problems/maximum-absolute-difference/
 *
 * @author K-arora on 11/07/20
 */
public class MaximumAbsoluteDifference {

  private static int calculateDiff(int i, int j, List<Integer> array) {

    return Math.abs(array.get(i) - array.get(j)) + Math.abs(i - j);
  }

  /**
   * 2nd Optimized Solution.
   *
   * @param array - array
   * @return - number
   */
  public int maxArrSolution2(ArrayList<Integer> array) {

    System.out.println("********** Optimized Solution **********");
    int max1 = Integer.MIN_VALUE;
    int min1 = Integer.MAX_VALUE;
    int max2 = Integer.MIN_VALUE;
    int min2 = Integer.MAX_VALUE;

    for (int i = 0; i < array.size(); i++) {

      max1 = Math.max(max1, array.get(i) + i);
      min1 = Math.min(min1, array.get(i) + i);
      max2 = Math.max(max2, array.get(i) - i);
      min2 = Math.min(min2, array.get(i) - i);

    }
    // for(int j = i; j < array.size(); j++) {

    //     if(i != j) {

    //         int value = calculateDiff(i, j, array);
    //         if (max_value < value) {
    //             max_value = value;

    //         }
    //     }
    // }
    return Math.max(max1 - min1, max2 - min2);
  }

  /**
   * Brute Force.
   *
   * @param array - array.
   * @return - number.
   */
  public int maxArrSolution1(List<Integer> array) {

    int max_value = -9999;

    for (int i = 0; i < array.size(); i++) {
      for (int j = i; j < array.size(); j++) {

        if (i != j) {
          int value = calculateDiff(i, j, array);
          if (max_value < value) {
            max_value = value;

          }
        }
      }
    }
    return max_value;
  }

   public static void main(String[] args) {
     System.out.println("Hello World");
  }
}
