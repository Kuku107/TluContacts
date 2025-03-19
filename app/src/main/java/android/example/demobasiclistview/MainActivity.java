package android.example.demobasiclistview;

import android.content.Intent;
import android.example.demobasiclistview.adapter.DonViAdapter;
import android.example.demobasiclistview.model.DonVi;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnDonVi;
    private Button btnCanBo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnDonVi = findViewById(R.id.btn_listDonVi);
        btnCanBo = findViewById(R.id.btn_listCanBo);

        btnDonVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DonViActivity.class);
                startActivity(intent);
            }
        });

        btnCanBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CanBoActivity.class);
                startActivity(intent);
            }
        });
    }
}