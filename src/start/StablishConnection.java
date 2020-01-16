/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author mahmo
 */
public class StablishConnection {
    Socket mySocket;
    BufferedReader d ;
    PrintStream ps;
    public void connect(){
        try {
                //Player intialization
                mySocket = new Socket("127.0.0.1",5005);
                if(mySocket!=null){
                    d = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
                    ps = new PrintStream(mySocket.getOutputStream());
                    System.out.println("player is connected \n");
                }
                } catch (IOException ex) {
                    System.out.println("Unable to connect to server plz wait");
            } 

    }

    public Socket getMySocket() {
        return mySocket;
    }

    public BufferedReader getD() {
        return d;
    }


    public PrintStream getPs() {
        return ps;
    }
    
}
