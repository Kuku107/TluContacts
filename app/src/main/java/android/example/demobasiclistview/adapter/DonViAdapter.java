package android.example.demobasiclistview.adapter;


import android.content.Context;
import android.example.demobasiclistview.R;
import android.example.demobasiclistview.model.DonVi;
import android.example.demobasiclistview.utils.OnItemClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DonViAdapter extends RecyclerView.Adapter<DonViAdapter.DonViViewHolder> {
    private List<DonVi> donViList;
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(DonVi donVi);
    }

    public DonViAdapter(Context context, List<DonVi> donViList) {
        this.donViList = donViList;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public DonViViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_don_vi, parent, false);
        return new DonViViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonViViewHolder holder, int position) {
        DonVi donVi = donViList.get(position);
        holder.tvTenDonVi.setText(donVi.getName());
        holder.tvSDT.setText(donVi.getPhoneNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(donVi);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (donViList == null) return 0;
        return donViList.size();
    }

    class DonViViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTenDonVi;
        private TextView tvSDT;
        public DonViViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenDonVi = itemView.findViewById(R.id.tv_TenDonVi);
            tvSDT = itemView.findViewById(R.id.tv_SDT_DonVi);
        }
    }
}
