class TrieNode:

    def __init__(self):
        self.__noChildren = 26
        self.children = [None] * self.__noChildren
        self.isEnd = False


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.getNode()

    def getNode(self) -> TrieNode:
        return TrieNode()

    def _charToIndex(self, char: str) -> int:
        return ord(char) - ord('a')


    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for char in word:
            index = self._charToIndex(char)
            if not node.children[index]:
                node.children[index] = self.getNode()
            node = node.children[index]

        node.isEnd = True


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for char in word:
            index = self._charToIndex(char)
            if not node.children[index]:
                return False
            node = node.children[index]

        return node != None and node.isEnd


    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for char in prefix:
            index = self._charToIndex(char)
            if not node.children[index]:
                return False
            node = node.children[index]

        return True



# Your Trie object will be instantiated and called as such:
obj = Trie()
word = 'hello'
obj.insert(word)
print(obj.search(word))
print(obj.startsWith('hell'))

print(obj.search('nice'))
print(obj.startsWith('hea'))
obj.insert('nice')
print(obj.search('nice'))
