package graph;
import java.util.Stack;
class Vertex{
public char lable;
public boolean wasvisited;
public Vertex (char lab){
lable = lab;
wasvisited = false;}
}
public class Graph {
private final int MAX_VERTS=20;
private Vertex vertexlist[];
private int adjMat[][];
private int nVerts;
private Stack <Integer> s;
public Graph(){
vertexlist = new Vertex[MAX_VERTS];
adjMat = new int[MAX_VERTS][MAX_VERTS];
nVerts = 0;
s = new Stack<Integer>();
}
public void addVertex(char lab) {
vertexlist[nVerts++] = new Vertex(lab); } 
public void addEdge(int start, int end) {
adjMat[start][end] = 1;
adjMat[end][start] = 1; }
public void displayVertex(int v) {
System.out.print(vertexlist[v].lable + " "); 
}
public int getAdjUnvisitedVertex (int v) {
for(int j = 0; j < nVerts; j++) {
if(adjMat[v][j] == 1 && 
vertexlist[j].wasvisited == false) {
return j; }
}
return -1; }
public void dfs() {
vertexlist[0].wasvisited = true;
displayVertex(0);
s.push(0); 
while(!s.isEmpty()) { 
int v = getAdjUnvisitedVertex(s.peek());
if(v == -1) {
s.pop();
} else {
vertexlist[v].wasvisited = true;
displayVertex(v);
s.push(v); }
}}
   
public static void main(String[] args) {
Graph theGraph = new Graph();
theGraph.addVertex('A');
theGraph.addVertex('B');
theGraph.addVertex('C');
theGraph.addVertex('D');
theGraph.addVertex('E');
theGraph.addVertex('F'); 
theGraph.addEdge(0, 1);
theGraph.addEdge(1, 2);
theGraph.addEdge(0, 3);
theGraph.addEdge(3, 4);
theGraph.addEdge(4, 5);
theGraph.addEdge(1, 3); 
System.out.println("Visits: ");
theGraph.dfs();
System.out.println();      
    }
    
}
