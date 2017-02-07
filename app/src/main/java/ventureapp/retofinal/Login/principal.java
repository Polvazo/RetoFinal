package ventureapp.retofinal.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ventureapp.retofinal.R;

public class principal extends AppCompatActivity {

    private Button pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        pokemon=(Button)findViewById(R.id.btn_ingresar);

        pokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(principal.this,login.class);
                startActivity(intent1);
            }
        });
    }
}
