import java.util.Random;
import java.util.Scanner;

public class NPCPlayboy extends NPCs {

    public NPCPlayboy(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "PLAYBOY", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {
        // -------------------------------------------------------------
        // AÇÃO QUE DEFINE O QUE O PERSONAGEM -- PLAYBOY -- VAI FALAR QUANDO O JOGADOR O ENCONTRAR
        // -------------------------------------------------------------

        String[] acoes = {
            "está andando e mexendo na chave do carro, fazendo questão de deixar o chaveiro aparecendo.",
            "está em ligação com seu amigo, falando que investir em BitCoin é o futuro.",
            "está tirando uma foto com seu novo rolex conquistado com o próprio esforço. (apenas pediu para o pai comprar).",
        };

        // -------------------------------------------------------------
        // NA PARTE DE CIMA, APENAS ADICIONE NOVAS AÇÕES A PLAYBOY (CASO PRECISE)
        // -------------------------------------------------------------

        Random random = new Random();

        String acao = acoes[random.nextInt(acoes.length)];
        String artigo = generoNPC.equals("FEMININO") ? "a" : "o";
        String pronome = generoNPC.equals("FEMININO") ? "Ela" : "Ele";
        Tela.encontro(localAtual, artigo, nomeNPC, estiloNPC, pronome + " " + acao);
    }

    @Override
    public int conversa(Scanner leitor, String estiloJogador, int bonus, Status status) {
        // Implementação específica para a conversa com a NPC Playboy
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
                // PLAYBOY É HETERO
                // --------------------------------------------------------------

                if ("MASCULINO".equals(generoJogador) && "MASCULINO".equals(generoNPC)) {
                    Tela.fala(nomeNPC + " cruza os braços e te encara no fundo dos seus olhos...");
                    Tela.fala("\"Mano, você está me estranhando? Eu não gosto de homem não! Lá Ele.\"");
                    status.perderVida();
                    Tela.rejeitado();
                    return 1;
                }
                if ("FEMININO".equals(generoJogador) && "FEMININO".equals(generoNPC)) {
                    Tela.fala(nomeNPC + " ajeita os óculos e te olha com cara de desdém");
                    Tela.fala("\"Segundo meus cálculos, eu só me relaciono com garotos. Rejeição com 100% de probabilidade.\"");
                    status.perderVida();
                    Tela.rejeitado();
                    return 1;
                }

                // PERGUNTA 1
                if (estiloNPC.equals("PLAYBOY")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "E aí, gatinha, beleza? Nunca te vi andando por aqui. Tá perdida?",
                            "Sou nova por aqui, vim andar para conhecer melhor a cidade.",
                            "Estou bem, não estou perdida. Vim encontrar uma amiga.",
                            "E aí, parça, beleza? Mano, não to perdida não, to de boa.",
                            "Estou perdida, preciso de ajuda para encontrar uma sorveteria.");
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
                        Tela.fala(nomeNPC + " fica feliz com sua resposta, ele acredita que possa te mostrar a cidade de carro.");
                    } else if (opcao == 2) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " fica contente em te encontrar perdida: \"Essa sua amiga é gatinha igual a você? (Faz uma contrapergunta e não recebe resposta)\"");
                    } else if (opcao == 4) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " fica contente em te encontrar perdida: \"Se você quiser eu posso te levar para sair de carro.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " se assusta com seu linguajar e cogita que você curta mulheres, assim como ele.");
                    }

                    // PERGUNTA 2

                    Tela.pergunta(nomeNPC, "Você vai fazer algo hoje à noite?",
                            "Hoje à noite eu vou me encontrar com minhas amigas, numa festa universitária.",
                            "Parça, hoje eu to livre. Você vai fazer o que?",
                            "Vou sair com meus amigos, vamos fazer uma social em minha casa.",
                            "Vou estar livre sim! Pretende fazer algo?");
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

                    if (opcao2 == 1) {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " fica mudo pelo restante da conversa, ele não gosta de pessoas que vivem o \"mundão\" assim como ele.");
                    } else if (opcao2 == 3) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " se convida para a social: \"Vai ter espaço para mais um homem nesta social?\"");
                    } else if (opcao2 == 4) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " fica emocionado: \"Me passa seu telefone, te busco hoje às 20:00 na sua casa. (Ele não te busca em sua casa, mas pega seu telefone)\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " se assusta com seu linguajar e cogita que você curta mulheres, assim como ele.");
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