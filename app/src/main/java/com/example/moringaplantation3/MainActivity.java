package com.example.moringaplantation3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.moringaplantation3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);


        bi.BtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DatabaseSQLite dbf = new DatabaseSQLite(MainActivity.this);
                    String ins = null;
                    if (isValidate()) {
                        ins = dbf.addData(bi.Pnid.getText().toString(), bi.DoV.getText().toString(), Integer.parseInt(bi.Chwcode.getText().toString()), Integer.parseInt(bi.Tlncode.getText().toString()), bi.VM2.getText().toString(), bi.Uccode.getText().toString(), Integer.parseInt(bi.Splant.getText().toString()), getValueInt(bi.q7rd1, bi.q7rd2, bi.q7rd3, bi.q7rd4, bi.q7rd5, bi.q7rd6, bi.q7rd7, bi.q7rd8, bi.q7rd9, bi.q7rd10), bi.q711x.getText().toString(),
                                Integer.parseInt(bi.QtyP.getText().toString()));
                    } else {

                        Toast.makeText(MainActivity.this, "Please fill form", Toast.LENGTH_LONG).show();
                    }
                    if (ins != null) {

                        Toast.makeText(MainActivity.this, ins, Toast.LENGTH_LONG).show();
                    }
                    if (ins.equals("inserted")) {
                        Intent intent = getIntent();
                           finish();
                           startActivity(intent);
                       }else{

                       }




            }catch (Exception ex){

                }

            }
        });
        bi.BtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(MainActivity.this, RecyclerViewList.class));
                } catch (Exception ex) {

                }
            }
        });


        bi.q7rd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bi.q7rd11.isChecked()) {
                    bi.q711x.setVisibility(View.VISIBLE);
                } else if (bi.q7rd10.isChecked()) {
                    bi.q711x.setVisibility(View.INVISIBLE);
                }
            }

        });

        bi.q7rd11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bi.q7rd11.isChecked()) {
                    bi.q711x.setVisibility(View.VISIBLE);
                } else if (bi.q7rd10.isChecked()) {
                    bi.q711x.setVisibility(View.INVISIBLE);
                }
            }

        });

        bi.q7rd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bi.q7rd11.isChecked()) {
                    bi.q711x.setVisibility(View.VISIBLE);
                } else if (bi.q7rd1.isChecked()) {
                    bi.q711x.setVisibility(View.INVISIBLE);
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

    public boolean isValidate() {

        if (bi.Pnid.getText().toString().isEmpty()) {
            bi.Pnid.setError("Please Enter PnidCode");
            bi.Pnid.requestFocus();
            return false;
        }
        if (bi.DoV.getText().toString().isEmpty()) {
            bi.DoV.setError("Please Enter Visit Date");
            bi.DoV.requestFocus();
            return false;
        }
        if (bi.Chwcode.getText().toString().isEmpty()) {
            bi.Chwcode.setError("Please Enter  ChwCode");
            bi.Chwcode.requestFocus();
            return false;
        }
        if (bi.Tlncode.getText().toString().isEmpty()) {
            bi.Tlncode.setError("Please Enter TlnCode");
            bi.Tlncode.requestFocus();
            return false;
        }
        if (bi.VM2.getText().toString().isEmpty()) {
            bi.VM2.setError("Please Enter  VM");
            bi.VM2.requestFocus();
            return false;
        }
        if (bi.Uccode.getText().toString().isEmpty()) {
            bi.Uccode.setError("Please Enter UcCode");
            bi.Uccode.requestFocus();
            return false;
        }

        if (bi.Splant.getText().toString().isEmpty()) {
            bi.Splant.setError("Please Enter Splant");
            bi.Splant.requestFocus();
            return false;
        }
        if (bi.QtyP.getText().toString().isEmpty()) {
            bi.QtyP.setError("Please Enter QtyP");
            bi.QtyP.requestFocus();
            return false;
        }
        return true;
    }


}