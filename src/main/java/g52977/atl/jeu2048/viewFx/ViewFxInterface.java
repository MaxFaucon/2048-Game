package g52977.atl.jeu2048.viewFx;

import g52977.atl.jeu2048.controller.ControllerFx;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Interface of the view.
 * 
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public interface ViewFxInterface extends PropertyChangeListener {

    /**
     * Makes an action according to the event sent by the model.
     *
     * @param pce The event sent by the model.
     */
    void propertyChange(PropertyChangeEvent pce);

    /**
     * Setter of ViewFx to set a controller. And add the view as a listener of
     * the model.
     *
     * @param controller A controller.
     */
    void setController(ControllerFx controller);

    /**
     * Show the stage of the fx view.
     */
    void showStage();
    
}
