package guc.thermonitorr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class DetailsActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart(){
        super.onStart();
        if(firebaseAuth.getCurrentUser()==null){
            Intent intent= new Intent(getApplicationContext(),loginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
