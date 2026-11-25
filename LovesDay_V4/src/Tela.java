import java.util.Scanner;

public class Tela {

    // -------------------------------------------------------------
    // CORES ANSI: HOMEM = AZUL, MULHER = ROSA, OUTROS = CIANO (ESTILO BBS)
    // -------------------------------------------------------------
    static String AZUL = "\033[94m";
    static String ROSA = "\033[38;5;213m";
    static String CIANO = "\033[96m";
    static String cor = CIANO;

    static String[] TITULO = {
        " █     ███  █   █ █████  ████   ████   ███  █   █",
        " █    █   █ █   █ █     █       █   █ █   █  █ █ ",
        " █    █   █ █   █ ████   ███    █   █ █████   █  ",
        " █    █   █  █ █  █         █   █   █ █   █   █  ",
        " █████ ███    █   █████ ████    ████  █   █   █  ",
    };

    public static void definirCor(String genero) {
        if (genero.equals("MASCULINO")) {
            cor = AZUL;
        } else if (genero.equals("FEMININO")) {
            cor = ROSA;
        } else {
            cor = CIANO;
        }
        System.out.print(cor);
    }

    // DESENHA O TITULO (SÓ APLICA A COR, SEM LIMPAR A TELA)
    public static void cabecalho(String subtitulo) {
        System.out.print(cor);
        System.out.println();
        for (String linha : TITULO) {
            System.out.println(linha);
        }
        System.out.println("\n ■   " + subtitulo + "   ■\n");
    }

    // DESENHA UMA CAIXA COM TITULO E AS LINHAS DENTRO
    public static void caixa(String titulo, String... linhas) {
        int largura = titulo.length() + 6;
        for (String linha : linhas) {
            largura = Math.max(largura, linha.length() + 2);
        }

        String topo = "─■ " + titulo + " ■";
        System.out.println("┌" + topo + "─".repeat(largura - topo.length()) + "┐");
        for (String linha : linhas) {
            System.out.println("│ " + linha + " ".repeat(largura - linha.length() - 1) + "│");
        }
        System.out.println("└" + "─".repeat(largura) + "┘");
    }

    // QUEBRA UM TEXTO GRANDE EM LINHAS DE NO MAXIMO "largura" LETRAS
    public static String[] quebrar(String texto, int largura) {
        java.util.ArrayList<String> linhas = new java.util.ArrayList<>();
        String linha = "";
        for (String palavra : texto.split(" ")) {
            if (!linha.isEmpty() && linha.length() + palavra.length() + 1 > largura) {
                linhas.add(linha);
                linha = palavra;
            } else {
                linha = linha.isEmpty() ? palavra : linha + " " + palavra;
            }
        }
        linhas.add(linha);
        return linhas.toArray(new String[0]);
    }

    // APRESENTAÇÃO DO NPC QUANDO O JOGADOR ENCONTRA ELE
    public static void encontro(String local, String artigo, String nome, String estilo, String acao) {
        java.util.ArrayList<String> linhas = new java.util.ArrayList<>();
        linhas.add("Andando por " + local + ", você encontrou " + artigo + " " + nome + "!");
        linhas.add("");
        for (String linha : quebrar(acao, 60)) {
            linhas.add(linha);
        }
        System.out.println();
        caixa("ALGUÉM APARECEU", linhas.toArray(new String[0]));
        esperar(2000);
    }

    // PAUSA A TELA POR UM TEMPO (EM MILISSEGUNDOS) PARA DAR TEMPO DE LER
    public static void esperar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException erro) {
        }
    }

    // PERGUNTA DO NPC E AS OPÇÕES, TUDO DENTRO DA MESMA CAIXA
    public static void pergunta(String nome, String texto, String... opcoes) {
        java.util.ArrayList<String> linhas = new java.util.ArrayList<>();
        for (String linha : quebrar(texto, 60)) {
            linhas.add(linha);
        }
        if (opcoes.length > 0) {
            linhas.add("");
        }
        for (int i = 0; i < opcoes.length; i++) {
            // A PRIMEIRA LINHA LEVA O NÚMERO, AS OUTRAS FICAM ALINHADAS EMBAIXO DO TEXTO
            String prefixo = "[" + (i + 1) + "] ";
            for (String linha : quebrar(opcoes[i], 56)) {
                linhas.add(prefixo + linha);
                prefixo = "    ";
            }
        }
        System.out.println();
        caixa(nome.toUpperCase() + " PERGUNTA", linhas.toArray(new String[0]));
    }

    // REAÇÃO / FALA DO NPC
    public static void fala(String texto) {
        System.out.println();
        String prefixo = " » ";
        for (String linha : quebrar(texto, 64)) {
            System.out.println(prefixo + linha);
            prefixo = "   ";
        }
    }

    public static void match() {
        System.out.println();
        caixa("RESULTADO", "■■■  DEU MATCH!  ■■■");
    }

    public static void rejeitado() {
        System.out.println();
        caixa("RESULTADO", "xxx  REJEITADO...  xxx");
    }

    public static void pausar(Scanner leitor) {
        System.out.print("\nPressione ENTER para continuar...");
        leitor.nextLine();
    }
}
