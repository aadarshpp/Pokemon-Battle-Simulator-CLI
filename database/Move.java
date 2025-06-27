package database;

import mechanics.Pokemon;

import java.util.Random;

import static database.Type.*;
import static database.MoveCategory.*;

enum MoveCategory{
    PHYSICAL, SPECIAL;
}

public enum Move {
//  MOVE         (TYPE, POWER, ACCURACY, PP, CATEGORY)
    Bite         (NORMAL, 60, 100, 25, PHYSICAL),
    Rage         (NORMAL, 20, 100, 20, PHYSICAL),
    Tackle       (NORMAL, 40, 100, 35, PHYSICAL),
    VineWhip     (GRASS, 45, 100, 25, PHYSICAL),
    RazorLeaf    (GRASS, 55, 100, 25, PHYSICAL),
    SeedBomb     (GRASS, 80, 100, 15, PHYSICAL),
    FrenzyPlant  (GRASS, 150, 90, 5, SPECIAL),
    Earthquake   (GROUND, 100, 100, 10, PHYSICAL),
    SludgeBomb   (POISON, 90, 100, 10, SPECIAL),
    Scratch      (NORMAL, 40, 100, 35, PHYSICAL),
    Ember        (FIRE, 40, 100, 25, SPECIAL),
    Flamethrower (FIRE, 90, 100, 15, SPECIAL),
    MetalClaw    (STEEL, 50, 95, 35, PHYSICAL),
    DragonClaw   (DRAGON, 80, 100, 15, PHYSICAL),
    FlameBurst   (FIRE, 70, 100, 15, SPECIAL),
    AirSlash     (FLYING, 75, 95, 20, SPECIAL),
    Overheat     (FIRE, 130, 90, 5, SPECIAL),
    DragonPulse  (DRAGON, 85, 100, 10, SPECIAL),
    WaterGun     (WATER, 40, 100, 25, SPECIAL),
    Bubble       (WATER, 30, 100, 40, SPECIAL),
    BubbleBeam   (WATER, 65, 100, 20, SPECIAL),
    RapidSpin    (NORMAL, 50, 100, 40, PHYSICAL),
    IceBeam      (ICE, 90, 100, 10, SPECIAL),
    HydroPump    (WATER, 110, 80, 5, SPECIAL),
    Scald        (WATER, 80, 100, 15, SPECIAL),
    Thunderbolt  (ELECTRIC, 90, 100, 15, SPECIAL),
    QuickAttack  (NORMAL, 40, 100, 30, PHYSICAL),
    VoltTackle   (ELECTRIC, 120, 100, 15, PHYSICAL),
    Thunder      (ELECTRIC, 110, 70, 10, SPECIAL),
    IronTail     (STEEL, 100, 75, 15, PHYSICAL),
    VoltSwitch   (ELECTRIC, 70, 100, 20, SPECIAL),
    ThunderShock (ELECTRIC, 40, 100, 30, SPECIAL),
    Psychic      (PSYCHIC, 90, 100, 10, SPECIAL),
    StoredPower  (PSYCHIC, 20, 100, 10, SPECIAL),
    Pursuit      (DARK, 40, 100, 20, PHYSICAL),
    FoulPlay     (DARK, 95, 100, 15, PHYSICAL),
    DarkPulse    (DARK, 80, 100, 15, SPECIAL),
    LeafBlade    (GRASS, 90, 100, 15, PHYSICAL),
    IceShard     (ICE, 40, 100, 30, PHYSICAL),
    AuroraBeam   (ICE, 65, 100, 20, SPECIAL),
    Blizzard     (ICE, 110, 70, 5, SPECIAL),
    KarateChop   (FIGHTING, 50, 100, 25, PHYSICAL),
    Submission   (FIGHTING, 80, 80, 25, PHYSICAL),
    RockSlide    (ROCK, 75, 90, 10, PHYSICAL),
    BulletPunch  (STEEL, 40, 100, 30, PHYSICAL),
    Strength     (NORMAL, 80, 100, 15, PHYSICAL),
    Payback      (DARK, 50, 100, 10, PHYSICAL),
    DynamicPunch (FIGHTING, 100, 50, 5, PHYSICAL),
    CloseCombat  (FIGHTING, 120, 100, 5, PHYSICAL),
    StoneEdge    (ROCK, 100, 80, 5, PHYSICAL),
    RockSmash    (FIGHTING, 40, 100, 15, PHYSICAL),
    Rollout      (ROCK, 30, 90, 20, PHYSICAL),
    Explosion    (NORMAL, 250, 100, 5, PHYSICAL),
    BrickBreak   (FIGHTING, 75, 100, 15, PHYSICAL),
    HeavySlam    (STEEL, 120, 85, 10, PHYSICAL),
    BodySlam     (NORMAL, 85, 100, 15, PHYSICAL),
    Headbutt     (NORMAL, 70, 100, 15, PHYSICAL),
    SteelWing    (STEEL, 70, 90, 25, PHYSICAL),
    BraveBird    (FLYING, 120, 100, 15, PHYSICAL),
    NightSlash   (DARK, 70, 100, 15, PHYSICAL),
    IronHead     (STEEL, 80, 100, 15, PHYSICAL),
    DrillPeck    (FLYING, 80, 100, 20, PHYSICAL),
    PowerWhip    (GRASS, 120, 85, 10, PHYSICAL),
    DoubleEdge   (NORMAL, 120, 100, 15, PHYSICAL),
    TakeDown     (NORMAL, 90, 85, 20, PHYSICAL),
    MeteorMash   (STEEL, 90, 85, 10, PHYSICAL),
    ZenHeadbutt  (PSYCHIC, 80, 90, 15, PHYSICAL);

    public final Type type;
    public final int power;
    public final int accuracy;
    public int pp;
    public final MoveCategory moveCategory;

    public void display(){
        System.out.print(this+" ("+type+")" + "["+moveCategory+"]");
        System.out.println(" POW:"+power+" ACC:"+accuracy+" PP:"+pp);
    }

    Move(Type type, int power, int accuracy, int pp, MoveCategory moveCategory) {
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
        this.moveCategory = moveCategory;
    }

    boolean moveMisses(){
        int rand = new Random().nextInt(100);
        if (rand > accuracy){
            System.out.println(this + " missed");
            return true;
        }
        return false;
    }

    public int calcDamage(Pokemon attacker, Pokemon defender){
        int A, D;

        float randM = (float)(Math.random() * (0.85f-1) + 1);
        float fix = this.type.getSTAB(attacker) *
                this.type.getTypeEffectiveness(defender) *
                attacker.stats.calcCriticalHitValue();

        if (attacker.stats.calcCriticalHitValue()>1) {System.out.print("CH");}
        System.out.println();

        float modifier = fix * randM; //(0.85, 1.00]

        if (this.moveCategory == SPECIAL){
            A = attacker.stats.special_attack;
            D = defender.stats.special_defence;
        }
        else{
            A = attacker.stats.physical_attack;
            D = defender.stats.physical_defence;
        }

//        System.out.println("modifier "+modifier+" fix "+fix+ " rand "+randM);

        int damage = (int) ((((2*attacker.level/5+2) * this.power * A/D)/50+2)*modifier);

        damage = (this.moveMisses()) ? 0 : damage;

        return damage;
    }
}
