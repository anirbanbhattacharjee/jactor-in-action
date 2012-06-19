package org.agilewiki.jactor.codeSamples.stateMachine.actors;


import org.agilewiki.jactor.JAIterator;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.stateMachine.requests.Print;
import org.agilewiki.jactor.codeSamples.stateMachine.requests.Start;
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
        Printer printer = new Printer();
        printer.initialize(getMailbox());
        SMBuilder stateMachineBuilder =  new SMBuilder();
        stateMachineBuilder._send(printer, new Print("a"));
        stateMachineBuilder._send(printer, new Print("b"));
        stateMachineBuilder._send(printer, new Print("c"));
        stateMachineBuilder.call(rp);
    }

}
