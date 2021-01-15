package com.github.ognen67.exercises.graphs;

import java.util.ArrayList;
import java.util.Stack;

class Solution
{
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();


        while (true) {
            int a;
            for(a = 0; a < V && visited[a] == true; ++a);
            if (a<V) // to znaci da se for zavrsio jer je postojao visited[u] = false
                stack.push(a);
            else
                break;
            while(!stack.isEmpty()) {
                int u = stack.pop();
                if(!visited[u]){ //ovde nije visited
                    result.add(u); //ovde jeste visited
                    visited[u] = true;
                }

                for(int v : adj.get(u)) {
                    if(!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }
}
