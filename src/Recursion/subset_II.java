package Recursion;

import java.util.*;
public class subset_II {
        public static void findSubsets(int ind, int[] arr, List<Integer> ds, List<List<Integer>> ansList) {
            ansList.add(new ArrayList<>(ds));
            for(int i=ind; i<arr.length;i++){
                if(i != ind && arr[i] == arr[i-1]) {
                    continue;
                }
                ds.add(arr[i]);
                findSubsets(i+1, arr, ds, ansList);
                ds.remove(ds.size() - 1);
            }
    }
    public static void main(String[] args) {
        int arr[] ={3,1,2,4};
        Arrays.sort(arr);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, arr, new ArrayList<>(), ansList);
        System.out.println(ansList);
    }
}