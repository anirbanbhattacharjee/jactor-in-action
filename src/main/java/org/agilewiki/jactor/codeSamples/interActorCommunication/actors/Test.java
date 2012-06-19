package org.agilewiki.jactor.codeSamples.interActorCommunication.actors;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.interActorCommunication.requests.Greet;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;

/**
 * Test Actor. This Actor receives request from the flow start prints
 * hello world and notfies main flow after that
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
        Greeter greeter = new Greeter();
        greeter.initialize(getMailbox());
        Greet.REQ.send(this, greeter, new RP<String>() {

            @Override
            public void processResponse(String greeting) throws Exception {
                System.out.println(greeting);
                rp.processResponse(null);
            }
        });
    }

}
