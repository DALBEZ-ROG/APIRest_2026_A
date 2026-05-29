package com.uteq.apirest_2026_a;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Supabase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supabase);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtAlumnos = findViewById(R.id.txtAlumnos);

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "https://vtctgskcxoadygvidavh.supabase.co/rest/v1/Alumnos",
                null,
                response -> {
                    try {
                        StringBuilder texto = new StringBuilder();

                        for (int i = 0; i < response.length(); i++){
                            JSONObject jsonAlumno = response.getJSONObject(i);
                            texto.append((i+1) + " " + jsonAlumno.optString("apellidos_nombres", "") + "\n");
                            texto.append("Cédula: " + jsonAlumno.optString("cedula", "") + "\n");
                            texto.append("Correo: " + jsonAlumno.optString("correo_institucional", "") + "\n\n");
                        }

                        txtAlumnos.setText(texto.toString());

                    } catch (Exception e) {
                        txtAlumnos.setText("Error procesando datos:\n" + e.getMessage());
                    }
                },
                //new ApiErrorListener(this)
                error -> txtAlumnos.setText("Error API:\n" + error.getMessage())
        ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                // Reemplaza con tu clave de Supabase (Settings > API > service_role key)
                String apiKey = "TU_SUPABASE_API_KEY";
                headers.put("apikey", apiKey);
                headers.put("Authorization", "Bearer " + apiKey);
                return headers;
            }
        };

        queue.add(request);

    }
}