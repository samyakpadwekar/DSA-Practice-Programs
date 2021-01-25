
import java.util.Scanner;

class AdjMatrixGraph {
	private int vertCount;
	private int edgeCount;
	private int [][] adjmat;
	
	public AdjMatrixGraph(int vertexCount) {
		edgeCount = 0;
		vertCount = vertexCount;
		adjmat = new int[vertCount][vertCount];
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++)
				adjmat[i][j] = 0;
		}
	}
	
	public int[][] accept(Scanner sc) {
		System.out.print("Enter number of edges: ");
		edgeCount = sc.nextInt();
		for (int i = 0; i < edgeCount; i++) {
			System.out.print("Enter edge (src dest): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjmat[src][dest] = 1;
			adjmat[dest][src] = 1; 
		}
		return adjmat;
	}
	
	public void display(int[][] mat) {
		System.out.println("\nAdjancecy Matrix: \n");
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++)
				System.out.print(mat[i][j] + "\t");
			System.out.println();
		}
	}
	
	public int[][] removeVertex(int [][]mat,int removeVertexId)
	{
		if (removeVertexId > vertCount)  
        { 
            System.out.println("Vertex not present!"); 
            return mat; 
        } 
        else 
        { 
            int i; 
            // removing the vertex 
            while (removeVertexId < vertCount) 
            { 
                // shifting the rows to left side 
                for (i = 0; i < vertCount; ++i)  
                { 	
                	//System.out.println();
                    mat[i][removeVertexId] = mat[i][removeVertexId + 1]; 
                } 
                // shifting the columns upwards 
                for (i = 0; i < removeVertexId; ++i) 
                { 
                	mat[removeVertexId][i] = mat[removeVertexId + 1][i]; 
                } 
                removeVertexId++; 
            }  
            // decreasing the number of vertices 
            vertCount--; 
        } 
		return mat;
	}
	
}

public class GraphMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vertCount = sc.nextInt();
		AdjMatrixGraph g = new AdjMatrixGraph(vertCount);
		int[][] mat=g.accept(sc);
		g.display(mat);
		System.out.print("Enter vertexId to be deleted: ");
		int removeVertexId=sc.nextInt();
		mat=g.removeVertex(mat, removeVertexId);
		g.display(mat);
		sc.close();
	}
}

/*
10
13
0 3
0 8
0 4
3 1
3 4
3 9
8 5
4 7
4 2
1 5
5 7
7 2
7 6
2 9
*/

