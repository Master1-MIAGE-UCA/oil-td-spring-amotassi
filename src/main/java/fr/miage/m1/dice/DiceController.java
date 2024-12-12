package fr.miage.m1.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiceController {

    @Autowired
    private DiceService diceService;

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    // Lancer un seul dé
    @GetMapping("/rollDice")
    public String rollSingleDice() {
        List<Integer> results = diceService.rollDices(1);
        return "Résultat du lancer : " + results.get(0);
    }

    // Lancer X dés
    @GetMapping("/rollDices/{x}")
    public String rollMultipleDices(@PathVariable int x) {
        List<Integer> results = diceService.rollDices(x);
        return "Résultats des " + x + " lancers : " + results;
    }

    // Afficher l'historique des lancés
    @GetMapping("/diceLogs")
    public List<DiceRollLog> getDiceLogs() {
        return diceRollLogRepository.findAll();
    }
}
