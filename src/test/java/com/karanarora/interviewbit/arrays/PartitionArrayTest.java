package com.karanarora.interviewbit.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gs-karora on 13/07/20
 */
class PartitionArrayTest {


  @Test
  void testPartitionArrayTest1() {

    PartitionArray partitionArray = new PartitionArray();
    List<Integer> integers = Arrays.asList(1, 2, 3, 0, 3);
//    List<Integer> integers = Arrays.asList(1, 3, 4, 0, 4);
    // 0, 1, -1, 0
    //1, 3, 4, 0, 4
    System.out.println("Original Array: " + integers);
    partitionArray.partitionArrayIntoThreeParts(integers);
    Assertions.assertEquals( 2 , partitionArray.partitionArrayIntoThreeParts(integers));
    Assertions.assertEquals( 2 , partitionArray.countWays(new ArrayList<>(integers), integers.size()));

  }

  @Test
  void testPartitionArrayTest2() {

    PartitionArray partitionArray = new PartitionArray();
    List<Integer> integers = Arrays.asList(1, 3, 6, 2, 7, 1, 2, 8);
    System.out.println("Original Array: " + integers);
    partitionArray.partitionArrayIntoThreeParts(integers);
    Assertions.assertEquals( 1 , partitionArray.partitionArrayIntoThreeParts(integers));
    Assertions.assertEquals( 1 , partitionArray.countWays(new ArrayList<>(integers), integers.size()));

  }

  @Test
  void testPartitionArrayTest3() {

    PartitionArray partitionArray = new PartitionArray();
    List<Integer> integers = Arrays.asList(0, 1, -1, 0);
    System.out.println("Original Array: " + integers);
    partitionArray.partitionArrayIntoThreeParts(integers);
    Assertions.assertEquals( 1 , partitionArray.partitionArrayIntoThreeParts(integers));
    Assertions.assertEquals( 1 , partitionArray.countWays(new ArrayList<>(integers), integers.size()));

  }

  @Test
  void testPartitionArrayTest5EdgeCase() {

    PartitionArray partitionArray = new PartitionArray();
    List<Integer> integers = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);
    System.out.println("Original Array: " + integers);
    Assertions.assertEquals( 24 , partitionArray.partitionArrayIntoThreeParts(integers));
    Assertions.assertEquals( 28, partitionArray.countWays(new ArrayList<>(integers), integers.size())); // correct one is 28.

  }



  @Test
  void testPartitionArrayTest4NegativeCase() {

    PartitionArray partitionArray = new PartitionArray();
    List<Integer> integers = Arrays.asList(7, 6, 2, 7);
    System.out.println("Original Array: " + integers);
    partitionArray.partitionArrayIntoThreeParts(integers);
    Assertions.assertEquals( 0 , partitionArray.partitionArrayIntoThreeParts(integers));
    Assertions.assertEquals( 0 , partitionArray.countWays(new ArrayList<>(integers), integers.size()));
  }




}