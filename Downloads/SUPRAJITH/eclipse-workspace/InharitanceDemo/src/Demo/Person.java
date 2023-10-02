package Demo;

class Person{
	private String name;
	private String address;
	private String email;
	private String phone;
	public Person(String name,String addr,String email,String ph) {
		this.name=name;
		this.address=addr;
		this.email=email;
		this.phone=ph;
		
		
	}
	public void display() {
		System.out.println("Name :"+this.name);
		System.out.println("Address :"+this.address);

		System.out.println("Email :"+this.email);

		System.out.println("Phone number :"+this.phone);
	}	
}


