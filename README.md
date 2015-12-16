TheAdvancedPageIndicatorView
===========

TheAdvancedPageIndicatorView is an Open Source Android library that allows developers to easily create applications 
with page indicator like those made in iOS. Feel free to use it all you want in your Android apps. The library provided as is without any warranty.

![screenshot 1](https://github.com/ihorsuniversalapps/TheAdvancedPageIndicatorView/raw/master/screenshot1.png "ScreenShot Of TheSimplestPageIndicatorView")
![screenshot 2](https://github.com/ihorsuniversalapps/TheAdvancedPageIndicatorView/raw/master/screenshot2.png "ScreenShot Of TheSimplestPageIndicatorView")

## Getting started

### Dependency

[Download](https://bintray.com/phoenixria/maven/theadvancedpageindicator/1.0.0/view)

Include the dependency:

```groovy
dependencies {
    compile 'ua.in.iua:theadvancedpageindicator:1.0.0'
}
```
### Usage

Insert code below to your layout xml file.

```xml
<ua.in.iua.theadvancedpageindicator.TheAdvancedPageIndicatorView
        android:id="@+id/piPageIndicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:padding="10dp"
        app:indicatorInactiveDrawable="@drawable/page_indicator_inactive"
        app:indicatorPadding="2dp"
        app:indicatorSelectedDrawable="@drawable/page_indicator_selected"
        app:indicatorSize="4dp"
        app:indicatorsCount="10"/>
``` 

Put next code in your `Activity` class in the `#onCreate()` method.

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TheSimplestPageIndicatorView indicatorView = (TheSimplestPageIndicatorView) findViewById(R.id.piPageIndicator);

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
```
### Available customization

Define next attributes in your xml tag:
 
* `indicatorsCount` xml - attr defines how many indicators view should have.
* `indicatorSize` xml - attr defines the width and height of indicators.
* `indicatorPadding` xml - attr defines the padding between indicators.
* `indicatorInactiveDrawable` xml - attr defines the drawable of inactive indicator.
* `indicatorSelectedDrawable` xml - attr defines the drawable of active(selected) indicator.

# Licence

The MIT License (MIT)

Copyright (c) 2015 ihorsuniversalapps

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
