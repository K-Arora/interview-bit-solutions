package com.karanarora.interviewbit.leetcode.arrays;

/**
 * @author gs-karora on 04/01/21
 */
public class Permutation {

  public static void main(String[] args) {

    int[] arr = {1, 2, 3};
    Permutation permutation = new Permutation();
    permutation.permute(arr, 0, arr.length - 1);
  }


  public void permute(int[] arr, int l, int r) {
    if (l == r) {
      for (int i : arr) {
        System.out.print(i);
      }
      System.out.println();

    } else {
      for (int i = l; i <= r; i++) {
        arr = swap(arr, l, i);
        permute(arr, l + 1, r);
        arr = swap(arr, l, i);
      }
    }
  }


  /**
   * Swap Characters at position
   *
   * @param arr string value
   * @param i   position 1
   * @param j   position 2
   * @return swapped string
   */
  public int[] swap(int[] arr, int i, int j) {
    int temp;
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return arr;
  }
}
