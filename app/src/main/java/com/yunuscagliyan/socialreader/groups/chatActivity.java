package com.yunuscagliyan.socialreader.groups;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.yunuscagliyan.socialreader.Home.HomeActivity;
import com.yunuscagliyan.socialreader.R;
import com.yunuscagliyan.socialreader.Utils.FirebaseMethods;
import com.yunuscagliyan.socialreader.Utils.UniversalImageLoader;
import com.yunuscagliyan.socialreader.models.User;
import com.yunuscagliyan.socialreader.models.UserAccountSettings;
import com.yunuscagliyan.socialreader.models.UserSettings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.println;

public class chatActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    String userName, otherName;
    TextView chatname;
    ImageView back, pen;
    EditText chatedittext;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    RecyclerView chatRecylerView;
    MesajAdapter mesajAdapter;
    List<MesajModel> list;
    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private FirebaseMethods mFirebaseMethods;
    String group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        User user = null;

        define();
        loadMesaj();

    }



    public void define() {

        list = new ArrayList<>();
        group = getIntent().getExtras().getString("group");
        chatname = (TextView) findViewById(R.id.chatname);
        back = (ImageView) findViewById(R.id.back);
        pen = (ImageView) findViewById(R.id.pen);
        chatedittext = (EditText) findViewById(R.id.chatedittext);
        userName = getIntent().getExtras().getString("userName");
        chatname.setText(group);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chatActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();
        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mesaj = chatedittext.getText().toString();
                chatedittext.setText("");
                sendmessage(mesaj);
            }
        });
        chatRecylerView = (RecyclerView) findViewById(R.id.chatRecylerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(chatActivity.this, 1);
        chatRecylerView.setLayoutManager(layoutManager);
        mesajAdapter = new MesajAdapter(chatActivity.this, list, chatActivity.this, group);
        chatRecylerView.setAdapter(mesajAdapter);
    }

    public void sendmessage(String text) {

        final String key = reference.child("gruplar").child(group).push().getKey();

        final Map messageMap = new HashMap();
        messageMap.put("text", text);
         //messageMap.put("from",userName);
        reference.child("gruplar").child(group).child(key).setValue(messageMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }

            }
        });

    }

    public void loadMesaj() {


        reference.child("gruplar").child(group).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                MesajModel mesajModel = dataSnapshot.getValue(MesajModel.class);
                list.add(mesajModel);
                 mesajAdapter.notifyDataSetChanged();
                 chatRecylerView.scrollToPosition(list.size()-1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
