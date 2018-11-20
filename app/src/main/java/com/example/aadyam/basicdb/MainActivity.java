package com.example.aadyam.basicdb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
public class MainActivity extends Activity
{

    String name, contact, email, address;
    Button button;
    EditText edit_name, edit_address, edit_contact, edit_email;

    DatabaseHelper databaseHelper;



    //Data insertion into table
    public void insertData(String name, String address, String contact, String email)
    {
        //error
        boolean insertdata = databaseHelper.addData(name, address, contact, email);

        if (insertdata)
        {
            Toast.makeText(this, "Data successfully inserted!", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(this, "Data not inserted....", Toast.LENGTH_SHORT);
        }



    }


    @Override
    public WindowManager getWindowManager()
    {
        return super.getWindowManager();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper= new DatabaseHelper(this);
        final Intent intent = new Intent(MainActivity.this, Display.class);


        // Intent intent1 = new Intent(getBaseContext(),);

        button = (Button) findViewById(R.id.submit_button);
        edit_name = (EditText) findViewById(R.id.name_input);
        edit_address = (EditText) findViewById(R.id.address_input);
        edit_contact = (EditText) findViewById(R.id.contact_input);
        edit_email = (EditText) findViewById(R.id.email_input);



        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                name = edit_name.getText().toString();
                address = edit_address.getText().toString();
                contact = edit_contact.getText().toString();

                email = edit_email.getText().toString();


                if (name.length() != 0 && address.length() != 0 && contact.length() != 0 && email.length() != 0)
                {
                    //error
                    insertData(name, address, contact, email);
                    toastMessage("NAME:"+name+" address:"+address+" contact: "+contact+"Email"+email);
                    intent.putExtra("NAME", name);
                    intent.putExtra("ADDRESS", address);
                    intent.putExtra("CONTACT", contact);
                    intent.putExtra("EMAIL", email);
                    startActivity(intent);

                }


                else
                    {
                        toastMessage("ERROR! No fields can be kept blank");
                    }

            }
        });

    }




    private void toastMessage(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



}
