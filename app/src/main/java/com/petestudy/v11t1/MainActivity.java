package com.petestudy.v11t1;

// Kurssin esimerkkien mukaan tehty.

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.ListContactsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactAdapter());
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.ListContactsRV);
        recyclerView.setAdapter(new ContactAdapter());
    }

    public void switchToAddContact(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }

    public void sortAlphabetically(View view) {
        ArrayList<Contact> contacts = ContactStorage.getInstance().getContacts();
        contacts.sort((c1, c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName()));
        RecyclerView recyclerView =  findViewById(R.id.ListContactsRV);
        recyclerView.setAdapter(new ContactAdapter());
    }

    public void sortByGroup(View view) {
        ArrayList<Contact> contacts = ContactStorage.getInstance().getContacts();
        contacts.sort(Comparator.comparing(Contact::getContactGroup));
        RecyclerView recyclerView = findViewById(R.id.ListContactsRV);
        recyclerView.setAdapter(new ContactAdapter());
    }
}