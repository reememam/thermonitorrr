package guc.thermonitorr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ListActivity extends AppCompatActivity {
    private  String[] as={"SQL", "JAVA", "JAVASCRIPT", "C#","PYTHON","C++","PHP"};
    private ListView listView;
    private FirebaseAuth firebaseAuth;
    private Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        firebaseAuth = FirebaseAuth.getInstance();
        buttonLogout = findViewById(R.id.logout);

        if(firebaseAuth.getCurrentUser()==null) {
            finish();
            startActivity(new Intent(getApplicationContext(), DetailsActivity.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),as );
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
                startActivity(intent);

            }
        });
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                firebaseAuth.signOut();
                startActivity(intent);
            }
        });
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
