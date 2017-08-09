/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorslizardspock;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.random;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 *
 * @author Daiane
 */
public class MainController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label label1;
    @FXML
    private JFXButton StartButton;
    @FXML
    private JFXButton RulesButton;
    @FXML
    private JFXButton backButton;
    @FXML
    private JFXButton rockButton;
    @FXML
    private JFXButton paperButton;
    @FXML
    private JFXButton scissorsButton;
    @FXML
    private JFXButton lizardButton;
    @FXML
    private JFXButton spockButton;
    @FXML
    private JFXButton homeButton;
    @FXML
    private JFXButton playAgainButton;
    @FXML
    private AudioClip mediaPlayer;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaPlayer = new AudioClip(new File("Heman.mp3").toURI().toString());
        mediaPlayer.stop();
    }    

    @FXML
    private void startButtonAction(ActionEvent event) throws IOException{
        //loop para esperar resposta do servidor sobre outros jogadores
        /*while(true){
            label1.setText("Por favor aguarde jogador...");
        }*/
        //label1.setText("Por favor aguarde outro jogador...");
        Stage stage;
        Parent root;
        JFXButton aux = (JFXButton) event.getSource();
        stage = (Stage) aux.getScene().getWindow(); 
        root = FXMLLoader.load(getClass().getResource("InterfaceJogo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void rulesButtonAction(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        if(event.getSource()==RulesButton){
            stage = (Stage) RulesButton.getScene().getWindow(); 
            root = FXMLLoader.load(getClass().getResource("Regras.fxml"));
        }     
        else{
            stage=(Stage) RulesButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        }        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void backButtonAction(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) backButton.getScene().getWindow(); 
        root = FXMLLoader.load(getClass().getResource("Main.fxml"));
     
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void gameAction(ActionEvent event) throws IOException{
        //enviar mensagem para o servidor
        //esperar mensagem
        //fazer um IF que caso tenha ganhado,vai para tela de vitória
        //se n ganhou, vai pra tela de jogar novamente
        double ran = random();
        Stage stage;
        Parent root;
        
        if(event.getSource()==rockButton || event.getSource()==paperButton || event.getSource()==scissorsButton || event.getSource()==lizardButton || event.getSource()==spockButton){
            JFXButton aux = (JFXButton) event.getSource();
            if(ran > 0 && ran < 0.3){
                stage = (Stage) aux.getScene().getWindow(); 
                root = FXMLLoader.load(getClass().getResource("WinScreen.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else if(ran >= 0.3 && ran < 0.6){
                stage = (Stage) aux.getScene().getWindow(); 
                root = FXMLLoader.load(getClass().getResource("LooseScreen.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }   
            else{
                stage = (Stage) aux.getScene().getWindow(); 
                root = FXMLLoader.load(getClass().getResource("TieScreen.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        else{
            JFXButton aux = (JFXButton) event.getSource();
            stage = (Stage) aux.getScene().getWindow(); 
            root = FXMLLoader.load(getClass().getResource("InterfaceJogo.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    @FXML
    private void HomeButtonAction(ActionEvent event) throws IOException{
        //enviar mensagem para o servidor
        //esperar mensagem
        //fazer um IF que caso tenha ganhado,vai para tela de vitória
        //se n ganhou, vai pra tela de jogar novamente
        Stage stage;
        Parent root;
        
        if(event.getSource()==homeButton){
            stage = (Stage) homeButton.getScene().getWindow(); 
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));  
        }
        else{
            JFXButton aux = (JFXButton) event.getSource();
            stage = (Stage) aux.getScene().getWindow(); 
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        }
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void playMusic(ActionEvent event) throws IOException{
        mediaPlayer = new AudioClip(new File("Heman.mp3").toURI().toString());
        mediaPlayer.play();
        
        mediaPlayer = new AudioClip(new File("Hello.mp3").toURI().toString());
        mediaPlayer.play();
    }
}
