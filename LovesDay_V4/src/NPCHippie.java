import java.util.Random;
import java.util.Scanner;

public class NPCHippie extends NPCs {

    public NPCHippie(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "HIPPIE", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÕES HIPPIE
        // -------------------------------------------------------------

        String[] acoes = {
            "está trançando uma tornozeleira artesanal de macramê com sementes de açaí e pedras energéticas.",
            "acendeu um incenso de sálvia branca e está defumando o ambiente para espantar o mau-olhado e energias densas.",
            "está descalço na grama, abraçado a uma árvore para \"trocar fluidos vitais com a Mãe Gaia\".",
            "oferece um chá misterioso de ervas e raízes que promete abrir e alinhar os seus 7 chakras.",
            "está afinando um violão cheio de adesivos pacifistas enquanto cantarola canções do Raul Seixas.",

        };

        // -------------------------------------------------------------
        // AÇÕES HIPPIE
        // -------------------------------------------------------------

        Random random = new Random();

        String acao = acoes[random.nextInt(acoes.length)];
        String artigo = generoNPC.equals("FEMININO") ? "a" : "o";
        String pronome = generoNPC.equals("FEMININO") ? "Ela" : "Ele";
        Tela.encontro(localAtual, artigo, nomeNPC, estiloNPC, pronome + " " + acao);
    }

