package Class_work;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Linked_list {
    Node head;

    public static void main(String... var) {

        Linked_list list = new Linked_list();
        list.insrtAtIndex(12, 17);

    }

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        newNode.next = head; // link new node to old head
        head = newNode; // update head
    }

    void insrtAtIndex(int index, int data) {
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            if (temp == null) {
                System.out.println("Index out of range");
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
}