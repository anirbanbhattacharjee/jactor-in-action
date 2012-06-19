package org.agilewiki.jactor.codeSamples.parallelProgramming.requests;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.parallelProgramming.actors.Test;
import org.agilewiki.jactor.codeSamples.parallelProgramming.actors.Timer;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;


/**
 * Start request. This request is sent by the main flow to the {@link Test}
 * actor.
 *
 * @author agilewiki
 *
 */
public class Delay extends Request<Object, Timer> {

    public final int ms;

    public Delay(int ms) {
        this.ms = ms;
    }



    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param targetActor   holds the target actor
     * @param rp            holds the  response object
     * @throws Exception    in case of exception
     */
    public void processRequest(JLPCActor targetActor, RP rp) throws Exception {
        Timer testActor = (Timer) targetActor;
        testActor.processeRequest(this, rp);
    }



    @Override
    public final boolean isTargetType(final Actor targetActor) {
        return targetActor instanceof Delay;
    }

}
