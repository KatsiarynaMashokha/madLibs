package com.epicodus.madlibs;

import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class StoryActivityTest {
    private StoryActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(StoryActivity.class);
    }

//    @Test
//    public void validateActivityStarted() {
//        activity.findViewById(R.id.)
//    }
}