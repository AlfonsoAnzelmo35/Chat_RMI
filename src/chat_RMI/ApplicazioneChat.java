package chat_RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicazioneChat {
    public static void main(String[] args) {
        try {
        
            Server s = new Server() ;
            Registry r = LocateRegistry.createRegistry(5099) ;
            r.rebind("chatServer", s) ;
        
        } catch (RemoteException ex) {
            Logger.getLogger(ApplicazioneChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
