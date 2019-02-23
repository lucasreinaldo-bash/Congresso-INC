package vostore.congressoinc2019;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity  implements  Runnable {

    private ImageView qrCode;
    private String tipoDoUsuario;
    private String nomeUsuario;
    private String cpfUsuario;
    private String emailUsuario;
    private String informacoesParaQr;
    private Button gerar;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private EditText cpf;

    MultiFormatWriter multi = new MultiFormatWriter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarFirebase();

        qrCode = findViewById(R.id.id_qr);
        cpf = findViewById(R.id.cpf_id);
        gerar = findViewById(R.id.btn_gerar);


        // Instaciando o servidor
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();





        Toast.makeText(this, informacoesParaQr, Toast.LENGTH_SHORT).show();


        gerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FirebaseUser currentUser = mAuth.getCurrentUser();
                DatabaseReference reference = database.getReference("Usuario/" + currentUser.getUid());
                String cpfDigitado = cpf.getText().toString();
                cpfValidar();
               isAccountValid();




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
                if (dataSnapshot.child("situacaoCadastro").getValue() == null)
                    Toast.makeText(MainActivity.this, "Null", Toast.LENGTH_SHORT).show();
                else {
                    Boolean accountChecked = Boolean.parseBoolean(dataSnapshot.child("situacaoCadastro").getValue().toString());
                    if (!accountChecked) {
                        Toast.makeText(MainActivity.this, "O CPF informado não se encontra na lista de inscrições confirmadas.", Toast.LENGTH_SHORT).show();
                    }
                    else{
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
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    } private void cpfValidar() {
        final String cpfDigitado = cpf.getText().toString();
        final String uid = mAuth.getCurrentUser().getUid();
        final Usuario user2 = new Usuario();
        DatabaseReference databaseReference = ConfiguracaoFirebase.getFirebase().child("CPF");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(cpfDigitado).getValue() == null) {

                    //Toast.makeText(MainActivity.this, "CPF não cadastrado", Toast.LENGTH_SHORT).show();
                } else {
                    user2.setSituacaoCadastro("true");
                    DatabaseReference reference = database.getReference("Usuario/" + uid);
                    reference.child("situacaoCadastro").setValue("true");
                    reference.child("CPF").setValue(cpfDigitado);


                    Toast.makeText(MainActivity.this, "QR-CODE gerado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    @Override
    public void onBackPressed () {

        Intent intent = new Intent(MainActivity.this, Menu.class);
        startActivity(intent);
        finish();

    }
}
