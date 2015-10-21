package com.example.holdenhughes.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> contacts;
    ListView listView;
    EditText nameText;
    EditText phoneText;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        nameText = (EditText) findViewById(R.id.nameText);
        phoneText = (EditText) findViewById(R.id.phoneText);
        addButton = (Button) findViewById(R.id.addButton);

        nameText.setHint("Name");
        phoneText.setHint("Phone #");

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(contacts);

        addButton.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String text = nameText.getText().toString();
        String text1 = phoneText.getText().toString();
        String textFinal = String.format("%s (%s)",text,text1);
        contacts.add(textFinal);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String contactToRemove = contacts.getItem(position);
        contacts.remove(contactToRemove);

        return true;
    }
}
