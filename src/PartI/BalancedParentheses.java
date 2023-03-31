package PartI;

public class BalancedParentheses {

	public static boolean isBalanced(String inString) {
		int l=inString.length();
		MyStack<Character> ms=new MyStack<Character>();
		for(int x=0;x<l;x++) {
			if(inString.charAt(x)=='(') {
				ms.push('(');
			}
			if(inString.charAt(x)==')') {
				if(ms.peek()=='(') {
					ms.pop();
				}else {
					return false;
				}
			}
		}
		return ms.empty();
	}
	
	public static void main(String[] args) {
		boolean result = isBalanced("(()()()())");
		System.out.println(result);
		result = isBalanced("(((())))");
		System.out.println(result);
		result = isBalanced("((((((())");
		System.out.println(result);
	}
}
