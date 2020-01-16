package loginscene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.text.PlainDocument;
import scene.ChangeView;
import start.StablishConnection;

public class LoginController implements Initializable{

    ChangeView cv = new ChangeView();
    Listner listner = new Listner();
    static StablishConnection con = new StablishConnection();
    
    //connection variables
    Socket mySocket;
    BufferedReader d ;

    PrintStream ps;
    ActionEvent eventOnline;
    //flag for one time connection
    private static boolean flag ;
    
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label checkLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(!flag){
            con.connect();
            flag = true ;
        }
        mySocket = con.getMySocket();
        d = con.getD();
        ps = con.getPs();
        if(mySocket!=null)
        {
                    listner.start();
        }
    }

    public static StablishConnection getCon() {
        return con;
    }
    
    

    //signup Buton //
    @FXML
    public void moveToRegisterationScene(ActionEvent event) throws IOException {
        cv.changeScene("/signup/registration.fxml", event);
    }

    //Login Button//
    @FXML
    public void moveToOnlineGameScene(ActionEvent event) throws IOException { //edit the method & scenes name and path// 
        eventOnline = event;
     //send login data to server
        String name = usernameField.getText();
        String password = passwordField.getText();
        String msg = "login:"+name+":"+password;
        ps.println(msg);   
    }

    //Back To main menu//
    @FXML
    public void moveToMainScene(ActionEvent event) throws IOException {  
        cv.changeScene("/start/start.fxml", event);
    }
    
    class Listner extends Thread{
        public void run(){
            while(true){
                try {
                    // get output of authenticaion from server 
                    String msg = d.readLine();
                    String[] str = msg.split("\\:");
                    System.out.println(str[0]);
                    //System.out.println(str[1]);
                    if(str[0].equals("loggedin")){
                        if(str[1].equals("yes")){
                            Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    cv.changeScene("/onlinePlayers/onlineXML.fxml", eventOnline);
                                    stop();
                                } catch (IOException ex) {
                                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            });
                            
                        }
                        else{
                            Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                               checkLabel.setText("*Wrong username or password");
                                
                            }
                            });
                            //usernameField.setPromptText("username or password is not right");
                            System.out.println("username or password is not right");
                        } 
                    }
  
                } catch (IOException ex) {
                    try {
                        System.out.println("Server is down");
                        d.close();
                        ps.close();
                        mySocket.close();
                        stop();
                    } catch (IOException ex1) {
                        ex1.printStackTrace();
                    }
                }
            }
            
        }
    }
    
}
