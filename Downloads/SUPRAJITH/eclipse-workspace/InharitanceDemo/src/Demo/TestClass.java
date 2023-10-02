package Demo;
import java.util.*;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String name;String addr;String email;String ph;String course;String USN;
		System.out.println("Enter Name");
		name = sc.nextLine();
		System.out.println("Enter Address");
		addr= sc.nextLine();
		System.out.println("Enter Email");
		email= sc.nextLine();
		System.out.println("Enter Phone Number");
		ph= sc.nextLine();
		Staff abc = new Staff(name,addr,email,ph,"Manager","EMP123","Cmpanyabc");
		abc.display();
		abc.calculateSalary();
		
		System.out.println("Enter Course");
		course= sc.nextLine();
		System.out.println("Enter USN");
		USN= sc.nextLine();
		Student std1 = new Student(name,addr,email,ph,course,USN);
		std1.display();
		std1.calculateFees();
	}

}
