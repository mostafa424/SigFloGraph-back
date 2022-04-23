package au.ctrl.prjct.services;

import au.ctrl.prjct.graph.Edge;
import au.ctrl.prjct.payloads.InputPayload;

import java.util.ArrayList;
import java.util.List;

public class InputHandler implements IInputHandler{
    private IGraphAddService graphAdder;
    private IGraphOperationService graphOperator;

    public InputHandler(IGraphAddService graphAdder, IGraphOperationService graphOperator) {
        this.graphAdder = graphAdder;
        this.graphOperator = graphOperator;
    }

    @Override
    public boolean handleInput(InputPayload payload) {
        graphOperator.clearGraph();
        List<String> nodes = payload.getNodes();
        List<String> sources = payload.getSources();
        List<String> destinations = payload.getDestinations();
        List<Integer> gains = payload.getGains();
        for(String node: nodes) {
            if (node.compareToIgnoreCase("START") == 0 || node.compareToIgnoreCase("END") == 0) {
                continue;
            }
            boolean err = this.graphAdder.addNode(node);
            if(!err) {
                System.out.println("Duplicate node detected in input, aborting input process...");
                return false;
            }
        }
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < sources.size(); i++) {
            edges.add(new Edge(sources.get(i), destinations.get(i), gains.get(i)));
        }
        for(Edge edge: edges) {
            boolean err = this.graphAdder.addEdge(edge);
            if(!err) {
                System.out.println("Invalid edge detected in input, aborting input process...");
                return false;
            }
        }
        return true;
    }
}
