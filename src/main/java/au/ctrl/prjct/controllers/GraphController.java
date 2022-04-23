package au.ctrl.prjct.controllers;

import au.ctrl.prjct.graph.SignalFlowGraph;
import au.ctrl.prjct.payloads.InputPayload;
import au.ctrl.prjct.services.GraphAddService;
import au.ctrl.prjct.services.GraphOperationService;
import au.ctrl.prjct.services.InputHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class GraphController {
    private SignalFlowGraph graph;

    @Autowired
    public GraphController(SignalFlowGraph graph) {
        this.graph = graph;
    }

    @PostMapping("/input")
    public boolean takeInput(@RequestBody InputPayload payload) {
        return new InputHandler(new GraphAddService(graph)).handleInput(payload);
    }

    @GetMapping("/output")
    public int returnOutput() {
        //temp value until calculation modules are completed.
        return 0;
    }

    @DeleteMapping("/clear")
    public boolean clearGraph() {
        return new GraphOperationService(graph).clearGraph();
    }
}
