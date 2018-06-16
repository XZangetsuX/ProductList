package pruebademensajewhatsapp.application.elturro.listtodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.Product;

public class Agregar extends AppCompatActivity {

    EditText addName;
    EditText addDecrip;
    EditText addStockMax;
    EditText addStock;
    EditText addPercentMin;
    EditText addPercentMax;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        addName =  (EditText) findViewById(R.id.txtAddName);
        addDecrip =  (EditText) findViewById(R.id.txtAddDescrip);
        addStockMax =   (EditText) findViewById(R.id.txtAddStockMax);
        addStock =   (EditText) findViewById(R.id.txtAddStockInicial);
        addPercentMin =   (EditText) findViewById(R.id.txtAddPercentMin);
        addPercentMax =   (EditText) findViewById(R.id.txtAddPercentMax);
        done = (Button) findViewById(R.id.buttonAddListo);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionAddProduct(v);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                Toast.makeText(Agregar.this, "Producto agregado",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ActionAddProduct(View v){

        //Tarea t = new Tarea(editTitulo.getText().toString());
        String name= addName.getText().toString();
        String decrip= addDecrip.getText().toString();
        int StockMax = Integer.parseInt(addStockMax.getText().toString()+"");
        int Stock = Integer.parseInt(addStock.getText().toString());
        double PercentMin = Double.parseDouble(addPercentMin.getText().toString());
        double PercentMax = Double.parseDouble(addPercentMax.getText().toString());



        Product p = new Product(name,decrip,StockMax,Stock,PercentMin,PercentMax);
        MainActivity.myListProduct.addProduct(p);
}
    }
