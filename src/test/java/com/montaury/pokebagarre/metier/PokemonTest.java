package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.fixtures.ConstructeurDePokemon;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PokemonTest {
    @Test
    void tester_si_pokemon1_vainqueur_car_meilleur_attaque() {
        // GIVEN
        Pokemon p1 = ConstructeurDePokemon.unPokemon().avecAttaque(12).construire();
        Pokemon p2 = ConstructeurDePokemon.unPokemon().avecAttaque(2).construire();
        // WHEN
        boolean resultat = p1.estVainqueurContre(p2);
        // THEN
        assertThat(resultat).isTrue();
        //assertEquals(true, resultat);
    }

    @Test
    void tester_si_pokemon1_perdant_car_moins_bonne_attaque() {
        // GIVEN
        Pokemon p1 = ConstructeurDePokemon.unPokemon().avecAttaque(2).construire();
        Pokemon p2 = ConstructeurDePokemon.unPokemon().avecAttaque(12).construire();
        // WHEN
        boolean resultat = p1.estVainqueurContre(p2);
        // THEN
        assertThat(resultat).isFalse();
        //assertEquals(false, resultat);
    }

    @Test
    void tester_si_pokemon2_vainqueur_car_meilleur_attaque() {
        // GIVEN
        Pokemon p1 = ConstructeurDePokemon.unPokemon().avecAttaque(12).construire();
        Pokemon p2 = ConstructeurDePokemon.unPokemon().avecAttaque(22).construire();
        // WHEN
        boolean resultat = p1.estVainqueurContre(p2);
        // THEN
        assertEquals(false, resultat);
    }

    @Test
    void tester_si_pokemon1_vainqueur_car_meilleur_defense() {
        // GIVEN
        Pokemon p1 = ConstructeurDePokemon.unPokemon().avecAttaque(10).avecDefense(22).construire();
        Pokemon p2 = ConstructeurDePokemon.unPokemon().avecAttaque(10).avecDefense(12).construire();
        // WHEN
        boolean resultat = p1.estVainqueurContre(p2);
        // THEN
        assertEquals(true, resultat);
    }

    @Test
    void tester_si_pokemon1_perdant_car_moins_bonne_defense() {
        // GIVEN
        Pokemon p1 = ConstructeurDePokemon.unPokemon().avecAttaque(10).avecDefense(11).construire();
        Pokemon p2 = ConstructeurDePokemon.unPokemon().avecAttaque(10).avecDefense(12).construire();
        // WHEN
        boolean resultat = p1.estVainqueurContre(p2);
        // THEN
        assertEquals(false, resultat);
    }
}