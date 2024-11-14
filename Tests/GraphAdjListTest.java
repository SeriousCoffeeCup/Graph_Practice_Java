package Tests;
import src.GraphBase.GraphAdjList; //
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
//assertThat( f(x) ) . isEqualTo( expected value )
import static com.google.common.truth.Truth.assertWithMessage;
//assertWithMessage( " Message " ) . that ( f(x) ) . isEqualTo ( expected value )
// Doesn't need to import target class?

public class GraphAdjListTest {
    //main provided test
    @Test
    public void testMatrixBasicFunctionality(){
        // Object of graph is created.
        GraphAdjList<Integer> g = new GraphAdjList<Integer>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        // Printing the graph
        System.out.println("Graph:\n" + g.toString());

        // Gives the no of vertices in the graph.
        g.printVertexCount();

        // Gives the no of edges in the graph.
        g.printEdgesCount(true);

        // Tells whether the edge is present or not.
        g.printHasEdge(3, 4);

        // Tells whether vertex is present or not
        g.printHasVertex(5);
        g.neighbors(1);
    }
}
