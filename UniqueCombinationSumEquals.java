// Given an array of positive integers arr[] and a sum x, 
// find all unique combinations in arr[] where the sum is equal to x
//
// 

import java.io.*;
import java.util.*;

class UniqueCombinationSumEquals {

  public static void main(String[] args) {
    
    Integer[] arr = {10,1,2,7,6,1,5};
    int target = 8;

    System.out.println(getUniqueCombinationSumEquals(arr, target));
  }

  private static List<List<Integer>> getUniqueCombinationSumEquals(Integer[] arr, int target) {

    List<List<Integer>> result = new ArrayList<>();

    // Sort the Array (for unique combination)
    Arrays.sort(arr);

    recursiveCall(0, result, new ArrayList<>(), arr, target);
    return result;
  }

  private static void recursiveCall(int pos, List<List<Integer>> result, List<Integer> local, Integer[] arr, int target) {

    if (getSum(local) == target) {
      result.add(new ArrayList<>(local));
      return;
    }

    for (int i=pos; i<arr.length; i++) {

      // check if sum exceeds target
      if (getSum(local)+arr[i] > target) {
        continue;
      }

      // check if this combination already exists (for unique combination)
      if (i>pos && Objects.equals(arr[i], arr[i-1])) {
        continue;
      }

      // Take the element into combination
      local.add(arr[i]);

      // RecursiveCall
      recursiveCall(i+1, result, local, arr, target);

      // Remove element from the combination
      local.remove(local.size()-1);
    }
  }

  private static int getSum(List<Integer> list) {
    int sum=0;
    for(int i: list) {
      sum = sum + i;
    }
    return sum;
  }
}
