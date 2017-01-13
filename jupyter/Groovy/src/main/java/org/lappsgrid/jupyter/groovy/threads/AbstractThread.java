package org.lappsgrid.jupyter.groovy.threads;

import java.security.NoSuchAlgorithmException;

import org.lappsgrid.jupyter.groovy.GroovyKernel;
import org.lappsgrid.jupyter.groovy.msg.Message;
import org.zeromq.ZMQ;

/**
 * @author Keith Suderman
 */
public abstract class AbstractThread extends Thread {
    public AbstractThread(ZMQ.Socket socket, GroovyKernel kernel) {
        this.socket = socket;
        this.kernel = kernel;
    }

    public void start() {
        running = true;
        super.start();
    }

    public void halt() {
        running = false;
    }

    public Message readMessage() {
        return kernel.readMessage(socket);
    }

    public void send(Message message) throws NoSuchAlgorithmException {
        kernel.send(socket, message);
    }

    public boolean getRunning() {
        return running;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public ZMQ.Socket getSocket() {
        return socket;
    }

    public void setSocket(ZMQ.Socket socket) {
        this.socket = socket;
    }

    public GroovyKernel getKernel() {
        return kernel;
    }

    public void setKernel(GroovyKernel kernel) {
        this.kernel = kernel;
    }

    private boolean running = false;
    private ZMQ.Socket socket;
    private GroovyKernel kernel;
}
