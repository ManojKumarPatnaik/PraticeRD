package rough;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Graph {


    private Map<String, List<String>> adjacentList;

    public Graph() {
        adjacentList = new HashMap<>();
    }


    public Map<String, List<String>> getAdjacentList() {
        return adjacentList;
    }

    public boolean addVertix(String value) {
        if (adjacentList.get(value) == null) {
            adjacentList.put(value, new CopyOnWriteArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjacentList.get(vertex1) != null && adjacentList.get(vertex2) != null) {
            adjacentList.get(vertex1).add(vertex2);
            adjacentList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjacentList.get(vertex1) != null && adjacentList.get(vertex2) != null) {
            adjacentList.get(vertex1).remove(vertex2);
            adjacentList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        List<String> stringList = adjacentList.get(vertex);
        if (stringList.isEmpty()) return false;
        for (String v : stringList) {
            removeEdge(vertex, v);
        }
        adjacentList.remove(vertex);
        return true;
    }
}
