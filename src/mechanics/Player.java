package mechanics;

public class Player{
    String name;
    Pokemon[] allPokemons;
    Pokemon[] availablePokemon;
    Pokemon battlingPokemon;
    int battlingPokemonIndex;
    int pokemonleft;

    public Player(String name, Pokemon[] pokemons){
        this.name = name;
        this.allPokemons = pokemons;
        this.availablePokemon = pokemons;
        this.battlingPokemon = pokemons[0];
        this.pokemonleft = pokemons.length;
    }
}
