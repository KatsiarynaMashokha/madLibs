package com.epicodus.madlibs;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ResourceCursorAdapter;
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

        Resources res = getResources();
        String story = String.format(res.getString(R.string.story_long), arr[0], arr[1], arr[2]);

        storyTextView.setText(story);
        storyTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    public String[] getData() {
        return arr;
    }
}
