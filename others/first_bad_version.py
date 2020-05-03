from math import ceil
def firstBadVersion(n):
        """
        :type n: int
        :rtype: int
        """
        if n > 1:
            mid = n//2
            bad_version = 0
            good_version = 0
            while mid > 0 and mid <= n:
                print(mid)
                if isBadVersion(mid):
                    bad_version = mid
                    mid = int((good_version + mid) / 2)
                else:
                    good_version = mid
                    mid += ceil((n - mid)/2)

                if bad_version - good_version == 1:
                    return bad_version
        return n


def isBadVersion(n):
    if n >= 2126753390:
        return True
    return False

print(firstBadVersion(2126753390))
