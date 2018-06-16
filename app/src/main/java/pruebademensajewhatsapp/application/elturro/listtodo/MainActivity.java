package pruebademensajewhatsapp.application.elturro.listtodo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import app.ListToDO;
import app.Product;
import app.Tarea;
import app.itemlist;

public class MainActivity extends AppCompatActivity {

    //public static ListToDO myListTodo = new ListToDO();
    //public static Tarea tareaStatica;

    public static itemlist myListProduct = new itemlist();
    public static Product staticProduct;


    MyAdapter ada;
    ListView list;
    Button btnAddNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // Tarea t = new Tarea("Ir por cotillitas");
        //myListTodo.agregarTarea(t);

        btnAddNew = (Button) findViewById(R.id.buttonAddProduct);




       // Tarea t2 = new Tarea("Ir al cine");
        //myListTodo.agregarTarea(t2);
        //Product p1= new Product("Leche","Litro de leche",200,123,20,80);
        //myListProduct.addProduct(p1);

        list = (ListView) findViewById(R.id.listviewList);

        ada = new MyAdapter();
        list.setAdapter(ada);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), Ver.class);
                staticProduct = myListProduct.getList().get(position);
                startActivity(i);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), Eliminar.class);

                staticProduct = myListProduct.getList().get(position);
                startActivity(i);
                return true;
            }
        });

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), Agregar.class);
                startActivity(i);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        if(ada != null)
            ada.notifyDataSetChanged();
    }

    public void callAgregar(View v){
        Intent i = new Intent(getBaseContext(), Agregar.class);
        startActivity(i);
    }


    public void change(View v){

        ada.notifyDataSetChanged();
    }


    class MyAdapter extends BaseAdapter {


        private LayoutInflater mInflater  = LayoutInflater.from(getBaseContext());


        @Override
        public int getCount() {
            return myListProduct.getList().size();
        }

        @Override
        public Object getItem(int position) {

            return myListProduct.getList().get(position);
        }

        @Override
        public long getItemId(int position) {

            return position;
        }


        TextView txtName;
        TextView txtStock;
        TextView txtPercent;
        TextView txtStatus;


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            try{



                if(convertView == null) {


                    convertView = this.mInflater.inflate(R.layout.item, parent, false);

                    txtName = (TextView)convertView.findViewById(R.id.txtNameitem);
                    txtStock = (TextView)convertView.findViewById(R.id.txtStockitem);
                    txtPercent = (TextView)convertView.findViewById(R.id.txtPercentitem);
                    txtStatus = (TextView)convertView.findViewById(R.id.txtStatusitem);

                    //Tarea it = myListTodo.getLista().get(position);

                    Product p = myListProduct.getList().get(position);

                    txtName.setText(p.getName().toString()+"");
                    txtStock.setText(p.getStock()+"");
                    txtPercent.setText(p.getGpercent()+"");

                    if(p.getRule()==null){
                        txtStatus.setText("Regulado");
                        txtStatus.setTextColor(Color.GREEN);
                    }else if(p.getRule()==true){
                        txtStatus.setText("Maximo");
                        txtStatus.setTextColor(Color.RED);
                    }else{
                        txtStatus.setText("Minimo");
                        txtStatus.setTextColor(Color.YELLOW);
                    }
                }
                else {
                    Product p = myListProduct.getList().get(position);
                    txtName.setText(p.getName()+"");
                    txtStock.setText(p.getStock()+"");
                    txtPercent.setText(p.getGpercent()+"");

                    if(p.getRule()==null){
                        txtStatus.setText("Regulado");
                        txtStatus.setTextColor(Color.GREEN);
                    }else if(p.getRule()==true){
                        txtStatus.setText("Maximo");
                        txtStatus.setTextColor(Color.RED);
                    }else{
                        txtStatus.setText("Minimo");
                        txtStatus.setTextColor(Color.YELLOW);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
            return convertView;
        }
    }
}
