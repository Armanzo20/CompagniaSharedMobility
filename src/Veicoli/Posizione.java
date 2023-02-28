package Veicoli;

public class Posizione {
    protected String citta ;
    protected String via ;
    protected int numeroCivico ;

    public Posizione(String citta, String via, int numeroCivico) {
        this.citta = citta;
        this.via = via;
        this.numeroCivico = numeroCivico;
    }


    public String getCitta() {
        return citta;
    }

    public String getVia() {
        return via;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }



}
