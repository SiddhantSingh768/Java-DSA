//connecting cities with minimum cost
import java.util.*;
public class ConnectingCities {
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;
        public Edge(int d,int c){
            this.dest=d;
            this.cost=c;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost-o.cost;//ascending
        }
    }
    public static int connectCities(int cities[][]){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        boolean visited[]=new boolean[cities.length];
        pq.add(new Edge(0,0));
        int finalCost=0;
        while(!pq.isEmpty()){
            Edge rem=pq.remove();
            if(!visited[rem.dest]){
                visited[rem.dest]=true;
                finalCost+=rem.cost;
                for(int i=0;i<cities[rem.dest].length;i++){
                    if(cities[rem.dest][i]!=0 ){
                        pq.add(new Edge(i,cities[rem.dest][i]));
                    }
                }
            }
        }
        return finalCost;
    }
    public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},{1,0,5,0,7},
                        {2,5,0,6,0},
                        {3,0,6,0,0},{4,7,0,0,0}};
        System.out.println(connectCities(cities));                
    }
}
