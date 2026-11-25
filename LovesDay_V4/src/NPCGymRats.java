import java.util.Random;
import java.util.Scanner;

public class NPCGymRats extends NPCs {

    public NPCGymRats(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "GYMRATS", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÕES GYMRATS
        // -------------------------------------------------------------

        String[] acoes = {
            "está contraindo o bíceps no reflexo de qualquer vitrine enquanto dá um gole num galão d'água de 3 litros.",
            "está pesando 150g de frango seco com batata-doce numa balança digital portátil no meio da calçada.",
            "ajeita a regata cavada até a cintura, estala os ombros e solta: \"Hoje é dia de moer perna, sem desculpas!\"",
            "está conferindo as veias dilatadas do antebraço para ver se a beta-alanina do pré-treino começou a formigar.",
            "faz uma pose clássica de fisiculturismo do nada e pergunta: \"Acha que meu shape tá retido ou seco?\"",
        };

        // -------------------------------------------------------------
        // AÇÕES GYMRATS
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
                // GYMRATS ESTA DENOMINADA COMO HETERO
                // --------------------------------------------------------------

                if ("MASCULINO".equals(generoJogador) && "MASCULINO".equals(generoNPC)) {
                    Tela.fala(nomeNPC + " puxa uma garrafa de whey da bolsa, agita a garrafa e diz:");
                    Tela.fala("\"Foi mal, mas eu não fico com homem, meu negócio é mulher e academia.\"");
                    status.perderVida();
                    Tela.rejeitado();
                    return 1;
                }
                if ("FEMININO".equals(generoJogador) && "FEMININO".equals(generoNPC)) {
                    Tela.fala(nomeNPC + " tira os fones do ouvido e guarda em sua bolsa vintage...");
                    Tela.fala("\"Nada contra você, mas mulher não faz meu tipo. Agora, um homem com shape eu considero.\"");
                    status.perderVida();
                    Tela.rejeitado();
                    return 1;
                }

                // --------------------------------------------------------------
                // GYMRATS ESTA DENOMINADA COMO HETERO
                // --------------------------------------------------------------
                

                // PERGUNTA 1
                if (estiloNPC.equals("GYMRATS")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "Qual é a refeição sagrada dos campeões?",
                            "Pratinho de alface com limão.",
                            "300g de frango grelhado, batata-doce e 4 ovos cozidos.",
                            "Dois scoops de whey com pasta de amendoim.",
                            "Pizza com refrigerante normal.");
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

                    if (opcao == 2) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " faz a pose clássica de duplo bíceps: \"RECEITA SAGRADA DO SHAPE! Proteína pura e carbo limpo! Monstro dos pesos!\"");
                    } else if (opcao == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " bate na coxa em aprovação: \"Prático, anabólico e salva os macros no meio da correria do dia!\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " olha com expressão de nojo: \"Que lixo metabólico! Desse jeito você vai catabolizar até a alma!\"");
                    }

                    // PERGUNTA 2

                    Tela.pergunta(nomeNPC, "O que você faz quando a barra do supino trava no seu peito na última repetição?",
                            "Pedir socorro e desistir da vida fitness.",
                            "Esperar o parceiro de treino ajudar com um dedinho.",
                            "Dar um berro: 'tá leve!', usar a força do ódio e empurrar até a falha.",
                            "Deixar o peso rolar pelo corpo e chorar.");
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

                    if (opcao2 == 3) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " bate no peito gritando: \"É DISSO QUE EU TÔ FALANDO! Sangue nos olhos! Se não for até a falha, nem conta!\"");
                    } else if (opcao2 == 2) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " concorda com a cabeça: \"Pedir um toque do parceiro de treino pra não quebrar a clavícula é sensato.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " sacode a cabeça inconformado: \"Fraqueza mental total! A mente desistiu muito antes do músculo, que vergonha!\"");
                    }

                    //PERGUNTA 3

                    Tela.pergunta(nomeNPC, "Qual é o maior pecado imperdoável que alguém pode cometer na academia?",
                            "Pular o leg day e deixar as anilhas espalhadas.",
                            "Revezar o aparelho no meio do treino.",
                            "Usar roupa larga.",
                            "Treinar pesado demais.");
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
                        Tela.fala(nomeNPC + " aponta o dedo indicador com firmeza: \"IMPERDOÁVEL! Frango de perna fina que larga anilha no chão merece expulsão do templo do ferro!\"");
                    } else if (opcao3 == 2) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " abre um sorriso tranquilo: \"Revezar é justo, quem é humilde divide a máquina e ainda motiva o parceiro.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " torce o nariz irritado: \"Falou besteira! Não tem nada de errado em treinar no limite ou usar casaco largo pra esconder o pump!\"");
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
