

class Student{
		int rollno;
		String name;
		int marks;
		public Student(int rollno, String name, int marks) {
			super();
			this.rollno = rollno;
			this.name = name;
			this.marks = marks;
		}
		public void display() {
			System.out.println("RollNo :"+rollno+"Name :"+name+"Marks :"+marks);
		}
	}

public class Insertion_Student {
	public static void main(String[] args) {
		int i,j;
		Student k;
		Student[] arr = new Student[3];
		
		arr[0] = new Student(1,"henil",99);
		arr[1] = new Student(2,"shamli",66);
		arr[2] = new Student(3,"ram",55);
		
		for(i=0;i<arr.length;i++) {
			arr[i].display();
			System.out.println();
		}
		
		/////////////insertion sort logic///////////////
		for(i=1;i<arr.length;i++) {
			k=arr[i];
			for(j=i-1;j>=0 && k.marks>arr[j].marks;j--) {
				arr[j+1]=arr[j];
			
			}
			arr[j+1]=k;
		}	
		

		System.out.println();
		System.out.println("student sorted using insertion :");
		
		for(i=0;i<arr.length;i++) {
			arr[i].display();
		}
		
		
		
	}
	
	
}
