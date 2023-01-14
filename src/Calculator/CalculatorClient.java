package Calculator;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {

        // connect to the server listening on the port 6942
        // 127.0.0.1 or localhost, means my local computer

        Boolean exit = true;

        System.out.println("Connected to server on localhost: 6942");
        


        while(exit){

            Socket conn = new Socket("127.0.0.1",6942);

            Console cons = System.console();
            String line = cons.readLine("Type an equation:");

            if(line.contentEquals("exit")){
                exit = false;
                conn.close();
                continue;
            }  
                
            //Do something
            OutputStream os = conn.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeUTF(line);
            oos.flush();

            InputStream is =  conn.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String result = ois.readUTF();

            System.out.printf(">>> Answer: %s\n", result);

        }
    }
    
}
