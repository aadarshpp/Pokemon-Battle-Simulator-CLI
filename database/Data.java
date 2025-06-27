package database;

import static Database.Move.*;
import static Database.Move.Psychic;

public class Data{

    private static int nextIdIndex = 0;
    public static int getNextId(){
         return nextIdIndex++;
    }

    final static float h = 1/2f; // HALF
    public final static float[][] typeEffectivenessMatrix = {
    // DEF  {  NM,  FI,  WA,  GA,  EL,  GD,  RK,  DA,  FT,  FL,  IC,  PO,  PS,  ST,  DR,  NA   }  // | ATTACKER
            {   1,   1,   1,   1,   1,   1,   h,   1,   1,   1,   1,   1,   1,   h,   1,   1  }, // | NORMAL
            {   1,   h,   h,   2,   1,   1,   h,   1,   1,   1,   2,   1,   1,   2,   h,   1  }, // | FIRE
            {   1,   2,   h,   h,   1,   2,   2,   1,   1,   1,   1,   1,   1,   1,   h,   1  }, // | WATER
            {   1,   h,   2,   h,   1,   2,   2,   1,   1,   h,   1,   h,   1,   h,   h,   1  }, // | GRASS
            {   1,   1,   2,   h,   h,   0,   1,   1,   1,   2,   1,   1,   1,   1,   h,   1  }, // | ELECTRIC
            {   1,   2,   1,   h,   2,   1,   2,   1,   1,   0,   1,   2,   1,   2,   1,   1  }, // | GROUND
            {   1,   2,   1,   1,   1,   h,   1,   1,   h,   2,   2,   1,   1,   h,   1,   1  }, // | ROCK
            {   1,   1,   1,   1,   1,   1,   1,   h,   h,   1,   1,   1,   2,   1,   1,   1  }, // | DARK
            {   2,   1,   1,   1,   1,   1,   2,   2,   1,   h,   2,   h,   h,   2,   1,   1  }, // | FIGHTING
            {   1,   1,   1,   2,   h,   1,   h,   1,   2,   1,   1,   1,   1,   h,   1,   1  }, // | FLYING
            {   1,   h,   h,   2,   1,   2,   1,   1,   1,   2,   h,   1,   1,   h,   2,   1  }, // | ICE
            {   1,   1,   1,   2,   1,   h,   h,   1,   1,   1,   1,   h,   1,   0,   1,   1  }, // | POISON
            {   1,   1,   1,   1,   1,   1,   1,   0,   2,   1,   1,   2,   h,   h,   1,   1  }, // | PSYCHIC
            {   1,   h,   h,   1,   h,   1,   2,   1,   1,   1,   2,   1,   1,   h,   1,   1  }, // | STEEL
            {   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   h,   2,   1  }, // | DRAGON
    };

    public static final int[][] pokemonStats = {
    // STATS    { HP, ATT, DEF, SATT, SDEF, SPD }  // | POKEMON
                { 45,  49,  49,   65,   65,  45 }, // | BULBASAUR
                { 60,  62,  63,   80,   80,  60 }, // | IVYSAUR
                { 80,  82,  83,  100,  100,  80 }, // | VENUSAUR
                { 39,  52,  43,   60,   50,  65 }, // | CHARMANDER
                { 58,  64,  58,   80,   65,  80 }, // | CHARMELEON
                { 78,  84,  78,  109,   85, 100 }, // | CHARIZARD
                { 44,  48,  65,   50,   64,  43 }, // | SQUIRTLE
                { 59,  63,  80,   65,   80,  58 }, // | WARTORTLE
                { 79,  83, 100,   85,  105,  78 }, // | BLASTOISE
                { 35,  55,  40,   50,   50,  90 }, // | PIKACHU
                { 60,  90,  55,   90,   80, 110 }, // | RAICHU
                { 55,  55,  50,   45,   65,  55 }, // | EEVEE
                { 65, 130,  60,   95,  110,  65 }, // | FLAREON
                { 65,  65,  60,  110,   95, 130 }, // | JOLTEON
                { 130, 65,  60,  110,   95,  65 }, // | VAPOREON
                { 65,  65,  60,  130,   95, 110 }, // | ESPEON
                { 95,  65, 110,   60,  130,  65 }, // | UMBREON
                { 65, 110, 130,   60,   65,  95 }, // | LEAFEON
                { 65,  60, 110,  130,   95,  65 }, // | GLACEON
                { 70,  80,  50,   35,   35,  35 }, // | MACHOP
                { 80, 100,  70,   50,   60,  45 }, // | MACHOKE
                { 90, 130,  80,   65,   85,  55 }, // | MACHAMP
                { 40,  80, 100,   30,   30,  20 }, // | GEODUDE
                { 55,  95, 115,   45,   45,  35 }, // | GRAVELER
                { 80, 120, 130,   55,   65,  45 }, // | GOLEM
                { 160,110,  65,   65,  110,  30 }, // | SNORLAX
                { 65,  80, 140,   40,   70,  70 }, // | SKARMORY
                { 250,  5,   5,   35,  105,  50 }, // | CHANSEY
                { 255, 10,  10,   75,  135,  55 }, // | BLISSEY
                { 40,  55,  80,   35,   60,  30 }, // | BELDUM
                { 60,  75, 100,   55,   80,  50 }, // | METANG
                { 80, 135, 130,   95,   90,  70 }  // | METAGROSS
    };


