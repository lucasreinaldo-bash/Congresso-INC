package vostore.congressoinc2019;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.ValueEventListener;

import vostore.congressoinc2019.Firebase.ConfiguracaoFirebase;

public class CPF {

    private String CPF;


    public CPF() {
    }

    public String getCPF() {
        return CPF;
    }
}