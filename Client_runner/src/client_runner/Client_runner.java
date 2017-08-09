<<<<<<< HEAD
package client_runner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client_runner {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        System.out.println("Please informe the user name: ");
        BufferedReader getName = new BufferedReader(new InputStreamReader(System.in));
        String name = getName.readLine();
        ClientTCP.exec(name, 60000);
        // TODO code application logic here
    
    }
    
}
=======
package client_runner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client_runner {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        System.out.println("Please informe the user name: ");
        BufferedReader getName = new BufferedReader(new InputStreamReader(System.in));
        String name = getName.readLine();
        ClientTCP.exec(name, 60000);
        // TODO code application logic here
    
    }
    
}
>>>>>>> 6652df7ee9c4abb6259b2f0c55c838571dbe0d8a
