package proyectoaprendizaje.app.mariathecharmix.com.formulariocoursera;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    static TextInputEditText tiNombre;
    static TextInputEditText tiTelefono;
    static TextInputEditText tiEmail;
    static TextInputEditText tiDescripcion;
    CalendarView calendario;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendario = findViewById(R.id.calendario);
        boton = findViewById(R.id.botonSiguiente);
        tiNombre = findViewById(R.id.tiNombre);
        tiTelefono = findViewById(R.id.tiTelefono);
        tiEmail = findViewById(R.id.tiEmail);
        tiDescripcion = findViewById(R.id.tiDescripcion);


        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        final String fechaSeleccionada = formatoFecha.format(new Date(calendario.getDate()));

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento= new Intent( MainActivity.this, ConfirmarDatosActivity.class);
                intento.putExtra(getResources().getString(R.string.nombreLabel), tiNombre.getText().toString());
                intento.putExtra(getResources().getString(R.string.fechaLabel), fechaSeleccionada);
                intento.putExtra(getResources().getString(R.string.telefonoLabel), tiTelefono.getText().toString());
                intento.putExtra(getResources().getString(R.string.emailLabel), tiEmail.getText().toString());
                intento.putExtra(getResources().getString(R.string.descripcionLabel), tiDescripcion.getText().toString());
                startActivity(intento);
            }
        });

        Bundle b=getIntent().getExtras();

        if (b != null) {
            String nombre=b.getString("Nombre1");
            String telefono=b.getString("Telefono1");
            String email=b.getString("Email1");
            String descripcion=b.getString("Descripcion1");

            tiNombre.setText(nombre);
            tiTelefono.setText(telefono);
            tiEmail.setText(email);
            tiDescripcion.setText(descripcion);
        }

    }
}
