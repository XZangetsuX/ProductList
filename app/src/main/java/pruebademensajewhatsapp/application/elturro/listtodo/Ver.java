package pruebademensajewhatsapp.application.elturro.listtodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Ver extends AppCompatActivity {

    EditText edName;
    EditText edDecrip;
    EditText edStockMax;
    EditText edStock;
    EditText edPercentMin;
    EditText edPercentMax;
    Button done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);




    }
}
