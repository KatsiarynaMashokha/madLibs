package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.first_edit_text) EditText firstEditText;
    @Bind(R.id.second_edit_text) Spinner secondEditText;
    @Bind(R.id.radio_group) RadioGroup thirdEditText;
//    @Bind(R.id.fourth_edit_text) EditText fourthEditText;
//    @Bind(R.id.fifth_edit_text) EditText fifthEditText;
//    @Bind(R.id.sixth_edit_text) EditText sixthEditText;
//    @Bind(R.id.seventh_edit_text) EditText seventhEditText;
//    @Bind(R.id.eighth_edit_text) EditText eighthEditText;
//    @Bind(R.id.ninth_edit_text) EditText ninthEditText;
//    @Bind(R.id.tenth_edit_text) EditText tenthEditText;

    @Bind(R.id.get_story_button) Button getStoryButton;
    public String occupation;
    public String noun;
    public String adj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getStoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtras( getInputs() );
                startActivity(intent);
            }
        });

    }
    private Bundle getInputs() {
        occupation = firstEditText.getText().toString();
        noun = secondEditText.getSelectedItem().toString();
        int selectedId = thirdEditText.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
        adj = selectedRadioButton.getText().toString();
        return makeBundle( new String[]{occupation, noun, adj} );
    }
    public Bundle makeBundle(String[] array) {
        Bundle b = new Bundle();
        b.putStringArray("data", array);
        return b;
    }
}
