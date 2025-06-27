package Mechanics;

import Database.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==============================================================================");
        System.out.println("                            POKEMON BATTLE SIMULATOR                          ");
        System.out.println("==============================================================================");
        System.out.println();

        Player player1 = createPlayer("Ash");
        Player player2 = createPlayer("Gary");

        Battle battle = new Battle();
        battle.startBattle(player1, player2);
    }

    private static Player createPlayer(String playerName) {
        System.out.println(playerName + ", choose your three pokemon from the list below:\n");
        displayAllPokemon();

        Pokemon[] chosenPokemon = new Pokemon[3];
        for (int i = 0; i < 3; i++) {
            chosenPokemon[i] = choosePokemon(i + 1);
        }

        return new Player(playerName, chosenPokemon);
    }

    private static void displayAllPokemon() {
        Species[] species = Species.values();
        int columns = 4;
        int rows = (int) Math.ceil(species.length / (double) columns);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int index = row * columns + col;
                if (index < species.length) {
                    System.out.printf("%2d. %-15s", index + 1, species[index]);
                }
            }
            System.out.println();
        }
    }

    private static Pokemon choosePokemon(int choiceNumber) {
        System.out.print("\nEnter the number of your choice for pokemon " + choiceNumber + ": ");
        int pokemonIndex = sc.nextInt() - 1;

        Species species = Species.getPokemon(pokemonIndex);
        species.display();

        return new Pokemon(species);
    }
}
