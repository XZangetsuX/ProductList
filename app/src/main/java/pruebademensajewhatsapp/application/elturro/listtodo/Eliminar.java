package pruebademensajewhatsapp.application.elturro.listtodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static pruebademensajewhatsapp.application.elturro.listtodo.MainActivity.staticProduct;
//import static pruebademensajewhatsapp.application.elturro.listtodo.MainActivity.tareaStatica;


public class Eliminar extends AppCompatActivity {

    TextView txtDeleteName;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        txtDeleteName = (TextView) findViewById(R.id.txtDeleteName);

        if(staticProduct != null){
            txtDeleteName.setText(staticProduct.getName());
            }

        btnDelete = (Button) findViewById(R.id.buttonDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteProduct(v);
                Toast.makeText(Eliminar.this, "Producto eliminado", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Eliminar.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void deleteProduct(View v){
        //MainActivity.myListTodo.eliminarTarea(tareaStatica);
        MainActivity.myListProduct.deleteProduct(staticProduct);
    }
}
