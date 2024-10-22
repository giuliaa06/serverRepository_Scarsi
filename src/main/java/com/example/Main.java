package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Server avviato");
        ServerSocket ss = new ServerSocket(3000);

        do{
            Socket s = ss.accept();
            System.out.println("Giocatore collegato");

            //thread per connessione client
            MyThread t = new MyThread(s);
            t.start();

        }while(true);
    }
}