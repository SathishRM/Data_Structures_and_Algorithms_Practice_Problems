'''
Design an Iterator class, which has:
A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
Example:
CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
'''

class CombinationIterator:

    def __init__(self, characters: str, combinationLength: int):

        self.combination_queue = []
        def get_combination(start, length, str_com):
            if length == 0:
                self.combination_queue.append(str_com)
                return None
            for i in range(start, len(characters) - length + 1):
                get_combination(i+1,length-1,str_com+characters[i])

        get_combination(0, combinationLength, '')


    def next(self) -> str:
        if self.combination_queue:
            return self.combination_queue.pop(0)


    def hasNext(self) -> bool:
        return True if self.combination_queue else False


iter = CombinationIterator('abcdef', 3)
print(iter.next())
print(iter.hasNext())
print(iter.next())
