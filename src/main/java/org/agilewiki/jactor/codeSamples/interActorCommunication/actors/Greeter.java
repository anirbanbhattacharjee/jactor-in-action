package org.agilewiki.jactor.codeSamples.interActorCommunication.actors;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;

/**
 * Greeter Actor. This Actor receives Greet request from the Test
 * hello world and notfies main flow after that
 *
 * @author agilewiki
 *
 */
public class Greeter extends JLPCActor {

    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param request    holds the incoming request
     * @param rp         holds the response object
     * @throws Exception the exception thrown purposefully
     */
    public void processeRequest(Request request, final RP rp)
            throws Exception  {
        rp.processResponse("Hello World");
    }
}
