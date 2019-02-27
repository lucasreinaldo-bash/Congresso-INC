package vostore.congressoinc2019;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import vostore.congressoinc2019.Firebase.ConfiguracaoFirebase;

public class QRMenu extends AppCompatActivity   {

    private Button btn_gerar_qr, btn_concluir_qr,btn_home,btn_voltar;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private AHBottomNavigation mNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        btn_gerar_qr = findViewById(R.id.btn_gerar_qr);
        btn_concluir_qr = findViewById(R.id.btn_concluir_qr);
        btn_home = findViewById(R.id.btn_home);
        btn_voltar = findViewById(R.id.btn_voltar);


        //Firebase
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        databaseReference = database.getReference("Usuario/" + currentUser.getUid());



        btn_concluir_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRMenu.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btn_gerar_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAccountValid();
            }
        });

    }

    @Override
    public void onBackPressed () {

        Intent intent = new Intent(QRMenu.this, Menu.class);
        startActivity(intent);
        finish();

    }
    private void isAccountValid() {
        String uid = mAuth.getCurrentUser().getUid();
        DatabaseReference databaseReference = ConfiguracaoFirebase.getFirebase().child("Usuario").child(uid);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("situacaoCadastro").getValue() == null)
                    Toast.makeText(QRMenu.this, "Null", Toast.LENGTH_SHORT).show();
                else {
                    Boolean accountChecked = Boolean.parseBoolean(dataSnapshot.child("situacaoCadastro").getValue().toString());
                    if (!accountChecked) {
                        Toast.makeText(QRMenu.this, "O seu cadastro não foi validado!", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(QRMenu.this, QRConfirmado.class);
                        startActivity(intent);
                        finish();



                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
