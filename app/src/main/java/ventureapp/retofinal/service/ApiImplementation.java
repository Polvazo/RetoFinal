package ventureapp.retofinal.service;


import retrofit.RestAdapter;

public class ApiImplementation {
    private static RestAdapter restAdapter = new RestAdapter.Builder()
                                        .setEndpoint("http://victorcasass.com/api").build();

    public static ApiPokemon getService(){
        return restAdapter.create(ApiPokemon.class);

    }
}

