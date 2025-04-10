package testing;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] numbers= {10.1,12,13.5,45,30};
		System.out.println("first element "+numbers[0]);
		System.out.println("last element "+numbers[4]);
		for(int i=(numbers.length-1);i>=0;i--)
		{
			System.out.println(numbers[i]);
		}

		System.out.println("total number of elements "+numbers.length);
	}

}
