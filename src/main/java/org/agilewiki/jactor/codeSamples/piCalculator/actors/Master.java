package org.agilewiki.jactor.codeSamples.piCalculator.actors;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.piCalculator.requests.Work;
import org.agilewiki.jactor.lpc.JLPCActor;

/**
 * The PI Calculation work distributor
 */
public class Master extends JLPCActor {
    public void calculate(final int nrOfMessages, int nrOfElements, final RP rp) throws Exception {
        for (int start = 0; start < nrOfMessages; start++) {
            Worker worker = new Worker();
            worker.initialize(getMailboxFactory().createAsyncMailbox());
            (new Work(start, nrOfElements)).send(this, worker, rp);
        }
    }
}
