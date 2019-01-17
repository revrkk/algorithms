package stack;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class EvaluateExpressions{

	private static int top = -1;

	private static String[] opStack;

	private static List<String> convertToPostFix(String infixExpression){
		String[] expression = infixExpression.split("\\s+");

		Map<String, Integer> precedence = new HashMap<String, Integer>(){{
			put("*", 3);
			put("/", 3);
			put("-", 2);
			put("+", 2);
			put("(", 1);
		}};
		
		System.out.println(Arrays.toString(expression));
		opStack = new String[expression.length];
		List<String> postFixExpression = new ArrayList<String>();
		for(int i=0; i<expression.length; i++){
			String c = expression[i];
			// 7 + 7 * 9 * (4 - 5 * 3) + 1
			switch (c) {
				case "+":
				case "-":
				case "*":
				case "/":
				case "%":
					while(top != -1 && precedence.get(opStack[top])>=precedence.get(c)){
						postFixExpression.add(opStack[top--]);
					}
					opStack[++top] = c;
					break;
				case "(":
					opStack[++top] = c;
					break;
				case ")":
					String p = opStack[top--];
					while(!p.equals("(")){
						postFixExpression.add(p);
						p = opStack[top--];
					}
					break;
				default:
					postFixExpression.add(c);
					break;
			}
			//System.out.println(Arrays.toString(opStack));
		}
		while(top!=-1){
			postFixExpression.add(opStack[top--]);
		}
		return postFixExpression;
	}

	private static String evaluatePostFix(List<String> postFixExpression){
		// [7, 7, 9, *, 4, 5, 3, *, -, *, +, 1, +]
		double result = 0;
		for(String i : postFixExpression){
			switch(i){
				case "+":
					opStack[top - 1] = String.valueOf(Integer.parseInt(opStack[top--]) + Integer.parseInt(opStack[top]));
					break;
				case "-":
					opStack[top - 1] = String.valueOf(-Integer.parseInt(opStack[top--]) + Integer.parseInt(opStack[top]));
					break;
				case "*":
					opStack[top - 1] = String.valueOf(Integer.parseInt(opStack[top--]) * Integer.parseInt(opStack[top]));
					break;
				case "/":
					opStack[top - 1] = String.valueOf(Integer.parseInt(opStack[top-1]) / Integer.parseInt(opStack[top--]));
					break;
				default:
					opStack[++top] = i;
					break;
			}
		}
		return opStack[0];
	}	

	public static void main(String... args){
		String in = "7 + 9 + 7 * 2 - 4 * ( 9 - 3 * 4 ) - 11 * 13";
		List<String> post = convertToPostFix(in);
		System.out.println("postfix: " + post);
		String result = evaluatePostFix(post);
		System.out.println("result: " + result); 
	}
}