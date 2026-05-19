package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.time.LocalDateTime;

public class Estacionamento {
    private ArrayList<Vaga> vagas;
    private ArrayList<Ticket> ticketsAbertos;
    private boolean flag, flag2;
    private int horaTotal;

    Tarifario tarifario = new Tarifario();

    public Estacionamento(int totalVagas){
        this.vagas = new ArrayList<>(); // Inicializa o Array
        this.ticketsAbertos = new ArrayList<>();
        for (int i=1; i <= totalVagas; i++){
            Vaga novaVaga = new Vaga(i); // cria a vaga com base no numero
            this.vagas.add(novaVaga); // Adiciona no Array
            Ticket novoTicket = new Ticket(i);
            this.ticketsAbertos.add(novoTicket);

        }

    }

    public void registrarEntrada(Veiculo carro, int vagaNum){
        if((vagaNum <= 0) || (vagaNum >= 11)){
            System.out.println("Vaga não encontrada");


        }else{
            for(Vaga vaga : vagas){
                if((vaga.getOcupada()) && (vaga.getNumero() == vagaNum)){
                    System.out.println("Vaga já esta ocupada");

                }else{
                    if(vaga.getNumero() == vagaNum){
                        vaga.estacionar(carro);
                        System.out.println("Vaga registrada com sucesso!");

                        LocalDateTime agora = LocalDateTime.now();

                        for(Ticket ticket : ticketsAbertos){
                            if(ticket.getNumero() == vaga.getNumero()){
                                ticket.setHoraEntrada(agora);

                            }

                        }

                    }

                }

            }

        }

    }

    public boolean registrarSaida(String placa, int cont){
        flag2 = false;
        for(Vaga vaga : vagas){
            if(vaga.getNumero() >= cont){
                // nada

            }else{
                if(Objects.equals(vaga.getPlaca(), placa)){ //Intelijay que sugeriu isso aí -_-
                    vaga.liberar();
                    System.out.println("Carro da vaga " + vaga.getNumero() + " foi liberado");
                    flag2 = true;

                    LocalDateTime agora = LocalDateTime.now();

                    for(Ticket ticket : ticketsAbertos){
                        if(ticket.getNumero() >= cont){


                        }else{
                            if(ticket.getNumero() == vaga.getNumero()){
                                ticket.setHoraSaida(agora);
                                horaTotal = ticket.calcularTempoEmHoras();
                                ticket.registrarSaida();

                            }

                        }

                    }

                    System.out.println("O valor total a ser pago é " + tarifario.calcularValor(horaTotal));

                }

            }

        }
        return flag2;


    }

    public void exibirVagasLivres(){
        System.out.println(" --- VAGAS DISPONÍVEIS ---");

        System.out.println("Vagas disponiveis agora: ");

        for(Vaga vaga : vagas){
            if(!vaga.getOcupada()){
                if(vaga.getNumero() == 0){
                    //nada

                }else{
                    System.out.println("Vaga " + vaga.getNumero());

                }

            }else{
                System.out.println("Vaga ocupada, placa do carro: " + vaga.getPlaca());

            }

        }

    }

    public boolean verificarPlaca(String placa, int cont){
        flag = false;
        for(Vaga vaga : vagas){
            if(vaga.getNumero() >= cont){
                // nada

            }else{
                if(Objects.equals(vaga.getPlaca(), placa)){ //Intelijay que sugeriu isso aí -_-
                    flag = true;

                }

            }

        }
        return flag;

    }

}