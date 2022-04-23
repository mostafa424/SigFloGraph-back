package au.ctrl.prjct.services;

import au.ctrl.prjct.graph.Edge;
import au.ctrl.prjct.graph.SignalFlowGraph;

import java.util.ArrayList;
import java.util.List;

public class GraphOperationService implements IGraphOperationService{
    SignalFlowGraph graph;

    public GraphOperationService(SignalFlowGraph graph) {
        this.graph = graph;
    }

    @Override
    public int getNode(String nodeName) {
        return this.graph.getNodes().getOrDefault(nodeName, -1);
    }

    @Override
    public List<Edge> getNodeEdges(String nodeName) {
        int nodeIndex = this.getNode(nodeName);
        if(nodeIndex == -1) return null;
        return this.graph.getEdges().get(nodeIndex);
    }

    @Override
    public boolean edgeExists(Edge edge) {
        int fromIndex = this.getNode(edge.getFromNode());
        int toIndex = this.getNode(edge.getToNode());
        if(fromIndex == -1 || toIndex == -1) return false;
        List<Edge> edgeList = this.graph.getEdges().get(fromIndex);
        return edgeList.contains(edge);
    }

    @Override
    public boolean clearGraph() {
        try {
            graph.getNodes().clear();
            graph.getEdges().clear();
            graph.getPaths().clear();
            graph.getLoops().clear();
        } catch (UnsupportedOperationException ex) {
            return false;
        }
        graph.getNodes().put("START", 0);
        graph.getEdges().add(new ArrayList<>());
        graph.getNodes().put("END", 1);
        graph.getEdges().add(new ArrayList<>());
        return true;
    }
}
