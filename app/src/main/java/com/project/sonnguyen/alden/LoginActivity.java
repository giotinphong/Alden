package com.project.sonnguyen.alden;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.sonnguyen.alden.data.StudentInformation;

public class LoginActivity extends AppCompatActivity {

    public static String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        final EditText txtCode = (EditText)findViewById(R.id.acti_login_edittext_usercode);
        Button btnLogin = (Button)findViewById(R.id.acti_login_button_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                     code = (txtCode.getText().toString());
                    if(code.equals("")){
                        Toast.makeText(getApplicationContext(),"Hãy nhập code",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
                    mRef.child("StudentInformation").child(code).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            StudentInformation stinf = dataSnapshot.getValue(StudentInformation.class);
                            if(stinf!=null){
                                Intent in = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(in);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Sai code",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(getApplicationContext(),"Sai code,code phải là số",Toast.LENGTH_SHORT).show();
                        }
                    });
                }catch (Exception e ){

                }
                //startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
}
