package android.example.demobasiclistview.adapter;

import android.example.demobasiclistview.R;
import android.example.demobasiclistview.model.CanBo;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CanBoAdapter extends RecyclerView.Adapter<CanBoAdapter.CanBoHolder> {

    private List<CanBo> canBoList;

    public CanBoAdapter(List<CanBo> canBoList) {
        this.canBoList = canBoList;
    }

    @NonNull
    @Override
    public CanBoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_don_vi, parent, false);
        return new CanBoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CanBoHolder holder, int position) {
        CanBo canBo = canBoList.get(position);
        holder.tvTenCanBo.setText(canBo.getName());
        holder.tvSDT.setText(canBo.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        if (canBoList == null) return 0;
        return canBoList.size();
    }

    class CanBoHolder extends RecyclerView.ViewHolder {
        private TextView tvTenCanBo;
        private TextView tvSDT;
        public CanBoHolder(@NonNull View itemView) {
            super(itemView);
            tvTenCanBo = itemView.findViewById(R.id.tv_TenDonVi);
            tvSDT = itemView.findViewById(R.id.tv_SDT_DonVi);
        }
    }
}
