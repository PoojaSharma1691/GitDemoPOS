package testing;

import java.util.Scanner;

public class Fibonnaci {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("enter array length");
		
		int n=s.nextInt();
		int arr[] = new int[n];
		
		arr[0]=0; arr[1]=1;
		
		for(int i=2;i<n;i++)
		{
			arr[i]=arr[i-2]+arr[i-1];
		}
		
		//System.out.println(arr[]);
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}

	}

}
