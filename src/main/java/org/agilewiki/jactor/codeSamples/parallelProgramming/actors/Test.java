package org.agilewiki.jactor.codeSamples.parallelProgramming.actors;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.parallelProgramming.requests.Delay;
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
        Timer timer1 = new Timer();
        Timer timer2 = new Timer();
        timer1.initialize(getMailboxFactory().createAsyncMailbox());
        timer2.initialize(getMailboxFactory().createAsyncMailbox());
        final long t0  = System.currentTimeMillis();
        RP prp = new RP() {
           boolean pending = true;
            @Override
            public void processResponse(Object response) throws Exception {
                if (pending) {
                    pending = false;
                    return;
                } else {
                    System.out.println("Time consumed -->"
                          + (System.currentTimeMillis() - t0));
                    rp.processResponse(null);
                }
            }

        };
        (new Delay(1000)).send(this, timer1, prp);
        (new Delay(1000)).send(this, timer2, prp);


    }

}