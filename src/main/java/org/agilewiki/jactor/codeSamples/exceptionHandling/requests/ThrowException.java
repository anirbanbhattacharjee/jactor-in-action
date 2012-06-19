package org.agilewiki.jactor.codeSamples.exceptionHandling.requests;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.exceptionHandling.actors.Test;
import org.agilewiki.jactor.codeSamples.exceptionHandling.actors.ThrowsException;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;


/**
 * ThrowException request. This request is sent by the {@link Test} actor to
 * the {@link ThrowsException} actor.
 *
 * @author agilewiki
 *
 */
public class ThrowException extends Request<Object, ThrowsException> {

    /**
     * Static instance of ThrowException request.
     */
    public static final ThrowException REQ = new ThrowException();


    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param targetActor   holds the target actor
     * @param rp            holds the  response object
     * @throws Exception    in case of exception
     */
    public void processRequest(JLPCActor targetActor, RP rp) throws Exception {
        ThrowsException throwsExceptionActor = (ThrowsException) targetActor;
        throwsExceptionActor.processeRequest(REQ, rp);
    }



    @Override
    public final boolean isTargetType(final Actor targetActor) {
        return targetActor instanceof ThrowsException;
    }

}
