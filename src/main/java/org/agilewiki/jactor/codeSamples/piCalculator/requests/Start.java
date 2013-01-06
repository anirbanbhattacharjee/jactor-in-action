package org.agilewiki.jactor.codeSamples.piCalculator.requests;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.piCalculator.actors.Master;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;

public class Start extends Request<Object, Master> {
    private int nrOfElements;
    private int nrOfMessages;

    private Start(int nrOfElements, int nrOfMessages){
        this.nrOfElements = nrOfElements;
        this.nrOfMessages = nrOfMessages;
    }

    public static Start init(int nrOfElements, int nrOfMessages){
        return new Start(nrOfElements, nrOfMessages);
    }

    public void processRequest(JLPCActor targetActor, final RP rp)
            throws Exception {
        Master a = (Master) targetActor;
        RP prp = new RP() {
            final long start = System.currentTimeMillis();
            boolean pending = true;
            double pi;
            int nrOfResults;

            public void processResponse(Object obj) throws Exception {
                pi += ((Double) obj).doubleValue();
                nrOfResults += 1;
                if (nrOfResults == nrOfMessages) {
                    System.out.println(String.format("\tPi approximation: \t\t%s\n\tCalculation time: \t%s", pi, System.currentTimeMillis() - start));
                    rp.processResponse(null);
                }
            }
        };
        a.calculate(nrOfMessages, nrOfElements, prp);
    }

    public boolean isTargetType(Actor targetActor) {
        return targetActor instanceof Master;
    }
}