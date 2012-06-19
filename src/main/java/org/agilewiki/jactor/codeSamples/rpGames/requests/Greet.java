package org.agilewiki.jactor.codeSamples.rpGames.requests;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.rpGames.actors.Greeter;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;


/**
 * Start request. This request is sent by the main flow to the {@link Test}
 * actor.
 *
 * @author agilewiki
 *
 */
public class Greet extends Request<String, Greeter> {

    /**
     * Static instance of Start request.
     */
    public static final Greet REQ = new Greet();


    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param targetActor   holds the target actor
     * @param rp            holds the  response object
     * @throws Exception    in case of exception
     */
    public void processRequest(JLPCActor targetActor, RP rp) throws Exception {
        Greeter greeterActor = (Greeter) targetActor;
        greeterActor.processeRequest(REQ, rp);
    }



    @Override
    public final boolean isTargetType(final Actor targetActor) {
        return targetActor instanceof Greeter;
    }

}
