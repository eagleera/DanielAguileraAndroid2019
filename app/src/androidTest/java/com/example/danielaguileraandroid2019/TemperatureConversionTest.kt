package com.example.danielaguileraandroid2019


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TemperatureConversionTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(SplashScreen::class.java)

    @Test
    fun temperatureConversionTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(3000)

        val appCompatButton = onView(
            allOf(
                withId(R.id.btnTempConversion), withText("Convert temperature"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.editCelsius),
                childAtPosition(
                    allOf(
                        withId(R.id.containerCelsius),
                        childAtPosition(
                            withId(R.id.container),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("30"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.editCelsius), withText("30"),
                childAtPosition(
                    allOf(
                        withId(R.id.containerCelsius),
                        childAtPosition(
                            withId(R.id.container),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(click())

        pressBack()

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.btnConvertFarenheit), withText("Convert to Farenheit"),
                childAtPosition(
                    allOf(
                        withId(R.id.containerCelsius),
                        childAtPosition(
                            withId(R.id.container),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.editFarenheit),
                childAtPosition(
                    allOf(
                        withId(R.id.containerFarenheit),
                        childAtPosition(
                            withId(R.id.container),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("50"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.editFarenheit), withText("50"),
                childAtPosition(
                    allOf(
                        withId(R.id.containerFarenheit),
                        childAtPosition(
                            withId(R.id.container),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(pressImeActionButton())

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.btnConvertCelsius), withText("Convert to Celsius"),
                childAtPosition(
                    allOf(
                        withId(R.id.containerFarenheit),
                        childAtPosition(
                            withId(R.id.container),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        pressBack()
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
