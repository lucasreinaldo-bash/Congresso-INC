package vostore.congressoinc2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import vostore.congressoinc2019.Firebase.Palestrante;
import vostore.congressoinc2019.Firebase.Usuario;


public class Registro extends AppCompatActivity {
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private Button btnRegistrar, btnPalestrante,btnParticipante;
    private EditText txtNome,txtEmail,txtNomeProfissional,txtFormacao,txtNacionalidade,txtInformacaoComplementar;
    private EditText txtSenha;
    private LinearLayout linear_curriculo;
    private String tipoDoUsuario;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseApp.initializeApp(this);
        //verificarUsuarioLogado();
        txtNome = (EditText) findViewById(R.id.nome_id);
        txtEmail = (EditText) findViewById(R.id.email_id);
        txtNomeProfissional = (EditText) findViewById(R.id.nome_profissional_id);
        txtFormacao = (EditText) findViewById(R.id.formacao_id);
        txtNacionalidade = (EditText) findViewById(R.id.nacionalidade_id);
        txtInformacaoComplementar = (EditText) findViewById(R.id.complementares_id);
       // txtSenha = (EditText) findViewById(R.id.rg_senha);
        //txtSenhaRepetida = (EditText) findViewById(R.id.rg_contrasenha);
        btnRegistrar = (Button) findViewById(R.id.btn_login);
        btnPalestrante = findViewById(R.id.id_palestrante);
        btnParticipante = findViewById(R.id.id_participante);
        linear_curriculo = findViewById(R.id.linear_curriculo_id);







        // Instaciando o servidor
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        // Adicionando evento ao click do botão


        btnPalestrante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPalestrante.setBackgroundResource(R.drawable.palestrante2);
                btnParticipante.setBackgroundResource(R.drawable.participante);
                Usuario usuario = new Usuario();
                usuario.setTipoUsuario("Palestrante");

                linear_curriculo.setVisibility(View.VISIBLE);



            }
        });
        btnParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnParticipante.setBackgroundResource(R.drawable.participante2);
                btnPalestrante.setBackgroundResource(R.drawable.palestrante);
                Usuario usuario = new Usuario();
                usuario.setTipoUsuario("Participante");

                linear_curriculo.setVisibility(View.GONE);
                txtNomeProfissional.setText("");
                txtFormacao.setText("");
                txtNacionalidade.setText("");
                txtInformacaoComplementar.setText("");
            }
        });


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = txtEmail.getText().toString();
                final String nomecompleto = txtNome.getText().toString();
                final String nome = txtNome.getText().toString();
                final String senhausuario = "000000";



                if(isValidEmail(email) && validarContraseña() && validarNombre(nome)){
                    final String senha = "000000";
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


                                        if (txtNomeProfissional.length() > 0) {
                                            usuario.setTipoUsuario("Palestrante");

                                            Palestrante palestrante = new Palestrante();
                                            palestrante.setNomeProfissional(txtNomeProfissional.getText().toString());
                                            palestrante.setNacionalidade(txtNacionalidade.getText().toString());
                                            palestrante.setFormacao(txtFormacao.getText().toString());
                                            palestrante.setInformacoesComplementares(txtInformacaoComplementar.getText().toString());

                                            FirebaseUser currentUser = mAuth.getCurrentUser();
                                            DatabaseReference reference = database.getReference("Palestrantes/"+txtNomeProfissional.getText().toString());
                                            reference.setValue(palestrante);
                                        }
                                        else{
                                            usuario.setTipoUsuario("Participante");
                                        }

                                        tipoDoUsuario = usuario.getTipoUsuario();
                                       // Toast.makeText(Registro.this, tipoDoUsuario, Toast.LENGTH_SHORT).show();

                                        FirebaseUser currentUser = mAuth.getCurrentUser();
                                        DatabaseReference reference = database.getReference("Usuario/"+currentUser.getUid());
                                        reference.setValue(usuario);
                                        Intent intent = new Intent(Registro.this, MainActivity.class);
                                        String nomeUsuario = usuario.getNome();
                                        String emailUsuario = usuario.getEmail();
                                        intent.putExtra("nomeUsuario",nomeUsuario);
                                        intent.putExtra("emailUsuario",emailUsuario);
                                        intent.putExtra("tipoDoUsuario",tipoDoUsuario);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(Registro.this, "Erro ao fazer o registro", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }else{
                    Toast.makeText(Registro.this, "Algum erro foi detectado! Está com internet ?", Toast.LENGTH_SHORT).show();
                }

            }
        });

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

}
