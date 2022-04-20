package au.ctrl.prjct.graph;

import java.util.Objects;

/**
 * Class that represents a weighted directed edge.
 * Immutable.
 */
public class Edge {
    /**
     * Node where the edge starts.
     */
    private String fromNode;
    /**
     * Node where the edge terminates.
     */
    private String toNode;
    /**
     * Gain between from node and to node represented as a <code>String</code>.
     */
    private String edgeGain;

    public Edge(String fromNode, String toNode, String edgeGain) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.edgeGain = edgeGain;
    }

    public String getFromNode() {
        return fromNode;
    }

    public String getToNode() {
        return toNode;
    }

    public String getEdgeGain() {
        return edgeGain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge edge = (Edge) o;
        return fromNode.equals(edge.fromNode) && toNode.equals(edge.toNode) && edgeGain.equals(edge.edgeGain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromNode, toNode, edgeGain);
    }
}
