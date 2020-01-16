/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import loginscene.LoginController;
import scene.ChangeView;
import start.StablishConnection;

public class RegistrationController implements Initializable {

    ChangeView cv = new ChangeView();
    Listner listner = new Listner();
    StablishConnection con;
    
     //connection variables
    Socket mySocket;
    BufferedReader d ;
    PrintStream ps;
    ActionEvent eventOnline;
    
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField repasswordField;
    @FXML
    private AnchorPane LoginAnchor;
    @FXML
    private Button signupButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label checkLabel;
    @FXML
    private Button btnPass;
    @FXML
    private Button btnUser;
    @FXML
    private Label checkPasswordLabel;
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = LoginController.getCon();
        mySocket = con.getMySocket();
        d = con.getD();
        ps = con.getPs();
        if(mySocket!=null)
        {
                listner.start();
                System.out.println("Registration Listner i running");
        }
    }


    //check repassword== password& name != null//
    @FXML
    public void checkNameAndPassword(ActionEvent event) throws IOException {
         event = eventOnline;
     //send login data to server
        if (userNameField.getText() != null && !userNameField.getText().isEmpty()) {
            if (repasswordField.getText().compareTo(passwordField.getText() ) == 0 && !passwordField.getText().isEmpty()) {
                {
                    
                    String name = userNameField.getText();
                    String password =  passwordField.getText();
                    String data = "signup:"+name+":"+password;
                    ps.println(data);
                }                
                 
            } else {
                checkPasswordLabel.setText("*Please re-type the password ");
                //System.out.println("Please re-type the password");

            }
        } else {
            checkPasswordLabel.setText("*Please Enter your username ");

        }

    }

    //cancel Button//
    @FXML
    public void moveToLoginScene(ActionEvent event) throws IOException {
        cv.changeScene("/loginscene/Login.fxml", event);
    }
    
    
    class Listner extends Thread{
        public void run(){
            while(true){
                try {
                    // get output of authenticaion from server 
                    String msg = d.readLine();
                    System.out.println(msg);
                    String[] str = msg.split("\\:");
                    System.out.println(str[0]);
                    System.out.println(str[1]);
                    if(str[0].equals("signedup")){
                    
                            Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    cv.changeScene("/onlinePlayers/onlineXML.fxml", eventOnline);
                                    stop();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
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
