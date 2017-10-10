package com.epicodus.madlibs;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoryActivity extends AppCompatActivity {
    String[] arr;
    @Bind(R.id.story_text_view) TextView storyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);

        ButterKnife.bind(this);

        Bundle b = this.getIntent().getExtras();
        arr = b.getStringArray("data");
        //Log.i("story", arr[0] + "array");

        String story = "Today a " + arr[0] + " named " + arr[1] + " came to our school to talk about his job. He said that the most" +
                "of the " + arr[2] + " skills you need ...";
        storyTextView.setText(story);
    }

    public String[] getData() {
        return arr;
    }
}
