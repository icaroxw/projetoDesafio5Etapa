package com.example.projetodesafio.models;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projetodesafio.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;

public class RedefinePassword extends Activity {

    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String userId, password, email;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefine_password);

        //

        Button buttonRedefinePasswordReturn;
        buttonRedefinePasswordReturn = (Button) findViewById(R.id.buttonRedefinePasswordReturn);
        buttonRedefinePasswordReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfile();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        //

        Button buttonSendRedefinePassword;
        buttonSendRedefinePassword = (Button) findViewById(R.id.buttonSendRedefinePassword);

        TextInputEditText TextInputEditTextRedefineOldPassword, TextInputEditTextRedefineNewPassword1,
                TextInputEditTextRedefineNewPassword2;

        TextInputEditTextRedefineOldPassword = findViewById(R.id.TextInputEditTextRedefineOldPassword);
        TextInputEditTextRedefineNewPassword1 = findViewById(R.id.TextInputEditTextRedefineNewPassword1);
        TextInputEditTextRedefineNewPassword2 = findViewById(R.id.TextInputEditTextRedefineNewPassword2);

        String TextInputEditTextRedefineOldPasswordStr = TextInputEditTextRedefineOldPassword.getText().toString();
        String TextInputEditTextRedefineNewPassword1Str = TextInputEditTextRedefineNewPassword1.getText().toString();
        String TextInputEditTextRedefineNewPassword2Str = TextInputEditTextRedefineNewPassword2.getText().toString();


        buttonSendRedefinePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(TextInputEditTextRedefineOldPasswordStr)) {
                    Toast.makeText(RedefinePassword.this, "Campo não pode ser nulo", Toast.LENGTH_SHORT).show();
//                } else if (TextInputEditTextRedefineOldPasswordStr.length() >= 6) {
//                    Toast.makeText(RedefinePassword.this, "A senha precisa ter pelo menos 6 caracteres", Toast.LENGTH_SHORT).show();
                } else if (TextInputEditTextRedefineNewPassword1Str.isEmpty()) {
                    Toast.makeText(RedefinePassword.this, "Campo não pode ser nulo", Toast.LENGTH_SHORT).show();
//                } else if (TextInputEditTextRedefineNewPassword1Str.length() >= 6) {
//                    Toast.makeText(RedefinePassword.this, "A senha precisa ter pelo menos 6 caracteres", Toast.LENGTH_SHORT).show();
                } else if (TextInputEditTextRedefineNewPassword2Str.isEmpty()) {
                    Toast.makeText(RedefinePassword.this, "Campo não pode ser nulo", Toast.LENGTH_SHORT).show();
//                } else if (TextInputEditTextRedefineNewPassword2Str.length() >= 6) {
//                    Toast.makeText(RedefinePassword.this, "A senha precisa ter pelo menos 6 caracteres", Toast.LENGTH_SHORT).show();
                } else if (TextInputEditTextRedefineNewPassword1Str.compareTo(TextInputEditTextRedefineNewPassword2Str) != 0) {
                    Toast.makeText(RedefinePassword.this, "As senhas precisam ser iguais", Toast.LENGTH_SHORT).show();
                } else {
                    updatePassword(TextInputEditTextRedefineOldPasswordStr, TextInputEditTextRedefineNewPassword1Str);
                }
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

        });

        //

//        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
//        if (currentUser != null) {
//            userId = currentUser.getUid();
//
//            DocumentReference documentReference = db.collection("Users").document(userId);
//
//            documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//                @Override
//                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
//                    if (documentSnapshot != null) {
//
//                        email = documentSnapshot.getString("email");
//                        password = documentSnapshot.getString("password");
//
//                        updatePassword(TextInputEditTextRedefineOldPasswordStr,);
//                    }
//                }
//            });
//        }

        //

    }

    private void goToSucessNotification() {
        Intent in = new Intent(this, SuccessNotificationRedefinePassword.class);
        startActivity(in);
    }

    private void goToProfile() {
        Intent in = new Intent(this, Profile.class);
        startActivity(in);
    }

    private void updatePassword(String oldpassword, String newpassword) {

        AuthCredential authCredential = EmailAuthProvider.getCredential(Objects.requireNonNull(currentUser.getEmail()), oldpassword);
        currentUser.reauthenticate(authCredential).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                currentUser.updatePassword(newpassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }






}
