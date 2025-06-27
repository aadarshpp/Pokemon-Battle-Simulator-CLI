package Mechanics;

import Database.Move;

import java.util.Random;
import java.util.Scanner;

public class Battle {
    static Scanner sc = new Scanner(System.in);

    void print(Object text){
        System.out.println(text + "\n");
    }

    void printm(Object text){
        print("\n>> "+text);
    }

    void turn(Player attacker, Player defender) throws NoPokemonLeft {
        print("TURN OF "+attacker.name);
        print("ATTACKER: "+attacker.battlingPokemon.name()+" ["+attacker.battlingPokemon.species.primaryType+"] ["+ attacker.battlingPokemon.species.secondaryType+"]");
        print("DEFENDER: "+defender.battlingPokemon.name()+" ["+defender.battlingPokemon.species.primaryType+"] ["+ defender.battlingPokemon.species.secondaryType+"]");
        print("MOVES: ");
        for(int i=0; i<attacker.battlingPokemon.moves.length; i++){
            System.out.print((i+1)+". ");attacker.battlingPokemon.moves[i].display();}
        print("0. SWITCH POKEMON");
        System.out.print("ENTER CHOICE: ");

        int choice = sc.nextInt();
        if (choice==0){
            switchPokemon(attacker);
            turn(defender, attacker);
            return;
        }

        Move move = attacker.battlingPokemon.moves[choice-1];

        if (move.pp==0){
            printm("insufficient pp");
            print("<<CHOOSE ANOTHER MOVE>>\n");
            turn(attacker, defender);
            return;
        }

        printm(attacker.battlingPokemon.name()+" used "+move);
        move.pp -= 1;
        int damage = move.calcDamage(attacker.battlingPokemon, defender.battlingPokemon);
        defender.battlingPokemon.RunningHP -= damage;
        print("DAMAGE:"+damage);
        if (defender.battlingPokemon.RunningHP<=0){

            printm(defender.battlingPokemon.name()+" fainted");
            defender.availablePokemon[defender.battlingPokemonIndex] = null;
            defender.pokemonleft -= 1;

            if (defender.pokemonleft==0){
                throw new NoPokemonLeft("\n<<<<<<<<<<" +attacker.name.toUpperCase() + " WON>>>>>>>>>>\n");
            }

            switchPokemon(defender);

        }
        else {
            print(defender.battlingPokemon.name()+" has "+
                    100*defender.battlingPokemon.RunningHP/defender.battlingPokemon.stats.HP+"% HP");
        }

        sc.nextLine();
        sc.nextLine();
    }

    int checkPoint(Player P1, Player P2, int prevTurn) throws NoPokemonLeft {

        if (prevTurn==2){turn(P1, P2);return 1;}
        if (prevTurn==1){turn(P2, P1);return 2;}

        int P1Speed = P1.battlingPokemon.stats.speed;
        int P2Speed = P2.battlingPokemon.stats.speed;

        if (P1Speed>P2Speed){turn(P1, P2);return 1;}
        if (P2Speed>P1Speed){turn(P2, P1);return 2;}

        if (Math.random()<0.5){turn(P1, P2);return 1;}
        else{turn(P2, P1);return 2;}

    }

    void switchPokemon(Player player){
        print(player.name+" CHOOSE ANOTHER POKEMON");
        displayPokemons(player);
    }

    void displayPokemons(Player player){
        print("POKEMONS: ");
        for(int i=0; i<player.availablePokemon.length; i++) {
            System.out.print((i + 1) + ". ");
            try {System.out.println(player.availablePokemon[i].name());}
            catch (Exception e) {System.out.println("--NONE--");}
        }
        System.out.println("\nENTER CHOICE: ");
        int pokemonIndex = sc.nextInt()-1;

        if (player.availablePokemon[pokemonIndex]==null){
            printm("invalid input.");
            print("\n<<CHOOSE AGAIN>>");
            displayPokemons(player);
            return;
        }

        player.battlingPokemon = player.availablePokemon[pokemonIndex];
        player.battlingPokemonIndex = pokemonIndex;
        printm(player.name + " chose "+ player.battlingPokemon.name());
    }

    int run (Player P1, Player P2, int prevTurn) throws NoPokemonLeft {
        while (true) {
            try {
                return checkPoint(P1, P2, prevTurn);
            } catch (NoPokemonLeft e) {
                throw e;
            }
             catch (Exception e) {
                System.out.println(">> Invalid input");
                System.out.println(">> "+e.getMessage());
                print("\n<<TURN RESTART>>");
            }
        }
    }

    public void startBattle(Player P1, Player P2){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------\n");
        print("DISCLAIMER");
        System.out.println("The game is in SET mode.\nIf you choose to switch pokemon, you will lose your turn to attack,\nyour opponent can attack you first regardless of speed");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------\n");

        print("CHOICE OF " + P1.name);
        displayPokemons(P1);

        int randomIndex = new Random().nextInt(P2.allPokemons.length);
        P2.battlingPokemon = P2.allPokemons[randomIndex];
        P2.battlingPokemonIndex = randomIndex;

        while (true){
            try{
                run(P1, P2, run(P1, P2, 0));
            }
            catch (NoPokemonLeft e){
                print(e.getMessage());
                return;
            }
        }
    }
}

class NoPokemonLeft extends Exception{
    NoPokemonLeft(String message){
        super(message);
    }
}

