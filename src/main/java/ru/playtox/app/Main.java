package ru.playtox.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.playtox.models.Account;
import ru.playtox.thread.TransferRequest;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 15.01.2022
 * TestTaskForPlaytox
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static void run(Account acc1, Account acc2, TransferRequest transferRequest) {
        AtomicInteger inc = new AtomicInteger(0);
        int min = 1000;
        int max = 2000;
        do {
            transferRequest.transfer(acc1, acc2);
            logger.info("Transfer complete. First Account - " + acc1 + ", Second Account - " + acc2 + " (" + inc.get() + ")");
            try {
                Thread.sleep(new Random().nextInt(max - min) + min);
            } catch (InterruptedException e) {
                logger.warn("Interrupted!", e);
                Thread.currentThread().interrupt();
            }
        } while (inc.incrementAndGet() != 30);
    }

    public static void main(String[] args) {
        Account acc1 = new Account(UUID.randomUUID().toString(), 10000);
        Account acc2 = new Account(UUID.randomUUID().toString(), 10000);
        Account acc3 = new Account(UUID.randomUUID().toString(), 10000);
        Account acc4 = new Account(UUID.randomUUID().toString(), 10000);
        TransferRequest transferRequest = new TransferRequest();

        Runnable r1 = () -> run(acc1, acc2, transferRequest);

        Runnable r2 = () -> run(acc3, acc4, transferRequest);

        Thread t1 = new Thread(r1, "First Thread");
        Thread t2 = new Thread(r2, "Second Thread");
        t1.start();
        t2.start();
    }
}
