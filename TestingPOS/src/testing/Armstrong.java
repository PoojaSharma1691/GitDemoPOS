package testing;

public class Armstrong {

	public static void main(String[] args) {
		
		int num=371;
		int original=num;
		double result=0;
		
		while(num!=0)
		{
			int remainder=num%10;
			result=result+Math.pow(remainder, 3);
			num=num/10;
		}
System.out.println(result);

if(original==result)
System.out.println("is armstrong number");
}
}
