package com.karanarora.interviewbit;

/**
 * @author gs-karora on 27/08/20
 */

public class example {
  public static void main(String[] args) throws Exception {
    // Your code here!
//    Map<String, String> map = new HashMap<>();
//    map.put("helo", "world");
//    map.put(null, "world");
//    map.put(null, "w2");
//    map.put(null, "w3");
//    map.put(null, null);
//
//    map.forEach((k,v) ->
//        System.out.println("key: "+k +"  val:"+v));
//    System.out.println("XXXXXXXX");

//    int[] a = {7, 1, 5, 3, 6, 4};
//    System.out.println("profit:  " + maxProfit(a));
//
//    int[] b = {7, 1, 5, 3, 6, 9, 15};
//    System.out.println("profit:  " + maxProfit(b));
//
//    int[] c = {6, 5, 4, 4, 3, 2, 1};
//    System.out.println("profit:  " + maxProfit(c));
//
//    int[] d = {1, 5, 7, 4, 1};
//    System.out.println("profit:  " + maxProfit(d));
//
//    int[] e = {2, 2, 5};
//    System.out.println("profit:  " + maxProfit(e));
//
//    int[] f = {2, 4, 1};
//    System.out.println("profit:  " + maxProfit(f));

    int[] g = {2, 1, 2, 0, 1};
    System.out.println("profit:  " + maxProfit(g));
  }

  public static int maxProfit(int[] a) {

    int profit = 0;
    int openPrice = a[0];
    int closedPrice = -99;
    int openDate = 0;
    int closedDate = -99;
    int openFinalPrice = 0;
    int openFinalDate = 0;

    for (int i = 1; i < a.length; i++) {

      if (openPrice > a[i]) {

        openPrice = a[i];
        openDate = i;
//        closedPrice = Integer.MIN_VALUE;
        System.out.println("open: " + openPrice + " i: " + i);
      } else if (closedPrice < a[i] && (closedPrice - openPrice >= 0 || closedPrice == -99)) { // || closedPrice == Integer.MIN_VALUE)
        closedPrice = a[i];
        closedDate = i;
        openFinalPrice = openPrice;
        openFinalDate = openDate;
        System.out.println("close: " + closedPrice + " i: " + i);
      } else if (closedPrice - openFinalPrice > 0 && closedDate - openFinalDate > 0) {
        profit += (closedPrice - openFinalPrice);
        openPrice = a[i];
        openDate = i;
        closedPrice = -99;
        System.out.println("profit: " + profit + " i: " + i);

      }
    }
    if (closedPrice - openFinalPrice > 0 && closedDate - openFinalDate > 0) {
      profit += closedPrice - openFinalPrice;
    }

    return profit;


  }
}

