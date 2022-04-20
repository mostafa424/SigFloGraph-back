package au.ctrl.prjct.services;

import au.ctrl.prjct.graph.Edge;

import java.util.List;

public interface IGraphOperationService {
    String getNode(int index);
    int getNodeIndex(String nodeName);
    List<Edge> getNodeEdges(String nodeName);
    boolean edgeExists(Edge edge);
}
