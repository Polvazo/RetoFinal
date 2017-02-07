package ventureapp.retofinal.Login;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import ventureapp.retofinal.R;
import ventureapp.retofinal.service.ApiImplementation;
import ventureapp.retofinal.service.pokemon;

public class listapokemon extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listapokemon);




        ApiImplementation.getService().getPokemon(new Callback<ArrayList<pokemon>>() {
            @Override
            public void success(ArrayList<pokemon> pokemons, Response response) {
                UsersAdapter adapter = new UsersAdapter(listapokemon.this, pokemons);

                ListView listView = (ListView) findViewById(R.id.listapokemon);
                listView.setAdapter(adapter);



            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });
    }

    public class UsersAdapter extends ArrayAdapter<pokemon> {
        public UsersAdapter(Context context, ArrayList<pokemon> users) {
            super(context, R.layout.listview_pokemones, users);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            pokemon user = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_pokemones, parent, false);
            }
            // Lookup view for data population
            TextView nombre = (TextView) convertView.findViewById(R.id.nombre_pokemon);
            TextView tipo = (TextView) convertView.findViewById(R.id.tipo_pokemon);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.foto_pokemon);
            // Populate the data into the template view using the data object
            nombre.setText("Nombre de Pokemon :" +user.getNombre());
            tipo.setText("Tipo de Pokemon :" +user.getTipo());


            Picasso.with(listapokemon.this).load(user.getImagen()).into(imageView);

            return convertView;
        }
    }




    }





