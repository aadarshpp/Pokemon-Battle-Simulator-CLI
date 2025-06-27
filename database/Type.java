package Database;

import Mechanics.Pokemon;

public enum Type{
    NORMAL, FIRE, WATER, GRASS, ELECTRIC, GROUND, ROCK,
    DARK, FIGHTING, FLYING, ICE, POISON, PSYCHIC, STEEL, DRAGON,
    NONE ;

    public float getSTAB(Pokemon attacker){
        if (this==attacker.species.primaryType || this==attacker.species.secondaryType) {
            return 1.5f;
        }
        return 1.0f;
    }

    public float getTypeEffectiveness(Pokemon defender){
        int attack_type_index = this.ordinal();
        int primary_type_index = defender.species.primaryType.ordinal();
        int secondary_type_index = defender.species.secondaryType.ordinal();
        float effectiveness = Data.typeEffectivenessMatrix[attack_type_index][primary_type_index];
        effectiveness *= Data.typeEffectivenessMatrix[attack_type_index][secondary_type_index];

        if (effectiveness==0.25){
            System.out.println("\nRESISTED 1/4\n");
        } else if (effectiveness==0.5) {
            System.out.println("\nresisted 1/2\n");
        } else if (effectiveness==2) {
            System.out.println("\nsuper effective 2x\n");
        } else if (effectiveness==4) {
            System.out.println("\nSUPER EFFECTIVE 4x\n");
        }


        return effectiveness;
    }
}

