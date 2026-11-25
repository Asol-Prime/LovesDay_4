import java.util.Scanner;

public class Renascer {

    // -------------------------------------------------------------
    // QUANDO AS VIDAS ACABAM (VIDAS <= 0):
    // 1. GANHA CASH (MATCHS x DIAS x RENASCIMENTOS + BÔNUS DO SEGURO)
    // 2. RESETA OS STATS E VOLTA PRO DIA 0 (OS ITENS COMPRADOS FICAM)
    // 3. ESCOLHE DE NOVO ESTILO, GÊNERO E SEXUALIDADE (LIBERA 1 ESTILO NOVO)
    // -------------------------------------------------------------
    public static void executar(Scanner leitor, Status status, Personagem personagem) {
        status.renascimentos++;

        int bonusSeguro = status.inventario.nivel("SEGURO") * 10;
        int ganho = status.matchs * status.diaAtual * status.renascimentos;
        ganho = ganho * (100 + bonusSeguro) / 100;
        status.cash += ganho;

        Tela.cabecalho("Você Morreu");
        Tela.caixa("FIM DA VIDA " + status.renascimentos,
                "Suas vidas acabaram... mas o amor sempre renasce.",
                "",
                "Matchs: " + status.matchs + "  x  Dias: " + status.diaAtual + "  x  Renascimentos: " + status.renascimentos,
                "Bônus do Seguro de Vida: +" + bonusSeguro + "%",
                "",
                "Cash ganho: " + ganho + "  |  Cash total: " + status.cash);

        status.matchs = 0;
        status.diaAtual = 0;
        status.diaDoUltimoTrufilho = -1;
        status.vidas = status.vidasMaximas();

        Tela.pausar(leitor);
        escolherNovoVisual(leitor, personagem, status.renascimentos);
    }

    private static void escolherNovoVisual(Scanner leitor, Personagem personagem, int renascimentos) {
        Tela.cabecalho("Renascimento");
        int liberados = Math.min(3 + renascimentos, Personagem.ESTILOS.length);
        if (3 + renascimentos <= Personagem.ESTILOS.length) {
            Tela.caixa("NOVIDADE", "Novo estilo desbloqueado: " + Personagem.ESTILOS[liberados - 1] + "!");
        }
        personagem.estilos = Personagem.escolherEstilo(leitor, liberados);
        personagem.genero = Personagem.escolherGenero(leitor, personagem.genero);
        Tela.definirCor(personagem.genero);
        personagem.sexualidade = Personagem.escolherSexualidade(leitor, personagem.sexualidade);
    }
}
