package Veicoli;

public enum Alimentazione {
    CARBURANTE, ELETTRICO ;

    public int consumo;
    public int percentuale = 100 ;

    public int getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(int percentuale) {
        this.percentuale = percentuale;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public void consumaBenziona(int min){
        this.percentuale -= consumo * min;
    }
}
