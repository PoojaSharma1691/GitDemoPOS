package testing;

public class reverseString {

	public static void main(String[] args) {
	
		
		String s= "Pooja";
		String r="";
		
		for(int i=s.length()-1;i>=0;i--)
		{
			r=r+s.charAt(i);
		}
	System.out.println("reverse "+r);
	}
	

}
