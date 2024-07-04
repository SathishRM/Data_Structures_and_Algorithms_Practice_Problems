package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(intersect(
                new int[]{1,2,2,1},
                new int[]{2,2}
        )));

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> small = new HashMap<>();
        Map<Integer, Integer> big = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int v;

        if(nums1.length < nums2.length) {
            for(int n: nums1) {
                v = small.getOrDefault(n,0);
                small.put(n,v+1);
            }
            for(int n: nums2) {
                v = big.getOrDefault(n,0);
                big.put(n,v+1);
            }
        }
        else {
            for(int n: nums1) {
                v = big.getOrDefault(n,0);
                big.put(n,v+1);
            }
            for(int n: nums2) {
                v = small.getOrDefault(n,0);
                small.put(n,v+1);
            }
        }

        for(Integer k: small.keySet()) {
            v = Math.min(small.get(k),big.getOrDefault(k,0));
            while (v > 0) {
                result.add(k);
                v--;
            }
        }
        // System.out.println(small.toString()+","+big.toString()+","+result.toString());

        return result.stream().mapToInt(i -> i).toArray();
    }
}
