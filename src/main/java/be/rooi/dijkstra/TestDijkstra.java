package be.rooi.dijkstra;

/**
 * Test class for Dijkstra's Algorithm 
 *  using Priority Queue 
 *
 */

import java.util.ArrayList; 
import java.util.List; 
import java.util.HashSet; 
import java.util.Set; 
import java.util.PriorityQueue; 
import java.util.Comparator; 

class I
{
   static public void indent(int d)
   {
      for (int i=0; i<d; i++)
      {
         System.out.print("   ");
      }
   }
}

public class TestDijkstra
{
   static class Vertex implements Dijkstra.IVertex
   {
      private String               name;
      private double               dist;
      private Dijkstra.IVertex     prev;
      private List<Dijkstra.IEdge> edges;
      
      public Vertex(String inm)
      {
         name  = inm;
         dist  = Double.MAX_VALUE;
         prev  = null;
         edges = new ArrayList<Dijkstra.IEdge>();
      }
      
      @Override
      public String getName()
      {
         return name;
      }

      @Override
      public double getDist()
      {
         return dist;
      }
      
      @Override
      public void setDist(double di)
      {
         dist = di;
      }

      @Override
      public Dijkstra.IVertex getPrev()
      {
         return prev;
      }

      @Override
      public void setPrev(Dijkstra.IVertex pr)
      {
         prev = pr;
      }

      @Override
      public List<Dijkstra.IEdge> getEdges()
      {
         return edges;
      }

      public void add(Edge e)
      {
         edges.add(e);
      }

      public void show(int d)
      {
         I.indent(d);
         System.out.println("Vertex " + name + " " + dist);
         
         for (Dijkstra.IEdge e: edges)
         {
            if (e.getNext().getPrev() == this)
            {
               Dijkstra.IVertex next = e.getNext();
               ((Vertex)next).show(d + 1);
            }
         }
      }
   }
   
   // Class to represent an edge in the graph 
   static class Edge implements Dijkstra.IEdge
   { 
      private Vertex  next; //next neighbour vertex
      private double  cost;
   
      public Edge(Vertex nxt, double cst) 
      { 
         next = nxt; 
         cost = cst;
      }
      
      @Override
      public Dijkstra.IVertex getNext()
      {
         return next;
      }
      
      @Override
      public double getCost()
      {
         return cost;
      }
   } 
   
   
   // Class for building the graph   
   static class Graph
   {
      private List<Vertex> vertices;
      
      public Graph()
      {
         vertices = new ArrayList<Vertex>();
      }
      
      public List<Vertex> getVertices()
      {
         return vertices;
      }

      public void add(Vertex v)
      {
         vertices.add(v);
      }
   }

   public static void main(String arg[]) 
   { 
      int n = 5; 

      // Adjacency list representation of the 
      // connected edges 
      Graph gra = new Graph();
      
      // Initialize list for every node 
      for (int i = 0; i < n; i++)
      { 
         Vertex vertex = new Vertex("v" + i); 
         gra.add(vertex); 
      } 

      Vertex source = gra.getVertices().get(0); 

      // Inputs for the DPQ graph 
      //                              node     cost
      gra.getVertices().get(0).add(new Edge(gra.getVertices().get(1), 9.0)); 
      gra.getVertices().get(0).add(new Edge(gra.getVertices().get(2), 6.0)); 
      gra.getVertices().get(0).add(new Edge(gra.getVertices().get(3), 5.0)); 
      gra.getVertices().get(0).add(new Edge(gra.getVertices().get(4), 3.0)); 

      gra.getVertices().get(2).add(new Edge(gra.getVertices().get(1), 2.0)); 
      gra.getVertices().get(2).add(new Edge(gra.getVertices().get(3), 4.0)); 

      // Calculate the single source shortest path 
      Dijkstra dijk = new Dijkstra(); 
      dijk.dijkstra(source); 

      // Print the shortest path to all the nodes 
      // from the source node 
      System.out.println("The shorted path from node :"); 
      for (Vertex ve: gra.getVertices())
      {
         System.out.println(source.getName() + " to " + ve.getName() + " is "
                     + ve.getDist());
      }
      
      source.show(0);
   } 
} 

