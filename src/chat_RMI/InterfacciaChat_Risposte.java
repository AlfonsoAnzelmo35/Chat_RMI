package chat_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfacciaChat_Risposte extends Remote {
    public String notificaTuttiMessaggio(Messaggio m)throws RemoteException;
    public String notificaTuttiIscrizione(String chi)throws RemoteException ;
    public String notificaTuttiAbbandono(String chi)throws RemoteException ;
}
 
    

