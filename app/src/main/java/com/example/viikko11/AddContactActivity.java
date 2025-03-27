package com.example.viikko11;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddContactActivity extends AppCompatActivity {
    EditText lastname;
    EditText firstname;
    EditText puhNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lastname = findViewById(R.id.LastNameEdit);
        firstname = findViewById(R.id.FirstNameEdit);
        puhNumber = findViewById(R.id.PhoneNumberEdit);
    }

    public void addContactButton(View view) {
        RadioGroup rgContactType = findViewById(R.id.ContactTypeRadioGroup);
                if(rgContactType == findViewById(R.id.PersonalRadioButton)){
                    ContactStorage.getInstance().addContact(new Contact(firstname.getText().toString(),lastname.getText().toString(), puhNumber.getText().toString(), "personal"));
                }
                if(rgContactType == findViewById(R.id.WorkRadioButton)){
                    ContactStorage.getInstance().addContact(new Contact(firstname.getText().toString(),lastname.getText().toString(), puhNumber.getText().toString(), "work"));
                }

    }
}