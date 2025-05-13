
public class SingleDigit {
    private StudentNode head;

    // Insert only if roll number is single-digit (0–9)
    public void insert(String name, int rollNo) {
        if (rollNo < 0 || rollNo > 9) {
            System.out.println("Error: Roll number must be a single-digit (0–9). Not inserted: " + rollNo);
            return;
        }

        StudentNode newNode = new StudentNode(name, rollNo);
        if (head == null) {
            head = newNode;
        } else {
            StudentNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Display list
    public void display() {
        StudentNode temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + ", Roll No: " + temp.rollNo);
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
    	SingleDigit list = new SingleDigit();

        list.insert("Amit", 5);     // Valid
        list.insert("Sneha", 12);   // Invalid
        list.insert("Ravi", -1);    // Invalid
        list.insert("Priya", 7);    // Valid

        System.out.println("\nFinal List:");
        list.display();
}
}


