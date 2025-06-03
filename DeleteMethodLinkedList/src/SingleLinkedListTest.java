import java.util.LinkedList;

public class SingleLinkedListTest {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedlist(int nodeValue){
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }
    LinkedList<String> lit = new LinkedList<>();

    //Insert Method
    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null){
            createSingleLinkedlist(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size){
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // Traversing through a linked list

    public void traverseLinkedList(){
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size -1) {
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    //Search for an element
    public boolean searchNode(int nodeValue){
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                if (tempNode.value == nodeValue) {
                    System.out.print("Found the node at location: " +i+"\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("Node not found");
        return false;
    }

    //implement deleting a node from single linked list

    public void deleteFromLinkedList(int location) {

        // If location is out of bounds, print error message
        if (location < 0 || location >= size) {
            System.out.println("Inputted location is out of bounds of Linked List");
            return;

        // If location = 0, delete head
        } else if (location == 0) {
            head = head.next;

        // If location = size-1, delete tail
        } else if (location == size - 1) {
            Node tempNode = head;
            int index = 0;

            // Iterate through LinkedList to find the previous node
            while (index < location -1) {
                tempNode = tempNode.next;
                index++;
            }

            // Unlink node
            tempNode.next = null;
            tail = tempNode;

        // Delete any middle index
        } else {
            Node tempNode = head;
            int index = 0;

            // Iterate through the LinkedList to find the previous node
            while (index < location -1) {
                tempNode = tempNode.next;
                index++;
            }

            // Unlink node
            tempNode.next = tempNode.next.next;
        }
        size--;
    }


    // Show that the delete method works

    public static void main(String[] args) {
        SingleLinkedListTest newLinkedList = new SingleLinkedListTest();

        newLinkedList.insertLinkedList(1,0);
        newLinkedList.insertLinkedList(2,1);
        newLinkedList.insertLinkedList(3,2);
        newLinkedList.insertLinkedList(4,3);
        newLinkedList.insertLinkedList(5,4);
        System.out.println("Initial Linked List:");
        newLinkedList.traverseLinkedList();

        // Out of bounds error
        System.out.println("Out of bounds error:");
        newLinkedList.deleteFromLinkedList(-1);

        // Remove head
        System.out.println("Remove head:");
        newLinkedList.deleteFromLinkedList(0);
        newLinkedList.traverseLinkedList();

        System.out.println("Re-inserting head...");
        newLinkedList.insertLinkedList(1,0);

        // Remove tail
        System.out.println("Remove tail:");
        newLinkedList.deleteFromLinkedList(4);
        newLinkedList.traverseLinkedList();

        System.out.println("Re-inserting tail...");
        newLinkedList.insertLinkedList(5,4);

        // Remove middle index
        System.out.println("Remove middle index:");
        newLinkedList.deleteFromLinkedList(2);
        newLinkedList.traverseLinkedList();
    }
}
