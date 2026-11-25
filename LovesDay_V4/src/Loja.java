import java.util.ArrayList;
import java.util.Scanner;

public class Loja {

    // MOSTRA A MESMA LISTA DO INVENTÁRIO: COMPRAR AQUI SOBE O NÍVEL DO ITEM LÁ
    public static void abrir(Scanner leitor, Status status) {
        ArrayList<Item> itens = status.inventario.itens;

        while (true) {
            Tela.cabecalho("Loja");
            Tela.caixa("CARTEIRA", "Cash: " + status.cash);

            ArrayList<String> gerais = new ArrayList<>();
            ArrayList<String> deEstilo = new ArrayList<>();
            for (int i = 0; i < itens.size(); i++) {
                Item item = itens.get(i);
                ArrayList<String> lista = i < Inventario.QTD_GERAIS ? gerais : deEstilo;
                lista.add("[" + (i + 1) + "] " + item.nome + "  -  " + situacao(item));
                lista.add("     " + item.descricao);
            }
            System.out.println();
            Tela.caixa("ITENS GERAIS", gerais.toArray(new String[0]));
            Tela.caixa("ITENS DE ESTILO", deEstilo.toArray(new String[0]));
            System.out.println("\n[0] - Voltar");
            System.out.print("\nEscolha uma opção: ");

            int opcao = lerOpcao(leitor, itens.size());

            if (opcao == 0) {
                return;
            }

            Item item = itens.get(opcao - 1);

            if (item.noMaximo()) {
                System.out.println("\n" + item.nome + " já está no máximo!");
            } else if (comprar(status, item)) {
                System.out.println("\n" + item.nome + " comprado!" + (item.unico() ? "" : " Agora está no LVL " + item.nivel + "."));
            } else {
                System.out.println("\nVocê não tem Cash suficiente.");
            }
            Tela.pausar(leitor);
        }
    }

    // PAGA E SOBE O NÍVEL DO ITEM (O ITEM É O MESMO OBJETO QUE ESTÁ NO INVENTÁRIO)
    private static boolean comprar(Status status, Item item) {
        if (status.cash < item.preco()) {
            return false;
        }

        status.cash -= item.preco();
        item.nivel++;
        if (item.id.equals("CORACAO")) {
            status.vidas++;
        }
        return true;
    }

    // TEXTO QUE APARECE DO LADO DO NOME: PREÇO, LVL OU [COMPRADO]
    private static String situacao(Item item) {
        if (item.unico()) {
            return item.noMaximo() ? "[COMPRADO]" : item.preco() + " cash";
        }
        if (item.noMaximo()) {
            return "LVL " + item.nivel + "/" + item.maximo + "  [MAX]";
        }
        return "LVL " + (item.nivel + 1) + "/" + item.maximo + "  " + item.preco() + " cash";
    }

    private static int lerOpcao(Scanner leitor, int quantidade) {
        while (true) {
            try {
                int opcao = Integer.parseInt(leitor.nextLine());
                if (opcao >= 0 && opcao <= quantidade) {
                    return opcao;
                }
            } catch (NumberFormatException erro) {
            }

            System.out.println("Digite um número válido!");
            System.out.print("Escolha uma opção: ");
        }
    }
}
