package ru.playtox.thread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;

/**
 * 15.01.2022
 * TestTaskForPlaytox
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
public class ThreadPool implements Executor {

    private final Queue<Runnable> workQueue = new ConcurrentLinkedDeque<>();
    private volatile boolean isRunning = true;

    public ThreadPool 

    @Override
    public void execute(Runnable command) {

    }
}
