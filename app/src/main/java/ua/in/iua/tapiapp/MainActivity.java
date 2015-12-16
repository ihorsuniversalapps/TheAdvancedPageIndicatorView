package ua.in.iua.tapiapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import ua.in.iua.theadvancedpageindicator.TheAdvancedPageIndicatorView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TheAdvancedPageIndicatorView indicatorView = (TheAdvancedPageIndicatorView) findViewById(R.id.piPageIndicator);

        ViewPager vpTest = (ViewPager) findViewById(R.id.vpTest);
        vpTest.setAdapter(new TestAdapter());
        vpTest.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicatorView.setCurrentSelectedItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
