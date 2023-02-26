import java.util.ArrayList;
import java.util.Arrays;

public class TestLexicalAnalyser {

	public static void main(String[] args) {
		String s = "1 + 2.0* ( 03 *4.56 + 78.9)";
		System.out.println("Input: '" + s + "'");

		Character[] symbols = { '+', '*', '(', ')' };
		LexicalAnalyser la = new LexicalAnalyser(s, Arrays.asList(symbols), true);

		ArrayList<Token> tokens = la.analyse();
		System.out.println(tokens);
	}

}