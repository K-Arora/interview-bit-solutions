package com.karanarora.interviewbit.leetcode.arrays;

import org.junit.jupiter.api.Test;

/**
 * @author gs-karora on 10/08/20
 */
class RemoveDuplicateFromSortedArrTest {

  @Test
  void removeDuplicates() {

    RemoveDuplicateFromSortedArr test = new RemoveDuplicateFromSortedArr();
    int[] arr = {0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5};
    int len = test.removeDuplicates(arr);
    System.out.println(len);

    for (int j = 0; j < arr.length; j++) {
      System.out.print(" " + arr[j] + " ");
    }
  }


  @Test
  void removeDuplicatesTest1() {

    RemoveDuplicateFromSortedArr test = new RemoveDuplicateFromSortedArr();
    int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int len = test.removeDuplicates(arr);
    System.out.println(len);

    for (int j = 0; j < arr.length; j++) {
      System.out.print(" " + arr[j] + " ");
    }
  }

}

//