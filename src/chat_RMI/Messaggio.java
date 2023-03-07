package chat_RMI;

import java.io.Serializable;

public class Messaggio implements Serializable {
    
    private static final long serialVersionUID = 1;

    
    public Messaggio(String mittente, String messaggio) {
        this.mittente = mittente;
        this.messaggio = messaggio;
    }

    public String getMittente() {
        return mittente;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String toString() {
        return "Messaggio{" + "mittente=" + mittente + ", messaggio=" + messaggio + '}';
    }
    
    
    
    private String mittente ;
    private String messaggio ;
}
