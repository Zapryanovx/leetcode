# https://leetcode.com/problems/network-delay-time/description/

from heapq import heappop, heappush


class Solution:

    def successor(self, graph, state):
        return graph.get(state, [])

    def networkDelayTime(self, times: list[list[int]], n: int, k: int) -> int:
        graph = {}

        for u, v, w in times:
            if u not in graph:
                graph[u] = []
            graph[u].append((v, w))

        frontier = [(0, k)]
        costs = {k: 0}

        while frontier:
            cost, state = heappop(frontier)

            if cost != costs[state]:
                continue

            for next_state, step_cost in self.successor(graph, state):
                new_cost = cost + step_cost

                if new_cost < costs.get(next_state, float("inf")):
                    costs[next_state] = new_cost
                    heappush(frontier, (new_cost, next_state))

        if len(costs) < n:
            return -1

        return max(costs.values())