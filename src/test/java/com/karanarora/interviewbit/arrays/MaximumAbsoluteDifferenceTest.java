package com.karanarora.interviewbit.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author gs-karora on 11/07/20
 */
class MaximumAbsoluteDifferenceTest {

  @Test
  void maxArrSolution2() {
    MaximumAbsoluteDifference maximumAbsoluteDifference = new MaximumAbsoluteDifference();
    List<Integer> integers = Arrays.asList(1, 3, -1);
    int i = maximumAbsoluteDifference.maxArrSolution1(integers);
    System.out.println("Answer: " + i);
  }

  @Test
  void maxArrSolution1() {
  }
}