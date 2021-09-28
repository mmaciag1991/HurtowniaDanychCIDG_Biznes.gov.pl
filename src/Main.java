/**Author: Mateusz Maci¹g*/

import javafx.application.Application;
import javafx.stage.Stage;
import HurtowniaDanychCEIDG.HurtowniaDanychApiCeidgBiznesGov;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String apiKey = "Twoj klucz do api biznes.gov.pl";
        HurtowniaDanychApiCeidgBiznesGov hurtowniaDanychAPI = new HurtowniaDanychApiCeidgBiznesGov();
        hurtowniaDanychAPI.setApiKey(apiKey);
        hurtowniaDanychAPI.setListLimit(20);
        hurtowniaDanychAPI.sendQuery("","","","","","","","","","","","","","");
        String josonBody = hurtowniaDanychAPI.getJosonBody().toString();
        System.out.println(josonBody);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
