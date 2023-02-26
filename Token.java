/* Classe simples que representa um token
 */
public class Token {
	private char tipo; // tipo do token, que e "n" para um token numerico
	private double valor; // valor do token numerico

	// Construtor de um token de operador, pois recebe apenas o tipo
	public Token(char tipo) {
		this.tipo = tipo;
		valor = 0;
	}

	// Construtor de um token numerico, pois recebe apenas um "double"
	public Token(double valor) {
		tipo = 'n';
		this.valor = valor;
	}

	// Metodo para retornar o tipo
	public char getType() {
		return (tipo);
	}

	// Metodo para retornar o valor
	public double getValue() {
		return (valor);
	}

	// Metodo para converter este objeto em string, usado para impresseo na tela
	public String toString() {
		if (tipo == 'n') {
			return ("[" + tipo + "," + valor + "] ");
		} else {
			return ("[" + tipo + "] ");
		}
	}
}
