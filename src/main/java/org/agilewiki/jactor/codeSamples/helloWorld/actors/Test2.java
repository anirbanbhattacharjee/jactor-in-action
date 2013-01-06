package org.agilewiki.jactor.codeSamples.helloWorld.actors;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;

/**
 * Test Actor. This Actor receives request from the flow start prints
 * hello world and notfies main flow after that
 *
 * @author agilewiki
 *
 */
public class Test2 extends JLPCActor {

    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param request    holds the incoming request
     * @param rp         holds the response object
     * @throws Exception the exception thrown purposefully
     */
    public void processeRequest(Request request, final RP rp)
            throws Exception  {
        System.out.println("Hello World");

        // Notify that done with work
        rp.processResponse(null);

    }

}
