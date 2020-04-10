# Dijkstra Shortest Path algorithm in Java with a `PriorityQueue`

This is an adaption of an example on this page:

* [https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/](https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/)

The original code only shows a minimal implementation of the algorithm with a `PriorityQueue`.
The adaptation adds classes for the edges and the vertices.
There is also a separation between the class `Dijkstra` which contains the algorithm itself and 
the class `TestDijkstra` which has the `main()` method.

In order to use the algorithm in other projects the class `Dijkstra` only sees the
interfaces `IVertex` and `IEdge`. When starting the algorithm there is no need to
pass the full graph as a parameter. Only the source vertex is passed.

Before starting the algorithm itself the number of the reachable vertices is calculated.
This number is used as the end condition.

After the algorithm has run all the distances are shown and the spanning tree is printed.
Every vertex keeps a pointer to the previous vertex. This information allows the construction
of the spanning tree. In this example the spanning tree is only printed.


