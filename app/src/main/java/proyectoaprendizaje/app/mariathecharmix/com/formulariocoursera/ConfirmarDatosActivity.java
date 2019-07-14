package proyectoaprendizaje.app.mariathecharmix.com.formulariocoursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatosActivity extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFecha;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    Button btnEditarDatos;


    String nombre;
    String fecha;
    String telefono;
    String email;
    String descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvNombre = findViewById(R.id.tvNombre);
        tvFecha = findViewById(R.id.tvFecha);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        btnEditarDatos = findViewById(R.id.btnEditarDatos);

        Bundle recibeIntent = getIntent().getExtras();
        nombre = recibeIntent.getString(getResources().getString(R.string.nombreLabel));
        fecha = recibeIntent.getString(getResources().getString(R.string.fechaLabel));
        telefono = recibeIntent.getString(getResources().getString(R.string.telefonoLabel));
        email = recibeIntent.getString(getResources().getString(R.string.emailLabel));
        descripcion = recibeIntent.getString(getResources().getString(R.string.descripcionLabel));

        tvNombre.setText("Nombre: " + nombre);
        tvFecha.setText("Fecha: " + fecha);
        tvTelefono.setText("Telefono: "  + telefono);
        tvEmail.setText("Email: " + email);
        tvDescripcion.setText("Descripcion: " + descripcion);

        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento=new Intent(ConfirmarDatosActivity.this, MainActivity.class);
                intento.putExtra("Nombre1", nombre);
                intento.putExtra("Telefono1", telefono);
                intento.putExtra("Email1", email);
                intento.putExtra("Descripcion1", descripcion);
                startActivity(intento);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {


        if(keyCode == KeyEvent.KEYCODE_BACK){

            Intent intento=new Intent(ConfirmarDatosActivity.this, MainActivity.class);
            intento.putExtra("Nombre1", nombre);
            intento.putExtra("Telefono1", telefono);
            intento.putExtra("Email1", email);
            intento.putExtra("Descripcion1", descripcion);
            startActivity(intento);
        }
        return super.onKeyDown(keyCode, event);
    }


}
