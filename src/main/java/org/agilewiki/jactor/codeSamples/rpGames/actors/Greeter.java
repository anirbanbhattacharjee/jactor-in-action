package org.agilewiki.jactor.codeSamples.rpGames.actors;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.rpGames.requests.Greet;
import org.agilewiki.jactor.codeSamples.rpGames.requests.Trigger;
import org.agilewiki.jactor.lpc.JLPCActor;

/**
 * Greeter Actor. This Actor receives Greet request from the Test
 * hello world and notfies main flow after that
 *
 * @author agilewiki
 *
 */
public class Greeter extends JLPCActor {
    private RP rp;


    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param request    holds the incoming request
     * @param rp         holds the response object
     * @throws Exception the exception thrown purposefully
     */
    public void processeRequest(Greet request, final RP rp)
            throws Exception  {
        this.rp = rp;
    }

    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param request    holds the incoming request
     * @param rp         holds the response object
     * @throws Exception the exception thrown purposefully
     */
    public void processeRequest(Trigger request, final RP rp)
            throws Exception  {
        rp.processResponse(null);
        this.rp.processResponse("Hello World");
    }


}
