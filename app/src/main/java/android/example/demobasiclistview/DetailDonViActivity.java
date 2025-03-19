package android.example.demobasiclistview;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.example.demobasiclistview.model.DonVi;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailDonViActivity extends AppCompatActivity {

    private ImageButton btnBack;
    private EditText edtName, edtPhone, edtAddress;
    private Button btnCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_don_vi);

        btnBack = findViewById(R.id.ib_back_from_donvi);
        edtName = findViewById(R.id.edt_donvi_name);
        edtPhone = findViewById(R.id.edt_donvi_phoneNumber);
        edtAddress = findViewById(R.id.edt_donvi_address);
        btnCall = findViewById(R.id.btn_donvi_call);

        DonVi donVi = (DonVi) getIntent().getSerializableExtra("donVi");

        if (donVi != null) {
            edtName.setText(donVi.getName());
            edtPhone.setText(donVi.getPhoneNumber());
            edtAddress.setText(donVi.getAddress());

            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + edtPhone.getText().toString()));
                    if (ActivityCompat.checkSelfPermission(DetailDonViActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(DetailDonViActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
                        return;
                    }
                    startActivity(callIntent);
                    Toast.makeText(DetailDonViActivity.this, "Calling", Toast.LENGTH_SHORT).show();
                }
            });
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}