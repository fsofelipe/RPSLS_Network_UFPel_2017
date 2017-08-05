/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Felipe
 */
public class Server {
    private static void handleClientRequest(Socket socket) {
        try{
            System.out.println("THREAD DO SERVER:");
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            


            String inMsg = null;
            System.out.println("\tEsperando mensagem do client:");
            

            while ((inMsg = socketReader.readLine()) != null) {
                System.out.println("Received from  client: " + inMsg);

                String outMsg = "Recebi: " + inMsg;
                socketWriter.write(outMsg);
                socketWriter.write("\n");
                socketWriter.flush();
            }
        socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    private static void ServerTCP()throws Exception{
        ServerSocket serverSocket = new ServerSocket(60000, 100, InetAddress.getByName("localhost"));
        System.out.println("Server started  at:  " + serverSocket);

        while (true) {
            System.out.println("Waiting for a  connection...");

            final Socket activeSocket = serverSocket.accept();

            System.out.println("Received a  connection from  " + activeSocket);
            Runnable runnable = () -> handleClientRequest(activeSocket);
            new Thread(runnable).start(); // start a new thread
        }
    }
    
    public static void main(String[] args)  {
        ArrayList<Integer> jogadores = new ArrayList <>();
        
        jogadores.add(1);
        jogadores.add(2);
        jogadores.add(3);
        jogadores.add(4);
        jogadores.add(5);
        
        Game teste = new Game(jogadores, 5);

        teste.makePlay(1, HandStatus.ROCK);
        teste.makePlay(3, HandStatus.ROCK);
        teste.makePlay(5, HandStatus.ROCK);
        teste.makePlay(7, HandStatus.ROCK);
        teste.makePlay(9, HandStatus.SPOCK);


        teste.checkHands();
        

    }
}