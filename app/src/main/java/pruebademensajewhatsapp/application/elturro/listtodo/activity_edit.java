package pruebademensajewhatsapp.application.elturro.listtodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.Product;

public class activity_edit extends AppCompatActivity {



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
        setContentView(R.layout.activity_edit);


        edName =  (EditText) findViewById(R.id.txteditName);
        edDecrip =  (EditText) findViewById(R.id.txteditDescrip);
        edStockMax =   (EditText) findViewById(R.id.txteditStockMax);
        edStock =   (EditText) findViewById(R.id.txteditStockInicial);
        edPercentMin =   (EditText) findViewById(R.id.txteditPercentMin);
        edPercentMax =   (EditText) findViewById(R.id.txteditPercentMax);
        done = (Button) findViewById(R.id.buttonAddListo);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionEditProduct(v);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                Toast.makeText(activity_edit.this, "Producto editado",Toast.LENGTH_SHORT).show();
            }
        });


    }


    public void ActionEditProduct(View v){

        String name= edName.getText().toString();
        String decrip= edDecrip.getText().toString();
        int StockMax = Integer.parseInt(edStockMax.getText().toString()+"");
        int Stock = Integer.parseInt(edStock.getText().toString());
        double PercentMin = Double.parseDouble(edPercentMin.getText().toString());
        double PercentMax = Double.parseDouble(edPercentMax.getText().toString());

        //edName.setText();

        Product p = new Product(name,decrip,StockMax,Stock,PercentMin,PercentMax);
        MainActivity.myListProduct.addProduct(p);
    }
}
