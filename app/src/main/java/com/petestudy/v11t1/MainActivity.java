package com.petestudy.v11t1;

// Kurssin esimerkkien mukaan tehty.

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactStorage.getInstance().getContacts().clear();

        recyclerView = findViewById(R.id.ListContactsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactAdapter());
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(new ContactAdapter());
    }

    public void switchToAddContact(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }

    public void sortAlphabetically(View view) {
        ArrayList<Contact> contacts = ContactStorage.getInstance().getContacts();
        contacts.sort((c1, c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName()));
        recyclerView.setAdapter(new ContactAdapter());
    }

    public void sortByGroup(View view) {
        ArrayList<Contact> contacts = ContactStorage.getInstance().getContacts();
        ArrayList<Contact> temp = new ArrayList<>();
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            temp.add(iterator.next());
        }

        temp.sort(Comparator.comparing(Contact::getContactGroup).thenComparing(Contact::getFullName, String.CASE_INSENSITIVE_ORDER));
        contacts.clear();
        contacts.addAll(temp);

        recyclerView.setAdapter(new ContactAdapter());
    }
}