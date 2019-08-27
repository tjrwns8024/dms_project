package com.example.githubapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView ID;
    TextView followers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        followers = (TextView) findViewById(R.id.followers);
        ID = (TextView) findViewById(R.id.ID);
    }

    public void onSearch(View view) {
        String id = editText.getText().toString();

        if (!id.isEmpty()) {
            Call<jsonparse> res = NetRetrofit.getInstance().getService().getListRepos(id);
            res.enqueue(new Callback<jsonparse>() {
                @Override
                public void onResponse(Call<jsonparse> call, Response<jsonparse> response) {
                    Log.d("Retrofit", response.toString());
                    if (response.code() == 200) {
                        if (response.body() != null)
                            ID.setText(response.body().login);
                        followers.setText(Integer.toString(response.body().followers));
                    } else {
                        Log.e("Response Code Error", response.code() + "");
                        makeToast("존재하지 않는 유저입니다");
                        ID.setText("-");
                        followers.setText("-");


                    }
                }

                @Override
                public void onFailure(Call<jsonparse> call, Throwable t) {
                    Log.e("Err", t.getMessage());
                }
            });
        } else {
            makeToast("아이디를 입력하세요");
        }

    }

    private void makeToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
