package com.example.fy_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fy_project.Models.QuestionOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TakeATestActivity extends AppCompatActivity {

    DrawerLayout drawerLayout ;
    NavigationView navigationView;
    ImageView menu_btn;
    TextView nav_user_fullname,nav_user_email;

    CardView test1;

    FirebaseAuth firebaseAuth;
    DatabaseReference user_ref;

    final LoadingDialog loadingDialog = new LoadingDialog(TakeATestActivity.this);

    public static ArrayList<QuestionOptions> listOfQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_atest);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.LEFT);
        navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        menu_btn = findViewById(R.id.menu_btn);
        nav_user_fullname = headerView.findViewById(R.id.nav_user_fullname);
        nav_user_email = headerView.findViewById(R.id.nav_user_email);

        test1 = findViewById(R.id.test1);

        firebaseAuth = FirebaseAuth.getInstance();
        user_ref = FirebaseDatabase.getInstance().getReference();


        user_ref.child("Users").child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String username = snapshot.child("fullname").getValue(String.class);
                String useremail = snapshot.child("email").getValue(String.class);
                nav_user_fullname.setText(username);
                nav_user_email.setText(useremail);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //menu btn click
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        //navigation item select
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:{
                        Intent intent_home = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent_home);
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    }
                    case R.id.experts:{
                        Intent intent_experts = new Intent(getApplicationContext(),PsychiatristActivity.class);
                        startActivity(intent_experts);
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    }
                    case R.id.settings:{
                        Intent intent_setting = new Intent(getApplicationContext(),SettingsActivity.class);
                        startActivity(intent_setting);
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;

                    }
                    case R.id.test:{
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;

                    }
                    case R.id.logout:{
                        //dialog start
                        loadingDialog.startLoadingDialog();
                        firebaseAuth.signOut();
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        //dialog stop
                        loadingDialog.dismissDialog();
                        break;
                    }

                }

                return false;
            }
        });


        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TestActivity.class);
                startActivity(intent);
            }
        });




        //static data
        listOfQ = new ArrayList<>();
        // questions of round 1
        listOfQ.add(new QuestionOptions("Over the past few weeks, how often have you felt that everything you did was an effort?","Not at all","No more than usual","Rather more than usual","Much more than usual",0,1,2,3, "Depression"));
        listOfQ.add(new QuestionOptions("Have you recently been able to enjoy your normal day-to-day activities?","More so than usual","Same as usual","Less than usual","Much less than usual",0,1,2,3, "Depression"));
        listOfQ.add(new QuestionOptions("Over the past two weeks, how often have you felt nervous and anxious?","Not at all","Occasionally","Often","Most of the time",0,1,2,3, "Anxiety"));
        listOfQ.add(new QuestionOptions("Have you recently been able to concentrate on whatever you're doing?","As well as usual","Not quite as well as usual","Only a little","Hardly at all",0,1,2,3, "Anxiety"));
        listOfQ.add(new QuestionOptions("How frequently have you noticed changes in your energy levels, such as feeling unusually energetic or lethargic?","No more than usual","Not quite as much as usual","Rather more than usual","Much more than usual",0,1,2,3, "Bipolar Disorder"));
        listOfQ.add(new QuestionOptions("Have you recently been feeling unhappy and depressed?","Not at all","No more than usual","Rather more than usual","Much more than usual",0,1,2,3, "Depression"));
        listOfQ.add(new QuestionOptions("How often do you find yourself avoiding certain situations or activities due to anxiety or fear?","Never","Rarely","Occasionally","Frequently",0,1,2,3, "Anxiety"));
        listOfQ.add(new QuestionOptions("Have you recently been able to face up to your problems?","As well as usual","Not quite as well as usual","Only a little","Hardly at all",0,1,2,3, "Anxiety"));
        listOfQ.add(new QuestionOptions("How frequently do you experience thoughts that you would be better off dead or of hurting yourself in some way?","Never","Rarely","Occasionally","Often",0,1,2,3, "Depression"));
        listOfQ.add(new QuestionOptions("Over the past two weeks, how often have you been bothered by persistent, unwanted thoughts or repetitive behaviors?","Not at all","Several days","More than half the days","Nearly every day",0,1,2,3, "OCD"));
        listOfQ.add(new QuestionOptions("Have you recently been able to make decisions about things?","As well as usual","Not quite as well as usual","Only a little","Hardly at all",0,1,2,3, "Depression"));
        listOfQ.add(new QuestionOptions("How often have you found yourself experiencing periods of heightened irritability or impulsive behavior?","Not at all","Occasionally","Often","Very often",0,1,2,3, "Bipolar Disorder"));


    }





    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
    }
}




















