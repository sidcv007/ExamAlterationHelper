package com.example.android.examalterationhelper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class update_details extends AppCompatActivity{

    private ProgressDialog progressDialog;
    EditText us,ps,nm,pn,emi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);
        progressDialog = new ProgressDialog(this);
        us=(EditText) findViewById(R.id.up_us);
        ps=(EditText) findViewById(R.id.up_ps);
        nm=(EditText) findViewById(R.id.up_nm);
        pn=(EditText) findViewById(R.id.up_pn);
        emi=(EditText) findViewById(R.id.up_emi);
//        progressDialog.setMessage("Please Wait");
//        progressDialog.show();
        display();
    }

    public void display(){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("username", global.username);
        params.add("password", global.password);
        //Toast.makeText(update_details.this, global.username, Toast.LENGTH_LONG).show();
        client.post("https://examalthelper.000webhostapp.com/set_update.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                progressDialog.dismiss();
//                Toast.makeText(update_details.this, "s2", Toast.LENGTH_LONG).show();
                String name = new String(responseBody);
                String[] data = name.split("_", 5);
                TextView tv1 = findViewById(R.id.up_us);
                tv1.setText("" + data[0]);
                TextView tv2 = findViewById(R.id.up_ps);
                tv2.setText("" + data[1]);
                TextView tv3 = findViewById(R.id.up_nm);
                tv3.setText("" + data[2]);
                TextView tv4 = findViewById(R.id.up_pn);
                tv4.setText("" + data[3]);
                TextView tv5 = findViewById(R.id.up_emi);
                tv5.setText("" + data[4]);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void update(View view){
//          Toast.makeText(update_details.this, "s2", Toast.LENGTH_LONG).show();
        int flag=0;
        String str_us = us.getText().toString();
        String str_ps = ps.getText().toString();
        String str_nm = nm.getText().toString();
        String str_pn = pn.getText().toString();
        String str_emi = emi.getText().toString();
        if(str_us.length()!=12||!(str_us.substring(0,6).equals("cb.en."))){
            flag=1;
            Toast.makeText(update_details.this,"Enter a valid username, like: cb.en.fac001",Toast.LENGTH_SHORT).show();
        }
        if(str_ps.length()<6){
            flag=1;
            Toast.makeText(update_details.this,"Password should be atleast 8 characters long",Toast.LENGTH_SHORT).show();
        }
        if(str_emi.length()==0){
            flag=1;
            Toast.makeText(update_details.this,"enter a valid email",Toast.LENGTH_SHORT).show();
        }
        else{
            int len = str_emi.length();
            if(!(str_emi.substring(len-10,len).equals("@gmail.com"))){
                flag=1;
                Toast.makeText(update_details.this,"enter a valid email",Toast.LENGTH_SHORT).show();
            }
        }
        if(str_pn.length()!=10){
            flag=1;
            Toast.makeText(update_details.this,"enter a valid phone number",Toast.LENGTH_SHORT).show();
        }
        else{
            int len = str_pn.length();
            for(int i=0;i<len;i++){
                if(str_pn.charAt(i)>='0'&&str_pn.charAt(i)<='9'){

                }
                else{
                    flag=1;
                    Toast.makeText(update_details.this,"enter a valid phone number",Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(str_nm.length()==0){
            flag=1;
            Toast.makeText(update_details.this,"enter a valid name",Toast.LENGTH_SHORT).show();
        }
        if(flag==0){
            global_test.uun = str_us;
            global_test.ups = str_ps;
            global_test.unm = str_nm;
            global_test.uphno = str_pn;
            global_test.uemi = str_emi;
            progressDialog.setMessage("Updating...");
            progressDialog.show();
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.add("username",str_us);
            params.add("password",str_ps);
            params.add("name",str_nm);
            params.add("phone_number",str_pn);
            params.add("email",str_emi);
            client.post("https://examalthelper.000webhostapp.com/update.php", params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    progressDialog.dismiss();
                    Toast.makeText(update_details.this, new String(responseBody), Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), admin_pg.class);
                    startActivity(i);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }
            });
        }
    }

}
