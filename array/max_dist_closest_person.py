'''
You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
There is at least one empty seat, and at least one person sitting.
Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
Return that maximum distance to the closest person.

Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.

Input: seats = [1,0,0,0]
Output: 3
Explanation:
If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
'''
import math
def maxDistToClosest(seats: list([int])) -> int:
    i = 0
    vacant = 0
    max_dist = 0
    cur_dist = 0
    while i < len(seats):
        # print(i, vacant,seats[i])
        if seats[i] == 0:
            vacant += 1
            if len(seats) - i == 1:
                cur_dist = vacant
        else:
            if i - vacant == 0:
                cur_dist = vacant
            else:
                cur_dist = math.ceil(vacant / 2)
            vacant = 0

        if max_dist < cur_dist:
            max_dist = cur_dist
        i += 1

    return max_dist

print(maxDistToClosest([1,1,0,0,0,0]))