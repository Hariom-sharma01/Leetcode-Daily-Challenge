class Solution:
    def sortColors(self, nums: List[int]) -> None:
        l=m=0
        h=len(nums)-1
        while m<=h:
            if nums[m]==0:
                t=nums[m]
                nums[m]=nums[l]
                nums[l]=t
                l+=1
                m+=1
            elif nums[m]==1:
                m+=1
            else:
                t=nums[h]
                nums[h]=nums[m]
                nums[m]=t
                h-=1
        print(nums)               