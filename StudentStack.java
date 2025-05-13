package Stack_Student;

class Student {
	int rollNo;
	String name;

	Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	@Override
	public String toString() {
		return rollNo + " - " + name;
	}
}

class Node {
	Student student;
	Node next;

	Node(Student student) {
		this.student = student;
		this.next = null;
	}
}

class StudentStack {
	private Node top;

	public void push(Student student) {
		Node newNode = new Node(student);
		newNode.next = top;
		top = newNode;
		System.out.println("Pushed: " + student);
	}

	public Student pop() {
		if (top == null) {
			System.out.println("Stack is empty.");
			return null;
		}
		Student popped = top.student;
		top = top.next;
		System.out.println("Popped: " + popped);
		return popped;
	}

	public void display() {
		Node temp = top;
		System.out.println("Stack contents:");
		while (temp != null) {
			System.out.println(temp.student);
			temp = temp.next;
		}
	}
}
