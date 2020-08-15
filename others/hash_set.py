class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.value = list()


    def add(self, key: int) -> None:
        if key not in self.value:
            self.value.append(key)


    def remove(self, key: int) -> None:
        if key in self.value:
            self.value.remove(key)


    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if key in self.value:
            return True
        else:
            return False



# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(2)
obj.remove(3)
param_3 = obj.contains(2)
print(param_3)
