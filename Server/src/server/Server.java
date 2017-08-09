<<<<<<< HEAD
package server;
import java.io.*;
import java.net.*;
import java.util.*;



public class Server {
    private Timer timeOut;
    private boolean kick;
     
    public Server() {
        lastUser = 0;
        kick = false;
    }
    
    
    private int lastUser;
    
    ArrayList <Integer> connected = new ArrayList<Integer>();

    private void kickPlayer(Socket client){
        
    }
    
    private void createNewLobby(Socket socketUserA, Socket socketUserB) {
        try{
            System.out.println("Server | New lobby:");
            BufferedReader socketReaderA = new BufferedReader(new InputStreamReader(socketUserA.getInputStream()));
            BufferedWriter socketWriterA = new BufferedWriter(new OutputStreamWriter(socketUserA.getOutputStream()));
            
            BufferedReader socketReaderB = new BufferedReader(new InputStreamReader(socketUserB.getInputStream()));
            BufferedWriter socketWriterB = new BufferedWriter(new OutputStreamWriter(socketUserB.getOutputStream()));

            //tell both players it is their time to play
            //sempre que o client receber 0, deve fazer uma nova jogada
            socketWriterA.write(0 + "\n");
            socketWriterA.flush();
            
            socketWriterB.write(0 + "\n");
            socketWriterB.flush();
            
            //WAITS FOR A REPLAY FROM THE CLIENT
            /*
            while (((inMsgA = socketReaderA.readLine()) != null) && ((inMsgB = socketReaderB.readLine()) != null)) {
                System.out.println("Received from  client A: " + inMsgA);
                System.out.println("Received from  client B: " + inMsgB);
                lastUser++;
                
                connected.add(lastUser);
                
                socketWriterA.write(lastUser + "\n");
                socketWriterA.flush();
            }
            */
            
            
            //replay the winner ID
            
            //close sockets
            socketUserA.close();
            socketUserB.close();
           
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public void ServerStart()throws Exception{
        ServerSocket serverSocket = new ServerSocket(60000, 100, InetAddress.getByName("localhost"));
        System.out.println("Server started  at:  " + serverSocket);
        
        while (true) {
            System.out.println("Waiting for a  connection...");

            final Socket socketUserA = serverSocket.accept();
            System.out.println("Received a  connection from  " + socketUserA);
            
            //ANSWER WITH THE PLAYER ID;
            BufferedWriter answUserA = new BufferedWriter(new OutputStreamWriter(socketUserA.getOutputStream()));
            lastUser++;
            answUserA.write(lastUser+"\n");
            answUserA.flush();
            
            ///////////////////////////////////////////////////////////////////////////////////////////
            //CREATE LOBBY WITH TIMEOUT
            
            
            
            //if the time runs out kick the first player
            if (kick == true){
                System.out.println("KICKA");
            }
            
            ///////////////////////////////////////////////////////////////////////////////////////////
            
            //WAITS FOR THE OTHER USER
            final Socket socketUserB = serverSocket.accept();
            System.out.println("Received a  connection from  " + socketUserB);
            
            //ANSWER WITH THE PLAYER ID;
            BufferedWriter answUserB = new BufferedWriter(new OutputStreamWriter(socketUserB.getOutputStream()));
            lastUser++;

            answUserB.write(lastUser + "\n");
            answUserB.flush();
            
            //START GAME IN A NEW THREAD
            if ((connected.size() % 2) == 0){
                Runnable runnable = () -> createNewLobby(socketUserA, socketUserB);
                new Thread(runnable).start(); // start a new thread
            }
            
            
        }
    }
    
    
=======
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
    
    
>>>>>>> 6652df7ee9c4abb6259b2f0c55c838571dbe0d8a
}