package iut.dam.powerhome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HabitatAdapter extends RecyclerView.Adapter<HabitatAdapter.ViewHolder> {
    private List<Habitat> items;

    public HabitatAdapter(List<Habitat> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_habitat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Habitat habitat = items.get(position);
        holder.nameTV.setText(habitat.getProprio());
        holder.floor.setText(String.valueOf(habitat.getEtage()));

        int equipementCount = habitat.getEquipements().size();
        holder.equipementCountTV.setText(equipementCount + (equipementCount > 1 ? " équipements" : " équipement"));

        // nettoyage des anciennes icônes
        holder.equipementContainer.removeAllViews();

        // ajout des icônes d'équipement
        for (int iconRes : habitat.getEquipements()) {
            ImageView imageView = new ImageView(holder.itemView.getContext());
            imageView.setImageResource(iconRes);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(50, 50)); // taille icône
            imageView.setPadding(4, 4, 4, 4);
            holder.equipementContainer.addView(imageView);
        }

        // action au clic
        holder.itemView.setOnClickListener(view -> {
            String message = "propriétaire : " + habitat.getProprio();
            Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV, floor, equipementCountTV;
        LinearLayout equipementContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.proprio);
            floor = itemView.findViewById(R.id.etageNumber);
            equipementCountTV = itemView.findViewById(R.id.tvEquipementCount);
            equipementContainer = itemView.findViewById(R.id.equipmentContainer);
        }
    }
}
