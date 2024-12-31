package nro.sot.accomplissement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {

    private List<InfoItem> infoList;

    public InfoAdapter(List<InfoItem> infoList) {
        this.infoList = infoList;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_info, parent, false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        InfoItem currentItem = infoList.get(position);
        holder.tvTitre.setText(currentItem.getTitre());
        holder.tvDescription.setText(currentItem.getDescription());
        holder.tvAstuce.setText(currentItem.getAstuce());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public static class InfoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitre, tvDescription, tvAstuce;

        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitre = itemView.findViewById(R.id.tvTitre);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvAstuce = itemView.findViewById(R.id.tvAstuce);
        }
    }
}
