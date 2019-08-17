package com.example.dms_project;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profile extends Fragment {

    EditText editText;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, container, false);


        editText = (EditText) view.findViewById(R.id.editText);
        textView = (TextView) view.findViewById(R.id.textView);

        return view;
    }


        public void onSearch (View view){
            String id = editText.getText().toString();

            if (!id.isEmpty()) {
                Call<ArrayList<JsonObject>> res = NetRetrofit.getInstance().getService().getListRepos(id);
                res.enqueue(new Callback<ArrayList<JsonObject>>() {
                    @Override
                    public void onResponse(Call<ArrayList<JsonObject>> call, Response<ArrayList<JsonObject>> response) {
                        Log.d("Retrofit", response.toString());
                        if (response.body() != null)
                            textView.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<JsonObject>> call, Throwable t) {
                        Log.e("Err", t.getMessage());
                    }
                });
            } else
                Toast.makeText(getContext(), "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
    }




