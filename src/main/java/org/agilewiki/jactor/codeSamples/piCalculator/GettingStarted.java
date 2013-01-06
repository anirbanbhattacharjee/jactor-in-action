package org.agilewiki.jactor.codeSamples.piCalculator;

import org.agilewiki.jactor.JAFuture;
import org.agilewiki.jactor.JAMailboxFactory;
import org.agilewiki.jactor.Mailbox;
import org.agilewiki.jactor.MailboxFactory;
import org.agilewiki.jactor.codeSamples.piCalculator.actors.Master;
import org.agilewiki.jactor.codeSamples.piCalculator.requests.Start;


/**
 * Main program does the following activities-
 * <ul>
 *   <li>Initializes {@link org.agilewiki.jactor.codeSamples.looping.actors.Test} actor with the mailbox</li>
 *   <li>Sends the {@link org.agilewiki.jactor.codeSamples.looping.requests.Start} request to the {@link org.agilewiki.jactor.codeSamples.looping.actors.Test} actor</li>
 * </ul>
 * under the hood, {@link org.agilewiki.jactor.codeSamples.looping.actors.Test} actor after receiving the message does the
 * following activities-
 * <ul>
 *   <li>
 *     Sends {@link ThrowException} request to the {@link ThrowsException}
 *     actor. And waits for response (a)
 *   </li>
 *   <li>
 *     {@link ThrowsException} actor throws exception, as a result flow never
 *     returns back to (a). But the special exception catching mechanism in
 *     {@link org.agilewiki.jactor.codeSamples.looping.actors.Test} actor catches the exception.
 *   </li>
 * </ul>
 *
 * @author agilewiki
 *
 */
public class GettingStarted {

    private static void calculate(final int nrOfWorkers, final int nrOfElements, final int nrOfMessages) throws Exception {
        System.out.println("JACTOR - calc - ("+nrOfWorkers+","+nrOfElements+","+nrOfMessages+")");
        MailboxFactory mailboxFactory = JAMailboxFactory.newMailboxFactory(nrOfWorkers);
        Mailbox mailbox = mailboxFactory.createMailbox();
        Master master = new Master();
        master.initialize(mailbox);
        JAFuture future = new JAFuture();
        Start.init(nrOfElements, nrOfMessages).send(future,master);
        mailboxFactory.close();
    }

    /**
     * Flow starts here.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int workers = 4, elements = 30000, messages = 30000;
        if (args.length == 1) {
            elements = Integer.valueOf(args[0]);
            messages = elements;
        } else if (args.length == 2) {
            elements = Integer.valueOf(args[0]);
            messages = Integer.valueOf(args[1]);
        } else if (args.length > 2) {
            workers = Integer.valueOf(args[0]);
            elements = Integer.valueOf(args[1]);
            messages = Integer.valueOf(args[2]);
        }
        calculate(workers, elements, messages);
        System.out.println("Getting started");
    }
}
