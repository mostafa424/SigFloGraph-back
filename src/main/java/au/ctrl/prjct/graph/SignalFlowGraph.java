package au.ctrl.prjct.graph;

import java.util.List;

public class SignalFlowGraph {
    /**
     * List of nodes in graph, first and last indices are "START" and "END" nodes.
     */
    private List<String> nodes;
    /**
     * List of directed edges in graph, implemented via adjacency list.
     * Second dimension lists' contents are edges such that the starting node
     * of the edge is the node referred to by the index of the first dimension.
     */
    private List<List<Edge>> edges;
    /**
     * List of paths between "START" and "END" nodes.
     * Second dimension lists' contents are the successive edges that lead from
     * START node to END node.
     */
    private List<List<Edge>> paths;
    /**
     * List of loops in graph, where a loop is defined as a sequence of edges that
     * start at a node and terminate at the same node.
     * Second dimension lists' contents are the successive edges that lead from a
     * node to itself.
     */
    private List<List<Edge>> loops;

    /**
     * Constructor for a signal flow graph object, takes four lists as parameter.
     * Provided lists are preferably empty, if not the lists are cleared.
     *
     * @param nodes <code>List</code> of <code>String</code> used to store nodes.
     * @param edges <code>List</code> of <code>List</code> of <code>Integer</code> used to store directed edges between nodes.
     * @param paths <code>List</code> of <code>List</code> of <code>Integer</code> used to store paths from START to END nodes.
     * @param loops <code>List</code> of <code>List</code> of <code>Integer</code> used to loops.
     */
    public SignalFlowGraph(List<String> nodes, List<List<Edge>> edges, List<List<Edge>> paths, List<List<Edge>> loops) {
        this.nodes = nodes;
        this.edges = edges;
        this.paths = paths;
        this.loops = loops;
        this.initGraph();
    }

    private void initGraph() {
        if(!this.nodes.isEmpty()) {
            this.nodes.clear();
        }
        if(!this.edges.isEmpty()) {
            this.edges.clear();
        }
        if(!this.paths.isEmpty()) {
            this.paths.clear();
        }
        if(!this.loops.isEmpty()) {
            this.loops.clear();
        }
        this.nodes.add("START");
        this.nodes.add("END");
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public List<List<Edge>> getEdges() {
        return edges;
    }

    public void setEdges(List<List<Edge>> edges) {
        this.edges = edges;
    }

    public List<List<Edge>> getPaths() {
        return paths;
    }

    public void setPaths(List<List<Edge>> paths) {
        this.paths = paths;
    }

    public List<List<Edge>> getLoops() {
        return loops;
    }

    public void setLoops(List<List<Edge>> loops) {
        this.loops = loops;
    }
}
