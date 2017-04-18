package week11;

/**
 *
 * @author Hank Gontarz
 */
public class LinkedList {
    private Link first;

    public LinkedList() {
        first = null;
    }
    public boolean isEmpty() {
        return (first == null);
    }
    public void push(double data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
    }
    public Link pop() {
        Link temp = first;
        first = first.next;
        return temp;
    }
    public Link peek() {
        return first;
    }
    
    public Link find(double key) {
        Link current = first;
        while(current.data != key) {
            if(current.next == null) {
                return null;
            }
            else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int index) {
        Link current = first;
        Link previous = first;
        
        int count = 0;
        if(!isEmpty()) {
            while(count != index) {
                if(current.next == null) {
                    return null;
                }
                else {
                    previous = current;
                    current = current.next;
                }
                count++;
            }
            if(current == first) {
                first = first.next;
            }
            else {
                previous.next = current.next;
            }
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        Link current = first;
        while(current != null) {
            sb.append(current.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(25.1);
        list.push(39.2);
        list.push(10.3);
        System.out.println("Peek at item : " + list.peek());
        System.out.println("Pop item : " + list.pop());
        
        System.out.println(list.toString());
        System.out.println("Match for item : " + list.find(39.2));
        System.out.println("Match for item : " + list.find(0.0));
        
        list.delete(2);
        System.out.println(list.toString());
    }
}
