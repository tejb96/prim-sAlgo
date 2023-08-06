import java.util.*;
import java.io.*;
public class Matrix {
	public static int[] mst;
	
	static int[] prim(int matrix[][], int v) {
		mst=new int[v];
		int[] key=new int[v];
		boolean[] set=new boolean[v];
		
		for(int i =0;i<v;i++) {
			key[i]=Integer.MAX_VALUE;
			set[i]=false;
		}
		
		key[0]=0;
		mst[0]=-1;
		
		for(int i=0;i<v-1;i++) {
			int u=minKey(set,key,v);
			set[u]=true;
			for(int j=0;j<v;j++) {
				if(matrix[u][j]!=0&&set[j]==false&&matrix[u][j]<key[j]) {
					mst[j]=u;
					key[j]=matrix[u][j];
				}
			}
		}
		return key;
	}

	private static int minKey(boolean[] set, int[] key,int v) {
		// TODO Auto-generated method stub
		int min=Integer.MAX_VALUE;
		int index=-1;
		
		for(int i =0;i<v;i++) {
			if(set[i]==false&&key[i]<min) {
				min=key[i];
				index=i;
			}
		}
		return index;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter input filename:");
		String name=scan.next();		
		File text=new File(name);
		scan.close();
		Scanner reader=new Scanner(text);
		
		
		int numNodes=reader.nextInt();
		char[] nodes=new char[numNodes];
		
		for(int i=0;i<numNodes;i++) {
			nodes[i]=(char) (i+97);
		}
		
		System.out.println("\nNumber of nodes in the graph: "+numNodes);
		System.out.print("\nNodes: ");
		
		for(int i=0;i<numNodes;i++) {
			System.out.print(nodes[i]+" ");			
		}
		System.out.println();
		
		int[][] adjMat=new int[numNodes][numNodes];
		
		while(reader.hasNextInt()) {
			for(int i=0;i<numNodes;i++) {
				for(int j=0;j<numNodes;j++) {
					adjMat[i][j]=reader.nextInt();
				}
			}
		}
		reader.close();
		
		System.out.println("\nAdjacency matrix for the graph: ");
		for(int i=0;i<numNodes;i++) {
			for(int j=0;j<numNodes;j++) {
				System.out.print(adjMat[i][j]+" ");
			}
			System.out.println();
		}
		int[] degrees=new int[numNodes];
		int sum=0;
		for(int i=0;i<numNodes;i++) {
			int count=0;
			for(int j=0;j<numNodes;j++) {
				if(adjMat[i][j]!=0) {
					count++;
				}
			}
			degrees[i]=count;
			sum+=count;
		}

		System.out.println("\nDegree of each node in the graph:");
		System.out.println("Node : Degree");
		for(int i=0;i<numNodes;i++) {
			System.out.println(nodes[i]+"    : "+degrees[i]);			
		}
		
		System.out.println("Total degree of the graph: "+sum);
		
		int[] key=prim(adjMat,numNodes);
		
		System.out.println("\nMinimum Spanning Tree with Prim's Algorithm:");
		System.out.println("Edge  : Min cost/distance/weight");
		int sum2=0;
		for(int i=1;i<key.length;i++) {
			System.out.println(nodes[mst[i]]+" - "+nodes[i]+" : "+key[i]);
			sum2+=key[i];
		}
		System.out.println("Total cost of minimum spanning tree with prim's algorithm: "+sum2);
	}

}
