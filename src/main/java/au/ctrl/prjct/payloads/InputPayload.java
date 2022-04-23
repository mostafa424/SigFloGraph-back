package au.ctrl.prjct.payloads;


import java.util.List;

public class InputPayload {
    private List<String> nodes;
    private List<String> sources;
    private List<String> destinations;
    private List<Integer> gains;

    public List<String> getNodes() {
        return nodes;
    }

    public List<String> getSources() {
        return sources;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public List<Integer> getGains() {
        return gains;
    }
}
