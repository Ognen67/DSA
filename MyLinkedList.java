class MyLinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;
    int size = 0;

    public MyLinkedList() {

    }

    // Recursively
    public int getLength() {
        return getLength(head);
    }

    public int getLength(Node head) {
        if(head == null)
            return 0;
        return 1 + getLength(head.next);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        if (size == 0) {
            return -1;
        }
        if (index < 0 || index >= size) {
            return -1;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {

        Node nn = new Node(val);
        if (size > 0) {
            nn.next = head;
            head = nn;
            size++;
        } else if (isEmpty()) {
            head = nn;
            tail = nn;
            size++;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node nn = new Node(val);
        if (size > 0) {
            tail.next = nn;
            tail = nn;
            size++;
        } else if (size == 0) {
            head = nn;
            tail = nn;
            size++;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index >= size + 1) {
            return;
        }
        if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            Node n = new Node(val);
            Node prev = null;
            Node curr = head;
            for (int i = 0; i < index; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = n;
            n.next = curr;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
        } else if (index == size - 1) {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        } else {

            Node prev = null;
            Node curr = head;
            for (int i = 0; i < index; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            size--;
        }

    }

    public void printList() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);

        int length = list.getLength();

        list.printList();

        System.out.println("--" + length);

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */