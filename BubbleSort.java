
// File: BubbleSort.java

// Define the Student class to store student data

class Student {
	
	int rollno; // Roll number of the student
	String name; // Name of the student
	int marks; // Marks obtained by the student
// Constructor to initialize the Student object

	public Student(int rollno, String name, int marks) {
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}

// Method to display the details of the student
	public void display() {
		System.out.println("Roll No: " + rollno + ", Name: " + name + ", Marks: " + marks);
	}
}

// BubbleSort class containing the main method
class BubbleSort {
	public static void main(String[] args) {
		int i, j; // Loop counters
		Student temp; // Temporary variable for swapping
		Student[] arr = new Student[5]; // Array of Student objects
// Initializing the student array
		arr[0] = new Student(101, "Alice", 85);
		arr[1] = new Student(102, "Tejas", 70);
		arr[2] = new Student(103, "Suraj", 90);
		arr[3] = new Student(104, "Henil", 60);
		arr[4] = new Student(105, "Omkar", 75);
// Displaying student data before sorting
		System.out.println("Student data before the bubble sort:");
		for (i = 0; i < arr.length; i++) {
			arr[i].display();
		}
// Bubble Sort algorithm based on marks
		for (i = arr.length - 1; i >= 0; i--) {
			int flag = 0; // Flag to detect any swap
			for (j = 0; j < i; j++) {
				if (arr[j].marks > arr[j + 1].marks) {
// Swapping if current student has more marks than the next
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = 1;
				}
			}
// If no swaps were made, the array is already sorted
			if (flag == 0)
				break;
		}
// Displaying student data after sorting
		System.out.println("\nStudent data after the bubble sort:");
		for (i = 0; i < arr.length; i++) {
			arr[i].display();
		}
	}
}


// public int compare(Student a, Student b) {
                return a.name.compareToIgnoreCase(b.name);
