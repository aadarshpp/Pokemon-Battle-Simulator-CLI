package Mechanics;

import Database.*;

import java.util.Random;

public class Pokemon {

    int id;
    public int level = 50;
    int RunningHP;
    public Species species;
    public Stats stats;
    Move[] moves;

    public void display(){
        System.out.println();
        System.out.println("ID:"+id);
        species.display();
        stats.display();
        System.out.println("CURRENT HP:"+RunningHP);
        System.out.println("MOVES:");
        for(Move move: moves){move.display();}
        System.out.println();
    }

    public String name(){
        return species + " (" + Math.max(RunningHP, 0)+")";
    }


    public Pokemon(Species species) {
        this.id = Data.getNextId();
        this.species = species;
        this.moves = species.availableMoves;
        this.stats = new Stats(Data.pokemonStats[species.index]);
        this.stats.IV = new Random().nextInt(32);
        this.stats.setCurrentStats(level);
        this.RunningHP = stats.HP;
    }

    public Pokemon(int index){
        this(Species.values()[index]);
    }

}
