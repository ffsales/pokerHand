package br.poker.java.exec;

import br.poker.java.game.GamePoker;
import br.poker.java.helper.CardsGenerator;
import br.poker.java.helper.GamesGenerator;
import br.poker.java.model.Deck;
import br.poker.java.model.PokerHand;

public class Game {

	public static void main(String[] args) {
		CardsGenerator generator = new CardsGenerator();
		Deck deck = generator.generateDeck();
		
		GamesGenerator gameGenerator = new GamesGenerator(deck);
		
		PokerHand handWhite = gameGenerator.generateHand();
		PokerHand handBlack = gameGenerator.generateHand();
		
		handWhite.setHand(GamePoker.WHITE);
		handBlack.setHand(GamePoker.BLACK);
		
		GamePoker game = new GamePoker(handWhite, handBlack);
		
		System.out.println("Entrada: " + handWhite + " " + handBlack);
		System.out.println("Saída: " + game.theWinnerIs());
	}
}
