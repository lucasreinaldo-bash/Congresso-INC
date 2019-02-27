package vostore.congressoinc2019;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
import vostore.congressoinc2019.Firebase.Usuario;

public class QRConfirmado extends AppCompatActivity  implements  Runnable {

    private ImageView qrCode;
    private String tipoDoUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String cpfUsuario;
    private String informacoesParaQr;
    private Button gerar,btn_home,btn_voltar;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private EditText cpf;

    MultiFormatWriter multi = new MultiFormatWriter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrconfirmado);
        inicializarFirebase();

        qrCode = findViewById(R.id.id_qr_confirmado);
        btn_home = findViewById(R.id.btn_home);
        btn_voltar = findViewById(R.id.btn_voltar);
        // Instaciando o servidor
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        isAccountValid();




        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QRConfirmado.this, Menu.class));
                finish();
            }
        });
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Handler handler = new Handler();
        handler.postDelayed(this, 100000);
    }

    public void run() {
        startActivity(new Intent(this, Menu.class));
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void isAccountValid() {
        String uid = mAuth.getCurrentUser().getUid();
        DatabaseReference databaseReference = ConfiguracaoFirebase.getFirebase().child("Usuario").child(uid);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null)
                    Toast.makeText(QRConfirmado.this, "Null", Toast.LENGTH_SHORT).show();
                else {
                     nomeUsuario = dataSnapshot.child("nome").getValue().toString();
                     emailUsuario = dataSnapshot.child("email").getValue().toString();
                     cpfUsuario = dataSnapshot.child("CPF").getValue().toString();


                    informacoesParaQr = "Nome Completo:" + nomeUsuario + "\n" + "E-mail: " + emailUsuario + "\n" + "CPF: " + cpfUsuario;

                    try {
                        BitMatrix bitMatrix = multi.encode(informacoesParaQr, BarcodeFormat.QR_CODE, 300, 300);
                        BarcodeEncoder encoder = new BarcodeEncoder();
                        Bitmap bitmap = encoder.createBitmap(bitMatrix);
                        qrCode.setImageBitmap(bitmap);
                        // Toast.makeText(MainActivity.this, "Deu certo!", Toast.LENGTH_SHORT).show();
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    @Override
    public void onBackPressed () {

        Intent intent = new Intent(QRConfirmado.this, Menu.class);
        startActivity(intent);
        finish();

    }
}
