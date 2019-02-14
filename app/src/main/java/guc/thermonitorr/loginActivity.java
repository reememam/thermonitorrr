package guc.thermonitorr;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    Button b1;
    EditText e1, e2;
    Button b2;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.register);
        e1 = findViewById(R.id.editTextEmail);
        e2 = findViewById(R.id.edtTextPass);
        b2=findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();


        b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                    startActivity(intent);;
                }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String email = e1.getText().toString().trim();
              String pass = e2.getText().toString().trim();
              if(email.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Email",Toast.LENGTH_SHORT).show();


                }
                else if(pass.isEmpty() || pass.length()<6){
                    Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();

                }
                else{
                  mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                              Intent intent = new Intent(getApplicationContext(),ListActivity.class);
                              startActivity(intent);
                              finish();
                          }
                          else{
                              Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                          }

                      }
                  });
              }
            }
        });


    }
    @Override
    public void onStart(){
        super.onStart();
        if(mAuth.getCurrentUser()!=null){
            Intent intent= new Intent(getApplicationContext(),ListActivity.class);
            startActivity(intent);
            finish();
        }

    }
}