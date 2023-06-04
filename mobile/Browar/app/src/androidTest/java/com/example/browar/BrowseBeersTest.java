/**
 * Project: Mobile App for Beer rating and commenting (students project)
 *
 * Description: In this app you can search your favorite beverage
 * find out what people think about it in the comments as well as by rating
 * and also rate it yourself according to your taste buds
 *
 * Author Pawel Badysiak
 * Author Sandro Sobczynski
 * Author Marcel Pankanin
 */
package com.example.browar;

import org.junit.runner.RunWith;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class BrowseBeersTest {
    @Rule
    public ActivityScenarioRule<BrowseBeers> activityScenarioRule = new ActivityScenarioRule<>(BrowseBeers.class);

    @Test
    public void searchBeer1AndClickOnCard() {
        // Initialize Intents before the test.
        Intents.init();

        // Type "Beczkowe" in the search bar and submit
        onView(withId(R.id.searchEditText)).perform(typeText("Beczkowe"), closeSoftKeyboard());

        // Give some time for the beers to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click on the first item in the RecyclerView
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Check if the intent to start the Beer activity was launched
        intended(hasComponent(Beer.class.getName()));

        // Clear Intents state after the test.
        Intents.release();
    }

    @Test
    public void searchBeer2AndClickOnCard() {
        // Initialize Intents before the test.
        Intents.init();

        // Type "Beczkowe" in the search bar and submit
        onView(withId(R.id.searchEditText)).perform(typeText("Halne"), closeSoftKeyboard());

        // Give some time for the beers to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click on the first item in the RecyclerView
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Check if the intent to start the Beer activity was launched
        intended(hasComponent(Beer.class.getName()));

        // Clear Intents state after the test.
        Intents.release();
    }
}
