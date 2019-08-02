package principal;

public class agenteAspirador {

	private espaco espaco;
	private movimentosAspirador movimento;

	private PosicaoXY posXY;
	private int pilhaMovimentos;

	public agenteAspirador(espaco espaço) {// primeiro movimento do aspirador
		this.espaco = espaço;
		espaco.setAgente(this);
		this.movimento = movimentosAspirador.DIREITA;
	}

	public void movimentar() {

		if (this.pilhaMovimentos >= 4) {
			return;
		}
		PosicaoXY proximoMovimento = retornarMovimento();
		String valor = this.espaco.retornarValorPosicaoAmbiente(proximoMovimento);

		if (valor.equals("L") || valor.equals("A")) {

			proximoMovimento();
			aumentarPilha();
			movimentar();

		} else {

			this.espaco.limpar();
			this.posXY = proximoMovimento;
		}
	}

	private void aumentarPilha() {

		this.pilhaMovimentos++;

	}

	private void proximoMovimento() {

		switch (this.movimento) {
		case CIMA:
			this.movimento = movimentosAspirador.BAIXO;
			break;
		case BAIXO:
			this.movimento = movimentosAspirador.ESQUERDA;
			break;
		case ESQUERDA:
			this.movimento = movimentosAspirador.DIREITA;
			break;
		case DIREITA:
			this.movimento = movimentosAspirador.CIMA;
			break;
		}
	}

	public PosicaoXY retornarMovimento() {
		int retornoPosX = this.posXY.getPosX();
		int retornoPosY = this.posXY.getPosY();
		switch (movimento) {
		case CIMA:
			if (retornoPosX > 0) {
				retornoPosX -= 1;
			}
			break;
		case BAIXO:
			if (retornoPosX < this.espaco.gettamanhoAmbiente() - 1) {
				retornoPosX += 1;
			}
			break;
		case ESQUERDA:
			if (retornoPosY > 0) {
				retornoPosY -= 1;
			}
			break;
		case DIREITA:
			if (retornoPosY < this.espaco.gettamanhoAmbiente() - 1) {
				retornoPosY += 1;
			}
			break;
		}
		return new PosicaoXY(retornoPosX, retornoPosY);
	}

	public PosicaoXY getPosicao() {

		return this.posXY;
	}

	public void setPosicao(PosicaoXY posicaoXY) {
		this.posXY = posicaoXY;

	}

	public boolean isAindaLimpando() {

		return pilhaMovimentos < 4;
	}

	public void zerarPilha() {

		this.pilhaMovimentos = 0;
	}
}
