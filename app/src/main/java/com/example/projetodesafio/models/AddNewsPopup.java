package com.example.projetodesafio.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projetodesafio.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddNewsPopup extends AppCompatActivity {


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser currentUser = mAuth.getCurrentUser();

    private Button buttonSendAddNewsPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news_popup);
        //

//        buttonSendAddNewsPopup = findViewById(R.id.buttonSendAddNewsPopup);
//
//        buttonSendAddNewsPopup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TextInputEditText TextInputEditTexttitlePopupAddNews = findViewById(R.id.TextInputEditTexttitlePopupAddNews);
//                TextInputEditText TextInputEditTextBodyPopupAddNews = findViewById(R.id.TextInputEditTextBodyPopupAddNews);
//
//                String titulo = String.valueOf(TextInputEditTexttitlePopupAddNews.getText());
//                String noticia = String.valueOf(TextInputEditTextBodyPopupAddNews.getText());
//
//
//                Map<String, Object> athleticNews = new HashMap<>();
//                athleticNews.put("titulo", titulo);
//                athleticNews.put("noticia", noticia);
//
//                DocumentReference documentReference = db.collection("AthleticNews")
//                        .document();
//                        documentReference.set(athleticNews)
//                        .addOnSuccessListener(aVoid -> {
//                            Toast.makeText(AddNewsPopup.this, "Notícia Enviada", Toast.LENGTH_SHORT).show();
//                        })
//                        .addOnFailureListener(e -> {
//                            Toast.makeText(AddNewsPopup.this, "Falha ao enviar a Notícia", Toast.LENGTH_SHORT).show();
//                        });
//            }
//        });


    }


}