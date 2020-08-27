package com.karanarora.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gs-karora on 11/07/20
 * <p>
 * <p>
 * Problem - https://www.interviewbit.com/problems/partitions/
 * References - https://www.geeksforgeeks.org/count-the-number-of-ways-to-divide-an-array-into-three-contiguous-parts-having-equal-sum/
 * * a
 * First solution -
 * @see com.karanarora.interviewbit.arrays.PartitionArray#partitionArrayIntoThreeParts(List).
 * This is an incorrect solution for test case -
 * @see com.karanarora.interviewbit.arrays.PartitionArrayTest#testPartitionArrayTest5EdgeCase().
 * <p>
 * Second Solution :
 * @see com.karanarora.interviewbit.arrays.PartitionArray#countWays(ArrayList, int).
 * This will work fine for all the test cases.
 */
public class PartitionArray {

  static int binarysearch(List<Integer> v, int x) {
    int low = 0, high = v.size() - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (v.get(mid) <= x)
        low = mid + 1;
      else if (v.get(mid) > x) // && v.get(mid) <= x)
        return mid;
      else if (v.get(mid) > x && mid == 0)
        return mid;
      else
        high = mid - 1;
    }
    return -1;
  }

  public int partitionArrayIntoThreeParts(List<Integer> arrayList) {

    int totalSum = getSum(arrayList);
    if (0 != totalSum % 3) {
      return 0;
    }
    int originalSize = arrayList.size();
    /*Dealing with prefix array*/
    List<Integer> prefixSumArray = new ArrayList<>(originalSize);
    prefixSumArray.add(0, arrayList.get(0));
    for (int i = 1; i < originalSize; i++) {

      int preSum = prefixSumArray.get(i - 1) + arrayList.get(i); // Each element will have totalSum of its own and all the elements before its position.
      prefixSumArray.add(i, preSum);
    }
    /*Dealing with suffix array*/
    List<Integer> suffixIndexPositions = new ArrayList<>();

    int[] suffixSumArray = new int[originalSize];

    suffixSumArray[originalSize - 1] = arrayList.get(originalSize - 1);
    for (int i = originalSize - 2; i > -1; i--) {
      suffixSumArray[i] = suffixSumArray[i + 1] + arrayList.get(i); // Each element will have totalSum of its own and all the elements after that.
    }

    System.out.println("  *************************    ");

    /* Printing the arrays*/
    System.out.println("Prefix Array: " + prefixSumArray);
    System.out.print("Suffix Array: [");
    for (int i = 0; i < suffixSumArray.length; i++) {
      System.out.print("" + suffixSumArray[i] + ", ");
    }
    System.out.println("\n  *************************    ");


    System.out.println("  Iterating on Suffix array    ");
    for (int i = 0; i < suffixSumArray.length; i++) {
      if ((totalSum / 3) == suffixSumArray[i]) {
        System.out.println("Adding the index position: \"" + i + "\" to suffix index array with equal sum: " + totalSum / 3);
        suffixIndexPositions.add(i);
      }
    }
    System.out.println("  *************************    ");

    int count = 0;
    for (int i = 0; i < originalSize; i++) {

      System.out.println("prefix sum : " + prefixSumArray.get(i) + "  Index: " + i);
      // We found a prefix with total_sum/3
      if (prefixSumArray.get(i) == totalSum / 3) {
        System.out.println("**** prefix sum is same for index: " + i);
        // Find first index in v[] which is greater than i+1.
        int res = binarysearch(suffixIndexPositions, i + 1);
        System.out.println("result for prefix array index: " + i + " is: " + res);

        if (res != -1)
          count += suffixIndexPositions.size() - res;
        System.out.println("-----Count:    " + count);
      }
    }
    System.out.println("  *************************    ");
    System.out.println("  Final Result:  " + count);
    return count;
  }

  private int getSum(List<Integer> arrayList) {
    return arrayList
        .stream()
        .reduce(0, Integer::sum);
  }


  public int countWays(ArrayList<Integer> array, int n) {
    int[] count = new int[n];
    int totalSum = 0;

    // Calculating the sum of the array
    // and storing it in variable totalSum
    for (int i = 0; i < n; i++) {
      totalSum += array.get(i);
    }

    // Checking totalSum is divisible by 3 or not
    if (totalSum % 3 != 0)
      return 0;

    // Calculating the sum of each part
    int partSum = totalSum / 3;

    int suffixSum = 0;

    // If the sum of elements from i-th to n-th
    // equals to sum of part putting 1 in count
    // array otherwise 0.
    for (int i = n - 1; i >= 0; i--) {
      suffixSum += array.get(i);
      if (suffixSum == partSum)
        count[i] = 1;
    }

    // Calculating the cumulative sum
    // of the array count from the last index.
    for (int i = n - 2; i >= 0; i--)
      count[i] += count[i + 1];

    int ans = 0;
    int prefixSum = 0;

    // Calculating answer using original
    // and count array.
    for (int i = 0; i + 2 < n; i++) {
      prefixSum += array.get(i);
      if (prefixSum == partSum)
        ans += count[i + 2];
    }
    return ans;
  }
}
