package android.example.demobasiclistview;

import android.example.demobasiclistview.adapter.CanBoAdapter;
import android.example.demobasiclistview.adapter.DonViAdapter;
import android.example.demobasiclistview.dao.implement.CanBoDao;
import android.example.demobasiclistview.dao.implement.DonViDao;
import android.example.demobasiclistview.model.CanBo;
import android.example.demobasiclistview.model.DonVi;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CanBoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CanBoAdapter canBoAdapter;
    private CanBoDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_can_bo);

        recyclerView = findViewById(R.id.rv_canbo);
        dao = new CanBoDao(this);
        dao.insert(new CanBo("Cán bộ 11", "Giáo viên", "01234556789", "Vĩnh Phúc", "Kinh tế"));
        canBoAdapter = new CanBoAdapter(dao.getAll());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(canBoAdapter);
    }
}