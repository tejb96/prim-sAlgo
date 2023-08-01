import java.util.*;
import java.io.*;
public class Matrix {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		File text=new File("graph.txt");
	
		Scanner reader=new Scanner(new File("graph.txt"));
		
		
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
		System.out.println();
		
		for(int i=0;i<numNodes;i++) {
			System.out.println(nodes[i]+" : "+degrees[i]);			
		}
		
		System.out.println("Total degree of the graph: "+sum);

	}

}
