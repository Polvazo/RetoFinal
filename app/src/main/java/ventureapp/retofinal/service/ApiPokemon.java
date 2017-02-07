package ventureapp.retofinal.service;

import java.util.ArrayList;

import retrofit.Callback;

import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;



public interface ApiPokemon {

    @GET("/lista_pokemons.php")
    void getPokemon (Callback<ArrayList<pokemon>> callback);
      }
