class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""

        n = len(s)
        maxl = 1
        ans = s[0]

        for i in range(n):
            for j in range(i + maxl, n):
                if self.checkPal(s, i, j):
                    curr_len = j - i + 1
                    if curr_len > maxl:
                        maxl = curr_len
                        ans = s[i:j+1]
        return ans               

    def checkPal(self, s, l, h):
        while l < h:
            if s[l] != s[h]:
                return False
            l += 1
            h -= 1
        return True
