class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0)
                st.push(i);
            else {
                while (!st.isEmpty() && asteroids[st.peek()]>0 && asteroids[st.peek()] < (-1*asteroids[i]))
                    st.pop();
                if (st.isEmpty() || asteroids[st.peek()] < 0)
                    st.push(i);
                else if (-1 * asteroids[i] == asteroids[st.peek()])
                    st.pop();
            }
        }
        int ans[] = new int[st.size()];
        for (int i = st.size()-1; i >=0; i--)
            ans[i] = asteroids[st.pop()];
        return ans;
    }
}