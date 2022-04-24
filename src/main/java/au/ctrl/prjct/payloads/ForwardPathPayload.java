package au.ctrl.prjct.payloads;

import au.ctrl.prjct.graph.Edge;
import au.ctrl.prjct.graph.SignalFlowGraph;
import au.ctrl.prjct.services.GraphAddService;

import java.util.ArrayList;
import java.util.List;

public class ForwardPathPayload {
   private List<String> forward_paths;
   private List<Integer> path_gain;

    public ForwardPathPayload(List<String> forward_paths, List<Integer> path_gain) {
        this.forward_paths = forward_paths;
        this.path_gain = path_gain;

    }
    public ForwardPathPayload() {
        this.forward_paths = new ArrayList<>();
        this.path_gain = new ArrayList<>();
    }
    public void convertPayloadToPathList(SignalFlowGraph graph){
       List<List<Edge>> adj_list=graph.getEdges();
        for(String i:this.forward_paths){
           String[]tmp=i.split(" ");
           List<Edge>tmp_edge=new ArrayList<>();
           for(int j=0,k=1;k<tmp.length;j++,k++){
               int start_node_as_index=graph.getNodes().get(tmp[j]);
               for(Edge edge: adj_list.get(start_node_as_index)){
                   if(edge.getToNode().equals(tmp[k])){
                       tmp_edge.add(edge);
                       break;
                   }
               }
           }
           new GraphAddService(graph).addPath(tmp_edge);
       }
    }
    public List<String> getForward_paths() {
        return forward_paths;
    }

    public void setForward_paths(List<String> forward_paths) {
        this.forward_paths = forward_paths;
    }

    public List<Integer> getPath_gain() {
        return path_gain;
    }

    public void setPath_gain(List<Integer> path_gain) {
        this.path_gain = path_gain;
    }
}
