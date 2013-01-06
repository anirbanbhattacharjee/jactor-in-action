package org.agilewiki.jactor.codeSamples.piCalculator.actors;

import org.agilewiki.jactor.lpc.JLPCActor;

/**
 * Individual PI calculator
 */
public class Worker extends JLPCActor {
    public double calculatePiFor(int start, int nrOfElements) {
        double acc = 0.0;
        for (int i = start * nrOfElements; i <= ((start + 1) * nrOfElements - 1); i++) {
            acc += 4.0 * (1 - (i % 2) * 2) / (2 * i + 1);
        }
        return acc;
    }
}
