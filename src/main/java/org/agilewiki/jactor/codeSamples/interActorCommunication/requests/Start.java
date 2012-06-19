package org.agilewiki.jactor.codeSamples.interActorCommunication.requests;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.interActorCommunication.actors.Test;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;


/**
 * Start request. This request is sent by the main flow to the {@link Test}
 * actor.
 *
 * @author agilewiki
 *
 */
public class Start extends Request<Object, Test> {

    /**
     * Static instance of Start request.
     */
    public static final Start REQ = new Start();


    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param targetActor   holds the target actor
     * @param rp            holds the  response object
     * @throws Exception    in case of exception
     */
    public void processRequest(JLPCActor targetActor, RP rp) throws Exception {
        Test testActor = (Test) targetActor;
        testActor.processeRequest(REQ, rp);
    }



    @Override
    public final boolean isTargetType(final Actor targetActor) {
        return targetActor instanceof Test;
    }

}
