import static java.lang.System.out;

public class Rectangle {
	private float width;
	private float hight;
	
	public Rectangle() {
		
	}
	
	public Rectangle(float a,float b) {
		this.hight=a;
		this.width=b;
	}
	
	public float Area() {
		return this.hight*this.width;
	}
	
	public void SetWidth(float a) {
		this.width=a;
	}
	
	public void SetHight(float b) {
		this.hight=b;
	}
	
	public float getHight() {
		return this.hight;
	}
	
	public float getWidth() {
		return this.width;
	}
	
	public static void main(String[] args) {
		Rectangle _killer=new Rectangle(2.9f,3.4f);
		out.println("The Area is:"+_killer.Area());
		_killer.SetHight(54.7f);
		_killer.SetWidth(45.8f);
		out.println("The new Hight:"+_killer.getHight());
		out.println("The new Width:"+_killer.getWidth());
		
		out.println("The new Area:"+_killer.Area());
	}

}
