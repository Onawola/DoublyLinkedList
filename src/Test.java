public class Test {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        LinkedList list = new LinkedList(head);
        list.addNodeToFront(10);
        list.addNodeToFront(13);

        list.addNodeToEnd(3);
//        list.addNodeToEnd(4);
        list.addNodeAfterData(2, 10);
//        list.addNodeAtIndex(4, 3);
//        boolean b = list.removeByData(4);
        list.printList();
        int numNodes = list.getNumNodes();
        System.out.print("\n" + numNodes);

        Node node = new Node(1, null);
        node.setNext(new Node(2, null));
        node.getNext().setData(3);
        Node node2 = new Node(2, null);
        node2.setNext(node.getNext());
        node.setNext(node2);
        node2.setPrevious(node);
        while(node.getNext() != null) {
            System.out.print(node.getData());
            System.out.print(", ");
            node = node.getNext();
        }
        System.out.print(node.getData());
    }
}
