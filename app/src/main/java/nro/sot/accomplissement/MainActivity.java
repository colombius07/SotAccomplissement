package nro.sot.accomplissement;

import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private InfoAdapter adapter;
    private List<InfoItem> fullInfoList; // Liste complète
    private List<InfoItem> filteredInfoList; // Liste filtrée

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fullInfoList = loadDataFromResources(); // Charge les données depuis res/values/data.xml
        filteredInfoList = new ArrayList<>(fullInfoList);

        adapter = new InfoAdapter(filteredInfoList);
        recyclerView.setAdapter(adapter);

        setupSearchView();
    }

    private List<InfoItem> loadDataFromResources() {
        List<InfoItem> infoItems = new ArrayList<>();
        String[] rawData = getResources().getStringArray(R.array.info_items);

        for (String item : rawData) {
            String[] parts = item.split("\\|");
            String titre = "", description = "", astuce = "";

            for (String part : parts) {
                if (part.startsWith("Titre::")) {
                    titre = part.replace("Titre::", "");
                } else if (part.startsWith("Description::")) {
                    description = part.replace("Description::", "");
                } else if (part.startsWith("Astuce::")) {
                    astuce = part.replace("Astuce::", "");
                }
            }

            infoItems.add(new InfoItem(titre, description, astuce));
        }
        return infoItems;
    }

    private void setupSearchView() {
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterResults(newText);
                return true;
            }
        });
    }

    private void filterResults(String query) {
        filteredInfoList.clear();

        if (query.isEmpty()) {
            filteredInfoList.addAll(fullInfoList);
        } else {
            for (InfoItem item : fullInfoList) {
                if (item.getTitre().toLowerCase().contains(query.toLowerCase()) ||
                        item.getDescription().toLowerCase().contains(query.toLowerCase()) ||
                        item.getAstuce().toLowerCase().contains(query.toLowerCase())) {
                    filteredInfoList.add(item);
                }
            }
        }

        adapter.notifyDataSetChanged();
    }
}
