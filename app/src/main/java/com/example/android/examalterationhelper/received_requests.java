package com.example.android.examalterationhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;


import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

import static com.loopj.android.http.AsyncHttpClient.log;


public class received_requests extends AppCompatActivity {
    TextView tev1;
    TextView tev2;
    TextView tev3;
    TextView tev4,tev5,tev6,tev7,tev8,tev9,tev10,tev11,tev12,tev13,tev14,tev15;
    String[] data = new String[50];
    static ListView reqlist;
    static ArrayList<requests> request_list = new ArrayList<>();
    static String url = "https://examalthelper.000webhostapp.com/requests_rcvd.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_requests);
        tev1=findViewById(R.id.tv1);
        tev2=findViewById(R.id.tv2);
        tev3=findViewById(R.id.tv3);
        tev4=findViewById(R.id.tv4);
        tev5=findViewById(R.id.tv5);
        tev6=findViewById(R.id.tv6);
        tev7=findViewById(R.id.tv7);
        tev8=findViewById(R.id.tv8);
        tev9=findViewById(R.id.tv9);
        tev10=findViewById(R.id.tv10);
        tev11=findViewById(R.id.tv11);
        tev12=findViewById(R.id.tv12);
        tev13=findViewById(R.id.tv13);
        tev14=findViewById(R.id.tv14);
        tev15=findViewById(R.id.tv15);
//        reqlist=(ListView) findViewById(R.id.listview2);
        displaylist();
    }

    public void displaylist(){
        log.v("datazz= ","yes");
        AsyncHttpClient client = new AsyncHttpClient();
        client.post("https://examalthelper.000webhostapp.com/requests_rcvd.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String results = new String(responseBody);
                global.req_response=results;
                data = results.split(" ");
                int len = data.length;
                log.v("datazz= ",results+" len= "+len);
                int k=1;
//                Toast.makeText(received_requests.this, "data="+data[0]+" "+data[1], Toast.LENGTH_SHORT).show();
                for(int i=0;i<len;i++){
                    if(i%3==2){
                        if(k==1){
                            tev1.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==2){
                            tev2.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==3){
                            tev3.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==4){
                            tev4.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==5){
                            tev5.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==6){
                            tev6.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==7){
                            tev7.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==8){
                            tev8.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==9){
                            tev9.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==10){
                            tev10.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==11){
                            tev11.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==12){
                            tev12.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==13){
                            tev13.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==14){
                            tev14.setText(data[i]);
                            k++;
                        }
                        else
                        if(k==15){
                            tev15.setText(data[i]);
                            k++;
                        }
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void update_req1(View view){
        global.upreq_name=tev1.getText().toString();
        int j=0;
        for(int i=0;i<3;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=1;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req2(View view){
        global.upreq_name=tev2.getText().toString();
        int j=0;
        for(int i=3;i<6;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=2;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req3(View view){
        global.upreq_name=tev3.getText().toString();
        int j=0;
        for(int i=6;i<9;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=3;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req4(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=9;i<12;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=4;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req5(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=15;i<18;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=5;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req6(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=18;i<21;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=6;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req7(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=21;i<24;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=7;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req8(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=24;i<27;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=8;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req9(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=27;i<30;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=9;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req10(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=30;i<33;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=10;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req11(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=33;i<36;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=11;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req12(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=36;i<39;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=12;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req13(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=39;i<42;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=13;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req14(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=42;i<45;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=14;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }
    public void update_req15(View view){
        global.upreq_name=tev4.getText().toString();
        int j=0;
        for(int i=45;i<48;i++){
            global.upreq_res[j++]=data[i];
        }
        global.pos=15;
        startActivity(new Intent(getApplicationContext(),update_request.class));
    }

}
