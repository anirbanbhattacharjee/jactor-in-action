package org.agilewiki.jactor.codeSamples.stateMachine.requests;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.stateMachine.actors.Printer;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;


/**
 * Print request. This request is sent by the main flow to the {@link Test}
 * actor.
 *
 * @author agilewiki
 *
 */
public class Print extends Request<Object, Printer> {

    private String value;

    public String getValue() {
        return value;
    }


    public Print(String value) {
       this.value = value;
    }


    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param targetActor   holds the target actor
     * @param rp            holds the  response object
     * @throws Exception    in case of exception
     */
    public void processRequest(JLPCActor targetActor, RP rp) throws Exception {
        Printer printerActor = (Printer) targetActor;
        printerActor.processeRequest(this, rp);
    }



    @Override
    public final boolean isTargetType(final Actor targetActor) {
        return targetActor instanceof Printer;
    }

}
