package nro.sot.accomplissement;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Call;
import okhttp3.Callback;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PromotionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Charger les promotions
        fetchPromotions();
    }

    private void fetchPromotions() {
        OkHttpClient client = new OkHttpClient();

        // URL de l'API qui retourne la liste des promotions
        String url = "http://sotapi.jaajeur.xyz/api/v1/promotions/";

        // Créer la requête
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Exécuter la requête
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "API Request Failed", Toast.LENGTH_SHORT).show());
                Log.e("API_ERROR", "Failed to fetch promotions", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    // Récupérer la réponse JSON de l'API
                    String responseBody = response.body().string();
                    Log.d("API_RESPONSE", "Promotions: " + responseBody);

                    // Convertir le JSON en liste d'objets
                    Gson gson = new Gson();
                    List<String> promotions = gson.fromJson(responseBody, List.class);

                    // Passer les promotions au thread principal pour les afficher
                    runOnUiThread(() -> {
                        adapter = new PromotionsAdapter(promotions);
                        recyclerView.setAdapter(adapter);
                    });
                } else {
                    runOnUiThread(() -> Toast.makeText(MainActivity.this, "Failed to get promotions", Toast.LENGTH_SHORT).show());
                    Log.e("API_ERROR", "Error fetching promotions: " + response.code());
                }
            }
        });
    }
}
