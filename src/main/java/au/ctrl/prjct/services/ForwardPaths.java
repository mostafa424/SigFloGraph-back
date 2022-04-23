package au.ctrl.prjct.services;

import au.ctrl.prjct.graph.Edge;
import au.ctrl.prjct.graph.ForwardPathPayload;
import au.ctrl.prjct.graph.SignalFlowGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ForwardPaths {
    ForwardPathPayload res=new ForwardPathPayload(new ArrayList<String>(),new ArrayList<Integer>());
    public ForwardPathPayload getForwardPaths(SignalFlowGraph graph, int gain, String forward_path) {
        List<List<Edge>> adj_list=graph.getEdges();

       for(Edge i : adj_list.get(0)){
            boolean[]flags=new boolean[adj_list.size()];
            flags[0]=true;
            dfs(graph,graph.getNodes().get(i.getToNode()),gain * i.getEdgeGain(),forward_path+i.getToNode(),flags);
       }
       return res;
    }
    public void dfs(SignalFlowGraph graph,int next_node, int gain, String forward_path,boolean[]flags){
        if(next_node==graph.getNodes().get("END")){
            res.getForward_paths().add(forward_path);
            res.getPath_gain().add(gain);
            return;
        }
        flags[next_node]=true;
        List<List<Edge>> adj_list=graph.getEdges();
        for(Edge i : adj_list.get(next_node)){
            if(flags[graph.getNodes().get(i.getToNode())]){
                continue;
            }
            else{
                dfs(graph,graph.getNodes().get(i.getToNode()),gain * i.getEdgeGain(),forward_path+i.getToNode(),flags);
                flags[next_node]=false;
            }
        }
    }
}