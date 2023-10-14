package mx.edu.isc.tesoem.hjcg.p2p4_7s21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import DatosExamen.EstructuraDatos;

public class PrincipalActivity extends AppCompatActivity {

    TextView txtpregunta;
    RadioButton r1, r2, r3;

    Button  btnant, btnsig, btncal;

    int currentIndex = 0; // Agrega esta variable para rastrear el índice de la pregunta actual
    int puntaje = 0;
    int respuestasCorrectas = 0;
    ArrayList<EstructuraDatos> listadatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtpregunta = findViewById(R.id.txtpregunta);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);

        btnant = findViewById(R.id.btnant);
        btnsig = findViewById(R.id.btnsig3);
        btncal = findViewById(R.id.btncal);

        EstructuraDatos ed = new EstructuraDatos();

        ed.setPregunta("1.- ¿Quien es el descrubridor de america?");
        ed.setR1("A) Hernan cortes");
        ed.setR2("B) Pancho Villa");
        ed.setR3("C) Cristobal Colon");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("2.- ¿Quien pinto la ultima cena?");
        ed.setR1("A) Diego Rivera");
        ed.setR2("B) Leonardo Davince");
        ed.setR3("C) Picasso");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("3.- ¿Quien es el mejor corredor de formula 1?");
        ed.setR1("A) Checo perez");
        ed.setR2("B) Halminton");
        ed.setR3("C) Michael");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("4.- ¿Cuál es el río más largo del mundo?");
        ed.setR1("A) El Amazonas");
        ed.setR2("B) El Nilo");
        ed.setR3("C) El Mississippi");
        ed.setRc("A");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("5.- ¿Qué planeta es conocido como el planeta rojo?");
        ed.setR1("A) Venus");
        ed.setR2("B) Júpiter");
        ed.setR3("C) Marte");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("6.- ¿Quién pintó la Mona Lisa?");
        ed.setR1("A) Pablo Picasso");
        ed.setR2("B) Vincent van Gogh");
        ed.setR3("C) Leonardo da Vinci");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("7.- ¿Cuál es la moneda oficial de Japón?");
        ed.setR1("A) Dólar japonés");
        ed.setR2("B) Yuan chino");
        ed.setR3("C) Yen japonés");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("8.- ¿Cuál es el metal más abundante en la corteza terrestre?");
        ed.setR1("A) Oro");
        ed.setR2("B) Hierro");
        ed.setR3("C) Aluminio");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("9.- ¿En qué continente se encuentra la Gran Muralla China?");
        ed.setR1("A) Europa");
        ed.setR2("B) Asia");
        ed.setR3("C) África");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("10.- ¿Cuál es el país más grande del mundo en términos de superficie?");
        ed.setR1("A) Estados Unidos");
        ed.setR2("B) Canadá");
        ed.setR3("C) Rusia");
        ed.setRc("C");
        listadatos.add(ed);
        EstructuraDatos edm = listadatos.get(0);
        //Log.i("informacion", "valor: " + edm.getPregunta());
        txtpregunta.setText(edm.getPregunta());
        r1.setText(edm.getR1());
        r2.setText(edm.getR2());
        r3.setText(edm.getR3());

        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si se ha seleccionado una respuesta antes de avanzar
                String respuestaSeleccionada = obtenerRespuesta();
                if (respuestaSeleccionada != null) {
                    listadatos.get(currentIndex).setRespuestaSeleccionada(respuestaSeleccionada);
                }

                currentIndex++;

                if (currentIndex < listadatos.size()) {
                    EstructuraDatos nextQuestion = listadatos.get(currentIndex);
                    txtpregunta.setText(nextQuestion.getPregunta());
                    r1.setText(nextQuestion.getR1());
                    r2.setText(nextQuestion.getR2());
                    r3.setText(nextQuestion.getR3());

                    // Limpia la selección de respuestas
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                }
            }
        });

        btnant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex--;

                if (currentIndex >= 0 && currentIndex < listadatos.size()) {
                    EstructuraDatos previousQuestion = listadatos.get(currentIndex);
                    txtpregunta.setText(previousQuestion.getPregunta());
                    r1.setText(previousQuestion.getR1());
                    r2.setText(previousQuestion.getR2());
                    r3.setText(previousQuestion.getR3());

                    // Limpia la selección de respuestas
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                }
            }
        });


        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Califica la pregunta actual si se ha seleccionado una respuesta
                if (currentIndex >= 0 && currentIndex < listadatos.size()) {
                    EstructuraDatos preguntaActual = listadatos.get(currentIndex);
                    String respuestaSeleccionada = obtenerRespuesta();

                    if (respuestaSeleccionada != null) {
                        preguntaActual.setRespuestaSeleccionada(respuestaSeleccionada);
                    }
                }
                puntaje = 0; // Reinicia el puntaje cada vez que se califica
                respuestasCorrectas = 0; // Reinicia el contador de respuestas correctas

                // Califica todas las preguntas y cuenta las respuestas correctas
                for (EstructuraDatos pregunta : listadatos) {
                    String respuestaSeleccionadaPregunta = pregunta.getRespuestaSeleccionada();

                    if (respuestaSeleccionadaPregunta != null) {
                        if (respuestaSeleccionadaPregunta.equals(pregunta.getRc())) {
                            // Respuesta correcta
                            puntaje++; // Aumenta el puntaje
                            respuestasCorrectas++;
                        }
                    }
                }
                Toast.makeText(PrincipalActivity.this, "Puntaje total: " + puntaje + " de 10 preguntas. Respuestas correctas: " + respuestasCorrectas, Toast.LENGTH_LONG).show();
            }
        });
    }

    private String obtenerRespuesta() {
        if (r1.isChecked()) {
            return "A";
        } else if (r2.isChecked()) {
            return "B";
        } else if (r3.isChecked()) {
            return "C";
        } else {
            return null; // Ninguna respuesta seleccionada
        }
    }

}