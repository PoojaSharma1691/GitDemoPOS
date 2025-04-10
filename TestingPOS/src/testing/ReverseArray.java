package testing;

public class ReverseArray {

	public static void main(String[] args) {
		
		char[] s= {'1','2','3','4','5'};
		
		int left=0;
		int right =s.length-1;
		
		while(left<right)
		{
			char c=s[left];
			s[left] = s[right];
			s[right]=c;
			
			left=left+1;
			right=right-1;
		}
				
		for(int i=0;i<s.length;i++)
		{
			System.out.print(s[i]+" ");
		}
		
		
		//capital letters count in a string
		
		
	}

}
