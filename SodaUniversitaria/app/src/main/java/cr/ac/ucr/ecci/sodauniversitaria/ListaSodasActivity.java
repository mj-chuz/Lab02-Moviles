package cr.ac.ucr.ecci.sodauniversitaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class ListaSodasActivity extends AppCompatActivity {

    // Lista de sodas
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sodas);
        listView = (ListView) findViewById(R.id.list);

        // Definimos el arreglo de datos a mostrar en la lista
        String[] values = new String[]{
                "Soda 01",
                "Soda 02",
                "Soda 03",
                "Soda 04",
                "Soda 05",
                "Soda 06",
                "Soda 07",
                "Soda 08",
                "Soda 09",
                "Soda 10",
                "Soda 11",
                "Soda 12",
                "Soda 13",
                "Soda 14",
                "Soda 15"};

        // definimos el adaptador para la lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                values);

        // asignamos el adaptador al ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener para las llamadas a las opciones de los items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {
                // ListView Clicked item index
                int itemPosition = position;
                // ListView Clicked item value
                String itemValue = (String)
                        listView.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(getApplicationContext(), "Position: " +
                        itemPosition +
                        " ListItem: " + itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }
}