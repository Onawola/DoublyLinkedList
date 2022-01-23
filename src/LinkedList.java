public class LinkedList {
        private Node head;
        private Node last;
        private int numNodes;

        public LinkedList(Node head) {
            this.head = head;
            this.last = head;
            numNodes = 1;
        }

        public int getNumNodes() {
            return numNodes;
        }

        public void addNodeToEnd(Node toAdd) {
//            Node n = head;
//            while(n.getNext() != null) {
//                n = n.getNext();
//            }
            this.last.setNext(toAdd);
            toAdd.setPrevious(last);
            this.last = toAdd;
            numNodes++;
        }

        public void addNodeToEnd(int data) {
            Node toAdd = new Node(data, null);
            addNodeToEnd(toAdd);
        }

        public void addNodeToFront(Node node) {
            head.setPrevious(node);
            node.setNext(head);
            this.head = node;
            numNodes++;
        }

        public void addNodeToFront(int data) {
            Node toAdd = new Node(data, null);
            addNodeToFront(toAdd);
        }

        public boolean addNodeAfterData(Node toAdd, int data) {
            Node n = head;
            if(head.getData() == data) {
                toAdd.setPrevious(head);
                toAdd.setNext(head.getNext());
                this.head.setNext(toAdd);
                numNodes++;
                return true;
            }

            while(n.getNext() != null) {
                if(n.getData() == data) {
                    toAdd.setPrevious(n);
                    toAdd.setNext(n.getNext());
                    n.setNext(toAdd);
                    numNodes++;
                    return true;
                }
                n = n.getNext();
            }
            return false;
        }

        public boolean addNodeAfterData(int data, int dataSearch) {
            Node toAdd = new Node(data, null);
            return addNodeAfterData(toAdd, dataSearch);
        }

        public boolean addNodeAtIndex(int index, Node toAdd) {
            if(((numNodes - index) <= 1 ) || index < 0) {
//                if(((index - numNodes) > 1) || index < 0) {

                    return false;
            }
            if(index == 0) {
                addNodeToFront(toAdd);
                return true;
            }
            int counter = 0;
            Node n = head;
            while(n.getNext() != null) {
                n = n.getNext();
                counter++;
                if(counter == index) {
                    toAdd.setPrevious(n.getPrevious());
                    toAdd.setNext(n);
                    n.getPrevious().setNext(toAdd);
                    numNodes++;
                    return true;
                }
            }
            return false;
        }

        public boolean addNodeAtIndex(int data, int index) {
            Node toAdd = new Node(data, null);
            return addNodeAtIndex(index, toAdd);
        }

        public void printList() {
            Node n = head;
            System.out.println("");
            while(n.getNext() != null) {
                System.out.print(n.getData());
                System.out.print(", ");
                n = n.getNext();
            }
            System.out.print(n.getData());
        }

        public boolean removeByData(int data) {
            Node n = head;
            if(head.getData() == data) {
                this.head = head.getNext();
                this.head.setPrevious(null);
                numNodes--;
                return true;
            }
            while(n.getNext() != null) {
                if(n.getData() == data) {
                    n.getPrevious().setNext(n.getNext());
                    n.getNext().setPrevious(n.getPrevious());
                    numNodes--;
                    return true;
                }
                n = n.getNext();
            }
            return false;
        }

        public boolean removeByIndex(int index) {
            if(index < 0 || index > numNodes) {
                return false;
            }
            if(index == 0) {
                if(this.head.getNext() != null) {
                    this.head = head.getNext();
                    this.head.setPrevious(null);
                    numNodes--;
                    return true;
                } else {
                    return false;
                }
            }
            int counter = 0;
            Node n = head;
            while(n.getNext() != null) {
                if(counter == index) {
                    n.getPrevious().setNext(n.getNext());
                    n.getNext().setPrevious(n.getPrevious());
                    numNodes--;
                    return true;
                }
                counter++;
                n = n.getNext();
            }
            return false;
        }

    }
