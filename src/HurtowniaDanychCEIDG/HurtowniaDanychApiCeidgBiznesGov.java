/**Author: Mateusz Maciπg*/

package HurtowniaDanychCEIDG;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import HurtowniaDanychCEIDG.enumSpace.ErrorCode;
import HurtowniaDanychCEIDG.enumSpace.SearchType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class HurtowniaDanychApiCeidgBiznesGov {

    private String apiKey;
    private int listLimit = 10;
    private StringBuilder josonBody;

    private Alert.AlertType alertAlertType = Alert.AlertType.ERROR;
    private Alert ErrorAlert = new Alert(alertAlertType);

    public HurtowniaDanychApiCeidgBiznesGov(){}

    public Alert getErrorAlert() {
        return ErrorAlert;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setListLimit(int listLimit) {
        this.listLimit = listLimit;
    }

    public StringBuilder getJosonBody() {
        return josonBody;
    }

    public String sendQuery(String NIP, String REGON, String IMIE, String NAZWISKO, String NAZWA, String ULICA, String BUDYNEK, String LOKAL, String MIASTO , String WOJEWODZTWO, String POWIAT, String GMINA, String KOD, String PKD){

        URL url;

        josonBody = new StringBuilder();

        try {

            ErrorCode errorCode = new ErrorCode();

            //zapytanie o dane joson
            url = new URL("https://dane.biznes.gov.pl/api/ceidg/v1/firmy?"+
                    SearchType.NIP+"="+NIP+"&"+
                    SearchType.REGON+"="+REGON+"&"+
                    SearchType.IMIE+"="+IMIE+"&"+
                    SearchType.NAZWISKO+"="+NAZWISKO+"&"+
                    SearchType.NAZWA+"="+NAZWA+"&"+
                    SearchType.ULICA+"="+ULICA+"&"+
                    SearchType.BUDYNEK+"="+BUDYNEK+"&"+
                    SearchType.LOKAL+"="+LOKAL+"&"+
                    SearchType.MIASTO+"="+MIASTO+"&"+
                    SearchType.WOJEWODZTWO+"="+WOJEWODZTWO+"&"+
                    SearchType.POWIAT+"="+POWIAT+"&"+
                    SearchType.GMINA+"="+GMINA+"&"+
                    SearchType.KOD+"="+KOD+"&"+
                    SearchType.PKD+"="+PKD+"&"+
                    "&limit="+listLimit);

            //Po≥πczenie z serwerem
            HttpURLConnection http = getHttpURLConnection(url);


            //bufor danych ze streamu http
            BufferedReader br = null;
            if (http.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(http.getInputStream(),"UTF-8"));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    //System.out.println(strCurrentLine);
                    josonBody.append(strCurrentLine);
                    josonBody.append("\n");
                }
            } else {
                br = new BufferedReader(new InputStreamReader(http.getErrorStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    //System.out.println(strCurrentLine);
                    josonBody.append("{\"Error\":\""+errorCode.getErrorMessage(http.getResponseCode())+"\"}");

                    try {
                        ((Stage) ErrorAlert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(String.valueOf(getClass().getResource("img/iconError.png").toURI())));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }

                    ErrorAlert.setTitle("B≥πd");
                    ErrorAlert.setHeaderText("Odpowiedü serwera biznes.gov.pl:");
                    ErrorAlert.setContentText(strCurrentLine);
                    ErrorAlert.showAndWait();
                }
            }

            http.disconnect();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  josonBody.toString();
    }

    private HttpURLConnection getHttpURLConnection(URL url) {

        try {
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestProperty("Authorization", "Bearer " + apiKey);
            http.setRequestProperty("Content-Type", "application/json; utf-8");
            http.setRequestProperty("Accept", "application/json");
            http.setRequestMethod("GET");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();

            return http;
        }catch (IOException e){
            e.printStackTrace();
            ErrorAlert.setTitle("B≥πd");
            ErrorAlert.setHeaderText("B≥πd Polπczenia z serwerem biznes.gov.pl");
            //ErrorAlert.setContentText(strCurrentLine);
            ErrorAlert.showAndWait();

            return null;
        }

    }

}

/** Przyk≥ad uøycia
 String apiKey = "Twoj klucz do api biznes.gov.pl";
 HurtowniaDanychApiCeidgBiznesGov hurtowniaDanychAPI = new HurtowniaDanychApiCeidgBiznesGov();
 hurtowniaDanychAPI.setApiKey(apiKey);
 hurtowniaDanychAPI.setListLimit(20);
 hurtowniaDanychAPI.sendQuery("8640008339","d","","","","","","","","","","","","");
 String josonBody = hurtowniaDanychAPI.getJosonBody().toString();
 */