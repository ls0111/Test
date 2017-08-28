import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Class c = Double[].class;
		System.out.println(c.getSimpleName());
		System.out.println(c.getName());
	}
	
}
class Apple{
	static int size = 1;
	{
		this.size = 10;
	}
	static{
		size = 100;
		System.out.println("hello world");
	}
	public void test(Apple a){
		System.out.println(a.size);	
	}
	public void f(){
		Apple a = new Apple();
		a.test(this);
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize!!!!!!!!!!");
		super.finalize();
	}
	@Override
	public boolean equals(Object s){
		return false;
	}
}