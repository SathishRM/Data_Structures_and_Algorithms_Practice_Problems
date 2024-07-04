package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));

    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> count = new HashMap<>();
        Set<Integer> uc = new HashSet<>();
        int v;

        for(int n: arr) {
            v = count.getOrDefault(n,0);
            count.put(n,v+1);
        }

        for(Integer n: count.values()) {
            if(uc.contains(n)) return false;
            uc.add(n);
        }
        return true;

    }
}
