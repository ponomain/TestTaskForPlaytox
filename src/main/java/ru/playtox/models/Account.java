package ru.playtox.models;

import lombok.*;

/**
 * 15.01.2022
 * TestTaskForPlaytox
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Account{
    private String id;
    private int money;
}
