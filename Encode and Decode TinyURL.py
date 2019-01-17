import random

class Codec:

    def __init__(self):
        self.memo = {}
        self.last = 0

    def encode(self, longUrl):
        """Encodes a URL to a shortened URL.

        :type longUrl: str
        :rtype: str
        """

        self.last += 1
        shortUrl = 'http://tinyurl.com/' + str(self.last)
        self.memo[shortUrl] = longUrl
        return shortUrl

        # if len(self.memo) == 0:
        #     shortUrl = shortUrl + '000000'
        #     self.memo[shortUrl] = longUrl
        #     return shortUrl
        #
        # else:
        #     url = self.memo[list(self.memo.keys())[-1]]
        #     url = url[len(url) - 6: len(url)]
        #
        #     index = -1
        #     while True:
        #         char = url[index]
        #
        #         if ord(char) in range(48, 57):
        #             url[index] = chr(ord(char) + 1)
        #             if shortUrl + url not in self.memo:
        #                 shortUrl = shortUrl + url
        #                 self.memo[shortUrl] = longUrl
        #                 return shortUrl
        #
        #         if ord(char) == 57:
        #             url[index] = 'A'
        #             if shortUrl + url not in self.memo:
        #                 shortUrl = shortUrl + url
        #                 self.memo[shortUrl] = longUrl
        #                 return shortUrl
        #
        #         if ord(char) in range(65, 90):
        #             url[index] = chr(ord(char) + 1)
        #             if shortUrl + url not in self.memo:
        #                 shortUrl = shortUrl + url
        #                 self.memo[shortUrl] = longUrl
        #                 return shortUrl
        #
        #         if ord(char) == 57:
        #             url[index] = 'a'
        #             if shortUrl + url not in self.memo:
        #                 shortUrl = shortUrl + url
        #                 self.memo[shortUrl] = longUrl
        #                 return shortUrl
        #
        #         if ord(char) in range(97, 122):
        #             url[index] = chr(ord(char) + 1)
        #             if shortUrl + url not in self.memo:
        #                 shortUrl = shortUrl + url
        #                 self.memo[shortUrl] = longUrl
        #                 return shortUrl
        #
        #         url[index] = '0'
        #         index -= 1

    def decode(self, shortUrl):
        """Decodes a shortened URL to its original URL.

        :type shortUrl: str
        :rtype: str
        """

        return self.memo[shortUrl]

# Your Codec object will be instantiated and called as such:
codec = Codec()
print(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")))
