import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
 * Implementa um analisador lexico para expressoes aritmeticas
 * 
 * @author Evandro H. Weyand
 */
public class LexicalAnalyser {

	private String input;
	private StringBuilder regex;
	private Pattern pattern;
	private Matcher matcher;

	public LexicalAnalyser(String s, List<Character> symbolsToMatch, boolean matchDigits) {
		input = s + "$"; // adiciona um caracter para indicar o final da string
		regex = new StringBuilder("");
		if (matchDigits) {
			regex.append("[-+]?\\d+(\\.\\d+)?|\\.\\d+");
			regex.append("|");
		}
		regex.append("[");
		symbolsToMatch.forEach(c -> regex.append(c));
		regex.append("]");

		compilePattern();
	}

	private void compilePattern() {
		pattern = Pattern.compile(regex.toString());
	}

	/*
	 * Metodo que efetua toda a analise, repetindo a leitura de tokens ate que a
	 * entrada termine ou que aconteca um erro, retornando um vetor de tokens
	 */
	public ArrayList<Token> analyse() {
		ArrayList<Token> tokens = new ArrayList<>();
		matcher = pattern.matcher(input);
		while (matcher.find()) { // enquanto tiver matches
			String match = matcher.group(); // pega o match
			// checa
			if (isNumeric(match)) {
				tokens.add(new Token(Double.parseDouble(match)));
			} else {
				tokens.add(new Token(match.charAt(0)));
			}
		}

		return tokens;
	}

	public static boolean isNumeric(String str) {
		return str != null && str.matches("[-+]?\\d*\\.?\\d+");
	}
}
