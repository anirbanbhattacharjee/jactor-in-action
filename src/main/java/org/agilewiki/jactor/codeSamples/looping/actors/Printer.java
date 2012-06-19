package org.agilewiki.jactor.codeSamples.looping.actors;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.looping.requests.Print;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;

/**
 * Printer Actor. This Actor receives request object and prints the value
 * associated with it.
 *
 * @author agilewiki
 *
 */
public class Printer extends JLPCActor {

    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param request    holds the incoming request
     * @param rp         holds the response object
     * @throws Exception the exception thrown purposefully
     */
    public void processeRequest(Request request, final RP rp)
            throws Exception  {
        Print printRequest = (Print) request;
        System.out.println(printRequest.getValue());
        rp.processResponse(null);
    }

}
