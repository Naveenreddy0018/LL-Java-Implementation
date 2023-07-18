public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    public void insertNode(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if (tail == null) {
            insertNode(value);
            return;
        }
        tail.next = node;
        tail = node;
        size += 1;
        
    }

    public void insertPosition(int value, int pos) {
        Node temp = head;
        if (pos == 0) {
            insertNode(value);
            return;
        }
        else if(size == pos) {
            insertLast(value);
            return;
        }
        else {
            for(int i = 1; i < pos; i++) {
                temp = temp.next;
            }
            Node node = new Node(value, temp.next);
            temp.next = node;
                
        }
        size += 1;
    }

    public int deleteBeginning() {
        int val = head.value;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        size -= 1;
        return val;
    }

    public int deleteEnd() {
        if (size <= 1) {
            return deleteBeginning();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public Node get(int index) {
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node find(int value) {
        Node node = head;
        while(node != null) {
            if(node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int deletePosition(int pos) {
        if (pos == 0) {
            return deleteBeginning();
        }
        if (pos == size - 1) {
            return deleteEnd();
        }
       
        Node node = get(pos - 1);
        int val = node.next.value;
        node.next = node.next.next;
        return val;

    }

    public void dispaly() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(9);
        list.insertNode(34);
        list.insertLast(87);
        list.insertPosition(67, 2);
        System.out.println(list.deleteBeginning());
        list.dispaly();
        System.out.println(list.deleteEnd());
        list.dispaly();
        System.out.println(list.deletePosition(2));
        list.dispaly();
    }
}
