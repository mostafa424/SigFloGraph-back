package au.ctrl.prjct.services;

import au.ctrl.prjct.graph.Edge;
import au.ctrl.prjct.graph.SignalFlowGraph;

import java.util.ArrayList;
import java.util.List;

public class GraphAddService implements IGraphAddService{
    private SignalFlowGraph graph;

    public GraphAddService(SignalFlowGraph graph) {
        this.graph = graph;
    }

    @Override
    public boolean addNode(String nodeName) {
        if(this.graph.getNodes().containsKey(nodeName)) return false;
        else {
            this.graph.getNodes().put(nodeName, this.graph.getNodes().size());
            this.graph.getEdges().add(new ArrayList<>());
            return true;
        }
    }

    @Override
    public boolean addEdge(Edge edge) {
        IGraphOperationService graphOpServ = new GraphOperationService(this.graph);
        int fromIndex = graphOpServ.getNode(edge.getFromNode());
        int toIndex = graphOpServ.getNode(edge.getToNode());
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
