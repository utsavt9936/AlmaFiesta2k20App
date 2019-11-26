package com.example.almafiesta2k20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class authActivity extends AppCompatActivity {


    private static final int RC_SIGN_IN = 234;

    //Tag for the logs optional
    private static final String TAG = "simplifiedCoding";

    //creating a GoogleSignInClient object
    GoogleSignInClient mGoogleSignInClient;

    //And also a Firebase Auth object
    FirebaseAuth mAuth;


    @Override
    protected void onStart() {



         nameDbHelper mHelper=new nameDbHelper(this);
        final  SQLiteDatabase db= mHelper.getReadableDatabase();
        String[] projection={"name"};
        Cursor cursor=db.query("login",projection,null,null,null,null,null);



        FirebaseUser currentUser=mAuth.getCurrentUser();



        if (currentUser!= null) {

            ImageView imv=(ImageView) findViewById(R.id.authImg);
            Uri photoUrl = currentUser.getPhotoUrl();
            Picasso.with(this).load(photoUrl).into(imv);
            TextView tmv=(TextView) findViewById(R.id.autName);
            tmv.setText(currentUser.getDisplayName());

            Button btn=(Button)findViewById(R.id.lgButton);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseAuth.getInstance().signOut();
                    db.delete("login",null,null);
                    finish();
                    startActivity(new Intent(authActivity.this,SplashScreenActivity.class));
                }
            });




        }
        else if(cursor.getCount()>0)
        {

            TextView nameView=(TextView)findViewById(R.id.autName);
            cursor.moveToFirst();
            nameView.setText(cursor.getString(cursor.getColumnIndex("name")));

            Button btn=(Button)findViewById(R.id.lgButton);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.delete("login",null,null);
                    finish();
                    startActivity(new Intent(authActivity.this,SplashScreenActivity.class));
                }
            });

        }





        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean b=cm.getActiveNetworkInfo()!= null && cm.getActiveNetworkInfo().isConnected();
        if(b!=true)
            Toast.makeText(this,"No Internet, Continue as Guest",Toast.LENGTH_SHORT).show();



        mAuth = FirebaseAuth.getInstance();

        //Then we need a GoogleSignInOptions object
        //And we need to build it as below
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);




    }
}
