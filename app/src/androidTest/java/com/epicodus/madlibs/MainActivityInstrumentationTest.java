package com.epicodus.madlibs;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText1() {
        onView(withId(R.id.first_edit_text)).perform(typeText("Developer"))
                .check(matches(withText("Developer")));
    }
    @Test
    public void validateEditText2() {
        onView(withId(R.id.second_edit_text)).perform(typeText("working"))
                .check(matches(withText("working")));
    }
    @Test
    public void validateEditText3() {
        onView(withId(R.id.third_edit_text)).perform(typeText("ballin"))
                .check(matches(withText("ballin")));
    }
    @Test
    public void informationIsPassedToNextActivity() {
        onView(withId(R.id.first_edit_text)).perform(typeText("Developer"));
        onView(withId(R.id.second_edit_text)).perform(typeText("working"));
        onView(withId(R.id.third_edit_text)).perform(typeText("ballin"));
        onView(withId(R.id.get_story_button)).perform(click());

    }

}
