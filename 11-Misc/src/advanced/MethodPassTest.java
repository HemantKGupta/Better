package advanced;

public class MethodPassTest {
	
	char c='A';
	
	public static void main(String[] args) {
		MethodPassTest m = new MethodPassTest();
		StringBuffer buffer = new StringBuffer("fun");
		m.append2(buffer);
		System.out.println(buffer);
		buffer = null;
		m.append(buffer);
		System.out.println(buffer);
		
	}
	public void append(StringBuffer buffer){
		if(buffer == null)
			buffer = new StringBuffer();
		for (int i = 0; i <6; i++) {
			buffer.append(c);
			c++;
		}
	}
	public void append2(StringBuffer buffer){
		buffer = new StringBuffer("vun");
	}

}
