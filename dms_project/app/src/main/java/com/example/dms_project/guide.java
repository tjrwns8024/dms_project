package com.example.dms_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class guide extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.guide, container, false);
    }
    public void onButtonClick2(View view)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://rogerdudler.github.io/git-guide/index.ko.html"));
        startActivity(myIntent);
    }
}
