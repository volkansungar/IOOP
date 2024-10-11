import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomerList {
    public class Node {
        public CustomerData data;
        public int customerNumber;
        public Node link;
        //node no argument constructor
        public Node() {
            data = null;
            customerNumber = 0;
            link = null;
        }

        //node constructor
        public Node(CustomerData data, int customerNumber, Node link) {
            this.data = data;
            this.customerNumber = customerNumber;
            this.link = link;
        }
    }

    //iterator class
    public class ListIterator {
        private Node position;
        private Node previous;
        //iterator no argument constructor
        public ListIterator() {
            position = head;
            previous = null;
        }
        public void restart() {
            position = head;
            previous = null;
        }

        public Node next() {
            if (!hasNext())
                throw new NoSuchElementException();

            Node toReturn = position;
            previous = position;
            position = position.link;
            return toReturn;
        }
        public void previous() {
            Node temp = previous;
            restart();
            while (position != temp) {next();}

        }
        public boolean hasNext() { return (position != null); }

        public void addHere(CustomerData newData, int customerNumber) {
            if (position == null && previous != null)
                    previous.link = new Node(newData, customerNumber, null);
                //start of the list
                else if (position == null || previous == null) {
                CustomerList.this.addToStart(newData, customerNumber);
            }
                //nodes are consecutive
                else {
                    Node temp = new Node(newData, customerNumber, position);
                    previous.link = temp;
                    previous = temp;
            }
        }

    }//end of iterator class
    public ListIterator iterator() {
        return new ListIterator();
    }

    private Node head;

    public CustomerList(){
        head = null;
    }

    public void addToStart (CustomerData data, int customerNumber) {
        head = new Node(data, customerNumber, head);
    }

    public boolean deleteHeadNode() {
        if (head != null) {
            head = head.link;
            return true;
        }
        else
            return false;
    }

    public int size() {
        int count = 0;
        Node position = head;
        while (position != null) {
            count++;
            position = position.link;
        }
        return count;
    }

    private Node find(Node target) {
        Node position = head;
        CustomerData itemAtPosition;
        while (position != null) {
            if (position.equals(target))
                return position;
            position = position.link;
        }
        return null;
    }

    public boolean contains(Node item) {
        return (find(item) != null);
    }

    public Node findData(Node target) {
        Node result = find(target);
        if (result == null)
            return null;
        else
            return head;
    }

    public void outputList() {
        Node position = head;
        while (position != null) {
            System.out.println(position.data);
            System.out.println("Customer number: " + position.customerNumber);
            position = position.link;
        }
    }

    public boolean checkDoctor(int customerNumber) {
        Node position = head;
        while (position != null) {
            if (position.customerNumber == customerNumber && Objects.equals(position.data.getOccupation(), "Doctor"))
                return true;
            position = position.link;
        }
        return false;
    }
    public boolean checkTurkey(int customerNumber) {
        Node position = head;
        while (position != null) {
            if (position.customerNumber == customerNumber && Objects.equals(position.data.getCountry(), "Turkey"))
                return true;
            position = position.link;
        }
        return false;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = null;
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
            return false;
        else {
            CustomerList otherList = (CustomerList)otherObject;
            if (size() != otherList.size())
                return false;
            Node position = head;
            Node otherPosition = otherList.head;
            while (position != null) {
                if (!(position.data.equals(otherPosition.data)))
                    return false;
                position = position.link;
                otherPosition = otherPosition.link;
            }
            return true;
        }
    }


}
