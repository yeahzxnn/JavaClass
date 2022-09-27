package Assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int y;
    int x;
    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int M = -1;
    static int N = -1;
    static double P =0;
    static int[][] random;
    static String[][] first;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        P = Double.parseDouble(st.nextToken());
        random = new int[M][N];
        arr = new int[M][N];
        first = new String[M][N];
        P=P*100;

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                int num = (int)(Math.random()*100);
                random[i][j] = num;
            }
        }
        for(int i=0;i<M; i++){
            for(int j=0;j<N;j++){
                if (P>random[i][j]) {
                    first[i][j]="*";
                } else{
                    first[i][j]="-";
                }
            }
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(first[i][j]=="*"){
                    System.out.println(first[i][j]+" ");
                } else{
                    System.out.println(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    static void bfs(int y, int x){
        int dx[] = {1,0,-1,0,1,-1,1,-1};
        int dy[] = {0,1,0,-1,1,1,-1,-1};
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(y,x));
        while(!q.isEmpty()) {
            Pair p = q.poll();
            for(int i=0; i<8; i++){
                int na = p.y+dx[i];
                int nb = p.x+dy[i];
                if(0<=na && 0<=nb && na<M && nb<N && first[na][nb]=="*"){
                    arr[p.y][p.x]++;
                }
            }
        }
    }
}

