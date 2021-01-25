package sunbeam;
import java.util.Stack;

//Use java.util.Stack to solve an expression using prefix/postfix conversion. 
//Assume that input expression contains operands and operators separated by spaces. 
//Expression can have operators like (, ), *, /, +, - and $ (power). 
//Note that operand value may range from -999 to +999.

public class QuesEightMain {

	private static int calc(int a, int b, char operator) {
		switch (operator) {
		case '$':
			return (int) Math.pow(a, b);
		case '*':
			return a * b;
		case '/':
			return a / b;
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '%':
			return a % b;
		}
		return 0;
	}

	private static int pri(char operator) {
		switch (operator) {
		case '$':
			return 5;
		case '*':
			return 4;
		case '/':
			return 4;
		case '%':
			return 4;
		case '+':
			return 3;
		case '-':
			return 3;
		}
		return 0;
	}

	public static boolean isNumber(String str) {
		return str.matches("-?\\d+");
	}

	private static String infixToPostfix(String infix) {
		String[] tokens = infix.split(" ");
		Stack<Character> s = new Stack<Character>();
		StringBuilder post = new StringBuilder();
		for (int i = 0; i < tokens.length; i++) {
			String sym = tokens[i];
			if (isNumber(sym))
				post.append(sym + " ");
			else if (sym.charAt(0) == '(')
				s.push(sym.charAt(0));
			else if (sym.charAt(0) == ')') {
				while (s.peek() != '(')
					post.append(s.pop() + " ");
				s.pop();
			} else {
				while (!s.isEmpty() && pri(s.peek()) >= pri(sym.charAt(0)))
					post.append(s.pop() + " ");
				s.push(sym.charAt(0));
			}
		}
		while (!s.isEmpty())
			post.append(s.pop() + " ");
		return post.toString();
	}

	private static int solvePostfix(String post) {
		String[] tokens = post.split(" ");
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			String sym = tokens[i];
			if (isNumber(sym)) {
				String operand = (sym);
				s.push(Integer.parseInt(operand));
			} else {
				int b = s.pop();
				int a = s.pop();
				int c = calc(a, b, sym.charAt(0));
				s.push(c);
			}
		}
		return s.pop();
	}

	public static void main(String[] args) {
		String infix = "-995 + 991 / ( 32 - 28 ) * 9 + -2 $ 5";
		String postfix = infixToPostfix(infix);
		System.out.println("Infix   : " + infix);
		System.out.println("Postfix : " + postfix.toString());
		int result1 = solvePostfix(postfix);
		System.out.println("Result  : " + result1);
	}
}
