package fr.miage.m1.dice;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Dice {

    private final Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1;
    }
}
