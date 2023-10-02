package shape;

public class Triangle {
	int base;
	int height;
	public Triangle(int base,int height)
	{
		this.base=base;
		this.height=height;
	}
	protected double calcArea() 
	{
		return 0.5 * this.base*this.height;
	}
	
	
}
