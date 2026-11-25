import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NPCFunkeiro extends NPCs {
    public NPCFunkeiro(String nomeNPC, String generoNPC, String acaoNPC) {
        super(nomeNPC, "FUNKEIRO", generoNPC, acaoNPC, 0);
    }

    @Override
    public void apresentar(String localAtual) {

        // -------------------------------------------------------------
        // AÇÕES FUNKEIRO
        // -------------------------------------------------------------

        String[] acoes = {
            "está fazendo o passinho do romano com uma caixinha de som no ombro.",
            "está com uma corrente de prata tão grossa que dá pra ver o brilho de longe.",
            "está gravando um vídeo pro status mandando um \"tá tranquilo, tá favorável\".",
            "está ajeitando o boné de aba reta e a meia até a canela com o chinelo slide.",
            "está combinando no grupo quem vai levar o paredão pro baile de sexta.",
        };

        // -------------------------------------------------------------
        // AÇÕES FUNKEIRO
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
                            Tela.pergunta(nomeNPC, "Começou a tocar um funk no paredão. O que você faz?",
                                    "Desço até o chão sem medo de ser feliz.",
                                    "Peço pra trocar por música clássica.",
                                    "Fico no canto balançando a cabeça de leve.",
                                    "Vou embora reclamando do barulho.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1) {
                                pontos += 25;
                                Tela.fala(nomeNPC + " grita de empolgação: \"AÍ SIM! Até o chão e ainda volta com estilo, isso é talento!\"");
                            } else if (opcao == 3) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " dá risada: \"Na timidez mas tá no clima, já é um começo. Na próxima eu te ensino o passinho.\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " abaixa o som na hora: \"Mano... você acabou de estragar o baile inteiro.\"");
                            }
                            break;

                        case 2:
                            Tela.pergunta(nomeNPC, "Qual o look perfeito pra ir no baile?",
                                    "Terno, gravata e sapato social.",
                                    "Juliet, corrente de prata, boné e camisa de time.",
                                    "Pijama e pantufa, vou no conforto.",
                                    "Roupa de academia, já vou suado mesmo.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 2) {
                                pontos += 25;
                                Tela.fala(nomeNPC + " aponta pra você: \"Kit completo! Chegou chegando, vai ser o destaque do baile.\"");
                            } else if (opcao == 4) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " ri: \"Pelo menos vai aguentar dançar a noite toda, né?\"");
                            } else {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " cruza os braços: \"Assim o segurança nem deixa você entrar, hein.\"");
                            }
                            break;

                        case 3:
                            Tela.pergunta(nomeNPC, "Qual dessas frases é a sua cara?",
                                    "\"Tá tranquilo, tá favorável.\"",
                                    "\"Prefiro ficar em casa lendo sobre impostos.\"",
                                    "\"Hoje eu tô bolado, ninguém fala comigo.\"",
                                    "\"Bota pra tocar que eu chego já já.\"");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1 || opcao == 4) {
                                pontos += 20;
                                Tela.fala(nomeNPC + " solta um sorrisão: \"É isso! Vibe boa e sem estresse, do jeito que eu gosto.\"");
                            } else if (opcao == 3) {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " levanta as mãos: \"Calma, calma... eu só vim conversar, tá ligado?\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " boceja alto: \"Impostos? Já dormi só de ouvir isso.\"");
                            }
                            break;

                        case 4:
                            Tela.pergunta(nomeNPC, "Qual o melhor jeito de passar o domingo?",
                                    "Churrasco na laje com o som ligado.",
                                    "Dormindo até meio-dia.",
                                    "Fazendo planilha de gastos da semana.",
                                    "Jogando bola na quadra do bairro.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1) {
                                pontos += 25;
                                Tela.fala(nomeNPC + " já vai pegando o celular: \"Fechou! Domingo que vem tem churrasco lá na laje, cola lá!\"");
                            } else if (opcao == 4 || opcao == 2) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " concorda: \"Também é bom demais, domingo foi feito pra isso.\"");
                            } else {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " faz careta: \"Planilha no domingo? Você trabalha até no descanso?\"");
                            }
                            break;

                        case 5:
                            Tela.pergunta(nomeNPC, "Alguém pisou no seu tênis novo no meio do baile. E aí?",
                                    "Começo uma briga na hora.",
                                    "Choro no banheiro a noite toda.",
                                    "Dou um sorriso e falo \"relaxa, faz parte\".",
                                    "Peço pra pessoa pagar um tênis novo.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 3) {
                                pontos += 25;
                                Tela.fala(nomeNPC + " bate no seu ombro: \"Tranquilidade é tudo! No baile a gente veio pra curtir, não pra brigar.\"");
                            } else if (opcao == 4) {
                                pontos += 10;
                                Tela.fala(nomeNPC + " ri: \"Justo, tênis branco é sagrado. Mas vai na calma.\"");
                            } else if (opcao == 2) {
                                pontos -= 10;
                                Tela.fala(nomeNPC + " fica sem graça: \"Poxa... é só um tênis, a noite ainda tá começando.\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " se afasta: \"Opa, confusão eu não quero não. Fui!\"");
                            }
                            break;

                        case 6:
                            Tela.pergunta(nomeNPC, "Se você fosse MC, qual seria o tema da sua primeira música?",
                                    "Sobre a quebrada e a correria do dia a dia.",
                                    "Sobre a vez que perdi o ônibus.",
                                    "Eu nunca seria MC, funk não é música.",
                                    "Sobre um amor que conheci no baile.");
                            System.out.print("\nSelecione uma opção: ");
                            opcao = lerOpcao(leitor);

                            if (opcao == 1 || opcao == 4) {
                                pontos += 20;
                                Tela.fala(nomeNPC + " já começa a fazer a batida com a boca: \"Isso dá hit! Já tô até vendo o clipe.\"");
                            } else if (opcao == 2) {
                                pontos += 15;
                                Tela.fala(nomeNPC + " cai na risada: \"Pode rir, mas essa letra ia viralizar demais.\"");
                            } else {
                                pontos -= 25;
                                Tela.fala(nomeNPC + " desliga a caixinha de som: \"Funk é cultura, parceiro. Respeita.\"");
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
