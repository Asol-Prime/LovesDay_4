import java.util.Scanner;

public class Personagem {

    // ORDEM EM QUE OS ESTILOS SÃO DESBLOQUEADOS (3 BASE + 1 POR RENASCIMENTO)
    static String[] ESTILOS = {"EMO", "PLAYBOY", "NERD", "PAIDEPET", "NOIA", "AGROBOY", "GYMRATS", "HIPPIE", "TIKTOKER", "KPOPERS", "PATRICINHA", "TWINK", "PLAYBOY GAY", "GAMER", "FUNKEIRO", "COACH"};

    String nome;
    String cabelo;
    String estilos;
    String genero;
    String altura;
    String sexualidade;

    public Personagem(String nome, String cabelo, String genero, String estilos, String altura, String sexualidade) {
        this.nome = nome;
        this.cabelo = cabelo;
        this.estilos = estilos;
        this.genero = genero;
        this.altura = altura;
        this.sexualidade = sexualidade;
    }

    public static Personagem criar(Scanner leitor) {
        String cabelo = "PADRAO";
        String estilos = "PADRAO";
        String genero = "PADRAO";
        String sexualidade = "PADRAO";
        String altura = "1.70";

        Tela.cabecalho("Criação de Personagem");
        System.out.print("Escolha seu nome: ");
        String nome = leitor.nextLine();

        loop: while (true) {
            Tela.cabecalho("Criação de Personagem");
            Tela.caixa(nome.toUpperCase(),
                    "[1] - CABELO      (" + cabelo + ")",
                    "[2] - ESTILO      (" + estilos + ")",
                    "[3] - ALTURA      (" + altura + ")",
                    "[4] - GENERO      (" + genero + ")",
                    "[5] - SEXUALIDADE (" + sexualidade + ")",
                    "[6] - CONFIRMAR",
                    "[9] - SAIR");
            System.out.print("\nEscolha uma opção: ");
            int opcao = lerOpcao(leitor, 6);

            switch (opcao) {
                case 1:
                    System.out.println();
                    Tela.caixa("CABELO", "[1] - COMPRIDO", "[2] - MEDIO", "[3] - CURTO", "[9] - SAIR");
                    System.out.print("\nEscolha uma opção: ");
                    int opcaoCabelo = lerOpcao(leitor, 3);

                    if (opcaoCabelo == 1) {
                        cabelo = "COMPRIDO";
                    } else if (opcaoCabelo == 2) {
                        cabelo = "MEDIO";
                    } else if (opcaoCabelo == 3) {
                        cabelo = "CURTO";
                    } else if (opcaoCabelo == 9) {
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 2:
                    estilos = escolherEstilo(leitor, 3);
                    break;

                case 3:
                    System.out.println();
                    Tela.caixa("ALTURA", "[1] - 1.65", "[2] - 1.75", "[3] - 1.85", "[9] - SAIR");
                    System.out.print("\nEscolha uma opção: ");
                    int opcaoAltura = lerOpcao(leitor, 3);

                    if (opcaoAltura == 1) {
                        altura = "1.65";
                    } else if (opcaoAltura == 2) {
                        altura = "1.75";
                    } else if (opcaoAltura == 3) {
                        altura = "1.85";
                    } else if (opcaoAltura == 9) {
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 4:
                    genero = escolherGenero(leitor, genero);
                    Tela.definirCor(genero);
                    break;

                case 5:
                    sexualidade = escolherSexualidade(leitor, sexualidade);
                    break;

                case 6:
                    System.out.println("Confirmado!");
                    break loop;

                case 9:
                    System.out.println("Saindo...");
                    return null;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        return new Personagem(nome, cabelo, genero, estilos, altura, sexualidade);
    }

    public static String escolherEstilo(Scanner leitor, int liberados) {
        String[] opcoes = new String[liberados];
        for (int i = 0; i < liberados; i++) {
            opcoes[i] = "[" + (i + 1) + "] - " + ESTILOS[i];
        }
        System.out.println();
        Tela.caixa("ESTILO (" + liberados + " de " + ESTILOS.length + " desbloqueados)", opcoes);
        System.out.print("\nEscolha uma opção: ");

        while (true) {
            try {
                int opcao = Integer.parseInt(leitor.nextLine());
                if (opcao >= 1 && opcao <= liberados) {
                    return ESTILOS[opcao - 1];
                }
            } catch (NumberFormatException erro) {
            }

            System.out.println("Digite um número válido!");
            System.out.print("Escolha uma opção: ");
        }
    }

    public static String escolherGenero(Scanner leitor, String atual) {
        System.out.println();
        Tela.caixa("GÊNERO", "[1] - MASCULINO", "[2] - FEMININO", "[3] - NÃO INFORMADO", "[9] - SAIR");
        System.out.print("\nEscolha uma opção: ");
        int opcaoGenero = lerOpcao(leitor, 3);

        if (opcaoGenero == 1) {
            return "MASCULINO";
        } else if (opcaoGenero == 2) {
            return "FEMININO";
        } else if (opcaoGenero == 3) {
            return "NÃO INFORMADO";
        }
        return atual;
    }

    public static String escolherSexualidade(Scanner leitor, String atual) {
        System.out.println();
        Tela.caixa("SEXUALIDADE", "[1] - HETEROSEXUAL", "[2] - HOMOSSEXUAL", "[3] - LESBICA", "[4] - BISEXUAL", "[9] - SAIR");
        System.out.print("\nEscolha uma opção: ");
        int opcaoSexualidade = lerOpcao(leitor, 4);

        if (opcaoSexualidade == 1) {
            return "HETEROSEXUAL";
        } else if (opcaoSexualidade == 2) {
            return "HOMOSSEXUAL";
        } else if (opcaoSexualidade == 3) {
            return "LESBICA";
        } else if (opcaoSexualidade == 4) {
            return "BISEXUAL";
        }
        return atual;
    }

    private static int lerOpcao(Scanner leitor, int maiorOpcao) {
        while (true) {
            String entrada = leitor.nextLine();

            try {
                int opcao = Integer.parseInt(entrada);
                if ((opcao >= 1 && opcao <= maiorOpcao) || opcao == 9) {
                    return opcao;
                }
            } catch (NumberFormatException erro) {
            }

            System.out.println("Digite um número válido!");
            System.out.print("Escolha uma opção: ");
        }
    }
}