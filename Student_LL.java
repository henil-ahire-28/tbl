


class StudentNode {
    String name;
    int rollNo;
    StudentNode next;

    public StudentNode(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.next = null;
    }
}


public class Student_LL {
    private StudentNode head;

    // Insert at the end
    public void insert(String name, int rollNo) {
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

    // Display the list
    public void display() {
        StudentNode temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + ", Roll No: " + temp.rollNo);
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        Student_LL list = new Student_LL();
        list.insert("Amit", 101);
        list.insert("Sneha", 102);
        list.insert("Ravi", 103);

        list.display();
    }
}




