/**Author: Mateusz Maci�g*/

package HurtowniaDanychCEIDG.enumSpace;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorCode {


    public String getErrorMessage(int Code) {


        switch(Code) {
            case 204:
                return "Nie znaleziono danych w odpowiedzi na podane kryteria wyszukiwania";
            case 400:
                return "Niepoprawnie skonstruowane zapytanie";
            case 401:
                return "Brak autoryzacji";
            case 403:
                return "Brak uprawnie� do zasobu";
            case 404:
                return "Zas�b nie istnieje";
            case 500:
                return "Wewn�trzny b��d serwera";
            default:
                return "OK";
        }

    }
}
