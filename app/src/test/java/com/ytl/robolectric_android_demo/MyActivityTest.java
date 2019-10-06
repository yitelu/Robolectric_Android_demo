package com.ytl.robolectric_android_demo;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.ytl.robolectric_android_demo.BuildConfig;
import com.ytl.robolectric_android_demo.MainActivity;
import com.ytl.robolectric_android_demo.R;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
/**
 * Created by Richard Yi-Te Lu on 05,October,2019
 */

@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class)
//@Config(manifest=Config.NONE)
public class MyActivityTest {

    private MainActivity mMainActivity;

    @Before
    public void setUP() throws Exception{
        mMainActivity = Robolectric.buildActivity(MainActivity.class).create().resume().get();
    }

    @Test
    public void shoudlNotBeNull() throws Exception{
        assertNotNull(mMainActivity);
    }

    @Test
    public void clickinButton_shouldChangeResultsViewText(){

        Activity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.press_me_button);
        TextView results = (TextView) activity.findViewById(R.id.results_text_view);

        button.performClick();
        assertThat(results.getText().toString(), equalTo("Testing Android Roocks!"));

//        Activity activity = Robolectric.buildActivity(MainActivity.class).create().resume().get();
//
//        activity.findViewById(R.id.press_me_button).performClick();
//        //String myResult = activity.findViewById(R.id.results_text_view).toString();
//
//        //System.out.println("heyhhhh: " + results.getText().toString());
//        assertThat(activity.findViewById(R.id.results_text_view).toString(), equals("Testing Android Rocks!"));
    }
}
