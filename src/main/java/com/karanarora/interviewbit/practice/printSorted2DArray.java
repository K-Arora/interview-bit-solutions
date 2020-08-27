package com.karanarora.interviewbit.practice;

import java.util.PriorityQueue;

/**
 * @author gs-karora on 06/08/20
 */
public class printSorted2DArray {


  void printSortedArray(int[][] arr, int length) {

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int[] ints : arr) {

      for (int number : ints) {

        queue.offer(number);
      }
    }

  }

}
