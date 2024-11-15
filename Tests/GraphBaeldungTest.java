package Tests;
import BaeldungImplementations.GraphBaeldung; //
import org.junit.jupiter.api.Test;

public class GraphBaeldungTest {
    @Test
    public void testCreateGraph(){
        GraphBaeldung trial = new GraphBaeldung();
        trial.createGraph();
    }
}
