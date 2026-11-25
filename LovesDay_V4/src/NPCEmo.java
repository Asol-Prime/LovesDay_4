import java.util.Random;
import java.util.Scanner;

public class NPCEmo extends NPCs {

    public NPCEmo(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "EMO", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÃO QUE DEFINE O QUE O PERSONAGEM -- EMO -- VAI FALAR QUANDO O JOGADOR O ENCONTRAR
        // -------------------------------------------------------------

        String[] acoes = {
            "está soprando a franja preta que cobre 90% do rosto enquanto suspira profundamente com o peso do mundo.",
            "está retocando o lápis de olho preto e ajeitando o cinto de rebites prateados.",
            "está encarando o chão com fones de ouvido no volume máximo, ouvindo Fresno e My Chemical Romance.",
            "tira uma foto no espelho de cima para baixo fazendo biquinho triste e o sinal de \"V\" com os dedos.",
            "está escrevendo um poema gótico melancólico no bloco de notas sobre um término que aconteceu há anos.",
        };

        // -------------------------------------------------------------
        // NA PARTE DE CIMA, APENAS ADICIONE NOVAS AÇÕES AO EMO (CASO PRECISE)
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
                if (estiloNPC.equals("EMO")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "Qual hino do rock define o sofrimento da sua alma?",
                            "HIGHWAY TO HELL.",
                            "Tá rocheda.",
                            "Lonely day.",
                            "Puxa o lança.");
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

                    if (opcao == 1) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " limpa uma lágrima escura do rosto: \"Você realmente compreende a marcha fúnebre da nossa geração...\"");
                    } else if (opcao == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " suspira nostálgico: \"Um clássico nacional do choro no quarto escuro... respeito.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " cobre o rosto com a franja em agonia: \"Música alegre demais... isso tá ferindo a minha alma.\"");
                    }

                    // PERGUNTA 2
                    
                    Tela.fala(nomeNPC + " suspira, ajeitando o cinto de rebites (taxinhas)...");
                    Tela.pergunta(nomeNPC, "O que você faz quando percebe que ninguém ao seu redor te entende?",
                            "Vou para uma festa conversar com pessoas e tentar me encaixar.",
                            "Tranco a porta do quarto, coloco paramore ou sunny day real estate no máximo e escrevo poemas tristes.",
                            "Ligo para os meus pais para pedir conselhos e desabafar.",
                            "Faço uma postagem super alegre no instagram para disfarçar.");
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
                        Tela.fala(nomeNPC + " aperta o peito com a mão: \"Porta trancada, Paramore no máximo e um poema triste... você é igualzinho a mim.\"");
                    } else if (opcao2 == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " dá de ombros: \"Pelo menos você desabafa com alguém... mesmo que ninguém entenda de verdade.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " cobre o rosto com a franja em agonia: \"Fingir que tá tudo bem e se enturmar? Isso é muito... feliz pra mim.\"");
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