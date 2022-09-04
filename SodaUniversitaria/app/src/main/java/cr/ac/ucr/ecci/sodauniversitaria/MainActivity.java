package cr.ac.ucr.ecci.sodauniversitaria;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import cr.ac.ucr.ecci.sodauniversitaria.model.Persona;
import cr.ac.ucr.ecci.sodauniversitaria.model.Soda;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "persona";
    private static final int SECOND_ACTIVITY_RESULT_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instancias de las clases de la capa de negocio
        final Persona persona = new Persona();
        final Soda soda = new Soda();

        //Instanciar los textos y botones del layout activity_main.xml
        TextView personaTV = (TextView) findViewById(R.id.persona);
        Button buttonPagina = (Button) findViewById(R.id.buttonPagina);
        Button buttonLlamar = (Button) findViewById(R.id.buttonLlamar);
        Button buttonCorreo = (Button) findViewById(R.id.buttonCorreo);
        Button buttonMapa = (Button) findViewById(R.id.buttonMapa);
        Button buttonCalcularPropina = (Button) findViewById(R.id.buttonCalcularPropina);
        Button buttonListaSodas = (Button) findViewById(R.id.buttonListaSodas);

        //Asigna mensaje de bienvenida para la persona
        personaTV .setText(persona.getNombre() + " : es un placer servirle.");

        buttonPagina.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                irPagina(soda);
            }
        });

        buttonLlamar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                realizarLlamada(soda);
            }
        });

        buttonCorreo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                enviarCorreo(soda);
            }
        });

        buttonMapa.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                irMapa(soda);
            }
        });

        buttonCalcularPropina.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                irCalculadoraPropina(persona, soda);
            }
        });

        buttonListaSodas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                irListaSodas(soda);
            }
        });
    }

    //Va a la pagina de la soda
    private void irPagina(Soda soda){
        //Intent para ver una pagina en el browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(soda.getWebsite()));
        startActivity(intent);
    }

    //Llama al telefono de la soda
    private void realizarLlamada(Soda soda){
        //Intent para poder realizar llamada
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+soda.getTelefono()));
        startActivity(intent);
    }

    //Envia un correo a la soda
    private void enviarCorreo(Soda soda){
        //Intent para abrir y crear un correo
        String [] To = {soda.getEmail()};
        Uri uri = Uri.parse("mailto:"+ soda.getEmail())
                .buildUpon()
                .appendQueryParameter("subject", "Consulta Soda Universitaria")
                .appendQueryParameter("body", "Enviando desde Soda Universitaria")
                .build();
        Intent mailIntent = new Intent(Intent.ACTION_SENDTO, uri);
        mailIntent.putExtra(Intent.EXTRA_EMAIL,To);
        startActivity(Intent.createChooser(mailIntent,"Enviar via correo"));
    }

    //Ir a la localizacion de la soda en el mapa
    private void irMapa(Soda soda)
    {
        //Intent para ver localizacion en mapa
        String url = "geo:"+String.valueOf(soda.getLatitud())+","+String.valueOf(soda.getLongitud());
        String q = "?q="+String.valueOf(soda.getLatitud())+","+String.valueOf(soda.getLongitud())
                +"("+soda.getNombre()+")";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url+q));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);

    }

    //Ir a la calculadora de propinas
    private void irCalculadoraPropina(Persona persona, Soda soda){
        //Intent para llamar a la Actividad Calculadora
        Intent intent = new Intent(this, CalculadoraActivity.class);
        intent.putExtra(EXTRA_MESSAGE, persona);
        //Deseo recibir una respuesta: startActivityForResult()
        startActivityForResult(intent, SECOND_ACTIVITY_RESULT_CODE);
    }

    //El método se llama cuando la segunda actividad termina
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        //Valida que la respuesta sea del activity de calculadora de propina
        if(requestCode== SECOND_ACTIVITY_RESULT_CODE)
            if(resultCode == RESULT_OK)
                //Obtiene y muestra los datos enviados desde la calculadora
                Toast.makeText(getApplicationContext(),data.getStringExtra("montoStr"),
                        Toast.LENGTH_LONG).show();
    }

    //Ir al listado de las sodas de la universidad
    private void irListaSodas(Soda soda){
        // Intent para llamar a la Actividad Lista sodas
        Intent intent = new Intent(this, ListaSodasActivity.class);
        startActivity(intent);
    }

}