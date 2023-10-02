package Demo;

import java.util.Scanner;
interface Staff_Op{
	public void calculateSalary();
}

class Staff extends Person implements Staff_Op{
	String designation;
	String empid;
	String company;
	int salary;
	public Staff(String name,String addr,String email,String ph,String designation,String empid,String company) {
		super(name,addr,email,ph);
		this.designation=designation;
		this.empid=empid;
		this.company=company;
		
		
		
	}
	public void calculateSalary() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Basic Salary");
		int sal= sc.nextInt();
		this.salary=(int)(sal+sal*0.15+sal*0.25-sal*0.12);
		System.out.println("Total Salary after bonus and deductions : "+this.salary);

		//sc.close();
	}	
}