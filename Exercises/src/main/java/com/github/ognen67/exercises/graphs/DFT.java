package com.github.ognen67.exercises.graphs;

import java.util.ArrayList;

class DFT
{
    private ArrayList<ArrayList<Integer>> adj;
    private boolean[] visited;
    private ArrayList<Integer> result = new ArrayList<Integer>();

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        this.adj = adj;
        this.visited = new boolean[V];
        DFSVisit(0);// odavde brisemo visited
        return result;
    }

    public void DFSVisit(int v) {

        visited[v] = true; // odakle nam visited ovde? moramo ga proslediti
        result.add(v);

        for (int u: adj.get(v))
            if (!visited[u]) DFSVisit(u); // i ako to u nije vec visited
        // znaci ako postoji dete u cvora v koje nije poseceno, poseti to u odmah

    }

}
