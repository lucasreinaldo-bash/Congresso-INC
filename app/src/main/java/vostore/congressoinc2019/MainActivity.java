package vostore.congressoinc2019;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    private ImageView qrCode;
    private    String tipoDoUsuario;
    private    String nomeUsuario;
    private   String emailUsuario;
    private   String informacoesParaQr;

    MultiFormatWriter multi = new MultiFormatWriter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        qrCode = findViewById(R.id.id_qr);



        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();

            if (extras == null) {
                Toast.makeText(this, "Houve um erro na transmissão dos dos dados", Toast.LENGTH_SHORT).show();
            } else {
                tipoDoUsuario = extras.getString("tipoDoUsuario");
                emailUsuario = extras.getString("emailUsuario");
                nomeUsuario = extras.getString("nomeUsuario");
            }
        }else{
            tipoDoUsuario = (String) savedInstanceState.getSerializable("tipoDoUsuario");
            emailUsuario = (String) savedInstanceState.getSerializable("emailUsuario");
            nomeUsuario = (String) savedInstanceState.getSerializable("nomeUsuario");
            }



            informacoesParaQr = "Nome Completo:" + nomeUsuario +"\n"+ "E-mail: "+ emailUsuario + "\n"+"Tipo de Cadastro: "+tipoDoUsuario;

        Toast.makeText(this, informacoesParaQr, Toast.LENGTH_SHORT).show();




        try {
            BitMatrix bitMatrix = multi.encode(informacoesParaQr, BarcodeFormat.QR_CODE, 300,300);
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(bitMatrix);
            qrCode.setImageBitmap(bitmap);
            Toast.makeText(MainActivity.this, "Deu certo!", Toast.LENGTH_SHORT).show();
        }
        catch (WriterException e ){
            e.printStackTrace();
        }
    }
}
