import java.util.Random;
import java.util.Scanner;

public class NPCPatricinha extends NPCs {

    public NPCPatricinha(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "PATRICINHA", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {
        // -------------------------------------------------------------
        // AÇÃO QUE DEFINE O QUE O PERSONAGEM -- PATRICINHA -- VAI FALAR QUANDO O JOGADOR O ENCONTRAR
        // -------------------------------------------------------------

        String[] acoes = {
            "está parada olhando para o celular, provavelmente vendo stories do Instagram.",
            "está arrumando a mesa do restaurante para tirar uma foto \"aesthetic\" para o Instagram.",
            "está conferindo suas unhas e reclama quando percebe que a manicure errou na cor do esmalte. Era para ser rosa bebê, não rosa choque.",
        };

        // -------------------------------------------------------------
        // NA PARTE DE CIMA, APENAS ADICIONE NOVAS AÇÕES A PATRICINHA (CASO PRECISE)
        // -------------------------------------------------------------

        Random random = new Random();

        String acao = acoes[random.nextInt(acoes.length)];
        String artigo = generoNPC.equals("FEMININO") ? "a" : "o";
        String pronome = generoNPC.equals("FEMININO") ? "Ela" : "Ele";
        Tela.encontro(localAtual, artigo, nomeNPC, estiloNPC, pronome + " " + acao);
    }

    @Override
    public int conversa(Scanner leitor, String estiloJogador, int bonus, Status status) {
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
                // PATRICINHA É BISSEXUAL
                // --------------------------------------------------------------

                // PERGUNTA 1
                if (estiloNPC.equals("PATRICINHA")) {
                    if (estiloJogador.equals(estiloNPC)) {
                        pontos += 14;
                    }

                    Tela.pergunta(nomeNPC, "Você também acha que R$ 300 é barato para uma bolsa?",
                            "Sim, mas acredito que uma bolsa boa custaria mais caro.",
                            "Não, acho que é um pouco caro para uma bolsa.",
                            "Acho que é um bom negócio, mas prefiro gastar em coisas mais importantes.",
                            "Não sei, nunca comprei uma bolsa antes.");
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
                        Tela.fala(nomeNPC + " fica muito feliz: \"FINALMENTE encontrei alguém que entende!\"");
                    } else if (opcao == 3) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " te olha de cima a baixo: \"Qualquer pessoa com classe saberia que R$ 300 não dá nem para comprar uma calcinha, quem dirá uma bolsa!\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " fica insatisfeita com sua resposta: \"Realmente, não parece ser do seu feitio ter conhecimento sobre bolsas.\"");
                    }

                    // PERGUNTA 2

                    Tela.pergunta(nomeNPC, "Bom, eu vim para o shopping comprar algumas roupas para uma festa de gala. Tem alguma loja para me indicar?",
                            "Acredito que a Renner tenha ótimas promoções para vestidos, sem contar na variedade de estilos.",
                            "Não costumo comprar roupas em shopping, prefiro comprar pela Shein ou Shopee.",
                            "Conheço uma que minha mãe compra, se chama Bottega Veneta. Acredito que você possa gostar.",
                            "Marcas costumam ser meu forte! Gosto de usar como referência a C&A.");
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
                        Tela.fala(nomeNPC + " se surpreende: \"A Bottega Veneta é uma marca muito boa, tinha me esquecido dela.\"");
                    } else if (opcao2 == 1) {
                        pontos += 10;
                        Tela.fala(nomeNPC + " te encara com dó: \"Renner? Bom, eu não costumo ir lá. Mas obrigada pela indicação.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " debocha de você: \"Acredito que você tenha muito conhecimento sobre roupas, não é mesmo?\"");
                    }

                    // PERGUNTA 3

                    Tela.pergunta(nomeNPC, "Estou atrasada e preciso terminar de fazer minhas compras. Quer me passar seu Instagram?",
                            "Claro! Meu instagram é @###########.",
                            "Não tenho instagram, mas posso te passar meu número de telefone.",
                            "Vish! Eu não sei o meu @ de cabeça e estou sem internet para entrar no instagram. Consegue rotear para eu?",
                            "Meu celular está quebrado e perdi acesso ao meu instagram.");
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
                        Tela.fala(nomeNPC + " fica feliz: \"Obrigada, vou continuar minhas compras. Até! (Ela não te seguiu no instagram, apenas anotou em seu bloco de notas)\"");
                    } else if (opcao3 == 3) {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " irritada, ela diz: \"Infelizmente não vou rotear minha internet para você, caso queira, use a internet disponibilizada por alguma loja local. Adeus.\"");
                    } else {
                        pontos -= 10;
                        Tela.fala(nomeNPC + " com um respiro profundo, te responde: \"Acredito que isso seja um \"Adeus\", até mais.\"");
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