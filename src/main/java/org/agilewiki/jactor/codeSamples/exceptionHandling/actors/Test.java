package org.agilewiki.jactor.codeSamples.exceptionHandling.actors;

import org.agilewiki.jactor.codeSamples.exceptionHandling.requests
.ThrowException;
import org.agilewiki.jactor.ExceptionHandler;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;

/**
 * Test Actor. This Actor receives request from the flow start and finally
 * delegates to {@link ThrowsException} actor.
 *
 * @author agilewiki
 *
 */
public class Test extends JLPCActor {

    /**
     * Processes the in-bound request originating from the flow start.
     *
     * @param request    holds the incoming request
     * @param rp         holds the response object
     * @throws Exception the exception thrown purposefully
     */
    public void processeRequest(Request request, final RP rp)
            throws Exception  {
        ThrowsException throwsException = new ThrowsException();
        throwsException.initialize(getMailbox());
        setExceptionHandler(new ExceptionHandler() {

            /**
             * Processes the exception generated by the Test actor.
             */
            public void process(Exception exception) throws Exception {
                System.out.println(exception.getMessage());
                rp.processResponse(null);
            }
        });

        // Sends the request to the ThrowsException actor.
        ThrowException.REQ.send(this, throwsException, new RP() {

            @Override
            public void processResponse(Object response) throws Exception {
                System.out.println("This block is not getting executed");
                rp.processResponse(null);
            }

        });
    }

}
