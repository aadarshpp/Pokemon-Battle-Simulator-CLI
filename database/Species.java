package Database;

import static Database.Type.*;


public enum Species {
//  POKEMON      (PRIMARY TYPE, SECONDARY TYPE)
    BULBASAUR    (GRASS, POISON),
    IVYSAUR      (GRASS, POISON),
    VENUSAUR     (GRASS, POISON),
    CHARMANDER   (FIRE, NONE),
    CHARMELEON   (FIRE, NONE),
    CHARIZARD    (FIRE, FLYING),
    SQUIRTLE     (WATER, NONE),
    WARTORTLE    (WATER, NONE),
    BLASTOISE    (WATER, NONE),
    PIKACHU      (ELECTRIC, NONE),
    RAICHU       (ELECTRIC, NONE),
    EEVEE        (NORMAL, NONE),
    FLAREON      (FIRE, NONE),
    JOLTEON      (ELECTRIC, NONE),
    VAPOREON     (WATER, NONE),
    ESPEON       (PSYCHIC, NONE),
    UMBREON      (DARK, NONE),
    LEAFEON      (GRASS, NONE),
    GLACEON      (ICE, NONE),
    MACHOP       (FIGHTING, NONE),
    MACHOKE      (FIGHTING, NONE),
    MACHAMP      (FIGHTING, NONE),
    GEODUDE      (ROCK, GROUND),
    GRAVELER     (ROCK, GROUND),
    GOLEM        (ROCK, GROUND),
    SNORLAX      (NORMAL, NONE),
    SKARMORY     (STEEL, FLYING),
    CHANSEY      (NORMAL, NONE),
    BLISSEY      (NORMAL, NONE),
    BELDUM       (STEEL, PSYCHIC),
    METANG       (STEEL, PSYCHIC),
    METAGROSS    (STEEL, PSYCHIC);

    public final int index;
    public final Type primaryType, secondaryType;
    public final Move[] availableMoves;

    public static Species getPokemon(int index){
        return Species.values()[index];
    }

    public void display(){
        System.out.println();
        System.out.println("SPECIES:"+this);
        System.out.println("INDEX:"+this.index);
        System.out.print("TYPING:"+this.primaryType);
        if(this.secondaryType!=NONE){System.out.print(" " + this.secondaryType);}
        System.out.println();
    }

     Species(Type primaryType, Type secondaryType) {
        this.index = this.ordinal();
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.availableMoves = Database.Data.pokemonAvailableMoves[index];
    }
};



