public class disjoint_set_union {
    public static void main(String[] args) {
        int[][] tree = new int[][]{{5,6}, {6,7}, {5,7}};
        int[] cycleEdge = findRedundantConnection(tree);
        for(int i : cycleEdge){
            System.out.print(i + " ");
        }

    }

    public static int find(int parent[], int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static int[] findRedundantConnection(int[][] tree){
        int n = 0;
        for(int[] edge : tree){
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        int[] parent = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i] = i;
        }
        for(int[] edge : tree){
            int x = edge[0];
            int y = edge[1];
            int parentx = find(parent, x);
            int parenty = find(parent, y);

            if(parentx == parenty){
                return new int[]{x,y};
            }
            else{
                parent[parentx] = parenty;
            }
        }

        return new int[]{0,0};
    }
}
