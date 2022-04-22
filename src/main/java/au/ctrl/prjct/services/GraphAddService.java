package au.ctrl.prjct.services;

import au.ctrl.prjct.graph.Edge;
import au.ctrl.prjct.graph.SignalFlowGraph;

import java.util.List;

public class GraphAddService implements IGraphAddService{
    private SignalFlowGraph graph;

    public GraphAddService(SignalFlowGraph graph) {
        this.graph = graph;
    }

    @Override
    public boolean addNode(String nodeName) {
        if(this.graph.getNodes().contains(nodeName)) return false;
        else {
            this.graph.getNodes().add(this.graph.getNodes().size() - 2, nodeName);
            return true;
        }
    }

    @Override
    public boolean addEdge(Edge edge) {
        IGraphOperationService graphOpServ = new GraphOperationService(this.graph);
        int fromIndex = graphOpServ.getNodeIndex(edge.getFromNode());
        int toIndex = graphOpServ.getNodeIndex(edge.getToNode());
        if(fromIndex == -1 || toIndex == -1) return false;
        this.graph.getEdges().get(fromIndex).add(edge);
        return true;
    }

    @Override
    public boolean addPath(List<Edge> pathEdges) {
        this.graph.getPaths().add(pathEdges);
        return true;
    }

    @Override
    public boolean addLoop(List<Edge> loopEdges) {
        this.graph.getLoops().add(loopEdges);
        return true;
    }
}
