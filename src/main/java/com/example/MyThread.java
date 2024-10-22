package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class MyThread extends Thread {
    private Socket clientSocket;
    private int numeroDaIndovinare;
    private int tentativi;
    private String nomeGiocatore;

    public MyThread(Socket s) {
        this.clientSocket = s;
        this.tentativi = 0;
    }

    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            System.out.println("Inserisci il tuo nickname: ");
            nomeGiocatore = in.readLine();
        
        do{
            Random random = new Random();
            int numero = random.nextInt(100);
            tentativi = 0;
            System.out.println("Partita iniziata. Indovina il numero da 0 a 100");
            String stringaRicevuta = in.readLine();
        
            
            int tentativo = Integer.parseInt(stringaRicevuta);
            if (tentativo < 0 || tentativo >= 100 ) {
                System.out.println("ERROR. Numero fuori range");
            }

            if(tentativo > numeroDaIndovinare){
                System.out.println(">");
            }
            else  if(tentativo < numeroDaIndovinare){
                System.out.println("<");
            }
            else{
                System.out.println("=");
                System.out.println("Hai indovinato il numero in "+ tentativi + " tentativi");

            }
        
        }while ((true));
    
    
    
    
    }catch (IOException e){
        e.printStackTrace();
    }
    
    }

}
