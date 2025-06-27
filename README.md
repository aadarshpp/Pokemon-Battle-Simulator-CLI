# Pokémon Battle Simulator (CLI)

A command-line based two-player Pokémon battle game written in Java. Players choose from a list of classic Pokémon and battle each other using moves with varying types, power, and accuracy. This project simulates core turn-based battle mechanics, including move damage, type effectiveness, and switching.

---

## 📸 Abbreviated Demo

```
==============================================================================
                            POKEMON BATTLE SIMULATOR                          
==============================================================================

Ash, choose your three Pokémon from the list below:

1. BULBASAUR       2. IVYSAUR         3. VENUSAUR        4. CHARMANDER
...

Enter the number of your choice for Pokémon 1: 1
...

SPECIES:BULBASAUR
INDEX:0
TYPING:GRASS POISON
...


CHOICE OF Ash

POKEMONS: 

1. BULBASAUR (115)
2. CHARMELEON (127)
3. IVYSAUR (128)

ENTER CHOICE: 
1

>> Ash chose BULBASAUR (115)

TURN OF Ash

ATTACKER: BULBASAUR (115) [GRASS] [POISON]

DEFENDER: SQUIRTLE (111) [WATER] [NONE]

MOVES: 

1. VineWhip (GRASS)[PHYSICAL] POW:45 ACC:100 PP:25
2. Tackle (NORMAL)[PHYSICAL] POW:40 ACC:100 PP:35
3. RazorLeaf (GRASS)[PHYSICAL] POW:55 ACC:100 PP:25
4. SeedBomb (GRASS)[PHYSICAL] POW:80 ACC:100 PP:15
0. SWITCH POKEMON

ENTER CHOICE: 1

>> BULBASAUR (115) used VineWhip

super effective 2x
DAMAGE:53

SQUIRTLE (58) has 52% HP
...

>> CHARMANDER (0) fainted

<<<<<<<<<<ASH WON>>>>>>>>>>

````

---

## 🕹️ How to Play

1. Two players take turns choosing three Pokémon each from a list of 32.
2. Battles proceed in a turn-based manner.
3. On your turn, you can:
   - Attack using one of four available moves.
   - Switch to another Pokémon (loses your attack turn).
4. Moves have:
   - Type (e.g. GRASS, FIRE, WATER)
   - Category (PHYSICAL or SPECIAL)
   - Power, Accuracy, and remaining PP
5. Type matchups are considered (e.g. GRASS is super effective against WATER).

---

## ⚙️ How to Run

### Requirements
- Java 8 or later

### Compile
```bash
javac -d out src/database/*.java src/mechanics/*.java
````

### Run

```bash
java -cp out mechanics.Main
```

> Make sure you're in the project root when running these commands.

---

## 📁 Project Structure

```
src/
├── database/
│   ├── Data.java
│   ├── Move.java
│   ├── Species.java
│   └── Type.java
└── mechanics/
    ├── Battle.java
    ├── Main.java
    ├── Player.java
    ├── Pokemon.java
    └── Stats.java
```

---

## ⚠️ Notes

* The game uses **SET mode** (switching forfeits your attack turn).
* Input validation is basic — invalid choices will cause the turn to restart.
* The project is currently CLI only. A GUI version with a computer opponent is in development.

---

## 📌 Future Plans

* Complete the GUI version.
* Add the computer as an opponent.
* Add more Pokémon and moves.
