package principal;

import java.util.Scanner;

public class ia {

	public static void main(String[] args) throws InterruptedException {

		Scanner ler = new Scanner(System.in);

		System.out.println("**** AGENTE ASPIRADOR DE PÓ ****");

		System.out.println("");

		System.out.println("Digite quantos locais deseja criar:");
		int valor = ler.nextInt();
		espaco local = new espaco(valor);// cria n espaços no ambiente conforme dados solicitados

		local.mostrarAmbiente();

		agenteAspirador agente = new agenteAspirador(local);
		agente.setPosicao(new PosicaoXY(0, 0));

		while (agente.isAindaLimpando()) {
			agente.zerarPilha();
			agente.movimentar();
			local.mostrarAmbiente();
			Thread.sleep(1500);
		}
		return;
	}

}
