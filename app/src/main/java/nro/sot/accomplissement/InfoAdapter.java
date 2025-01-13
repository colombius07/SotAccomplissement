package nro.sot.accomplissement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {

    private List<PromotionDetail> promotionDetails;

    public InfoAdapter(List<PromotionDetail> promotionDetails) {
        this.promotionDetails = promotionDetails;
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
        PromotionDetail currentItem = promotionDetails.get(position);
        holder.tvTitle.setText(currentItem.getFullName());
        holder.tvDescription.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return promotionDetails.size();
    }

    public static class InfoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription;

        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            // Récupération des TextViews par leur ID
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
