package org.agilewiki.jactor.codeSamples.stateMachine;

import org.agilewiki.jactor.JAFuture;
import org.agilewiki.jactor.JAMailboxFactory;
import org.agilewiki.jactor.Mailbox;
import org.agilewiki.jactor.MailboxFactory;
import org.agilewiki.jactor.codeSamples.stateMachine.actors.Test;
import org.agilewiki.jactor.codeSamples.stateMachine.requests.Start;


/**
 * Main program does the following activities-
 * <ul>
 *   <li>Initializes {@link Test} actor with the mailbox</li>
 *   <li>Sends the {@link Start} request to the {@link Test} actor</li>
 * </ul>
 * under the hood, {@link Test} actor after receiving the message does the
 * following activities-
 * <ul>
 *   <li>
 *     Sends {@link ThrowException} request to the {@link ThrowsException}
 *     actor. And waits for response (a)
 *   </li>
 *   <li>
 *     {@link ThrowsException} actor throws exception, as a result flow never
 *     returns back to (a). But the special exception catching mechanism in
 *     {@link Test} actor catches the exception.
 *   </li>
 * </ul>
 *
 * @author agilewiki
 *
 */
public class GettingStarted {

    /**
     * Flow starts here.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MailboxFactory mailboxFactory = JAMailboxFactory.newMailboxFactory(10);
        Mailbox mailbox = mailboxFactory.createMailbox();
        JAFuture future = new JAFuture();
        Test test = new Test();
        test.initialize(mailbox);
        Start.REQ.send(future, test);
        mailboxFactory.close();
        System.out.println("Getting started");
    }
}
