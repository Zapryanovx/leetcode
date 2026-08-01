# https://leetcode.com/problems/asteroid-collision/description/

class Solution:
    def asteroidCollision(self, asteroids: list[int]) -> list[int]:
        st = []

        for a in asteroids:
            destroyed = False
            if a < 0:
                while st and st[-1] > 0:
                    if -a > st[-1]:
                        st.pop()
                    elif -a == st[-1]:
                        st.pop()
                        destroyed = True
                        break
                    else:
                        destroyed = True
                        break

            if not destroyed:
                st.append(a)

        return st