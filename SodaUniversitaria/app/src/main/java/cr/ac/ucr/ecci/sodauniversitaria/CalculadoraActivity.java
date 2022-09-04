package cr.ac.ucr.ecci.sodauniversitaria;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.text.NumberFormat;
import cr.ac.ucr.ecci.sodauniversitaria.model.Persona;
public class CalculadoraActivity extends AppCompatActivity {
    /*Variables Globales*/
    private Persona persona;
    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat =
            NumberFormat.getPercentInstance();
    private double billAmount = 0.0;
    private double percent = 0.15;
    private TextView amountTextView;
    private TextView percentTextView;
    private TextView tipTextView;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        //recibimos el Intent y los parametros
        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
            persona = bundle.getParcelable(MainActivity.EXTRA_MESSAGE);


        // Obtenenos las demas referencias a los componentes
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        tipTextView.setText(currencyFormat.format(0));
        totalTextView.setText(currencyFormat.format(0));

        EditText amountEditText = (EditText)
                findViewById(R.id.amountEditText);
        amountEditText.addTextChangedListener(amountEditTextWhatcher);

        // Setea percentSeekBar en el evento OnSeekBarChangeListener
        SeekBar percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        percentSeekBar.setOnSeekBarChangeListener(seekBarListener);

        // mensaje de bienvenida para persona
        TextView personaTV = (TextView) findViewById(R.id.persona);
        personaTV.setText(persona.toString() + ": es un placer servirle.");

        // Boton de envio del monto de la propina
        Button buttonEnviar = (Button)
                findViewById(R.id.buttonEnviarPropina);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // monto total final
                String montoStr = totalTextView.getText().toString();
                // Devolvemos el monto y cerramos la actividad
                Intent intent = new Intent();
                intent.putExtra("montoStr", montoStr);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    // listener object for the SeekBar 's progress changed events
    private final SeekBar.OnSeekBarChangeListener seekBarListener = new
            SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    percent = progress / 100.0; // Set percent based on progress
                    calculate(); // Calculate and display tip and total
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };


    // Listener object for the EditText 's text - changed events
    private final TextWatcher amountEditTextWhatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int
                count) {
            try {
                billAmount = Double.parseDouble(s.toString());
                amountTextView.setText(currencyFormat.format(billAmount));
            } catch (NumberFormatException e) {
                amountTextView.setText("");
                billAmount = 0.0;
            }
            calculate(); // Update the tip and total TextViews
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };


    // Calculate and display tip and total amounts
    private void calculate() {
        // format percent and display in percentTextView
        percentTextView.setText(percentFormat.format(percent));
        // calculate the tip and total
        double tip = billAmount * percent;
        double total = billAmount + tip;
        // display tip and total formatted as currency
        tipTextView.setText(currencyFormat.format(tip));
        totalTextView.setText(currencyFormat.format(total));
    }
}
