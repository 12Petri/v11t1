package com.petestudy.v11t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {
    private EditText firstNameEdit, lastNameEdit, phoneNumberEdit;
    private RadioGroup contactTypeGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        firstNameEdit = findViewById(R.id.FirstNameEdit);
        lastNameEdit = findViewById(R.id.LastNameEdit);
        phoneNumberEdit = findViewById(R.id.PhoneNumberEdit);
        contactTypeGroup = findViewById(R.id.ContactTypeRadioGroup);
    }

    public void addContact(View view) {
        String firstName = firstNameEdit.getText().toString().trim();
        String lastName = lastNameEdit.getText().toString().trim();
        String number = phoneNumberEdit.getText().toString().trim();

        int selectID = contactTypeGroup.getCheckedRadioButtonId();
        String group;
        if (selectID == R.id.WorkRadioButton) {
            group = "Työ";
        }
        else {
            group = "Henkilökohtainen";
        }

        if (!firstName.isEmpty() && !lastName.isEmpty() && !number.isEmpty()) {
            Contact contact = new Contact(firstName, lastName, number, group);
            ContactStorage.getInstance().addContact(contact);
        }

        finish();
    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
