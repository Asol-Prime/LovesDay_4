import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dias {

    // -------------------------------------------------------------
    // CENARIO, ESTILOS COM BONUS (3 OU 4)
    // OS 3 PRIMEIROS SÃO BASE, OS OUTROS LIBERAM NOS DIAS 3, 6, 9, 12, 15, 18 E 21
    // -------------------------------------------------------------
    static String[][] CENARIOS = {
        {"Parque", "EMO", "HIPPIE", "PAIDEPET"},
        {"Praia", "PLAYBOY", "GYMRATS", "TIKTOKER", "FUNKEIRO"},
        {"Biblioteca", "NERD", "EMO", "KPOPERS", "GAMER"},
        {"Academia", "GYMRATS", "PLAYBOY", "AGROBOY", "COACH"},
        {"Fazenda", "AGROBOY", "HIPPIE", "PAIDEPET"},
        {"Pet Shop", "PAIDEPET", "PATRICINHA", "NERD"},
        {"Festival", "HIPPIE", "NOIA", "EMO"},
        {"Balada", "NOIA", "TWINK", "PLAYBOY GAY", "FUNKEIRO"},
        {"Shopping", "PATRICINHA", "TIKTOKER", "PLAYBOY", "COACH"},
        {"Show de K-pop", "KPOPERS", "TWINK", "NERD", "GAMER"},
    };

    // -------------------------------------------------------------
    // DIFICULDADE: A CADA DIA DA VIDA AS PESSOAS FICAM MAIS EXIGENTES (TIRA % DA CHANCE DE MATCH)
    // -------------------------------------------------------------
    static int EXIGENCIA_BASE = 10;
    static int EXIGENCIA_POR_DIA = 3;

    public static void iniciar(Personagem personagem, Scanner leitor, Status status) {
        Tela.cabecalho("Dia " + (status.diaAtual + 1) + " - Encontro 1");
        status.iniciarDia();

        int liberados = 3 + Math.min(status.diaAtual / 3, 7);
        if (status.diaAtual % 3 == 0 && status.diaAtual <= 21) {
            Tela.caixa("NOVIDADE", "Novo cenário desbloqueado: " + CENARIOS[liberados - 1][0] + "!");
        }

        List<String[]> locais = new ArrayList<>();
        for (int i = 0; i < liberados; i++) {
            locais.add(CENARIOS[i]);
        }

        Collections.shuffle(locais);

        for (int encontro = 0; encontro < 3; encontro++) {
            if (encontro > 0) {
                Tela.pausar(leitor);
                Tela.cabecalho("Dia " + status.diaAtual + " - Encontro " + (encontro + 1));
            }

            String[] cenario = locais.get(encontro);
            String localAtual = cenario[0];
            int bonus = 0;

            for (int i = 1; i < cenario.length; i++) {
                if (personagem.estilos.equals(cenario[i])) {
                    bonus = 10;
                }
            }
            int exigencia = EXIGENCIA_BASE + status.diaAtual * EXIGENCIA_POR_DIA;

            // EVENTO ALEATÓRIO ANTES DO ENCONTRO (PODE DAR CASH, TIRAR VIDA OU MUDAR A CHANCE)
            int evento = Eventos.sortear(status);
            if (status.morreu()) {
                Tela.pausar(leitor);
                return;
            }

            String linhaBonus = "Bônus do cenário: +" + bonus + "%  |  Exigência do dia: -" + exigencia + "%";
            if (evento != 0) {
                linhaBonus += "  |  Evento: " + (evento > 0 ? "+" : "") + evento + "%";
            }

            Tela.caixa("ENCONTRO " + (encontro + 1) + " DE 3",
                    "Local: " + localAtual,
                    linhaBonus,
                    "Vidas: " + status.vidas + "  |  Matchs: " + status.matchs);

            NPCs npc = NPCs.criar(localAtual, personagem.genero, personagem.sexualidade);
            npc.apresentar(localAtual);
            int escolha = npc.conversa(leitor, personagem.estilos, bonus - exigencia + evento, status);

            if (escolha == 2 && NPCs.interessa(npc.generoNPC, personagem.genero, personagem.sexualidade)) {
                System.out.println("\nVocê deixou passar alguém do seu interesse...");
                status.perderVida();
            }

            // SAIR NO MEIO DO DIA CUSTA 1 VIDA POR ENCONTRO QUE FALTAVA (CONTANDO O ATUAL)
            if (escolha == 9) {
                int restantes = 3 - encontro;
                System.out.println("\nVocê abandonou o dia com " + restantes + " encontro(s) restante(s)...");
                for (int i = 0; i < restantes && !status.morreu(); i++) {
                    status.perderVida();
                }
                Tela.pausar(leitor);
                return;
            }

            if (status.morreu()) {
                Tela.pausar(leitor);
                return;
            }
        }

        System.out.println();
        Tela.caixa("FIM DO DIA " + status.diaAtual, "Os encontros de hoje terminaram.", "Vidas: " + status.vidas + "  |  Matchs: " + status.matchs);
        Tela.pausar(leitor);
    }
}
