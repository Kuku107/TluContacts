package android.example.demobasiclistview;

import android.example.demobasiclistview.adapter.DonViAdapter;
import android.example.demobasiclistview.dao.implement.DonViDao;
import android.example.demobasiclistview.model.CanBo;
import android.example.demobasiclistview.model.DonVi;
import android.example.demobasiclistview.utils.OnItemClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DonViActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView recyclerView;
    private DonViAdapter donViAdapter;
    private DonViDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_don_vi);

        recyclerView = findViewById(R.id.rv_donvi);
        dao = new DonViDao(this);
        donViAdapter = new DonViAdapter(dao.getAll(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(donViAdapter);
    }

    @Override
    public void onItemClick(int position) {
        DonVi donVi = dao.getAll().get(position);
        Toast.makeText(this, donVi.getName(), Toast.LENGTH_SHORT).show();
    }
}