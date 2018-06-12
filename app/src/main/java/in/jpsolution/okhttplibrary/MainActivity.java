package in.jpsolution.okhttplibrary;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import in.jpsolution.okhttplibrary.AsyncTasks.AsyncResponse;
import in.jpsolution.okhttplibrary.AsyncTasks.WebserviceCall;
import in.jpsolution.okhttplibrary.Helper.Config;
import in.jpsolution.okhttplibrary.Helper.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[]keys=new String[]{"mode","studentEmailId","passowrd","deviceToken"};
        String[]values=new String[]{"loginstu","ishani.vnurture@gmail.com","Ishani@123","aaa"};
        String jsonRequest= Utils.createJsonRequest(keys,values);

        Log.d("Login Request",jsonRequest);

        String URL = Config.MAIN_URL;
        
        new WebserviceCall(MainActivity.this, URL, jsonRequest, "Sign In...!!", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("Login Response",response);
                LoginModel model = new Gson().fromJson(response,LoginModel.class);
                if (model.getStatus()==1)
                {
                    Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences=getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("id", String.valueOf(model.getUserDetail().getStudentId()));
                    editor.putString("batchid",model.getUserDetail().getBatch_id());
                    editor.putString("subid",model.getUserDetail().getSub_id());
                    editor.putString("email",model.getUserDetail().getStudentEmailId());
                    editor.commit();
                }
                else {
                    Toast.makeText(MainActivity.this, ""+model.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(MainActivity.this, ""+message, Toast.LENGTH_SHORT).show();
            }
        }).execute();

    }
}
