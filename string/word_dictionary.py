class TrieNode:
    def __init__(self):
        self._noChildren = 26
        self.children = [None] * self._noChildren
        self.isEnd = False


class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.words = self.getNode()
        self.dotIndex = 0

    def getNode(self) -> TrieNode:
        return TrieNode()

    def _charToIndex(self, char: str) -> int:
        return ord(char) - ord('a')

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        node = self.words
        for char in word:
            index = self._charToIndex(char)
            if not node.children[index]:
                node.children[index] = self.getNode()
            node = node.children[index]

        node.isEnd = True

    def searchWord(self, word: str, index: int, node: TrieNode) -> list([TrieNode]):
        if index == len(word):
            return node.isEnd
        char = word[index]
        if char == '.':
            for i in range(node._noChildren):
                if node.children[i] != None and self.searchWord(word, index+1, node.children[i]):
                    return True
            return False
        else:
            i = self._charToIndex(char)
            return node.children[i] != None and self.searchWord(word, index+1, node.children[i])


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        return self.searchWord(word, 0, self.words)



# Your WordDictionary object will be instantiated and called as such:
obj = WordDictionary()
obj.addWord('hello')
obj.addWord('ant')
obj.addWord('animals')
print(obj.search('an.'))
print(obj.search('andy'))
