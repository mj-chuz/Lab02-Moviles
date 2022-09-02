package cr.ac.ucr.ecci.sodauniversitaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cr.ac.ucr.ecci.sodauniversitaria.model.Persona;
import cr.ac.ucr.ecci.sodauniversitaria.model.Soda;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Persona persona = new Persona();
        final Soda soda = new Soda();

        TextView personaTV = (TextView) findViewById(R.id.persona);
        Button buttonPagina = (Button) findViewById(R.id.buttonPagina);
        Button buttonLlamar = (Button) findViewById(R.id.buttonLlamar);
        Button buttonCorreo = (Button) findViewById(R.id.buttonCorreo);
        Button buttonMapa = (Button) findViewById(R.id.buttonMapa);
        Button buttonCalcularPropina = (Button) findViewById(R.id.buttonCalcularPropina);
        Button buttonListaSodas = (Button) findViewById(R.id.buttonListaSodas);

        personaTV .setText(persona.getNombre() + ": es un placer servirle.");

        buttonPagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarLlamada(soda);
            }
        });
    }
}