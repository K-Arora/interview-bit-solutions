package com.karanarora.interviewbit.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gs-karora on 24/07/20
 */
class LargestNumberFormedTest {

  @Test
  void testLargestNumberSameLengthDigits() {

    List<Integer> list = new ArrayList<>();
    list.addAll(Arrays.asList(1, 51, 7, 6, 10));  // 58, 59, 60
    LargestNumberFormed testClass = new LargestNumberFormed();
    System.out.println("result: " + testClass.largestNumberNew(list));
    Assertions.assertEquals("7651110", testClass.largestNumberNew(list));
  }

  @Test
  void testLargestNumberCloserNumbers() {

    List<Integer> list = new ArrayList<>();
    list.addAll(Arrays.asList(34, 5, 9, 3, 30));

    //3, 30, 34
//    3, 30, 34, 5, 9
    //8,89
    LargestNumberFormed testClass = new LargestNumberFormed();
    Assertions.assertEquals("9534330", testClass.largestNumberNew(list));
  }


  @Test
  void testLargestNumberAllZeroes() {

    List<Integer> list = new ArrayList<>();
    list.addAll(Arrays.asList(0, 0, 0, 0, 0));

    //3, 30, 34
//    3, 30, 34, 5, 9
    //8,89
    LargestNumberFormed testClass = new LargestNumberFormed();
    Assertions.assertEquals("0", testClass.largestNumberNew(list));
  }

  @Test
  void testLargestNumberCloserNumbers2() {

    List<Integer> list = new ArrayList<>();
    list.addAll(Arrays.asList(8, 89));

    //3, 30, 34
//    3, 30, 34, 5, 9
    //
    LargestNumberFormed testClass = new LargestNumberFormed();
    Assertions.assertEquals("898", testClass.largestNumberNew(list));
  }
}