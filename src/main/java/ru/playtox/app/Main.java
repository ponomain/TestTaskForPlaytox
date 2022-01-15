package ru.playtox.app;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.playtox.models.Account;

import java.util.UUID;

/**
 * 15.01.2022
 * TestTaskForPlaytox
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Account acc1 = new Account(UUID.randomUUID().toString(), 10000);
        Account acc2 = new Account(UUID.randomUUID().toString(), 10000);
        Account acc3 = new Account(UUID.randomUUID().toString(), 10000);
        Account acc4 = new Account(UUID.randomUUID().toString(), 10000);
    }
}
