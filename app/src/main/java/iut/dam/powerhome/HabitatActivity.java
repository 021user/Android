package iut.dam.powerhome;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HabitatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HabitatAdapter adapter;
    private List<Habitat> habitats;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_habitat);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.habitatLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        habitats = new ArrayList<>();
        habitats.add(new Habitat("gaëtan leclair", Arrays.asList(R.drawable.ic_aspirateur, R.drawable.ic_machine_a_laver, R.drawable.ic_fer_a_repasser, R.drawable.ic_climatiseur),1));
        habitats.add(new Habitat("cédric boudet",  Arrays.asList(R.drawable.ic_aspirateur),2));
        habitats.add(new Habitat("gaylord thibodeaux", Arrays.asList(R.drawable.ic_climatiseur, R.drawable.ic_machine_a_laver), 3));
        habitats.add(new Habitat("adam jacquinot", Arrays.asList(R.drawable.ic_aspirateur, R.drawable.ic_machine_a_laver, R.drawable.ic_fer_a_repasser), 4));
        habitats.add(new Habitat("abel fresnel", Arrays.asList(R.drawable.ic_machine_a_laver), 5));

        Log.d("RecyclerView", "nombre d'éléments : " + habitats.size()); // vérification des données

        adapter = new HabitatAdapter(habitats);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged(); // mise à jour des données
    }
}
