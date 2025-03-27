package com.example.viikko11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private ContactStorage contactStorage;
    private RecyclerView recyclerView;

    private ContactListAdapter adapter; //LISÄTTY


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        contactStorage = ContactStorage.getInstance();

        recyclerView = findViewById(R.id.ListContactsRV);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactListAdapter(this, contactStorage.getContacts());
        recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(new ContactListAdapter(getApplicationContext(), contactStorage.getContacts()));


    }

    public void SwitchToAddContactActivity(View view){
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}