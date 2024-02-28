package practice;

class RunAway{
	public int hashCode() {
		return 15;
		
	}
}
public class Modification {

	public static void main(String[] args) {
		JumpAway ja = new JumpAway();
		System.out.println("ja:"+ja.hashCode());
		JumpAway ja1 = new JumpAway();
		System.out.println("ja1:"+ja1.hashCode());
		RunAway ra = new RunAway();
		System.out.println("ra:"+ra.hashCode());
		RunAway ra1 = new RunAway();
		System.out.println("ra1:"+ra1.hashCode());
		
	}
}
class JumpAway{
	
}
