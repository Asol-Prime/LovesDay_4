import java.util.Random;
import java.util.Scanner;

public class NPCTikToker extends NPCs {

    public NPCTikToker(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "TIKTOKER", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÕES TIKTOKER
        // -------------------------------------------------------------

        String[] acoes = {
            "está montando um mini ring light no celular enquanto repete: \"Gente, cês não tão preparados pro storytime que eu vou soltar agora!\"",
            "faz uma dancinha de 15 segundos no meio da calçada, encarando a lente do celular com caras e bocas frenéticas.",
            "está conferindo freneticamente o analytics do último post e comemora: \"O algoritmo finalmente entregou meu conteúdo pra For You!\"",
            "aponta a câmera na sua direção do nada e fala: \"Olha com quem eu acabei de trombar, galera! Comentem aqui embaixo se vocês conhecem!\"",
            "está fingindo que chora pra gravar um POV dramático com áudio desacelerado em slow motion.",

        };

        // -------------------------------------------------------------
        // AÇÕES TIKTOKER
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
                // TIKTOKER É BISSEXUAL
                // --------------------------------------------------------------

                // PERGUNTA 1
                if (estiloNPC.equals("TIKTOKER")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.fala(nomeNPC + " coloca o celular no tripé, arruma o cabelo...");
                    Tela.pergunta(nomeNPC, "Se a gente fosse passar o fim de semana inteiro juntos na praia, como seria o nosso plano de conteúdo ideal?",
                            "Gravar três vlogs de rotina por dia e fazer lives no pôr do sol.",
                            "Deixar o celular desligado na mochila, curtir o mar em paz e viver a vida real sem ninguém saber.",
                            "Registrar só as transições de looks e as comidas mais chiques.",
                            "Contratar um videomaker profissional pra gravar nossos takes cinematográficos.");
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
                        Tela.fala(nomeNPC + " dá um pulinho: \"Isso! O engajamento no fim de semana é altíssimo, o público ama acompanhar viagem em tempo real!\"");
                    } else if (opcao == 2) {
                        pontos -= 30; // PENALIDADE MÁXIMA PARA QUEM DETESTA REDE SOCIAL
                        Tela.fala(nomeNPC + " olha para você chocada, como se tivesse visto um fantasma: \"Viver a vida real em paz?! Sem postar nada?! Mas se um evento não foi postado com uma música de fundo aesthetic, ele sequer existiu?! Que horror, você é um homem das cavernas digital!\"");
                    } else {
                        pontos += 15;
                        Tela.fala(nomeNPC + " acena com a cabeça: \"Boa! Focar na estética do lugar sem precisar trabalhar tanto... Uma estratégia de conteúdo bem limpa.\"");
                    }

                    // PERGUNTA 2

                    Tela.pergunta(nomeNPC, "Qual é o seu aplicativo favorito para passar o tempo livre no dia a dia?",
                            "O tiktok ou instagram reels vendo vídeos curtos sem parar.",
                            "Nenhum, prefiro deixar o celular longe e ler um livro físico ou ir caminhar na natureza.",
                            "Aplicativos de edição de vídeo complexos para deixar meus posts perfeitos.",
                            "Apps de entretenimento e jogos casuais rapidinhos.");
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
                        pontos += 25;
                        Tela.fala(nomeNPC + " sorri: \"É viciante demais, né? Quando vejo, já se passaram três horas na For You. Melhor passatempo!\"");
                    } else if (opcao2 == 2) {
                        pontos -= 35; // Penalidade anti-rede social
                        Tela.fala(nomeNPC + " te olha indignado: \"Ler livro físico? Caminhar no mato sem celular?! Meu Deus, você é uma alma de oitenta anos presa no corpo de um jovem.\"");
                    } else {
                        pontos += 15;
                        Tela.fala(nomeNPC + " acena: \"Muito bom! Dedicar o tempo livre à produção ou foco estético mostra que você tem compromisso.\"");
                    }

                    //PERGUNTA 3

                    Tela.pergunta(nomeNPC, "Qual a sua opinião sobre as pessoas que ficam famosas na internet fazendo dancinhas ou expondo a vida?",
                            "Acho super legal, eles são trabalhadores do entretenimento digital e merecem o sucesso.",
                            "Acho uma futilidade completa e uma perda de tempo da sociedade que consome esse tipo de coisa.",
                            "Sou neutro, desde que o conteúdo seja bem editado e tenha qualidade visual.",
                            "Tenho até vontade de fazer igual para ver se consigo ficar famoso também.");
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

                    if (opcao3== 1 || opcao3== 4) {
                        pontos += 25;
                        Tela.fala(nomeNPC + " sorri orgulhoso: \"Finalmente alguém que entende e valoriza o nosso corre! É arte, é dedicação, é engajamento!\"");
                    } else if (opcao3 == 2) {
                        pontos -= 40;
                        Tela.fala(nomeNPC + " te olha horrorizado, com a boca aberta: \"Futilidade?! Perda de tempo?! Você acabou de ofender toda a minha existência e a minha profissão de creator! Que cara preconceituoso com a internet!\"");
                    } else {
                        pontos += 10;
                        Tela.fala(nomeNPC + " dá de ombros: \"Justo. A qualidade técnica e a edição contam muito na retenção do público mesmo.\"");
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
