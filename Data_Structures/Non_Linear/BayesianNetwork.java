package com.Data_Structures_byprayush.Data_Structures.Non_Linear;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BayesianNetwork {

    private Map<String, Node> nodes;

    public BayesianNetwork() {
        nodes = new HashMap<>();
    }

    public void addNode(String name, Map<String, Double> probabilities) {
        Node node = new Node(name, probabilities);
        nodes.put(name, node);
    }

    public void addEdge(String parent, String child) {
        Node parentNode = nodes.get(parent);
        Node childNode = nodes.get(child);
        parentNode.addChild(childNode);
    }

    public double getProbability(String node, String state) {
        Node n = nodes.get(node);
        return n.getProbability(state);
    }

    public static void main(String[] args) {
        BayesianNetwork network = new BayesianNetwork();

        // Create the nodes and their probabilities.
        Map<String, Double> ageProbabilities = new HashMap<>();
        ageProbabilities.put("young", 0.6);
        ageProbabilities.put("old", 0.4);
        network.addNode("age", ageProbabilities);

        Map<String, Double> sexProbabilities = new HashMap<>();
        sexProbabilities.put("male", 0.5);
        sexProbabilities.put("female", 0.5);
        network.addNode("sex", sexProbabilities);

        // Create the edges.
        network.addEdge("age", "sex");

        // Print the probability of a patient being young and male.
        System.out.println(network.getProbability("age", "young") * network.getProbability("sex", "male"));
    }
}

class Node {

    private String name;
    private Map<String, Double> probabilities;
    private List<Node> children;

    public Node(String name, Map<String, Double> probabilities) {
        this.name = name;
        this.probabilities = probabilities;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getProbabilities() {
        return probabilities;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public double getProbability(String state) {
        return probabilities.get(state);
    }
}
