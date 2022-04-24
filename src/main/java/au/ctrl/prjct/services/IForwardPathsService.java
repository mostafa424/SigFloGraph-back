package au.ctrl.prjct.services;

import au.ctrl.prjct.graph.SignalFlowGraph;
import au.ctrl.prjct.payloads.ForwardPathPayload;

public interface IForwardPathsService {
     ForwardPathPayload getForwardPaths(SignalFlowGraph graph, int gain, String forward_path);

}
