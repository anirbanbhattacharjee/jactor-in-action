package org.agilewiki.jactor.codeSamples.parallelProgramming.actors;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.parallelProgramming.requests.Delay;
import org.agilewiki.jactor.lpc.JLPCActor;

/**
 * Test Actor. This Actor receives request from the flow start prints
 * hello world and notfies main flow after that
 *
 * @author agilewiki
 *
 */
public class Timer extends JLPCActor {

    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param request    holds the incoming request
     * @param rp         holds the response object
     * @throws Exception the exception thrown purposefully
     */
    public void processeRequest(Delay request, final RP rp)
            throws Exception  {
        Thread.sleep(request.ms);

        // Notify that done with work
        rp.processResponse(null);

    }

}
