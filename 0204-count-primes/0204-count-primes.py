class Solution:
    def countPrimes(self, n: int) -> int:
        if n==0 or n==1:
            return 0
        ls=[False]*n
        ls[0]=ls[1]=True
        i=2
        while i*i<n:
            if ls[i]==False:
                j=2
                while i*j<n:
                    ls[i*j]=True
                    j+=1
            i+=1
        c=0
        for b in ls:
            if b==False:
                c+=1
        return c                    

        