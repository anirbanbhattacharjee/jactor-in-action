package org.agilewiki.jactor.codeSamples.piCalculator.requests;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.piCalculator.actors.Worker;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;

/**
 * A pi calculation work unit to be distributed to Worker
 */
public class Work extends Request<Double, Worker> {
    private final int start;
    private final int nrOfElements;

    public Work(int start, int nrOfElements) {
        this.start = start;
        this.nrOfElements = nrOfElements;
    }

    @Override
    public boolean isTargetType(Actor actor) {
        return actor instanceof Worker;

    }

    @Override
    public void processRequest(JLPCActor targetActor, RP rp) throws Exception {
        Worker worker = (Worker) targetActor;
        double result = ((Worker) targetActor).calculatePiFor(start, nrOfElements);
        rp.processResponse(result);
    }
}
