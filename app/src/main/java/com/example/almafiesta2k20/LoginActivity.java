package com.example.almafiesta2k20;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.core.utilities.Utilities;

import java.util.Timer;
import java.util.TimerTask;


public class LoginActivity extends AppCompatActivity {
    //a constant for detecting the login intent result
    private static final int RC_SIGN_IN = 234;

    //Tag for the logs optional
    private static final String TAG = "simplifiedcoding";

    //creating a GoogleSignInClient object
    GoogleSignInClient mGoogleSignInClient;

    //And also a Firebase Auth object
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean b=cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
        if(b!=true)
            Toast.makeText(this,"No Internet Continue as guest",Toast.LENGTH_SHORT).show();




nameDbHelper mHelper=new nameDbHelper(this);
        SQLiteDatabase db= mHelper.getReadableDatabase();
        String[] projection={"name"};
        Cursor cursor=db.query("login",projection,null,null,null,null,null);







        //first we intialized the FirebaseAuth object
        mAuth = FirebaseAuth.getInstance();

        //Then we need a GoogleSignInOptions object
        //And we need to build it as below
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //Then we will get the GoogleSignInClient object from GoogleSignIn class
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //Now we will attach a click listener to the sign_in_button
        //and inside onClick() method we are calling the signIn() method that will open
        //google sign in intent
        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        findViewById(R.id.guest_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guestIn();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        //if the user is already signed in
        //we will close this activity
        //and take the user to profile activity







        nameDbHelper mHelper=new nameDbHelper(this);
       final SQLiteDatabase db= mHelper.getReadableDatabase();
        String[] projection={"name"};
        Cursor cursor=db.query("login",projection,null,null,null,null,null);











        FirebaseUser currentUser=mAuth.getCurrentUser();
        if (currentUser!= null) {
            findViewById(R.id.guest_button).setVisibility(View.INVISIBLE);

            final Intent intent=new Intent(this, MainActivity.class);
            SignInButton sgnb=(SignInButton)findViewById(R.id.sign_in_button);
            sgnb.setVisibility(View.GONE);
            TextView nameView=(TextView)findViewById(R.id.nameText);
            nameView.setText(currentUser.getDisplayName());

            int secs = 2; // Delay in seconds

            Button button=(Button)findViewById(R.id.lgb);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseAuth.getInstance().signOut();
                    findViewById(R.id.guest_button).setVisibility(View.VISIBLE);
                    finish();


                    startActivity(getIntent());


                }
            });






        }
        else if(cursor.getCount()>0)
        {
            findViewById(R.id.guest_button).setVisibility(View.INVISIBLE);
            TextView nameView=(TextView)findViewById(R.id.nameText);
            cursor.moveToFirst();
            nameView.setText(cursor.getString(cursor.getColumnIndex("name")));
            Button button=(Button)findViewById(R.id.lgb);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.delete("login",null,null);

                    findViewById(R.id.guest_button).setVisibility(View.VISIBLE);
                    finish();


                    startActivity(getIntent());

                }
            });


        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if the requestCode is the Google Sign In code that we defined at starting
        if (requestCode == RC_SIGN_IN) {

            //Getting the GoogleSignIn Task
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);

                //authenticating with firebase
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        //getting the auth credential
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        //Now using firebase we are signing in the user here
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            FirebaseUser currentUser=mAuth.getCurrentUser();

                            SignInButton sgnb=(SignInButton)findViewById(R.id.sign_in_button);
                            sgnb.setVisibility(View.GONE);
                            TextView nameView=(TextView)findViewById(R.id.nameText);
                            nameView.setText(currentUser.getDisplayName());

                            int secs = 2; // Delay in seconds

                            Button button=(Button)findViewById(R.id.lgb);
                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    FirebaseAuth.getInstance().signOut();
                                }
                            });
                            finish();
                            startActivity(getIntent());












                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            Toast.makeText(LoginActivity.this, "User Signed In", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed. please continue as guest",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }


    //this method is called on click
    private void signIn() {
        //getting the google signin intent
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();

        //starting the activity for result
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }



    private void guestIn(){
      final EditText gText=(EditText) findViewById(R.id.guestText);
      gText.setVisibility(View.VISIBLE);
        nameDbHelper mHelper=new nameDbHelper(this);
        final SQLiteDatabase db= mHelper.getReadableDatabase();
        Button button=(Button)findViewById(R.id.sumb) ;
        button.setVisibility(View.VISIBLE);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {



              ContentValues values = new ContentValues();
              values.put("name", gText.getText().toString().trim());

              db.insert("login",null,values);
              finish();


              startActivity(getIntent());
          }
      });
    }
}
