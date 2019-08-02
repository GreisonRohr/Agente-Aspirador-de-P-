package principal;

public class espaco {

	private int tamanhoAmbiente;

	private String[][] ambiente;

	private agenteAspirador agente;

	// Valores: S == Sujo  ;  L == Limpo  ;  A == Aspirador
	 

	public espaco(int tamanhoAmbiente) {// cria um novo ambiente com a quantidade de espaços que foi passado por
										// parametro
		this.tamanhoAmbiente = tamanhoAmbiente;
		this.contruirAmbiente();
	}

	// Constroi o ambiente
	private void contruirAmbiente() {
		ambiente = new String[this.tamanhoAmbiente][this.tamanhoAmbiente];

		for (int i = 0; i < this.tamanhoAmbiente; i++) {
			for (int j = 0; j < this.tamanhoAmbiente; j++) {
				this.ambiente[i][j] = "S"; // adiciona a sujeira
			}

		}
	}

	public void mostrarAmbiente() {
		atualizarPosicaoAgente();// exibe o agente na posição atual
		for (int i = 0; i < tamanhoAmbiente; i++) {
			for (int j = 0; j < this.tamanhoAmbiente; j++) {
				
				System.out.print("| " + ambiente[i][j] + " |");

			}
			System.out.println("");

		}
		System.out.println("");

	}

	

	public int gettamanhoAmbiente() {//retorna o tamanho do ambiente
		return this.tamanhoAmbiente;
	}

	public String retornarValorPosicaoAmbiente(PosicaoXY posicao) {//retorna posição atual do agente
		return this.ambiente[posicao.getPosX()][posicao.getPosY()];
	}

	public void setAgente(agenteAspirador agente) {

		this.agente = agente;
	}

	public void limpar() {//adiciona  letra L na posiçao em que o aspirador executou a limpeza

		PosicaoXY posicao = this.agente.getPosicao();
		ambiente[posicao.getPosX()][posicao.getPosY()] = "L";

	}
	
	private void atualizarPosicaoAgente() {// adiciona a letra A na posição onde esta o aspirador 
		if (this.agente != null) {
			PosicaoXY posAgente = this.agente.getPosicao();
			ambiente[posAgente.getPosX()][posAgente.getPosY()] = "A";
		}
	}

}