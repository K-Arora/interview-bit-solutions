package com.karanarora.interviewbit.arrays;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author gs-karora on 22/07/20.
 * Largest number formed from appending all the integers from the array.
 */
public class LargestNumberFormed {


  public void swap(List<Integer> list, int i, int j) {

    int temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }

  public String largestNumberNew(List<Integer> arrayList) {

    Collections.sort(arrayList, new CustomComparator());

    return getString(arrayList);
  }

  private String getString(List<Integer> arrayList) {
    int countZeroes = 0;
    StringBuilder joiner = new StringBuilder();
    for (Integer i : arrayList) {
      String s = i.toString();
      joiner.append(s);
      if (i == 0)
        countZeroes++;
    }
    if (countZeroes == arrayList.size())
      return "0";
    return joiner.toString();
  }

  private boolean isSwapRequiredNew(Integer integer1, Integer integer2) {

    if (integer1.equals(integer2))
      return false;
    String str1 = new StringBuilder().append(integer1).append(integer2).toString();
    long value1 = Long.parseLong(str1);
    String str2 = new StringBuilder().append(integer2).append(integer1).toString();
    long value2 = Long.parseLong(str2);
    return value2 > value1;
  }

  /*Wrong function*/
  private boolean isSwapRequired(Integer integer1, Integer integer2) {

    String string1 = String.valueOf(integer1);
    String string2 = String.valueOf(integer2);

    int smaller = Math.min(integer1, integer2);
    int lengthOfSmaller = String.valueOf(smaller).length();

    int bigger = Math.max(integer1, integer2);
    int lengthOfBigger = String.valueOf(bigger).length();


    for (int i = 0; i < lengthOfSmaller; i++) {

      int digit1 = Character.getNumericValue(string1.charAt(i));
      int digit2 = Character.getNumericValue(string2.charAt(i));
      /* Why returning true even on equal digits? Because if it would have been a case of same length [3,3] then, it wouldn't have been here.
       * It is coming to this condition simply implies  case of [3,30] or [3,33]   */
      if (digit2 > digit1) {
        return true;
      } else if (digit2 == digit1 && lengthOfBigger > lengthOfSmaller) {
        return true;
      }
    }


    int secondLastDigit = Character.getNumericValue(string2.charAt(lengthOfSmaller - 1));
    int lastDigit = Character.getNumericValue(string2.charAt(lengthOfSmaller));


    return false;
  }


  /*Wrong function*/
  private boolean isSwapRequired1(Integer integer1, Integer integer2) {

    if (integer1.equals(integer2))
      return false;

    boolean alreadySwapped = false;

    // integer2 is always > integer1.
    if (integer1 > integer2) {
      int temp = integer1;
      integer1 = integer2;
      integer2 = temp;
      alreadySwapped = true;
    }


    String string1 = String.valueOf(integer1);
    String string2 = String.valueOf(integer2);

    int lengthOfSmaller = String.valueOf(integer1).length();


    boolean myResult = false;
    for (int i = 0; i < lengthOfSmaller; i++) {

      int digit1 = Character.getNumericValue(string1.charAt(i));
      int digit2 = Character.getNumericValue(string2.charAt(i));
      /* Why returning true even on equal digits? Because if it would have been a case of same length [3,3] then, it wouldn't have been here.
       * It is coming to this condition simply implies  case of [3,30] or [3,34]   */
      if (digit2 > digit1) {
        myResult = true;
        break;
      }
    }
    int secondLastDigit = Character.getNumericValue(string2.charAt(lengthOfSmaller - 1));
    int lastDigit = Character.getNumericValue(string2.charAt(lengthOfSmaller));
    if (lastDigit > secondLastDigit) {
      myResult = true;
    }
    if (alreadySwapped) {
      return !myResult;
    }
    return myResult;
  }

  public String largestNumber(List<Integer> arrayList) {

    for (int i = 0; i < arrayList.size(); i++) {

      boolean flag = false;

      for (int j = 0; j < arrayList.size() - i - 1; j++) {

        Integer integer1 = arrayList.get(j);
        Integer integer2 = arrayList.get(j + 1);
        String string1 = String.valueOf(integer1);
        String string2 = String.valueOf(integer2);


        // whether a swap is required, if both are of same lengths.
        if ((string1.length() == string2.length() && integer2 > integer1) || isSwapRequiredNew(integer1, integer2)) {

//        System.out.println(" i, j : " + i + j + arrayList);
          flag = true;
          swap(arrayList, j, j + 1);
//          arrayList.set(i, arrayList.set(j, arrayList.get(i)));

        }
      }
      // if no swapping happened.
      if (!flag) {
//        System.out.println("No swapping happened");
        break;
      }
    }
//    System.out.print("Result: " + arrayList);

    return getString(arrayList);
  }


  class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {

      boolean swapRequiredNew = isSwapRequiredNew(i1, i2);
      if (swapRequiredNew) {
        return 1;
      } else if (!swapRequiredNew)
        return -1;
      return 0;
    }
  }
}
  class MyCompartor implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      String first = s1 + s2;
      String second = s2 + s1;
      return second.compareTo(first);
    }
  }

