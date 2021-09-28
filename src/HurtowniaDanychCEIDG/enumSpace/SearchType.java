/**Author: Mateusz Maci¹g*/

package HurtowniaDanychCEIDG.enumSpace;

public enum SearchType {
    NIP {
        public String toString() { return "nip"; }
    },

    REGON {
        public String toString() {
            return "regon";
        }
    },

    IMIE {
        public String toString() {
            return "imie";
        }
    },

    NAZWISKO {
        public String toString() {
            return "nazwisko";
        }
    },

    NAZWA {
        public String toString() {
            return "nazwa";
        }
    },

    ULICA {
        public String toString() {
            return "ulica";
        }
    },

    BUDYNEK {
        public String toString() {
            return "budynek";
        }
    },

    LOKAL {
        public String toString() {
            return "lokal";
        }
    },

    MIASTO {
        public String toString() {
            return "miasto";
        }
    },

    WOJEWODZTWO {
        public String toString() {
            return "wojewodztwo";
        }
    },

    POWIAT {
        public String toString() {
            return "powiat";
        }
    },

    GMINA {
        public String toString() {
            return "gmina";
        }
    },

    KOD {
        public String toString() {
            return "kod";
        }
    },

    PKD {
        public String toString() {
            return "pkd";
        }
    },
}
/**
        Parametr Opis Przyk³ad
        nip Numer NIP nip=1112223344
        regon Numer REGON regon=1234567890123
        imie Imiê przedsiêbiorcy imie=jan
        nazwisko Nazwisko przedsiêbiorcy nazwisko=kowalski
        nazwa Nazwa firmy nazwa=abc
        ulica Adres firmy, ulica ulica=ogrodowa
        budynek Adres firmy, budynek budynek=34
        lokal Adres firmy, lokal lokal=12
        miasto Adres firmy, miasto miasto=warszawa
        wojewodztwo Adres firmy, wojewodztwo wojewodztwo= mazow ieckie
        powiat Adres firmy, powiat powiat=warszawa
        gmina Adres firmy, gmina gmina=warszawa
        kod Adres firmy, kod pocztowy kod=01-234
        pkd Kod PKD pkd=9312Z
        page Numer strony wyszukiwania page=1
        limit Maksymalna liczba zwracanych elementów limit=50



 */