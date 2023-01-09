package Calculator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

    public static void main(String[] args) throws IOException, EOFException{
        // create a server socket and listen to a specific port

        Boolean exit = true;

        System.out.println("starting server on port: 6942");
        ServerSocket server = new ServerSocket(6942);

        //wait for a connection
        try{

            while(exit){
            System.out.println("Waiting for incoming connections");
            Socket conn = server.accept();
                System.out.println("Got a connection");

                Math operation = new Math();             

                    // do something then close the connection
                    // get the inputstream read the data from the client
                    InputStream is =  conn.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(is);

                    String input = ois.readUTF();
                    System.out.printf(">>> this is the eqn %s\n", input);
                    
                    //apply method to string

                    // if(input.contentEquals("exit")){
                    //     conn.close();
                    //     exit = false;
                    //     continue;
                    // }

                    input = operation.calculate(input);

                    OutputStream os = conn.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(os);
                    
                    oos.writeUTF(input);
                    oos.flush();
                    conn.close();
                
        }


    }catch(IOException i){
        System.err.println();
    }
    
}
}
