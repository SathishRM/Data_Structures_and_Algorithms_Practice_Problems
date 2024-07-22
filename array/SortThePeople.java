package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortThePeople {
    public static void main(String[] args) {
        String[] result = sortPeople(new String[]{"Mary","John","Emma"},
                new int[]{180,165,170});
        System.out.println(Arrays.toString(result));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for(int i=0;i<heights.length;i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        for(int i=heights.length-1;i>=0;i--){
            names[heights.length-1-i] = map.get(heights[i]);
        }
        return names;
    }
}
