package au.ctrl.prjct.graph;

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
