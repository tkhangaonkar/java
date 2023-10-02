package Demo;

import java.util.Scanner;

interface Student_Op{
	public void calculateFees();
}






class Student extends Person implements Student_Op{
	String course;
	String USN;
	int fees;
	public Student(String name,String addr,String email,String ph,String course,String USN) {
		super(name,addr,email,ph);
		this.course=course;
		this.USN=USN;
		
		
		
	}
	public void calculateFees() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Fees");
		
		int fee = sc.nextInt();
		this.fees=(int)(fee+fee*0.15+50850);
		System.out.println("Total Fees after University and other fees : "+this.fees);

		//sc.close();
	}	
}