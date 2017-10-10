package com.epicodus.madlibs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoryActivity extends AppCompatActivity {
    String[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);

        Bundle b = this.getIntent().getExtras();
        arr = b.getStringArray("data");
        Log.i("story", arr[0] + "array");
    }

    public String[] getData() {
        return arr;
    }
}
