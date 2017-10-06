package Graphs;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Clustering1 {

    private static class DisjointUnionSets {
        int[] rank, parent;
        int n;

        // Constructor
        public DisjointUnionSets(int n) {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        // Creates n sets with single item in each
        void makeSet() {
            for (int i=0; i<n; i++) {
                // Initially, all elements are in
                // their own set.
                parent[i] = i;
            }
        }

        // Returns representative of x's set
        int find(int x) {
            // Finds the representative of the set
            // that x is an element of
            if (parent[x]!=x) {
                // if x is not the parent of itself
                // Then x is not the representative of
                // his set,
                parent[x] = find(parent[x]);

                // so we recursively call Find on its parent
                // and move i's node directly under the
                // representative of this set
            }

            return parent[x];
        }

        // Unites the set that includes x and the set
        // that includes x
        void union(int x, int y) {
            // Find representatives of two sets
            int xRoot = find(x), yRoot = find(y);

            // Elements are in the same set, no need
            // to unite anything.
            if (xRoot == yRoot)
                return;

            // If x's rank is less than y's rank
            if (rank[xRoot] < rank[yRoot])

                // Then move x under y  so that depth
                // of tree remains less
                parent[xRoot] = yRoot;

                // Else if y's rank is less than x's rank
            else if (rank[yRoot] < rank[xRoot])

                // Then move y under x so that depth of
                // tree remains less
                parent[yRoot] = xRoot;

            else // if ranks are the same{
                // Then move y under x (doesn't matter
                // which one goes where)
                parent[yRoot] = xRoot;

                // And increment the the result tree's
                // rank by 1
                rank[xRoot] = rank[xRoot] + 1;
            }
        }

    private static int countDistinct(int[] arr, int n) {
        int count = 0;
        // Pick all elements one by one
        for (int i=0; i<n; i++)
        {
            // Check if the picked element is already printed
            int j;
            for (j=0; j<i; j++)
                if (arr[i] == arr[j])
                    break;

            // If not printed earlier, then print it
            if (i == j)
                count++;
        }
        
        return count;
    }

    // To calculate the distance between to vertices
    private static double distance(int[] x, int[] y) {
        return Math.sqrt(Math.pow(x[1]-x[0], 2) + Math.pow(y[1]-y[0], 2));
    }

    private static class Edge implements Comparable<Edge> {
        private double distance;
        private int pt1;
        private int pt2;

        public Edge(double distance, int pt1, int pt2) {
            this.distance = distance;
            this.pt1 = pt1;
            this.pt2 = pt2;
        }

        public double getDistance() {
            return distance;
        }

        public int getPt1() {
            return pt1;
        }

        public int getPt2() {
            return pt2;
        }

        @Override
        public int compareTo(Edge other) {
            if(this.getDistance() > other.getDistance()) return 1;
            else if (this.getDistance() < other.getDistance()) return -1;
            else return 0;
        }
    }

    private static double clustering(int[] x, int[] y, int k, int n) {

        PriorityQueue<Edge> q = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int[] x1 = {x[i], x[j]};
                int[] y1 = {y[i], y[j]};
                double edgeDistance = distance(x1, y1);
                Edge edge = new Edge(edgeDistance, i, j);
                q.add(edge);
            }
        }

                DisjointUnionSets dus = new DisjointUnionSets(n);
        while(countDistinct(dus.parent, n)!=k) {
            Edge minDistEdge = q.poll();
            if(dus.find(minDistEdge.pt1)!=dus.find(minDistEdge.pt2))
                dus.union(minDistEdge.pt1, minDistEdge.pt2);
        }

        ArrayList<Integer> distinctParent = new ArrayList<>();
        ArrayList<Integer>[] clusters = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            clusters[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<n; i++) {
            int j;
            for (j=0; j<i; j++)
                if (dus.parent[i] == dus.parent[j])
                    break;
            if (i == j)
                distinctParent.add(dus.parent[i]);
        }

        for(int i =0; i<k;i++) {
            int parent = distinctParent.get(i);
            for(int j=0;j<dus.parent.length;j++) {
                if(dus.parent[j]==parent) {
                    clusters[i].add(j);
                }
            }
        }

        // finding the minimum distance
        int[] xTemp = {x[clusters[0].get(0)], x[clusters[1].get(0)]};
        int[] yTemp = {y[clusters[0].get(0)], y[clusters[1].get(0)]};
        double minDistance = distance(xTemp, yTemp), distance;
        for(int i=0;i<k;i++) {
            for(int j=i+1;j<k;j++) {
                for(int pt1:clusters[i]) {
                    for(int pt2:clusters[j]) {
                        int[] x1 = {x[pt1], x[pt2]};
                        int[] y1 = {y[pt1], y[pt2]};
                        distance = distance(x1, y1);
                        if(distance<minDistance) minDistance = distance;
                    }
                }
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        if(k==1|| k==0) System.out.println(0.0);
        else
            System.out.println(clustering(x, y, k, n));
    }
}

