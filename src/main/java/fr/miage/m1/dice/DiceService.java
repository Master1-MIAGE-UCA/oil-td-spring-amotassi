package fr.miage.m1.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {

    @Autowired
    private Dice dice;

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    public List<Integer> rollDices(int numberOfDices) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < numberOfDices; i++) {
            results.add(dice.roll());
        }

        // Enregistrer l'historique des lancers dans la base de données
        DiceRollLog log = new DiceRollLog(numberOfDices, results, LocalDateTime.now());
        diceRollLogRepository.save(log);

        return results;
    }
}