    @Override
    public int conversa(Scanner leitor, String estiloJogador, int bonus, Status status) {

        String pronome = generoNPC.equals("FEMININO") ? "ela" : "ele";
        System.out.println();
        Tela.caixa("O QUE VOCÊ FAZ?", "[1] - Puxar assunto", "[2] - Deixar passar", "[9] - Abandonar o dia (-1 vida por encontro restante)");
        System.out.print("\nSelecione uma opção: ");
        int escolha;
        while (true) {
            try {
                escolha = Integer.parseInt(leitor.nextLine());
                if (escolha == 1 || escolha == 2 || escolha == 9) {
                    break;
                }
            } catch (NumberFormatException erro) {
            }

            System.out.println("Digite um número válido!");
            System.out.print("Selecione uma opção: ");
        }

        switch (escolha) {
            case 1:

                // --------------------------------------------------------------
                // HIPPIE É DO MUNDO GOODVIBES
                // --------------------------------------------------------------

                // PERGUNTA 1
                if (estiloNPC.equals("HIPPIE")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "Qual é a sua casa dos sonhos?",
                            "Cobertura de luxo na capital.",
                            "Casa simples na praia perto das ondas.",
                            "Uma kombi home ou ecovila no meio da serra.",
                            "Apartamento num condomínio fechado.");
                    System.out.print("\nSelecione uma opção: ");
                    int opcao;
                    while (true) {
                        try {
                            opcao = Integer.parseInt(leitor.nextLine());
                            if (opcao >= 1 && opcao <= 4) {
                                break;
                            }
                        } catch (NumberFormatException erro) {
                        }

                        System.out.println("Digite um número válido!");
                        System.out.print("Selecione uma opção: ");
                    }

                    if (opcao == 3) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " junta as palmas das mãos: \"Namastê! Viver livre na estrada, plantando o que colhe e conectado à Mãe Terra!\"");
                    } else if (opcao == 2) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " sorri relaxado: \"Ouvir as ondas do mar todo dia purifica os chakras, vibração muito pura.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " balança a cabeça negativamente: \"Prédios altos e condomínios são só gaiolas cinzas pro espírito\"");
                    }


                    // PERGUNTA 2

                    Tela.pergunta(nomeNPC, "Qual é a melhor terapia para curar o estresse da vida moderna?",
                            "Trabalhar muito.",
                            "Banho de cachoeira, cristais e meditação.",
                            "Chá de ervas naturais e caminhada descalço.",
                            "Comprar coisas caras no cartão de crédito.");
                    System.out.print("\nSelecione uma opção: ");
                    int opcao2;
                    while (true) {
                        try {
                            opcao2 = Integer.parseInt(leitor.nextLine());
                            if (opcao2 >= 1 && opcao2 <= 4) {
                                break;
                            }
                        } catch (NumberFormatException erro) {
                        }

                        System.out.println("Digite um número válido!");
                        System.out.print("Selecione uma opção: ");
                    }

                    if (opcao2 == 2) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " fica com os olhos brilhando: \"A água pura lava tudo e o quartzo rosa alinha o coração! Essa é a verdadeira cura!\"");
                    } else if (opcao2 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " acena em concordância: \"Aterramento na terra descarrega qualquer energia densa de volta pro solo.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " suspira com compaixão: \"Consumismo desenfreado e correria são ilusões do sistema babilônico\"");
                    }

                    // PERGUNTA 3

                    Tela.pergunta(nomeNPC, "Qual lema você escolhe para guiar suas atitudes?",
                            "PAZ, AMOR, RESPEITO À MÃE TERRA E BOA VIBRAÇÃO.",
                            "Cada um cuida do seu e ninguém se mete.",
                            "Compartilhar o pouco que tem com quem precisa.",
                            "O dinheiro move o mundo.");
                    System.out.print("\nSelecione uma opção: ");
                    int opcao3;
                    while (true) {
                        try {
                            opcao3 = Integer.parseInt(leitor.nextLine());
                            if (opcao3 >= 1 && opcao3 <= 4) {
                                break;
                            }
                        } catch (NumberFormatException erro) {
                        }

                        System.out.println("Digite um número válido!");
                        System.out.print("Selecione uma opção: ");
                    }

                    if (opcao3 == 1) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " abre os braços com um sorriso sereno: \"O Universo conspira a favor de quem emana luz pura e harmonia cósmica!\"");
                    } else if (opcao3 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " faz o sinal de paz e amor: \"A partilha e a solidariedade enriquecem a alma de verdade.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " acende um incenso com expressão preocupada: \"Pesada demais essa energia... que Jah limpe essa aura carregada.\"");
                    }


                    // Cálculo da probabilidade (executado uma única vez ao final das escolhas)
                    int pTotal = bonus + pontos + status.getBonusCompra(estiloNPC);
                    int probabilidade = Math.min(Math.max(pTotal, 0), 100);
                    System.out.println();
                    Tela.caixa("CONVERSA", "Pontos da conversa: " + pontos, "Chance de match: " + probabilidade + "%");

                    while (true) {
                        Random random = new Random();
                        int sorteio = random.nextInt(100) + 1;

                        if (sorteio <= probabilidade) {
                            status.adicionarMatch();
                            Tela.match();
                            break;
                        }

                        status.perderVida();
                        Tela.rejeitado();

                        if (!status.podeUsarTrufilho()) {
                            break;
                        }

                        System.out.println();
                        Tela.caixa("TRUFILHO", "Usar o Trufilho para tentar de novo?", "[1] - SIM", "[2] - NÃO");
                        System.out.print("\nSelecione uma opção: ");
                        int usarTrufilho = lerOpcaoTrufilho(leitor);

                        if (usarTrufilho == 2) {
                            break;
                        }

                        status.usarTrufilho();
                        System.out.println("\nVocê usou o Trufilho! Esta é sua última tentativa do dia.");
                    }
                }
                break;

            case 2:
                System.out.println("\nVocê decidiu deixar passar e seguir em frente.");
                break;

            case 9:
                System.out.println("\nVocê abandonou o dia...");
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        return escolha;
    }

    private int lerOpcaoTrufilho(Scanner leitor) {
        while (true) {
            try {
                int opcao = Integer.parseInt(leitor.nextLine());
                if (opcao == 1 || opcao == 2) {
                    return opcao;
                }
            } catch (NumberFormatException erro) {
            }

            System.out.println("Digite um número válido!");
            System.out.print("Selecione uma opção: ");
        }
    }
}