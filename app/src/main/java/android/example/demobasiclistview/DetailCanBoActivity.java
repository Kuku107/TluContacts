package android.example.demobasiclistview;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.example.demobasiclistview.model.CanBo;
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

public class DetailCanBoActivity extends AppCompatActivity {

    private ImageButton ibBack;
    private EditText edtName, edtRole, edtPhone, edtEmail, edtDivision;
    private Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_can_bo);

        ibBack = findViewById(R.id.ib_back_from_canbo);
        edtName = findViewById(R.id.edt_canbo_name);
        edtRole = findViewById(R.id.edt_canbo_role);
        edtPhone = findViewById(R.id.edt_canbo_phoneNumber);
        edtEmail = findViewById(R.id.edt_canbo_email);
        edtDivision = findViewById(R.id.edt_canbo_division);
        btnCall = findViewById(R.id.btn_canbo_call);

        CanBo canBo = (CanBo) getIntent().getSerializableExtra("canBo");
        if (canBo != null) {
            edtName.setText(canBo.getName());
            edtRole.setText(canBo.getRole());
            edtPhone.setText(canBo.getPhoneNumber());
            edtEmail.setText(canBo.getEmail());
            edtDivision.setText(canBo.getDonvi());

            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + edtPhone.getText().toString()));
                    if (ActivityCompat.checkSelfPermission(DetailCanBoActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(DetailCanBoActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
                        return;
                    }
                    startActivity(callIntent);
                    Toast.makeText(DetailCanBoActivity.this, "Calling", Toast.LENGTH_SHORT).show();
                }
            });
        }

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(DetailCanBoActivity.this, "Back", Toast.LENGTH_SHORT).show();
            }
        });
    }
}