package chat_RMI;

public class ApplicazioneChatClient {
     public static void main(String[] args) {
    
        Client c = new Client("Alfonso") ;
        
        Messaggio messaggio = new Messaggio(c.getNome() , "messsssssaggiooone") ;
        //c.eseguiUnSoloMessaggio(messaggio) ;
        
        c.iniziaChat() ;
     }   
}
