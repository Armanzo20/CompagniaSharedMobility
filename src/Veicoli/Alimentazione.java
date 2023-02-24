package Veicoli;

public enum Alimentazione {
    CARBURANTE, ELETTRICO ;


    public int percentuale = 100 ;

    public int getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(int percentuale) {
        this.percentuale = percentuale;
    }


}
