public class BalancedParanthesis {

	public static void main(String... x){
		if(x==null && x[0]==null){
			System.err.println("Provide Pranthesis");
			return;
		}
		char[] stack = new char[100];
		String inp = x[0];
		int i, top = -1, extraBraces = 0;
		for(i = 0; i<inp.length(); i++){
			char c = inp.charAt(i);
			if(c=='{'||c=='['||c=='('){
				stack[++top] = c;
			}else if(top > -1){
				switch(c) {
					case '}':
						if(stack[top] == '{') top--; break;
					case ')':
						if(stack[top] == '(') top--; break;
					case ']':
						if(stack[top] == '[') top--; break;
				}
			}else{
				extraBraces++;
			}
		}
		if(top == -1 && extraBraces == 0){
			System.out.println("Balanced");
		}else{	
			System.out.println("Unbalanced check position " + i);
		}
	}
}