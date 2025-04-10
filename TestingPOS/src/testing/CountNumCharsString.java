package testing;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CountNumCharsString {

	public static void main(String[] args) {
		
		System.out.println("Enter string");
		Scanner s=new Scanner(System.in);
		String str=s.next();
		
		HashMap<Character,Integer> hm=new HashMap<>();
		
		char[] arr=str.toCharArray();
		
		for(char c:arr)
		{
			if(hm.containsKey(c))
			 hm.put(c, hm.get(c)+1);
			else 
			 hm.put(c, 1);
		}
		
		System.out.println(hm);
		
		//find duplicate characters in a string
		Set<Character> set=hm.keySet();
		for(char c:set)
		{
			if(hm.get(c)>1)
			{
				System.out.println(c+" "+hm.get(c));
			}
		}
		
		

	}

}
