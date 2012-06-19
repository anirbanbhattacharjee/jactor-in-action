package org.agilewiki.jactor.codeSamples.looping.actors;


import org.agilewiki.jactor.JAIterator;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.exceptionHandling.actors.ThrowsException;
import org.agilewiki.jactor.codeSamples.looping.requests.Print;
import org.agilewiki.jactor.codeSamples.looping.requests.Start;
import org.agilewiki.jactor.lpc.JLPCActor;

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
    public void processeRequest(Start request, final RP rp)
            throws Exception  {
        final Printer printerActor = new Printer();
        printerActor.initialize(getMailbox());
        final int max = 5;
        (new JAIterator() {
            int i = 0;

            @Override
            protected void process(RP irp) throws Exception {
                if (i == max) {
                    irp.processResponse("done");
                } else {
                    i += 1;
                    (new Print("" + i)).send(Test.this, printerActor, irp);
                }

            }
        }).iterate(rp);

    }

}
