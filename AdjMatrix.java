import java.io.*;
import java.util.*;



public class AdjMatrix <T extends Object> implements FriendshipGraph<T>
{

	int[][] theMatrix;
	Map<T, Integer> theMap;
	/**
	 * Contructs empty graph.
	 */
    public AdjMatrix() {
	
    	// Creates matrix and Map
	theMap = new HashMap<T, Integer>();
	theMatrix = new int[100][100];
    } // end of AdjMatrix()
    
    
    public void addVertex(T vertLabel) {
        // Implement me!
	for (int i=0; i < theMatrix.length; i++)
	{
		if(!theMap.containsKey(vertLabel) && !theMap.containsValue(i))
		{
			theMap.put(vertLabel, i);
		}
	}
	
	
    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
        // Implement me!
		
		int source = theMap.get(srcLabel);
		int target = theMap.get(tarLabel);
		
		theMatrix[source][target] = 1;
		theMatrix[target][source] = 1;
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
        
		int vert = theMap.get(vertLabel);
		for(int i =0; i<100; i++)
		{
			if(theMatrix[vert][i] == 1)
			{	
			
				for(T key: theMap.keySet())
				{
					//neighbours.add((T)key);
					if(theMap.get(key) == i)
					{
						neighbours.add(key);
					}
				}
			}
		}
        // Implement me!
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
        // Implement me!
		int vert = theMap.get(vertLabel);
		for(int i =0; i<theMap.size(); i++)
		{
			if(theMatrix[vert][i] == 1)
			{
				theMatrix[vert][i] = 0;
				theMatrix[i][vert] = 0;
			}
		}
		theMap.remove(vertLabel);
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
        // Implement me!
		int source = theMap.get(srcLabel);
		int target = theMap.get(tarLabel);
		
		theMatrix[source][target] = 0;
		theMatrix[target][source] = 0;
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) 
	{
       
		for(T key: theMap.keySet())
		{
			
			os.print(" " + key.toString());
			
		}
		
		os.close();
		
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
        // Implement me!
	T sourceKey = null;
	T targetKey= null;
		for(int i =0; i < 100; i++)
		{
			for(int j=0; j<100; j++)
			{
			
				
				if(theMatrix[i][j] == 1)
				{
					
					for(T key: theMap.keySet())
					{
						
				
						if(theMap.get(key) == i)
						{
							sourceKey = key;
						}
						
						if(theMap.get(key) == j)
						{
							targetKey = key;
						}
						//os.println(sourceKey + " " + targetKey);
					}
					os.println(sourceKey + " " + targetKey);
				}
			}
		}
		os.close();
		
		//os.println(sourceKey + " " + targetKey);
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	// Implement me!
    	final int disconnectedDist = -1;
    	int distance = 0;
		Queue<T> q = new ArrayDeque();
		ArrayList<Integer> qDistance = new ArrayList<Integer>();
		
		ArrayList<T> explored = new ArrayList<T>();
		
		q.add(vertLabel1);
		qDistance.add(distance);
		explored.add(vertLabel1);
		
		while(!q.isEmpty())
		{
			
			
			
			T current = q.poll();
			if(current.equals(vertLabel2))
			{
				
				return qDistance.get(0);
			}
			for(T aVertex: neighbours(current))
			{
				if(!explored.contains(aVertex))
				{
					q.add(aVertex);
					int prev = qDistance.get(0);
					distance = prev + 1;
					qDistance.add(distance);
				}
			}
			qDistance.remove(0);
			
		}
		
    	 return disconnectedDist;
    } // end of shortestPathDistance()
    
} // end of class AdjMatrix