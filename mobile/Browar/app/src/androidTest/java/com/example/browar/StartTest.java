package com.example.browar;

    import org.junit.Rule;
    import org.junit.Test;
    import org.junit.runner.RunWith;

    import androidx.test.espresso.intent.Intents;
    import androidx.test.ext.junit.rules.ActivityScenarioRule;
    import androidx.test.ext.junit.runners.AndroidJUnit4;
    import static androidx.test.espresso.Espresso.onView;
    import static androidx.test.espresso.action.ViewActions.click;
    import static androidx.test.espresso.intent.Intents.intended;
    import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
    import static androidx.test.espresso.matcher.ViewMatchers.withId;


    @RunWith(AndroidJUnit4.class)
    public class StartTest {

        @Rule
        public ActivityScenarioRule<Start> activityScenarioRule =
                new ActivityScenarioRule<>(Start.class);

        @Test
        public void nextButtonLaunchesBrowseBeersActivity() {
            // Initialize Intents before the test.
            Intents.init();

            // Perform a click on the button
            onView(withId(R.id.nextButton)).perform(click());

            // Check if the intent to start the BrowseBeers activity was launched
            intended(hasComponent(BrowseBeers.class.getName()));

            // Clear Intents state after the test.
            Intents.release();
        }
    }
