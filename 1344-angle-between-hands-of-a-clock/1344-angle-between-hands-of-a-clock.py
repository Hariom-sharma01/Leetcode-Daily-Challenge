class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        cal=abs(30*hour-5.5*minutes)
        return min(cal,360-cal)
        