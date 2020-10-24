'''
You have a RecentCounter class which counts the number of recent requests within a certain time frame.

Implement the RecentCounter class:

RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]

Explanation
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
'''
from collections import deque

class RecentCounter:
    #approach-1 using deque
    def __init__(self):
        self.counter = deque()

    def ping(self, t: int) -> int:
        self.counter.append(t)
        while self.counter[0] < t - 3000:
            self.counter.popleft()

        return len(self.counter)

    #approach-2 using list
    '''
    def __init__(self):
        self.counter = []
        self.prev_start_index = None


    def ping(self, t: int) -> int:
        self.counter.append(t)
        result = 0
        start_range = t - 3000
        if start_range > self.counter[0]:
            if start_range in self.counter:
                start_index = self.counter.index(start_range)
            else:
                while start_range > self.counter[self.prev_start_index]:
                    self.prev_start_index += 1
                start_index = self.prev_start_index
        else:
            start_index = 0

        end_index = self.counter.index(t)
        self.prev_start_index = start_index
        return end_index - start_index + 1
    '''



# Your RecentCounter object will be instantiated and called as such:
obj = RecentCounter()
param_1 = obj.ping(100) #[-2900,100]
param_2 = obj.ping(350) #[-2650,350]
param_3 = obj.ping(2000) #[-1000, 2000]
param_4 = obj.ping(3100) #[100,3100]
param_5 = obj.ping(3500) #[500,3500]
print(param_1,param_2,param_3,param_4,param_5)
