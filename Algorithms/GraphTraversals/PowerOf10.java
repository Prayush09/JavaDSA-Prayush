package com.Data_Structures_byprayush.Algorithms.GraphTraversals;

import java.util.*;

public class PowerOf10 {
    static int MAXN = 100001;
    static int LOG = 17;  // log2(100000) ≈ 17

    static List<int[]>[] adj = new ArrayList[MAXN];
    static int[][] up = new int[MAXN][LOG];
    static int[] depth = new int[MAXN];
    static int[] count2 = new int[MAXN];
    static int[] count5 = new int[MAXN];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        preprocess(n);

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            addEdge(u, v, weight);
        }

        // Initialize up array with -1
        for (int i = 0; i < MAXN; i++) {
            Arrays.fill(up[i], -1);
        }

        depth[1] = 0;
        count2[1] = 0;
        count5[1] = 0;
        dfs(1, -1);

        int q = sc.nextInt();
        while (q-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            System.out.println(query(u, v));
        }

        sc.close();
    }

    public static void preprocess(int n) {
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void addEdge(int u, int v, int weight) {
        adj[u].add(new int[]{v, weight});
        adj[v].add(new int[]{u, weight});
    }

    public static void dfs(int v, int p) {
        up[v][0] = p;
        for (int i = 1; i < LOG; i++) {
            if (up[v][i - 1] != -1) {
                up[v][i] = up[up[v][i - 1]][i - 1];
            }
        }

        for (int[] edge : adj[v]) {
            int u = edge[0];
            int weight = edge[1];
            if (u != p) {
                depth[u] = depth[v] + 1;
                count2[u] = count2[v] + countFactors(weight, 2);
                count5[u] = count5[v] + countFactors(weight, 5);
                dfs(u, v);
            }
        }
    }

    public static int countFactors(int n, int factor) {
        int count = 0;
        while (n % factor == 0) {
            n /= factor;
            count++;
        }
        return count;
    }

    public static int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];
        for (int i = 0; i < LOG; i++) {
            if ((diff & (1 << i)) != 0) {
                u = up[u][i];
            }
        }

        if (u == v) return u;

        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }

        return up[u][0];
    }

    public static int query(int u, int v) {
        int lca = lca(u, v);
        int count2InPath = count2[u] + count2[v] - 2 * count2[lca];
        int count5InPath = count5[u] + count5[v] - 2 * count5[lca];
        return Math.min(count2InPath, count5InPath);
    }
}
