package au.ctrl.prjct.services;

import au.ctrl.prjct.graph.Edge;
import au.ctrl.prjct.graph.SignalFlowGraph;

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
}
