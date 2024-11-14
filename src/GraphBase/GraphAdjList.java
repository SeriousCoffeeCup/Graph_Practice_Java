package src.GraphBase;
import java.util.*;

// Figure out https://www.geeksforgeeks.org/implementing-generic-graph-in-java/ first then Princeton implementation
    // Actually this G4G implementation has been rather stupid
// Factorize this API into GraphBase and allow for using GraphAdjList instead
// Implement algorithms and test case, or do test cases earlier

// Confirm if Princeton method also uses bidirectional boolean

/*
Grab multiple implementations of Graphs and then factorize them essentially
List the essential components of this Graph
Abstract into an interface
Implement the algorithms of traversal and shortest path on the interface
*/
//Things I didn't know well enough:
//  <T> implementation,
//  splitting up where each section in OOP goes. See above plans
public class GraphAdjList<T> {
    private Map<T, List<T>> map = new HashMap<>();

    //TODO: I believe bidirectional should be tracked by the edge, not the LinkedList of items
    //TODO: how to fast and easy track in-degrees?
    public void addVertex(T s){
        map.put(s, new LinkedList<T>());
    }

    public void addEdge(T start, T end, boolean bidirectional){
        if(!map.containsKey(start)){
            addVertex(start);
        }
        if(!map.containsKey(end)){
            addVertex(end);
        }

        map.get(start).add(end); // LinkedList get returned by reference

        if(bidirectional){
            map.get(start).add(start);
        }
    }


    public void neighbors(T s) {
        if(!map.containsKey(s))
            return;

        // TODO: this should return list

        //TODO: this is NOT neighbors. It does not return in-degrees that aren't bidirectional

        System.out.println("The neighbors of "+s+" are");
        StringBuilder delimitedList = new StringBuilder();

        for ( T w : map.get(s)){
            delimitedList.append(w).append(", ");
        }
        if (!delimitedList.isEmpty()){
            delimitedList.setLength(delimitedList.length() - 2); // removing the last comma and space
        }

        System.out.println(delimitedList.toString());
    }


    // There should be other visualizations too

    // Prints the adjacency list of each vertex.

    //Not much more than just a printNeighbors - remove the override and the toString name in my opinion
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }

    //4 minor derivative methods
    public int getVertexCount(){
        return map.keySet().size();
    }
    public int getEdgesCount(boolean bidirection){
        int count = 0;
        for (T v :  map.keySet()){
            count += map.get(v).size();
        }
        if (bidirection){
            if ( count % 2 > 0){
                //TODO: wipe this before posting? Add to tests? Update: if doing bidirectional edge update, does not need this
                System.out.println("Count is not even despite being assumed even: " + count);
            }
            count = count / 2; //uhh, some edges are bidirection and others are not
            // man this is iffy
            // Convert to (int) to hide symptoms
            // What if there are mixed bidirectional and not bidirectional edges...
        }
        return count;
    }

    public boolean hasVertex ( T s ){
        if ( map.containsKey(s) ){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean hasEdge(T s, T t) {
        if (map.get(s).contains(t)) {
            return true;
        }
        else {
            return false;
        }
    }


    //print methods that reaaally don't need to exist
    public void printVertexCount(){
        System.out.println("The graph has " + getVertexCount() + " vertices.");
    }

    public void printEdgesCount(boolean bidirection){
        System.out.println("Graph has " + getEdgesCount(bidirection) + " edges ");
    }

    public void printHasVertex(T s){
        if (map.containsKey(s)) {
            System.out.println("The graph contains " + s
                               + " as a vertex.");
        }
        else {
            System.out.println("The graph does not contain "
                               + s + " as a vertex.");
        }
    }

    public void printHasEdge(T s, T t) {
        if (map.get(s).contains(t)) {
            System.out.println(
                "The graph has an edge between " + s
                + " and " + t + ".");
        }
        else {
            System.out.println(
                "The graph has no edge between " + s
                + " and " + t + ".");
        }
    }
}

