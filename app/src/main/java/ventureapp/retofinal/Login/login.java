package ventureapp.retofinal.Login;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import ventureapp.retofinal.R;

import ventureapp.retofinal.service.ApiImplementation;
import ventureapp.retofinal.service.pokemon;

public class login extends AppCompatActivity {

     EditText username1;
     EditText password1;
     Button ingresar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username1 = (EditText) findViewById(R.id.et_username);
        password1 = (EditText) findViewById(R.id.et_password);
        ingresar = (Button) findViewById(R.id.bt_ingresar);



            ApiImplementation.getService().getPokemon(new Callback<ArrayList<pokemon>>() {
                @Override
                public void success(final ArrayList<pokemon> lista, Response response) {
                    ingresar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            for (pokemon p : lista) {
                                if ( Integer.parseInt(username1.getText().toString())==p.getId() && password1.getText().toString().equals(p.getTipo())) {
                                    Log.i("Respuesta",p.getTipo());
                                    Intent nuevo = new Intent(getApplicationContext(),listapokemon.class);
                                    startActivity(nuevo);
                                    break;
                                } else{
                                    Toast.makeText(login.this, "Usuario no registrado", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                    });


                }
                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.i("Respuesta", "Salio mal");

                }

    });





            }





    }





















