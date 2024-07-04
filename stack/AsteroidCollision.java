/*
735. Asteroid Collision
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction
(positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Constraints:
2 <= asteroids.length <= 10^4
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */
package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(asteroidCollision(new int[]{1,-2,-2,-2})));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int clash;
        boolean flag = false;
        for(int a: asteroids) {
            if (!stack.isEmpty()) {
                clash = stack.peekLast();
                if(a < 0 && Integer.signum(clash) != Integer.signum(a)) {
                    while (!stack.isEmpty() && Integer.signum(clash) != Integer.signum(a)) {
                        if(Math.abs(clash) < Math.abs(a)) {
                            stack.pollLast();
                            flag = true;
                        }
                        else if (Math.abs(clash) == Math.abs(a)) {
                            stack.pollLast();
                            flag = false;
                            break;
                        }
                        else {
                            flag = false;
                            break;

                        }
                        if(!stack.isEmpty()) clash = stack.peekLast();
                    }
                    if(flag) stack.offer(a);

                }
                else stack.offer(a);
            }
            else {
                stack.offer(a);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
