package com.epicodus.madlibs;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;


public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText1() {
        onView(withId(R.id.first_edit_text)).perform(typeText("Developer"))
                .check(matches(withText("Developer")));
    }
    @Test
    public void validateSpinnerInput() {
        onView(withId(R.id.second_edit_text)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Putin"))).perform(click());
        onView(withId(R.id.second_edit_text)).check(matches(withSpinnerText(containsString("Putin"))));
    }


    @Test
    public void validateRadioButtons() {
        onView(withId(R.id.radio_pretty))
                .perform(click());
        onView(withId(R.id.radio_pretty))
                .check(matches(isChecked()));
        onView(withId(R.id.radio_sad))
                .check(matches(not(isChecked())));
        onView(withId(R.id.radio_bad))
                .check(matches(not(isChecked())));
    }
}
