package client_runner;

import java.io.*;
import java.net.*;

public class ClientTCP {
    
    
    public static void exec(String myName, int ipPort) throws Exception {
        Socket socket = new Socket("localhost", ipPort);

        System.out.println("Started client  socket at " + socket.getLocalSocketAddress());

        BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));



        String outMsg = null;


        //while ((outMsg = consoleReader.readLine()) != null) {

          // Add a new line to the message to the server,
          // because the server reads one line at a time.
          socketWriter.write(myName+'\n');
          socketWriter.flush();

          // Read and display the message from the server
          String inMsg = socketReader.readLine();
          System.out.println(inMsg);
          System.out.println(); // Print a blank line

        //}
        socket.close();
    } 

}