    static final Move[][] pokemonAvailableMoves = {
    //      {AVAILABLE MOVES}                                             // POKEMON
            {VineWhip, Tackle, RazorLeaf, SeedBomb},                      // BULBASAUR
            {VineWhip, Tackle, RazorLeaf, SeedBomb},                      // IVYSAUR
            {FrenzyPlant, Earthquake, SludgeBomb, VineWhip},              // VENUSAUR
            {Scratch, Ember, Flamethrower},                               // CHARMANDER
            {MetalClaw, DragonClaw, FlameBurst, AirSlash, Flamethrower},  // CHARMELEON
            {Overheat, AirSlash, DragonPulse, Flamethrower},              // CHARIZARD
            {Tackle, WaterGun, BubbleBeam},                               // SQUIRTLE
            {Bite, RapidSpin, IceBeam, HydroPump},                        // WARTORTLE
            {HydroPump, IceBeam, Earthquake, Scald},                      // BLASTOISE
            {Thunderbolt, QuickAttack, VoltTackle},                       // PIKACHU
            {Thunder, IronTail, VoltSwitch, Thunderbolt, QuickAttack},    // RAICHU
            {Tackle, QuickAttack, Rage},                                  // EEVEE
            {QuickAttack, Ember, Flamethrower},                           // FLAREON
            {ThunderShock, QuickAttack, Thunderbolt},                     // JOLTEON
            {WaterGun, HydroPump},                                        // VAPOREON
            {Psychic, StoredPower},                                       // ESPEON
            {Pursuit, FoulPlay, DarkPulse},                               // UMBREON
            {RazorLeaf, LeafBlade},                                       // LEAFEON
            {IceShard, AuroraBeam, Blizzard},                             // GLACEON
            {KarateChop, Submission, RockSlide},                          // MACHOP
            {BulletPunch, Strength, Payback, DynamicPunch},               // MACHOKE
            {CloseCombat, StoneEdge, Earthquake, DynamicPunch},           // MACHAMP
            {Tackle, RockSmash, Earthquake},                              // GEODUDE
            {Rollout, Explosion, BrickBreak, StoneEdge},                  // GRAVELER
            {HeavySlam, Earthquake, StoneEdge, BodySlam, RockSlide},      // GOLEM
            {BodySlam, Headbutt},                                         // SNORLAX
            {SteelWing, BraveBird, NightSlash, IronHead, DrillPeck},      // SKARMORY
            {PowerWhip, Explosion},                                       // FERROTHORN
            {DoubleEdge},                                                 // CHANSEY
            {DoubleEdge},                                                 // BLISSEY
            {TakeDown, MetalClaw},                                        // BELDUM
            {BulletPunch, Psychic, MeteorMash, ZenHeadbutt},              // METANG
            {MeteorMash, Earthquake, ZenHeadbutt, Psychic}                // METAGROSS
    };

}

