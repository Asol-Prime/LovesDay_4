import java.util.Random;

public class Status {
	int vidas = 5;
	int matchs;
	int renascimentos;
	int cash = 1000;
	int diaAtual;
	int diaDoUltimoTrufilho = -1;
	Inventario inventario = new Inventario(); // OS ITENS DO JOGADOR

	// 5 VIDAS BASE + 1 POR LVL DO CORAÇÃO EXTRA
	public int vidasMaximas() {
		return 5 + inventario.nivel("CORACAO");
	}

	public void adicionarMatch() {
		matchs++;
	}

	public void perderVida() {
		vidas--;
		System.out.println(" [!] Você perdeu 1 vida. Vidas restantes: " + vidas);
	}

	public boolean morreu() {
		return vidas <= 0;
	}

	// SEM CHECAR VIDAS: MESMO QUE A 1ª REJEIÇÃO ZERE AS VIDAS, O TRUFILHO DEVOLVE ELA
	public boolean podeUsarTrufilho() {
		return inventario.nivel("TRUFILHO") > 0 && diaDoUltimoTrufilho != diaAtual;
	}

	// O TRUFILHO DEVOLVE A VIDA DA 1ª REJEIÇÃO, SÓ PERDE VIDA SE FOR REJEITADO DE NOVO
	public boolean usarTrufilho() {
		if (!podeUsarTrufilho()) {
			return false;
		}

		diaDoUltimoTrufilho = diaAtual;
		vidas++;
		System.out.println(" [!] O Trufilho te devolveu a vida perdida. Vidas: " + vidas);
		return true;
	}

	public void iniciarDia() {
		diaAtual++;

		if (vidas < vidasMaximas() && new Random().nextInt(100) < inventario.nivel("ENERGETICO") * 5) {
			vidas++;
			System.out.println(" [!] O Energético te deu uma vida extra! Vidas: " + vidas + "\n");
		}
	}

	// BONUS DE CHANCE DOS ITENS + BONUS DO ITEM DE ESTILO DO NPC (ID DO ITEM DE ESTILO = ESTILO)
	public int getBonusCompra(String estiloNPC) {
		return inventario.nivel("PERFUME") * 5 + inventario.nivel("CANTADAS") * 3 + inventario.nivel(estiloNPC) * 4;
	}
}
