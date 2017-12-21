# (Swing Library) Fullscreen


 ### Features :
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Auto Mode & Manual Mode
 * Make Fullscreen GUI
 * Enable/Disable Decoration on the go
 * Maximize (Both Vertical & Horizontal  or Only Vertical and Horizontal)
 * Minimize
 * Close
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

### How to install :

* Download the jar from [here](https://github.com/arghadasofficial/Fullscreen-Library/raw/master/dist/Fullscreen_Library.jar)
* Add it to you project



###  Auto Mode :
* First import the cass
* Second initialize the class and pass Parameter values
* Third and Last call the method DoTheWorkFor(); to actually do the work for you


```java
import argha.util.Fullscreen;
```

```java
/**
 * this refers to JFrame
 * true refers to Decorations enable/disable make it false if you want decorations
 */
Fullscreen screen = new Fullscreen(this, true);
```

```java
screen.DoTheWorkFor();
```
### Code Snippet :
```java
/*
 * Copyright (C) 2017 Argha Das
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package argha.util;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import argha.util.Fullscreen;

/**
 *
 * @author Argha Das
 */
public class Snippet extends JFrame {

    private Fullscreen screen;

    public Snippet() {
        screen = new Fullscreen(this, true);
        buildGUI();
        screen.DoTheWorkFor();
    }

    private void buildGUI() {
        setTitle("Fullscreen Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Snippet().setVisible(true);
            }
        });
    }

}

```

