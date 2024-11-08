package array;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) throws InterruptedException{
        System.out.println(maxDistance(new int[]{5,4,3,2,1,1000000000}, 1));

    }

    public static int maxDistance(int[] position, int m) throws InterruptedException {
        Arrays.sort(position);
        int[] allPositions = new int[m];
        int idx = 2;
        allPositions[0] = 1;
        m--;
        if (m > 0) {
            allPositions[1] = position[position.length-1];
            m--;
        }


        if ( m > 0) {
            int mid = maxDistanceBinarySearch(allPositions, 0, allPositions.length, idx);
            idx++;
            m--;

            int l = m / 2;
            int r = m - l;
            while (l > 0) {
                mid = maxDistanceBinarySearch(allPositions, 0, mid - 1, idx);
                idx++;
                l--;
            }

            while (r > 0) {
                mid = maxDistanceBinarySearch(allPositions, mid + 1, allPositions.length, idx);
                idx++;
                r--;
            }
        }

//        Arrays.sort(allPositions);
        int result = Integer.MAX_VALUE;
//        int prev = -1;
//        for(int i=1;i<=allPositions.length;i++) {
//            System.out.println(prev+" val: "+allPositions[i-1]);
////            sleep(1000);
//            if (prev == -1 && allPositions[i-1] == 1) prev = i;
//            else if(allPositions[i-1] == 1) {
//                result = Math.min(result, i - prev);
//            }
//        }
        if (m > 1) {
            Arrays.sort(allPositions);
            for(int i=1;i<allPositions.length;i++) {
                result = Math.min(result, allPositions[i] - allPositions[i-1]);
            }
            return result;
        }

    return 0;
    }

    public static int maxDistanceBinarySearch(int[] allPositions, int l ,int r, int idx) {

        int m = (l + r) / 2;
        System.out.println(l+" r: "+r);
        allPositions[idx] = m;

        return m;
    }
}
