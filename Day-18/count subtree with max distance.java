class Solution {
    int[][] dist;
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
	    //precalculate the distance of any two cities
        dist = new int[n][n];
        List<Integer>[] graph = new List[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList();
        }
        for(int[] e : edges){
            graph[e[0]-1].add(e[1]-1);
            graph[e[1]-1].add(e[0]-1);
        }
        for(int i=0; i<n; i++){
            calcDist(graph, i, -1, i, 0);
        }
        int[] res = new int[n-1];
        for(int i=1; i<(1<<n); i++){
            int maxDist = 0;
            int oneDistCount = 0;
            int cities = 0;
			//find the max distance between each pair of cities
            for(int j=0; j<n; j++){
                if((i & (1<<j))!=0){
                    cities++;
                    for(int k=j+1; k<n; k++){
                        if((i & (1<<k))!=0){
                            maxDist = Math.max(maxDist, dist[j][k]);
                            if(dist[j][k]==1){
                                oneDistCount++;
                            }
                        }
                    }                    
                }
            }
			//x cities form a substree if and only if there are x-1 edges among these cities
            if(oneDistCount==cities-1 && maxDist>0) res[maxDist-1]++;
        }
        return res;
    }
    
    public void calcDist(List<Integer>[] graph, int source, int prev, int cur, int d){
        if(prev==cur){
            return;
        }
        dist[source][cur] = d;
        dist[cur][source] = d;
        for(int next : graph[cur]) if(next!=prev){
            calcDist(graph, source, cur, next, d+1);
        }
    }
}