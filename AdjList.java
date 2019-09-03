import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class AdjList<T extends Object> implements FriendshipGraph<T> {
	MyLinkedList[] vertex;
	Map<T, Integer> aMap;
	protected int length;

	/**
	 * Contructs empty graph.
	 */
	public AdjList() 
	{
		//creates linked list and Map
		vertex = new MyLinkedList[1000];
		aMap = new HashMap<T, Integer>();
		for (int i = 0; i < vertex.length; i++) 
		{
			vertex[i] = new MyLinkedList();
			//System.out.println("Adding linkedlist");
		}
		//}

	} // end of AdjList()

	public void addVertex(T vertLabel) {
		
		for (int i = 0; i < vertex.length; i++) 
		{
			if (!aMap.containsKey(vertLabel) && !aMap.containsValue(i))
			{
				aMap.put(vertLabel, i);
			}
			//else
			//	System.out.println("Cannot add vertex");
		}
	} // end of addVertex()

	public void addEdge(T srcLabel, T tarLabel) {

		int source = aMap.get(srcLabel);
		int target = aMap.get(tarLabel);
		//MyLinkedList aEdge  = new MyLinkedList();
		//aEdge = aEdge.add(tarLabel)
		
			vertex[source].add(tarLabel);
			vertex[target].add(srcLabel);
		
	} // end of addEdge() 

	public ArrayList<T> neighbours(T vertLabel) {
		ArrayList<T> neighbours = new ArrayList<T>();

		// Implement me!
		int value = aMap.get(vertLabel);
		MyLinkedList aList = vertex[value];
		for(int i =0; i< aList.mLength; i++)
		{
			T aNeighbour = (T)aList.get(i);
			neighbours.add(aNeighbour);
		}
		return neighbours;
	} // end of neighbours()

	public void removeVertex(T vertLabel) 
	{
		if (aMap.containsKey(vertLabel)) 
		{
			int index = aMap.get(vertLabel);
			vertex[index] = new MyLinkedList();
			
			for(int i= 0;  i< vertex.length; i++)
			{
				if(vertex[i].search(vertLabel))
				{
					vertex[i].remove(vertLabel);
				}
			}
			
			aMap.remove(vertLabel);
			//aMap.remove(vertLabel);
		}
	} // end of removeVertex()

	public void removeEdge(T srcLabel, T tarLabel) 
	{
		// Implement me!
		int srcIndex = aMap.get(srcLabel);
		int tarIndex = aMap.get(tarLabel);
		
		boolean source = vertex[srcIndex].remove(tarLabel);
		boolean target = vertex[tarIndex].remove(srcLabel);
		
		
		
	} // end of removeEdges()

	public void printVertices(PrintWriter os) 
	{
		
		for(T aVertex: aMap.keySet())
		{
			os.print(aVertex.toString());
		}
		
		os.close();
	} // end of printVertices()

	public void printEdges(PrintWriter os) {
	
		
		for(T aVertex: aMap.keySet())
		{
			
			int value = aMap.get(aVertex);
			
			MyLinkedList aList = vertex[value];
			for(int i = 0; i< aList.mLength; i++)
			{
				T aEdge = (T)aList.get(i);
			os.println(aVertex.toString() + " " + aEdge.toString());
			}
			//for(int i = 0; i < vertex.length; i++)
			//{
				//vertex[i]
			//}
		}
		os.close();
	} // end
		// of
		// printEdges()

	public int shortestPathDistance(T vertLabel1, T vertLabel2) {
		// Implement me!

		// if we reach this point, source and target are disconnected
		return disconnectedDist;
	} // end of shortestPathDistance()

} // end of class AdjList