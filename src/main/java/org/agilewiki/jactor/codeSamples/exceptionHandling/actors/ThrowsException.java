package org.agilewiki.jactor.codeSamples.exceptionHandling.actors;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;

/**
 * Actor throws exception.
 *
 * @author agilewiki
 *
 */
public class ThrowsException extends JLPCActor {

    /**
     * Processes an inbound request.
     *
     * @param request    holds the incoming request
     * @param rp         holds the response object
     * @throws Exception the exception thrown purposefully
     */
    public void processeRequest(Request request, RP rp) throws Exception  {
        throw new Exception("Boo");
    }

}
