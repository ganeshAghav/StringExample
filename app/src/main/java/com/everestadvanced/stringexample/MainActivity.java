package com.everestadvanced.stringexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mystring,mystring1,mystring2;
    String tempstring="Airtime recharge Reference 6113538750 Phone 0777050404 Amount TZS 500 Vendor IVISIONTZ Powered by Selcom";
    EditText mydit;
    Button showing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mystring= (TextView) findViewById(R.id.mystring);
        mystring1= (TextView) findViewById(R.id.mystring1);
        mystring2= (TextView) findViewById(R.id.mystring2);
        mydit= (EditText) findViewById(R.id.myedit);
        showing= (Button) findViewById(R.id.show);
        mydit.addTextChangedListener(new NumberTextWatcherForThousand(mydit));

//        String substr=tempstring.substring(44,54);
//        String substr1=tempstring.substring(62,69);
//        String substr2=tempstring.substring(77,104);


        String newno="010";

        int dmeo=Integer.parseInt(newno);

        if(dmeo==010)
        {
            Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"false",Toast.LENGTH_LONG).show();
        }

        String temp=tempstring.substring(tempstring.indexOf("Phone"),tempstring.indexOf("Amount"));
        String[] split = temp.split("Phone");
        String Phone = split[1].trim();

        String temp1=tempstring.substring(tempstring.indexOf("Amount") , tempstring.indexOf("Vendor"));
        String[] split1 = temp1.split("Amount TZS");
        String Amount = split1[1].trim();

        String temp2=tempstring.substring(tempstring.indexOf("Vendor"));
        String[] split2 = temp2.split("Vendor");
        String Vendor = split2[1];

        mystring.setText(Phone);
        mystring1.setText(Amount);
        mystring2.setText(Vendor);

        showing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                String editvalue=mydit.getText().toString();
//                editvalue=editvalue.replace(",","");
//                int val = Integer.parseInt(editvalue);
//
//                if(val>200000)
//                {
//                    Toast.makeText(getApplicationContext(),"amount large",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),"amount small",Toast.LENGTH_SHORT).show();
//                }


                String mytemp="500,00.00";
                mytemp= mytemp.replace(",","");
                mytemp= mytemp.split("\\.")[0];

                int orignal=Integer.parseInt(mytemp.trim());

                Toast.makeText(getApplicationContext(),String.valueOf(orignal),Toast.LENGTH_SHORT).show();

            }
        });


    }
}
