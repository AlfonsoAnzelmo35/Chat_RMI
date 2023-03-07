package chat_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfacciaChat extends Remote {
    public void inviaMessaggio(Messaggio m)throws RemoteException;
    public void iscriviti(InterfacciaChat_Risposte client, String nome)throws RemoteException ;
    public void abbandona(InterfacciaChat_Risposte client, String nome)throws RemoteException ;
}
