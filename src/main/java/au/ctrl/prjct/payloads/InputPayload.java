package au.ctrl.prjct.payloads;


import java.util.List;

public class InputPayload {
    private List<String> nodes;
    private List<String> sources;
    private List<String> destinations;
    private List<Integer> gains;

    public InputPayload(List<String> nodes, List<String> sources, List<String> destinations, List<Integer> gains) {
        this.nodes = nodes;
        this.sources = sources;
        this.destinations = destinations;
        this.gains = gains;
    }

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
