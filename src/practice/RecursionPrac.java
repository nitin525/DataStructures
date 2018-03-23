package practice;

public class RecursionPrac {

	public static void main(String[] args) {
		int a=5;
		System.out.println(fact(a));
	}
	
	static int fact(int n){
		if(n==1)
			return 1;
		
		System.out.println("n recursion-->"+n);
		int ans =  n*fact(n-1);
		System.out.println(ans);//backtracking
		return ans;
	}
}
