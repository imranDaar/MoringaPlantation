package com.example.moringaplantation3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText q711x, Pnid;
    RadioButton q7rd1, q7rd2, q7rd3, q7rd4, q7rd5, q7rd6, q7rd7, q7rd8, q7rd9, q7rd10, q7rd11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText Pnid = findViewById(R.id.Pnid);
        final EditText Dov = findViewById(R.id.DoV);
        final EditText Chwcode = findViewById(R.id.Chwcode);
        final EditText Tlncode = findViewById(R.id.Tlncode);
        final EditText VM2 = findViewById(R.id.VM2);
        final EditText Uccode = findViewById(R.id.Uccode);
        final EditText Splant = findViewById(R.id.Splant);
        final EditText QtyP = findViewById(R.id.QtyP);
        final   EditText  q711x = findViewById(R.id.q711x);
        q7rd1 = findViewById(R.id.q7rd1);
        q7rd2 = findViewById(R.id.q7rd2);
        q7rd3 = findViewById(R.id.q7rd3);
        q7rd4 = findViewById(R.id.q7rd4);
        q7rd5 = findViewById(R.id.q7rd5);
        q7rd6 = findViewById(R.id.q7rd6);
        q7rd7 = findViewById(R.id.q7rd7);
        q7rd8 = findViewById(R.id.q7rd8);
        q7rd9 = findViewById(R.id.q7rd9);
        q7rd10 = findViewById(R.id.q7rd10);
        q7rd11 = findViewById(R.id.q7rd11);

        Button BtnS = findViewById(R.id.BtnS);
        Button BtnView = findViewById(R.id.BtnView);


        BtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try {
                     DatabaseSQLite dbf = new DatabaseSQLite(MainActivity.this);
                       String ins = null;
                       if(isValidate(Pnid,Dov,Chwcode,Tlncode,VM2,Uccode,Splant,QtyP)) {
                           ins = dbf.addData(Pnid.getText().toString(), Dov.getText().toString(), Integer.parseInt(Chwcode.getText().toString()), Integer.parseInt(Tlncode.getText().toString()), VM2.getText().toString(), Uccode.getText().toString(), Integer.parseInt(Splant.getText().toString()), getValueInt(q7rd1, q7rd2, q7rd3, q7rd4, q7rd5, q7rd6, q7rd7, q7rd8, q7rd9, q7rd10), q711x.getText().toString(),
                                   Integer.parseInt(QtyP.getText().toString()));
                       }else{
                         Toast.makeText(MainActivity.this,"Please fill form",Toast.LENGTH_LONG).show();
                       }
                       if(ins!= null) {

                           Toast.makeText(MainActivity.this, ins, Toast.LENGTH_LONG).show();
                       }
                       if (ins.equals("inserted")){
                           Intent intent = getIntent();
                           finish();
                           startActivity(intent);
                       }else{

                       }




            }catch (Exception ex){
                  Toast.makeText(MainActivity.this,ex.getMessage(),Toast.LENGTH_SHORT).show();
            }

            }
        });
        BtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(MainActivity.this, RecyclerViewList.class));
                } catch (Exception ex) {

                }
            }
        });



q7rd10.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       if (q7rd11.isChecked()){
           q711x.setVisibility(View.VISIBLE);
       } else if (q7rd10.isChecked()) {
           q711x.setVisibility(View.INVISIBLE);
       }
       }

});

q7rd11.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (q7rd11.isChecked()) {
            q711x.setVisibility(View.VISIBLE);
        } else if (q7rd10.isChecked()) {
            q711x.setVisibility(View.INVISIBLE);
        }
    }

});

q7rd1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (q7rd11.isChecked()) {
            q711x.setVisibility(View.VISIBLE);
        } else if (q7rd1.isChecked()) {
            q711x.setVisibility(View.INVISIBLE);
        }
    }
});

    }
 public int getValueInt(RadioButton q7rd1, RadioButton q7rd2, RadioButton q7rd3, RadioButton q7rd4, RadioButton q7rd5, RadioButton q7rd6, RadioButton q7rd7, RadioButton q7rd8, RadioButton q7rd9, RadioButton q7rd10) {
            if (q7rd1.isChecked())
                return 1;
            else if (q7rd2.isChecked()) {
                return 2;
            } else if (q7rd3.isChecked()) {
                return 3;
            } else if (q7rd4.isChecked()) {
                return 4;

            } else if (q7rd5.isChecked()) {
                return 5;

            } else if (q7rd6.isChecked()) {
                return 6;

            } else if (q7rd7.isChecked()) {
                return 7;

            } else if (q7rd8.isChecked()) {
                return 8;

            } else if (q7rd9.isChecked()) {
                return 9;

            } else if (q7rd9.isChecked()) {
                return 9;

            } else if (q7rd10.isChecked()) {
                return 10;

            }
            return 0;
        }

           public boolean isValidate(EditText Pnid, EditText Dov, EditText Chwcode, EditText Tlncode, EditText VM2, EditText Uccode, EditText Splant, EditText QtyP) {
        if (Pnid.getText().toString().isEmpty()) {
            Pnid.setError("Please Enter PnidCode");
            Pnid.requestFocus();
            return false;
        }
        if (Dov.getText().toString().isEmpty()) {
            Dov.setError("Please Enter visit Date");
            Dov.requestFocus();
            return false;
        }
        if (Chwcode.getText().toString().isEmpty()) {
            Chwcode.setError("Please Enter  ChwCode");
            Chwcode.requestFocus();
            return false;
        }
        if (Tlncode.getText().toString().isEmpty()) {
            Tlncode.setError("Please Enter TlnCode");
            Tlncode.requestFocus();
            return false;
        }
        if (VM2.getText().toString().isEmpty()) {
            VM2.setError("Please Enter  VM");
            VM2.requestFocus();
            return false;
        }
        if (Uccode.getText().toString().isEmpty()) {
            Uccode.setError("Please Enter UcCode");
            Uccode.requestFocus();
            return false;
        }

        if (Splant.getText().toString().isEmpty()) {
            Splant.setError("Please Enter Splant");
            Splant.requestFocus();
            return false;
        }
        if (QtyP.getText().toString().isEmpty()) {
            QtyP.setError("Please Enter QtyP");
            QtyP.requestFocus();
            return false;
        }
        return true;
    }


}