package vostore.congressoinc2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.ArrayList;
import java.util.List;


import vostore.congressoinc2019.Firebase.ConfiguracaoFirebase;
import vostore.congressoinc2019.Firebase.Usuario;


public class Registro extends AppCompatActivity {

    private Button btnInsta, btnFace,btnLinke,btnVerQr,btnConcluirInscricao;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Button btnRegistrar, btnPalestrante,btnParticipante;
    private EditText txtNome,txtEmail,txtCpf,txtNomeProfissional,txtFormacao,txtNacionalidade,txtInformacaoComplementar;
    private EditText txtSenha;
    private LinearLayout linear_curriculo;
    private String tipoDoUsuario,cpfValido;
    private DatabaseReference reference, referenciaCPF;
    private DatabaseReference dref = FirebaseDatabase.getInstance().getReference().child("CPF");

    private List<CPF> listCPF = new ArrayList<CPF>();
    private ArrayAdapter<CPF> arrayAdapter ;
    private String situacaoCadastro = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       inicializarFirebase();
        //verificarUsuarioLogado();
      //verificarUsuarioLogado();
        txtNome = (EditText) findViewById(R.id.nome_id);
        txtEmail = (EditText) findViewById(R.id.email_id);


        //Redes Sociais
        btnInsta = findViewById(R.id.btn_insta);
        btnFace = findViewById(R.id.btn_face);
        btnLinke = findViewById(R.id.btn_in);

       // txtSenha = (EditText) findViewById(R.id.rg_senha);
        //txtSenhaRepetida = (EditText) findViewById(R.id.rg_contrasenha);
        btnRegistrar = (Button) findViewById(R.id.btn_login);








        btnInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registro.this, Site.class);
                intent.putExtra("site","https://www.instagram.com/hospital_inc/");
                startActivity(intent);
                finish();
            }
        });
        btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registro.this, Site.class);
                intent.putExtra("site","https://www.facebook.com/InstitutoDeNeurologiaDeCuritiba/?ref=br_rs");
                startActivity(intent);
                finish();
            }
        });
        btnLinke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registro.this, Site.class);
                intent.putExtra("site","https://br.linkedin.com/company/hospitalinc");
                startActivity(intent);
                finish();
            }
        });



        // Instaciando o servidor
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();



        //Carregando Banco de Dados

        FirebaseUser currentUser = mAuth.getCurrentUser();




        // Adicionando evento ao click do botão





        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = txtEmail.getText().toString();
                final String nomecompleto = txtNome.getText().toString();
                final String nome = txtNome.getText().toString();
                final String cpf = "04486557565";
                final String senhausuario = "000000";

                if(isValidEmail(email) && validarContraseña() && validarNombre(nome)){
                    final String senha = "000000";
                    final Boolean status = false;
                    mAuth.createUserWithEmailAndPassword(email, senha)
                            .addOnCompleteListener(Registro.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {


                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(Registro.this, "Registro Confirmado. Seja-bem vindo!", Toast.LENGTH_SHORT).show();
                                        Usuario usuario = new Usuario();
                                        usuario.setEmail(email);
                                        usuario.setNome(nome);
                                        usuario.setSituacaoCadastro(situacaoCadastro);
                                        FirebaseUser currentUser = mAuth.getCurrentUser();
                                        DatabaseReference reference = database.getReference("Usuario/"+currentUser.getUid());
                                        reference.setValue(usuario);
                                        Intent intent = new Intent(Registro.this, Menu.class);
                                        String nomeUsuario = usuario.getNome();
                                        String emailUsuario = usuario.getEmail();
                                        intent.putExtra("nomeUsuario",nomeUsuario);
                                        intent.putExtra("emailUsuario",emailUsuario);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(Registro.this, "Erro ao fazer o registro", Toast.LENGTH_SHORT).show();
                                        Log.i("CreateUser", "Erro ao cadastrar usuário! ", task.getException());
                                    }
                                }
                            });
                }else{
                    Toast.makeText(Registro.this, "Algum erro foi detectado! Está com internet ?", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    private void verificarUsuarioLogado(){
        mAuth = ConfiguracaoFirebase.getFirebaseAutenticacao();
        if(mAuth.getCurrentUser()!= null ){
            Intent intent = new Intent(Registro.this, Menu.class);
            startActivity(intent);
            finish();
        }
    }
    //método para validar e-mail
    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    //método para validar senha
    public boolean validarContraseña(){
        String contraseña;
        String validar;
        contraseña = "000000";
        validar = "000000";
        if(contraseña.equals(validar)){
            if(contraseña.length()>=6 && contraseña.length()<=16){
                return true;
            }else return false;
        }else return false;
    }
    //método para validar nome
    public boolean validarNombre(String nombre){
        return !nombre.isEmpty();
    }


    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Registro.this, Splash.class);
        startActivity(intent);
        finish();


    }


    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

}
