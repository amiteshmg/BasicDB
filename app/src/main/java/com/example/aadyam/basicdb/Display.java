package com.example.aadyam.basicdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Display extends Activity {

    public Display() {
        super();
    }
    DatabaseHelper databaseHelper;

    String s1,s2,s3,s4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final TextView name,contact,address,email;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        databaseHelper=new DatabaseHelper(this);
       // databaseHelper.open

        final List<User> userList = databaseHelper.getDatabaseEntries();

        name = (TextView) findViewById(R.id.name);
        /*address = (TextView) findViewById(R.id.set_address);
        contact = (TextView) findViewById(R.id.set_contact);
        email = (TextView) findViewById(R.id.set_email);
*/
        Button button = (Button) findViewById(R.id.button);



         View.OnClickListener onclickListener = new View.OnClickListener() {
            @Override

            public void onClick(final View v) {

                for(int listcounter=0;listcounter<userList.size();listcounter++){
                    User us=userList.get(listcounter);

                    name.setText("");
                    name.append("name: "+us.getName());
                    name.append(" ,Adress: "+us.getAddress());
                    name.append(",Contact: "+us.getContact());
                    name.append(",Email: "+us.getEmail());



                    Toast.makeText(Display.this," Name :" +us.getName()+" address - "+us.getAddress()+" contact: "+us.getContact()+" Email: "+us.getEmail(),Toast.LENGTH_SHORT).show();

                   // listcounter++;
                }
                /*else{
                    //Reset the Counter here
                    listcounter = 0;

                }*/
            }
        };


        button.setOnClickListener(onclickListener);

        /*name=(TextView)findViewById(R.id.set_name);
        address=(TextView)findViewById(R.id.set_address);
        contact=(TextView)findViewById(R.id.set_contact);
        email=(TextView)findViewById(R.id.set_email);


        String display_name=getIntent().getStringExtra("NAME");
        String display_address=getIntent().getStringExtra("ADDRESS");
        String display_contact=getIntent().getStringExtra("CONTACT");
        String display_email=getIntent().getStringExtra("EMAIL");


        name.setText(display_name);
        address.setText(display_address);
        contact.setText(display_contact);
        email.setText(display_email);
*/


        // s1= R.id.



        //name.setText();

    }
}