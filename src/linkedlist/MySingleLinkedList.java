package linkedlist;

public class MySingleLinkedList<T> {

    public Node<T> head;
    public int size;

    public MySingleLinkedList() {
        head = null;
        size = 0;
    }

    public void add(int index, T item) {    // insert

    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        // 조건문을 안 넣어도 됨.
//        if(head == null) {
//            this.head = newNode;
//        } else {
//            Node<T> temp = head;
//            head = newNode;
//            newNode.next = temp;
//        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void remove(int index) {         // delete

    }

    public int indexOf(T item) {            // search
        return -1;
    }

    public T get(int index) {
        return null;
    }

    public static void main(String[] args) {

        MySingleLinkedList<String> list = new MySingleLinkedList<>();

        list.add(0, "Saturday");    // S
        list.add(1, "Friday");  // S, F
        list.add(0, "Monday");  // M, S, F
        list.add(2, "Tuesday"); // M, S, T, F

        String str = list.get(2);   // str = "Tuesday"
        list.remove(2);     // M, S, F
        int pos = list.indexOf("Friday");   // 2

    }
}
