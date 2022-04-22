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
    public String getNode(int index) {
        return this.graph.getNodes().get(index);
    }

    @Override
    public int getNodeIndex(String nodeName) {
        return this.graph.getNodes().indexOf(nodeName);
    }

    @Override
    public List<Edge> getNodeEdges(String nodeName) {
        int nodeIndex = this.getNodeIndex(nodeName);
        if(nodeIndex == -1) return null;
        return this.graph.getEdges().get(nodeIndex);
    }

    @Override
    public boolean edgeExists(Edge edge) {
        int fromIndex = this.getNodeIndex(edge.getFromNode());
        int toIndex = this.getNodeIndex(edge.getToNode());
        if(fromIndex == -1 || toIndex == -1) return false;
        List<Edge> edgeList = this.graph.getEdges().get(fromIndex);
        return edgeList.contains(edge);
    }
}
