package src.GraphBase;
import java.util.*;

// Figure out https://www.geeksforgeeks.org/implementing-generic-graph-in-java/ first then Princeton implementation
// Factorize this API into GraphBase and allow for using GraphAdjacencyList instead
// Implement algorithms and test case, or do test cases earlier

// Confirm if Princeton method also uses bidirectional boolean

// List the essential components of this Graph


//Things I didn't know well enough:
//  <T> implementation,
//  splitting up where each section in OOP goes
public class GraphAdjacencyMatrix<T> {
    private Map<T, List<T>> map = new HashMap<>();

    public void addVertex(T s){
        map.put(s, new LinkedList<T>());
    }

    public void addEdge(T start, T end, boolean bidirectional){
        //Didn't like source being used as keyword here so changed to start
        // Source and Sink are reserved. Source is for nodes with nothing pointing to them.

        //bidirectional is... interesting design


        //TODO: once test cases get established, check if could factorize !map.contains key into addVertex function
        if(!map.containsKey(start)){
            addVertex(start);
        }
        if(!map.containsKey(end)){
            addVertex(end);
        }

        map.get(start).add(end); // huh, LinkedList get returned by reference
        if(bidirectional){
            map.get(start).add(start);
        }
    }


    public void neighbours(T s) {
        if(!map.containsKey(s))
            return;
        System.out.println("The neighbours of "+s+" are");
//        for(T w:map.get(s))
//         System.out.print(w+",");
        StringBuilder delimitedList = new StringBuilder();

        for ( T w : map.get(s)){
            delimitedList.append(w).append(", ");
        }
        if (delimitedList.length() > 0){
            delimitedList.setLength(delimitedList.length() - 2); // removing the last comma and space
        }
    }
    public int getVertexCount(){
        return map.keySet().size();
    }



    public int getEdgesCount(boolean bidirection){
        int count = 0;
//        for (int i = 0; i < map.keySet().size(); i++){
//            count += map.get()
//        }
        for (T v :  map.keySet()){
            count += map.get(v).size();
        }
        if (bidirection){
            if ( count % 2 > 0){
                //TODO: wipe this before posting? Add to tests?
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




    // Prints the adjancency list of each vertex.
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

