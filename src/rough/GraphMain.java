package rough;

public class GraphMain {
    public static void main(String[] args) {
        Graph main = new Graph();
        main.addVertix("A");
        main.addVertix("B");
        main.addVertix("C");
        main.addVertix("D");
        main.addEdge("A","B");main.addEdge("A","C");main.addEdge("A","D");
        main.addEdge("D","C");main.addEdge("B","D");main.addEdge("B","C"); main.addEdge("B","C");
        System.out.println(main.getAdjacentList());
        main.removeEdge("B","C");
        System.out.println(main.getAdjacentList());
        main.removeVertex("D");
        System.out.println(main.getAdjacentList());

    }
}
