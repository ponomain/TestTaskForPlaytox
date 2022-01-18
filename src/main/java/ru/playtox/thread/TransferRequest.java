package ru.playtox.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.playtox.models.Account;

import java.util.Random;


/**
 * 17.01.2022
 * TestTaskForPlaytox
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
public class TransferRequest {
    private static final Logger logger = LoggerFactory.getLogger(TransferRequest.class);
    private final Random random = new Random();

    public void transfer(Account a1, Account a2) {
        Object lock1;
        Object lock2;
        if (a1.getId().compareTo(a2.getId()) > 0) {
            lock1 = a1;
            lock2 = a2;
        } else {
            lock1 = a2;
            lock2 = a1;
        }

        synchronized (lock1) {
            synchronized (lock2) {
                int amount = random.nextInt(10000);
                if ((a1.getMoney() | a2.getMoney()) < amount) {
                    logger.error("Can't transfer. Balance is lower than amount");
                } else if ((a1.getMoney() < 0) || (a2.getMoney() < 0)) {
                    logger.error("Can't transfer. Balance is lower than 0");
                } else if (a1.getMoney() < a2.getMoney()) {
                    logger.info("Transfer started from Account id: " + a2.getId() + " with money: " + a2.getMoney()
                            + " to Account id: " + a1.getId() + " with money:" + a1.getMoney() + "/amount - " + amount);
                    a1.setMoney(a1.getMoney() + amount);
                    a2.setMoney(a2.getMoney() - amount);
                } else {
                    logger.info("Transfer started from Account id: " + a1.getId() + " with money: " + a1.getMoney()
                            + " to Account id: " + a2.getId() + " with money:" + a2.getMoney() + "/amount - " + amount);
                    a1.setMoney(a1.getMoney() - amount);
                    a2.setMoney(a2.getMoney() + amount);
                }
            }
        }
    }
}
