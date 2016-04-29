package com.example.guest.openresources;

import android.support.test.rule.ActivityTestRule;

import com.example.guest.openresources.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Guest on 4/22/16.
 */
public class MainActivityInstumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.UserNameText)).perform(typeText("Brad")).check(matches(withText("Brad")));
    }
}
