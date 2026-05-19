package org.example;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0, cont = 1;
        String entradaOpcao;

        Estacionamento estacionamento = new Estacionamento(10);

        do{
            System.out.println("\n--- MENU ESTACIONAMENTO ---");
            System.out.println("1. Registrar Entrada");
            System.out.println("2. Registrar Saída");
            System.out.println("3. Exibir Vagas Livres");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            entradaOpcao = scanner.nextLine().trim(); //.trim = limpa espaços em branco no começo ou no fim
            try{
                opcao = Integer.parseInt(entradaOpcao);

            }catch (NumberFormatException e){
                System.out.println("Erro : " + e.getMessage());
                System.out.println("Entrada Invalida, Digite numeros entre 1 e 4");
                System.out.println("Tente novamemte");
                continue;

            }

            switch(opcao){
                case 1:
                    int vaga;
                    String placa, modelo;
                    boolean flag = false;

                    if(cont > 10){
                        System.out.println("Todas as vagas estão preenchidas");

                    }else{
                        System.out.println("Digite o modelo do carro:");
                        modelo = scanner.nextLine();

                        System.out.println("Digite a placa do carro:");
                        placa = scanner.nextLine();

                        if(cont != 1){
                            while(!flag){
                                if(estacionamento.verificarPlaca(placa, cont)){
                                    System.out.println("Placa já usada, tente novamente");

                                    System.out.println("Digite a placa do carro:");
                                    placa = scanner.nextLine();

                                }else{
                                    flag = true;

                                }
                            }

                        }

                        switch(cont){
                            case 1:
                                Veiculo c1 = new Veiculo (placa, modelo);
                                System.out.println("Digite a vaga na qual voce deseja estacionar:");
                                vaga = scanner.nextInt();

                                estacionamento.registrarEntrada(c1, vaga);

                                break;

                            case 2:
                                Veiculo c2 = new Veiculo (placa, modelo);
                                System.out.println("Digite a vaga na qual voce deseja estacionar:");
                                vaga = scanner.nextInt();

                                estacionamento.registrarEntrada(c2, vaga);

                                break;

                            case 3:
                                Veiculo c3 = new Veiculo (placa, modelo);
                                System.out.println("Digite a vaga na qual voce deseja estacionar:");
                                vaga = scanner.nextInt();

                                estacionamento.registrarEntrada(c3, vaga);

                                break;

                            case 4:
                                Veiculo c4 = new Veiculo (placa, modelo);
                                System.out.println("Digite a vaga na qual voce deseja estacionar:");
                                vaga = scanner.nextInt();

                                estacionamento.registrarEntrada(c4, vaga);

                                break;

                            case 5:
                                Veiculo c5 = new Veiculo (placa, modelo);
                                System.out.println("Digite a vaga na qual voce deseja estacionar:");
                                vaga = scanner.nextInt();

                                estacionamento.registrarEntrada(c5, vaga);

                                break;

                            case 6:
                                Veiculo c6 = new Veiculo (placa, modelo);
                                System.out.println("Digite a vaga na qual voce deseja estacionar:");
                                vaga = scanner.nextInt();

                                estacionamento.registrarEntrada(c6, vaga);

                                break;

                            case 7:
                                Veiculo c7 = new Veiculo (placa, modelo);
                                System.out.println("Digite a vaga na qual voce deseja estacionar:");
                                vaga = scanner.nextInt();

                                estacionamento.registrarEntrada(c7, vaga);

                                break;

                            case 8:
                                Veiculo c8 = new Veiculo (placa, modelo);
                                System.out.println("Digite a vaga na qual voce deseja estacionar:");
                                vaga = scanner.nextInt();

                                estacionamento.registrarEntrada(c8, vaga);

                                break;

                            case 9:
                                Veiculo c9 = new Veiculo (placa, modelo);
                                System.out.println("Digite a vaga na qual voce deseja estacionar:");
                                vaga = scanner.nextInt();

                                estacionamento.registrarEntrada(c9, vaga);

                                break;

                            case 10:
                                Veiculo c10 = new Veiculo (placa, modelo);
                                System.out.println("Digite a vaga na qual voce deseja estacionar:");
                                vaga = scanner.nextInt();

                                estacionamento.registrarEntrada(c10, vaga);

                                break;

                            default:
                                System.out.println("Todas as vagas preenchidas");

                        }

                        scanner.nextLine();
                        cont++;

                    }

                    break;

                case 2:
                    String placaL;

                    System.out.println("Digite a placa do carro que voce quer liberar:");
                    placaL = scanner.nextLine();

                    if(estacionamento.registrarSaida(placaL, cont)){
                        cont--;

                    }else{
                        System.out.println("Não há um carro com esta placa no estacionamento");

                    }
                    break;

                case 3:
                    estacionamento.exibirVagasLivres();

                    break;

                case 4:
                    System.out.println("Saindo...");

                    break;

                default:
                    System.out.println("Comando nao identificado, tente novamente");

                    break;

            }
        }while (opcao != 4);
        System.out.println("O usuário saiu do sistema");

    }
}