package g52977.atl.jeu2048.viewFx;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.ListView;

/**
 * ListView that represents the differents in-game messages.
 * 
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class MessagesList extends ListView {

    LocalTime currentTime;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * Constructor of MessagesList.
     */
    public MessagesList() {        
        this.getStylesheets().add("css/ViewFx.css");          
        
        // Disable the scroll.
        this.setMouseTransparent(true);
        this.setFocusTraversable(false);        
    }
    
    /**
     * Add a message in the messages list.
     * 
     * @param message The message to display.
     */
    public void displayMessage(String message) {
        currentTime = LocalTime.now();
        int listViewLength = this.getItems().size();        
        this.getItems().add(listViewLength, currentTime.format(dtf)
                + " - " + message);   
        
        // Focus on the last message of the list.    
        this.getSelectionModel().select(listViewLength);
        this.getFocusModel().focus(listViewLength);
        this.scrollTo(listViewLength);
    }
    
}
