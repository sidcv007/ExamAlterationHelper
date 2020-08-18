package com.example.android.examalterationhelper;

import android.content.Intent;
import android.icu.util.ValueIterator;
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

import static com.loopj.android.http.AsyncHttpClient.log;

public class update_request extends AppCompatActivity {

    TextView blocke,roome,timee,datee;
    EditText namee;
    String onm;
    public static String ans=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_request);
//        blocke = (TextView) findViewById(R.id.block_edit_req);
//        roome = (TextView) findViewById(R.id.room_edit_req);
        namee = (EditText) findViewById(R.id.name_edit_req);
        timee = (TextView) findViewById(R.id.time_edit_req);
        datee = (TextView) findViewById(R.id.date_edit_req);
        timee.setText(global.upreq_res[1]);
        datee.setText(global.upreq_res[0]);
        disp();
    }

    public void disp(){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("username",global.upreq_res[2]);
        client.post("https://examalthelper.000webhostapp.com/set_req_update.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String name = new String(responseBody);
                namee.setText(name);
                onm=name.trim();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void check_name_avail(String date,String time,String name){
        final String[] r = new String[1];
        final String nm=name;
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("date",date);
        params.add("time",time);
        params.add("name",name);
        params.add("username",global.upreq_res[2]);
        log.v("name123= ", name);
        client.post("https://examalthelper.000webhostapp.com/check_name_avail.php",params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String t = new String(responseBody);
                ans=t;
                Toast.makeText(update_request.this,ans+" abcdef",Toast.LENGTH_SHORT).show();
                log.v("rezz123= ", ans);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                log.v("name234= ", nm);
            }
        });
        log.v("rz[0]= ", ans);
    }

    public void update(View view) {
        final String dt=datee.getText().toString();
        final String nm=namee.getText().toString();
        String tm=timee.getText().toString();
        tm=tm.toUpperCase();
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.add("date",dt);
            params.add("time",tm);
            params.add("oldname",onm);
            params.add("newname",nm);
            final String tm1=tm;
            client.post("https://examalthelper.000webhostapp.com/update_tt_req.php", params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    log.v("datazz123= ", "date1= "+dt+" name= "+nm+" time= "+tm1);
                    String temp=new String(responseBody);
                    Toast.makeText(update_request.this,temp,Toast.LENGTH_SHORT).show();
                    if(temp.equals("Records Updated")){
                        delete_req();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Toast.makeText(update_request.this,"temp= error",Toast.LENGTH_SHORT).show();
                }
            });
        }

    public void delete_req(){
        String un = global.upreq_res[2];
        log.v("deleteun",un);
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("username",un);
        client.post("https://examalthelper.000webhostapp.com/delete_req.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                log.v("deletemsg",responseBody.toString());
                startActivity(new Intent(getApplicationContext(),admin_pg.class));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void delete_req1(View view) {
        String un = global.upreq_res[2];
        log.v("deleteun",un);
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("username",un);
        client.post("https://examalthelper.000webhostapp.com/delete_req.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                log.v("deletemsg",responseBody.toString());
                startActivity(new Intent(getApplicationContext(),admin_pg.class));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
