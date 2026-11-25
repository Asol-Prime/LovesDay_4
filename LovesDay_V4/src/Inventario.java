import java.util.ArrayList;

public class Inventario {

	static int QTD_GERAIS = 6;

	ArrayList<Item> itens = criarItens(); // TODOS OS ITENS DO JOGO, CADA UM COM O SEU NÍVEL (A LOJA USA ESSA MESMA LISTA)

	// -------------------------------------------------------------
	// CRIA A LISTA COM TODOS OS ITENS (TODOS COMEÇAM NO NÍVEL 0)
	// ID, NOME, PREÇO BASE, DESCRIÇÃO, LVL MÁXIMO
	// -------------------------------------------------------------
	public static ArrayList<Item> criarItens() {
		ArrayList<Item> itens = new ArrayList<>();

		// ITENS GERAIS
		itens.add(new Item("TRUFILHO", "Trufilho", 250, "mais uma chance por dia", 1));
		itens.add(new Item("SEGURO", "Seguro de Vida", 100, "+10% de Cash ao renascer por LVL", 5));
		itens.add(new Item("PERFUME", "Perfume", 40, "+5% de chance de match por LVL", 5));
		itens.add(new Item("CANTADAS", "Livro de Cantadas", 30, "+3% de chance de match por LVL", 5));
		itens.add(new Item("ENERGETICO", "Energético", 120, "5% / 10% / 15% de chance de recuperar 1 vida por dia", 3));
		itens.add(new Item("CORACAO", "Coração extra", 200, "+1 vida por LVL", 3));

		// ITENS DE ESTILO: O ID É O PRÓPRIO ESTILO DO NPC
		itens.add(new Item("EMO", "Lápis de Olho", 30, "+4% com EMO por LVL", 5));
		itens.add(new Item("NERD", "Óculos de Grau", 30, "+4% com NERD por LVL", 5));
		itens.add(new Item("PLAYBOY", "Relógio de Ouro", 30, "+4% com PLAYBOY por LVL", 5));
		itens.add(new Item("AGROBOY", "Chapéu de Boiadeiro", 30, "+4% com AGROBOY por LVL", 5));
		itens.add(new Item("GYMRATS", "Pote de Whey", 30, "+4% com GYMRATS por LVL", 5));
		itens.add(new Item("KPOPERS", "Camisa do BTS", 30, "+4% com KPOPERS por LVL", 5));
		itens.add(new Item("PATRICINHA", "Bolsa de Grife", 30, "+4% com PATRICINHA por LVL", 5));
		itens.add(new Item("PLAYBOY GAY", "Cropped Brilhante", 30, "+4% com PLAYBOY GAY por LVL", 5));
		itens.add(new Item("PAIDEPET", "Coleira de Patinha", 30, "+4% com PAIDEPET por LVL", 5));
		itens.add(new Item("TWINK", "Gloss Labial", 30, "+4% com TWINK por LVL", 5));
		itens.add(new Item("HIPPIE", "Colar de Cristal", 30, "+4% com HIPPIE por LVL", 5));
		itens.add(new Item("NOIA", "Kenner", 30, "+4% com NOIA por LVL", 5));
		itens.add(new Item("TIKTOKER", "Ring Light", 30, "+4% com TIKTOKER por LVL", 5));
		itens.add(new Item("GAMER", "Headset RGB", 30, "+4% com GAMER por LVL", 5));
		itens.add(new Item("FUNKEIRO", "Corrente de Prata", 30, "+4% com FUNKEIRO por LVL", 5));
		itens.add(new Item("COACH", "Livro de Autoajuda", 30, "+4% com COACH por LVL", 5));

		return itens;
	}

	// PROCURA O ITEM PELO ID E DEVOLVE O NÍVEL (0 = NÃO COMPRADO)
	public int nivel(String id) {
		for (Item item : itens) {
			if (item.id.equals(id)) {
				return item.nivel;
			}
		}
		return 0;
	}

	public void mostrar() {
		ArrayList<String> linhas = new ArrayList<>();
		for (Item item : itens) {
			if (item.nivel > 0) {
				String lvl = item.unico() ? "" : "  LVL " + item.nivel + "/" + item.maximo;
				linhas.add("■ " + item.nome + lvl);
				if (!item.id.equals("TRUFILHO")) { // O TRUFILHO MOSTRA SÓ O NOME
					linhas.add("    " + item.descricao);
				}
			}
		}
		if (linhas.isEmpty()) {
			linhas.add("Nenhum item ainda.");
		}
		Tela.caixa("INVENTARIO", linhas.toArray(new String[0]));
	}
}
