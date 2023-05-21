

public class Solution {
    int[]colours;
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        colours=new int[n];
        for (int i=0;i<n;i++)
        {

            if (colours[i]==0)
            {
                colours[i]=1;
                if (!dfs(i,graph))
                    return false;
            }
        }
        return true;
    }
    boolean dfs(int parent,int[][]graph){
        for (int child:graph[parent])
        {
            if (colours[child]==0)
            {
                colours[child]=3-colours[parent];
                if (!dfs(child,graph))
                    return false;
            }
            else if (colours[child]==colours[parent])
            {
                return false;
            }
        }
        return true;

    }
}
