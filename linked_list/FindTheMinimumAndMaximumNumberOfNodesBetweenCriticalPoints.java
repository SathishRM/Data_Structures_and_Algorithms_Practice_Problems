package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        int[] result = nodesBetweenCriticalPoints(
                new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(2,
                        new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(1)))))))));
        System.out.println(java.util.Arrays.toString(result));

    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int pre=head.val, i=2, minValue=Integer.MAX_VALUE, fi=-1, pi=-1;
        int[] result = {-1, -1};
        boolean flag = false;
        head = head.next;
        while(head.next != null) {
            if (pre > head.val && head.val < head.next.val) {
                if(!flag) {
                    fi = i;
                }
                else {
                    minValue = (fi != -1 && pi == -1) ? Math.min(minValue, i-fi) : Math.min(minValue, i-pi);
                    pi = i;
                }
                flag = true;
            }
            else if (pre < head.val && head.val > head.next.val) {
                if(!flag) fi = i;
                else {
                    minValue = (fi != -1 && pi == -1) ? Math.min(minValue, i-fi) : Math.min(minValue, i-pi);
                    pi = i;
                }
                flag = true;
            }
            i++;
            pre = head.val;
            head = head.next;
        }

        if(flag && pi != -1 && fi != -1) {
            result[0] = minValue;
            result[1] = pi - fi;
        }
        return result;
    }

    // Approach-2 using collections

//    public static int[] nodesBetweenCriticalPoints(ListNode head) {
//        int pre=head.val, i=2, s, c, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
//        List<Integer> optimalNodes = new ArrayList<>();
//        int[] result = {-1, -1};
//        boolean flag = false;
//        head = head.next;
//        while(head.next != null) {
//            if (pre > head.val && head.val < head.next.val) {
//                optimalNodes.add(i);
//                // System.out.println("less i:"+i+" val:"+head.val);
//            }
//            else if (pre < head.val && head.val > head.next.val) {
//                optimalNodes.add(i);
//                // System.out.println("i:"+i+" val:"+head.val);
//            }
//
//            i++;
//            pre = head.val;
//            head = head.next;
//        }
//        // System.out.println(optimalNodes);
//
//        if(optimalNodes.size() > 1) {
//            s = optimalNodes.size();
//            pre = optimalNodes.get(0);
//            for(int j=1;j<s;j++) {
//                c = optimalNodes.get(j);
//                min = Math.min(min, c-pre);
//                pre = c;
//            }
//            result[0] = min;
//            result[1] = optimalNodes.get(s-1) - optimalNodes.get(0);
//        }
//        return result;
//
//
//    }
}
