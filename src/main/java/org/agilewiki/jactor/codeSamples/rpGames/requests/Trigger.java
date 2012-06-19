package org.agilewiki.jactor.codeSamples.rpGames.requests;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.codeSamples.rpGames.actors.Greeter;
import org.agilewiki.jactor.lpc.JLPCActor;
import org.agilewiki.jactor.lpc.Request;

public class Trigger extends Request<Object, Greeter> {

    public static final Trigger REQ = new Trigger();

    public void processRequest(JLPCActor targetActor, RP rp) throws Exception {
        Greeter greeter = (Greeter) targetActor;
        greeter.processeRequest(this, rp);
    }

    @Override
    public boolean isTargetType(Actor targetActor) {
        // TODO Auto-generated method stub
        return targetActor instanceof Greeter;
    }

}
