class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        ls=list()
        p=0
        for i in gain:
            ls.append(p)
            p=p+i
        ls.append(p)        
        return max(ls)
        