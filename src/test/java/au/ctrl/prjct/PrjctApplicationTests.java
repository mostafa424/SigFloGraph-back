package au.ctrl.prjct;

import au.ctrl.prjct.graph.Edge;
import au.ctrl.prjct.graph.ForwardPathPayload;
import au.ctrl.prjct.graph.SignalFlowGraph;
import au.ctrl.prjct.services.ForwardPaths;
import au.ctrl.prjct.services.GraphAddService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PrjctApplicationTests {

    @Test
    void test_forward_path1() {
        SignalFlowGraph test_graph=new SignalFlowGraph(new HashMap<>(),new ArrayList<>(new ArrayList<>()),new ArrayList<>(new ArrayList<>()),new ArrayList<>(new ArrayList<>()));
        GraphAddService test_service= new GraphAddService(test_graph);
        test_service.addNode("A");
        test_service.addNode("B");
        test_service.addNode("C");
        test_service.addNode("D");
        test_service.addNode("E");
        test_service.addEdge(new Edge("START","A",2));
        test_service.addEdge(new Edge("A","B",2));
        test_service.addEdge(new Edge("B","C",2));
        test_service.addEdge(new Edge("C","D",2));
        test_service.addEdge(new Edge("D","E",2));
        test_service.addEdge(new Edge("E","END",2));
        ForwardPathPayload test_payload=new ForwardPaths().getForwardPaths(test_graph,1,"START");
        assertEquals("STARTABCDEEND",test_payload.getForward_paths().get(0));
        assertEquals(64,test_payload.getPath_gain().get(0));
    }
    @Test
    void test_forward_path2() {
        SignalFlowGraph test_graph=new SignalFlowGraph(new HashMap<>(),new ArrayList<>(new ArrayList<>()),new ArrayList<>(new ArrayList<>()),new ArrayList<>(new ArrayList<>()));
        GraphAddService test_service= new GraphAddService(test_graph);
        test_service.addNode("A");
        test_service.addNode("B");
        test_service.addNode("C");
        test_service.addNode("D");
        test_service.addNode("E");
        test_service.addEdge(new Edge("START","A",2));
        test_service.addEdge(new Edge("A","B",2));
        test_service.addEdge(new Edge("B","C",2));
        test_service.addEdge(new Edge("C","D",2));
        test_service.addEdge(new Edge("D","E",2));
        test_service.addEdge(new Edge("E","END",2));
        test_service.addEdge(new Edge("A","END",2));
        test_service.addEdge(new Edge("E","B",2));
        ForwardPathPayload test_payload=new ForwardPaths().getForwardPaths(test_graph,1,"START");
        assertEquals("STARTABCDEEND",test_payload.getForward_paths().get(0));
        assertEquals("STARTAEND",test_payload.getForward_paths().get(1));
        assertEquals(64,test_payload.getPath_gain().get(0));
        assertEquals(4,test_payload.getPath_gain().get(1));
    }
    @Test
    void test_forward_path3() {
        SignalFlowGraph test_graph=new SignalFlowGraph(new HashMap<>(),new ArrayList<>(new ArrayList<>()),new ArrayList<>(new ArrayList<>()),new ArrayList<>(new ArrayList<>()));
        GraphAddService test_service= new GraphAddService(test_graph);
        test_service.addNode("A");
        test_service.addNode("B");
        test_service.addNode("C");
        test_service.addNode("D");
        test_service.addNode("E");
        test_service.addNode("1");
        test_service.addEdge(new Edge("START","A",2));
        test_service.addEdge(new Edge("START","1",2));
        test_service.addEdge(new Edge("1","END",2));
        test_service.addEdge(new Edge("A","B",2));
        test_service.addEdge(new Edge("B","C",2));
        test_service.addEdge(new Edge("C","D",2));
        test_service.addEdge(new Edge("D","E",2));
        test_service.addEdge(new Edge("E","END",2));
        test_service.addEdge(new Edge("A","END",2));
        test_service.addEdge(new Edge("E","B",2));
        ForwardPathPayload test_payload=new ForwardPaths().getForwardPaths(test_graph,1,"START");
        assertEquals("STARTABCDEEND",test_payload.getForward_paths().get(0));
        assertEquals("START1END",test_payload.getForward_paths().get(2));
        assertEquals("STARTAEND",test_payload.getForward_paths().get(1));
        assertEquals(64,test_payload.getPath_gain().get(0));
        assertEquals(4,test_payload.getPath_gain().get(1));
        assertEquals(4,test_payload.getPath_gain().get(2));
    }

}
