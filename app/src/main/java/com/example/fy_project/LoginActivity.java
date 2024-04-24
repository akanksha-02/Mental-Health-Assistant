package com.example.fy_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {


    TextView login_btn, signup_btn, google_btn;
    TextView title1,title2;

    EditText user_email,user_password;


    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    GoogleSignInClient googleSignInClient;
    int RC_SIGN_IN = 20;


    final LoadingDialog loadingDialog = new LoadingDialog(LoginActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn = findViewById(R.id.login_btn);
        signup_btn = findViewById(R.id.signup_btn);
        google_btn = findViewById(R.id.google_sign_btn);
        user_email = findViewById(R.id.user_email);
        user_password = findViewById(R.id.user_password);
        title1 = findViewById(R.id.tv1);
        title2 = findViewById(R.id.tv2);

        //firebase
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        //login click
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //dialog start
                loadingDialog.startLoadingDialog();

                firebaseAuth.signInWithEmailAndPassword(user_email.getText().toString(),user_password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                            //dialog stop
                            loadingDialog.dismissDialog();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            //dialog stop
                            loadingDialog.dismissDialog();
                        }
                    }
                });

            }
        });


        //signup click
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);


                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View,String>(login_btn,"next_btn");
                pairs[1] = new Pair<View,String>(signup_btn,"prev_btn");
                pairs[2] = new Pair<View,String>(user_email,"email_et");
                pairs[3] = new Pair<View,String>(user_password,"password_et");
                pairs[4] = new Pair<View,String>(google_btn,"google_btn");
                pairs[5] = new Pair<View,String>(title1,"title1");
                pairs[6] = new Pair<View,String>(title2,"title2");



                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
                startActivity(intent,options.toBundle());
            }
        });

        //google sign-in
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();

        googleSignInClient = GoogleSignIn.getClient(this,gso);

        google_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignIn();
            }
        });

    }

    private void googleSignIn() {

        Intent intent = googleSignInClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==RC_SIGN_IN){

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try{
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());
            }
            catch (Exception e){

                Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();;

            }
        }
    }

    private void firebaseAuth(String idToken) {

        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();

                            HashMap<String, Object> map = new HashMap<>();
                            map.put("id", user.getUid());
                            map.put("name", user.getDisplayName());
                            map.put("profile", user.getPhotoUrl().toString());

                            database.getReference().child("users").child(user.getUid()).setValue(map);

                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                            //dialog stop
                            loadingDialog.dismissDialog();
                        }

                        else{
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            //dialog stop
                            loadingDialog.dismissDialog();
                        }
                        }


                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}