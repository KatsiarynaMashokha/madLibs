package com.epicodus.madlibs;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;

import org.junit.Assert.*;
import org.apache.tools.ant.Main;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.Shadow;
import org.robolectric.shadows.ShadowActivity;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.deepEquals;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateActivityStarted() {
        activity.findViewById(R.id.get_story_button).performClick();
        Intent makeIntent = new Intent(activity, StoryActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent createdIntent = shadowActivity.getNextStartedActivity();
        assertTrue(createdIntent.filterEquals(makeIntent));
    }

    @Test
    public void informationPassedToNextActivity() {
        activity.occupation = "occupation";
        activity.noun = "noun";
        activity.adj = "adj";
        String[] arr = new String[]{ activity.occupation,activity.noun, activity.adj };

        Intent intent = new Intent(activity, StoryActivity.class);
        intent.putExtras(activity.makeBundle(arr));

        StoryActivity nextActivity = Robolectric.buildActivity(StoryActivity.class).withIntent(intent).create().get();
        assertEquals(arr[0], nextActivity.getData()[0]);
    }
}