package chat_RMI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements InterfacciaChat_Risposte,Serializable {
    private static String nome = "Alfonso" ;
    private static final long serialVersionUID = 1;
   
    
    public Client(String nome) {
        this.nome = nome ;
    }

    
    @Override
    public String notificaTuttiMessaggio(Messaggio m) throws RemoteException {
        return m.getMittente()+ "<<" + m.getMessaggio();
    }

    @Override
    public String notificaTuttiIscrizione(String chi) throws RemoteException {
        return chi + " può leggere i messaggi" ;

    }

    @Override
    public String notificaTuttiAbbandono(String chi) throws RemoteException {
        return chi + " non può più leggere i messaggi" ;
    }
    
    public void eseguiUnSoloMessaggio(Messaggio messaggio){
    try {
           InterfacciaChat server = (InterfacciaChat)Naming.lookup("rmi://localhost:5099/chatServer") ;
           server.iscriviti(this , nome);
           server.inviaMessaggio(messaggio);
           server.abbandona(this , nome);
     
         } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void iniziaChat(){
        BufferedReader bufferedReader =
           new BufferedReader(new InputStreamReader(System.in)) ;
       
        try {
            InterfacciaChat server = (InterfacciaChat)Naming.lookup("rmi://localhost:5099/chatServer") ;
            server.iscriviti(this , nome);
            
            String parola = "" ;
            while(!(parola = bufferedReader.readLine()).equals("!chiudi")){
                server.inviaMessaggio(new Messaggio(this.nome, parola));
            }
            server.abbandona(this, nome);
            
        }catch(IOException | NotBoundException e){e.printStackTrace();}
    }

    public static String getNome() {
        return nome;
    }

    
}
