import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NPCCoach extends NPCs {
    public NPCCoach(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "COACH", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÕES COACH
        // -------------------------------------------------------------

        String[] acoes = {
            "está gravando um story falando que \"o sucesso é uma escolha diária\" às 5 da manhã.",
            "está entregando cartão de visita pra todo mundo que passa, até pro cachorro.",
            "está com um livro chamado \"Pense Rico, Viva Rico\" debaixo do braço.",
            "está explicando pra um desconhecido como sair da zona de conforto em 7 passos.",
            "está tomando um café sem açúcar e falando que \"dormir é pra quem não tem metas\".",
        };

        // -------------------------------------------------------------
        // AÇÕES COACH
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

                if (estiloJogador.equals(estiloNPC)) {
                    pontos += 14;
                }

                // -------------------------------------------------------------
                // PERGUNTAS SORTEADAS: SÃO 6, MAS SÓ 3 APARECEM POR ENCONTRO
                // -------------------------------------------------------------

                List<Integer> ordem = Arrays.asList(1, 2, 3, 4, 5, 6);
                Collections.shuffle(ordem);

                for (int i = 0; i < 3; i++) {
                    int opcao;
                    switch (ordem.get(i)) {
                        case 1:
                            Tela.pergunta(nomeNPC, "Que horas você acorda?",
                                    "5 da manhã, banho gelado e meditação.",
                                    "Meio-dia, se ninguém me acordar.",
                                    "7 horas, igual gente normal.",
                                    "Eu não durmo, eu recarrego.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1 || opcao == 4) {
                                pontos += 25;
                                Tela.fala(nomeNPC + " aponta pra você: \"ISSO! Enquanto eles dormem, a gente constrói o império!\"");
                            } else if (opcao == 3) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " anota no caderninho: \"Bom começo. Agora é só antecipar duas horas e você vira outra pessoa.\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " leva a mão ao peito: \"Meio-dia?! Metade do dia já foi! Isso é sabotagem dos seus sonhos!\"");
                            }
                            break;

                        case 2:
                            Tela.pergunta(nomeNPC, "Qual é o seu maior objetivo para os próximos 5 anos?",
                                    "Ter meu próprio negócio e ser livre.",
                                    "Sei lá, viver um dia de cada vez.",
                                    "Ficar rico vendendo curso de como ficar rico.",
                                    "Terminar a série que comecei em 2019.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1) {
                                pontos += 25;
                                Tela.fala(nomeNPC + " aperta sua mão com força: \"Mentalidade de dono! Você nasceu pra liderar!\"");
                            } else if (opcao == 3) {
                                pontos += 15;
                                Tela.fala(nomeNPC + " olha pros lados e sussurra: \"Shhh... não espalha o segredo do mercado.\"");
                            } else if (opcao == 2) {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " suspira: \"Quem não sabe pra onde vai, chega em qualquer lugar...\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " fecha os olhos: \"2019... isso é muita procrastinação pra um ser humano só.\"");
                            }
                            break;

                        case 3:
                            Tela.pergunta(nomeNPC, "Você recebeu 1000 reais inesperados. O que faz?",
                                    "Invisto tudo e deixo o dinheiro trabalhar por mim.",
                                    "Gasto tudo em roupa e comida no mesmo dia.",
                                    "Compro um curso pra me desenvolver.",
                                    "Empresto pra um amigo que nunca devolve.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1 || opcao == 3) {
                                pontos += 20;
                                Tela.fala(nomeNPC + " bate palmas: \"Juros compostos e conhecimento! Você tá no caminho certo!\"");
                            } else if (opcao == 4) {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " balança a cabeça: \"Coração bom, mas o seu planejamento financeiro chorou agora.\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " quase deixa o café cair: \"Tudo no mesmo dia?! Isso é mentalidade de escassez!\"");
                            }
                            break;

                        case 4:
                            Tela.pergunta(nomeNPC, "Como você lida quando algo dá errado?",
                                    "Choro e desisto.",
                                    "Encaro como aprendizado e tento de novo.",
                                    "Coloco a culpa em todo mundo, menos em mim.",
                                    "Como um pote de sorvete e tento amanhã.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 2) {
                                pontos += 25;
                                Tela.fala(nomeNPC + " sobe no banco da praça: \"NÃO EXISTE FRACASSO, SÓ RESULTADO! Alguém anota essa frase!\"");
                            } else if (opcao == 4) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " sorri: \"Tudo bem, até o sorvete faz parte do processo. O importante é tentar amanhã.\"");
                            } else {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " te entrega um cartão: \"Acho que você precisa de uma mentoria. A primeira sessão é só 997 reais.\"");
                            }
                            break;

                        case 5:
                            Tela.pergunta(nomeNPC, "Qual dessas frases você colocaria na parede do quarto?",
                                    "\"Foco, força e fé.\"",
                                    "\"Hoje não.\"",
                                    "\"O sucesso é a soma de pequenos esforços repetidos todos os dias.\"",
                                    "\"Wi-Fi grátis.\"");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1 || opcao == 3) {
                                pontos += 20;
                                Tela.fala(nomeNPC + " se emociona: \"Essa frase mudou a minha vida. E agora vai mudar a sua!\"");
                            } else if (opcao == 4) {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " ri sem graça: \"Útil, mas não é exatamente uma inspiração...\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " parece ter levado um soco: \"'Hoje não'?! Hoje SIM! Todo dia é dia!\"");
                            }
                            break;

                        case 6:
                            Tela.pergunta(nomeNPC, "O que você faz no seu tempo livre?",
                                    "Leio livros de desenvolvimento pessoal.",
                                    "Vejo vídeo de gatinho por 4 horas seguidas.",
                                    "Treino na academia e organizo minha semana.",
                                    "Durmo, eu mereço.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1 || opcao == 3) {
                                pontos += 20;
                                Tela.fala(nomeNPC + " sorri com satisfação: \"Tempo livre bem usado é investimento! A gente combina.\"");
                            } else if (opcao == 2) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " admite baixinho: \"Tá, eu também vejo vídeo de gatinho... mas só 15 minutos, cronometrado.\"");
                            } else {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " anota no caderno: \"Merece? Mas e as metas? As metas não batem sozinhas!\"");
                            }
                            break;
                    }
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
                    Tela.fala("Você usou o Trufilho! Esta é sua última tentativa do dia.");
                }
                break;

            case 2:
                Tela.fala("Você decidiu deixar passar e seguir em frente.");
                break;

            case 9:
                Tela.fala("Você abandonou o dia...");
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        return escolha;
    }

    // LÊ UMA RESPOSTA DE 1 A 4 DAS PERGUNTAS
    private int lerOpcao(Scanner leitor) {
        while (true) {
            try {
                int opcao = Integer.parseInt(leitor.nextLine());
                if (opcao >= 1 && opcao <= 4) {
                    return opcao;
                }
            } catch (NumberFormatException erro) {
            }

            System.out.println("Digite um número válido!");
            System.out.print("Selecione uma opção: ");
        }
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
