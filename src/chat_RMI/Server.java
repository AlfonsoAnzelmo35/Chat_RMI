package chat_RMI;

import java.io.BufferedReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server extends UnicastRemoteObject implements InterfacciaChat{
    public Server()throws RemoteException{
        clients = new ArrayList<>();
    }

    @Override
    public void inviaMessaggio(Messaggio m)throws RemoteException {

        for(InterfacciaChat_Risposte c : clients){
            c.notificaTuttiMessaggio(m);
        }

    }

   
    @Override
    public void iscriviti(InterfacciaChat_Risposte client, String nome) throws RemoteException {
        clients.add(client) ;
        for(InterfacciaChat_Risposte c : clients){
            c.notificaTuttiIscrizione(nome);
        }
    }

    @Override
    public void abbandona(InterfacciaChat_Risposte client, String nome) throws RemoteException {
         for(InterfacciaChat_Risposte c : clients){
            c.notificaTuttiAbbandono(nome);
        }
        clients.remove(client) ;
    }
    private List<InterfacciaChat_Risposte>clients;
}
