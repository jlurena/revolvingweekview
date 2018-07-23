

Revolving Week View (Android)
===

**Android Week View** is an android library to display a static week calendar with options of viewing 1-7 days of the week at a time.
<div align="center">
	<img src="https://raw.githubusercontent.com/jlurena/revolvingweekview/master/images/samplegif.gif"/>
</div>
<img src="https://raw.githubusercontent.com/jlurena/revolvingweekview/master/images/dayview.png" alt="Day View" width="270" height="480"/>
<img src="https://raw.githubusercontent.com/jlurena/revolvingweekview/master/images/3dayview.png" alt="Three Day View" width="270" height="480"/>
<img src="https://raw.githubusercontent.com/jlurena/revolvingweekview/master/images/weekview.png" alt="Three Day View" width="270" height="480"/>


Features
---

* Choose from 1-7 viewing days
* Custom styling
* Vertical scrolling and zooming
* Possibility to set min and max day of the week
* Possibility to set range of visible hours
* Drag and drop a View into an area in the calendar

Sample
---

There is also a [sample app](https://github.com/jlurena/revolvingweekview/tree/master/sample) to get you started.

Getting Started
---
Via Maven

    <dependency>
      <groupId>me.jlurena</groupId>
      <artifactId>revolvingweekview</artifactId>
      <version>1.0.0</version>
      <type>aar</type>
    </dependency>

Via Gradle

    implementation 'me.jlurena:revolvingweekview:1.0.0'
Stay up to date with the latest version http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22me.jlurena%22

Write the following code in your layout file

    <me.jlurena.revolvingweekview.WeekView  
      android:id="@+id/revolving_weekview"  
      android:layout_width="match_parent"  
      android:layout_height="match_parent"  
      app:eventTextColor="@android:color/white"  
      app:hourHeight="60dp"  
      app:headerColumnPadding="8dp"  
      app:headerColumnTextColor="#8f000000"  
      app:headerRowPadding="12dp"  
      app:noOfVisibleDays="3"  
      app:headerRowBackgroundColor="@color/color_accent"  
      app:dayBackgroundColor="#05000000"  
      app:todayBackgroundColor="#1848adff"  
      app:headerColumnBackground="#ffefefef"  
      />
Write the following in your activity

        // Get a reference for the week view in the layout.
        mWeekView = (WeekView) findViewById(R.id.revolving_weekview);
        
        // Set an WeekViewLoader to draw the events on load.
        mWeekView.setWeekViewLoader(new WeekView.WeekViewLoader() {  
      
	        @Override  
		public List<? extends WeekViewEvent> onWeekViewLoad() {
		    List<WeekViewEvent> events = new ArrayList<>();
	            // Add some events
	            return events;
	        }  
	    });
	    // There are many other Listeners to choose from as well.

Special Thanks and Credits
---
*  Author [Raquib-ul Alam (Kanak)](https://github.com/alamkanak) and the widget this library was inspired by  [Android-Week-View](https://github.com/alamkanak/Android-Week-View)
* [Quivr](https://github.com/Quivr)'s fork https://github.com/Quivr/Android-Week-View
* The Github community and everyone that contributed to Android-Week-View.

The MIT License (MIT)
=====================

Copyright © `2018` `Jean Luis Urena`

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the “Software”), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
