package server;
import java.io.*;
import java.net.*;
import java.util.*;



public class Server {
    private int lastUser;
    
    ArrayList <Integer> connected = new ArrayList<Integer>();


    public Server() {
        lastUser = 0;
        //connected = 0;
    }
    
    private void createNewLobby(Socket clientA, Socket clientB) {
        try{
            System.out.println("Server | New lobby:");
            BufferedReader socketReaderA = new BufferedReader(new InputStreamReader(clientA.getInputStream()));
            BufferedWriter socketWriterA = new BufferedWriter(new OutputStreamWriter(clientA.getOutputStream()));
            
            BufferedReader socketReaderB = new BufferedReader(new InputStreamReader(clientA.getInputStream()));
            BufferedWriter socketWriterB = new BufferedWriter(new OutputStreamWriter(clientA.getOutputStream()));


            String inMsgA = null;
            String inMsgB = null;
            

            while (((inMsgA = socketReaderA.readLine()) != null) && ((inMsgB = socketReaderB.readLine()) != null)) {
                System.out.println("Received from  client A: " + inMsgA);
                System.out.println("Received from  client B: " + inMsgB);
                lastUser++;
                
                connected.add(lastUser);
                
                socketWriterA.write(lastUser + "\n");
                socketWriterA.flush();
            }
        clientA.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public void ServerStart()throws Exception{
        ServerSocket serverSocket = new ServerSocket(60000, 100, InetAddress.getByName("localhost"));
        System.out.println("Server started  at:  " + serverSocket);
        
        while (true) {
            System.out.println("Waiting for a  connection...");

            final Socket activeSocket = serverSocket.accept();

            System.out.println("Received a  connection from  " + activeSocket);
            
            final Socket activeSocket2 = serverSocket.accept();
            
            System.out.println("Received a  connection from  " + activeSocket2);
            
            
            if ((connected.size() % 2) == 0){
                Runnable runnable = () -> createNewLobby(activeSocket, activeSocket2);
                new Thread(runnable).start(); // start a new thread
            }
            
            
        }
    }
    
    
}