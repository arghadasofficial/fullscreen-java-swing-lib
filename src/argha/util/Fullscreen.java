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

import java.awt.Frame;
import javax.swing.JFrame;

public class Fullscreen {
    
    private JFrame frame;
    private boolean bool;
    private Screen screen;
    private Utils util;
    
    public Fullscreen(JFrame frame, boolean bool) {
        screen = new Screen();
        this.frame = frame;
        this.bool = bool;
        util = new Utils(frame);
        screen.measureScreen();
    }
    
    public void DoTheWorkFor() {
        frame.dispose();
        frame.setSize(screen.getWidth(), screen.getHeight());
        frame.setUndecorated(bool);
        if (bool == false) {
            maximize();
        }
    }
    
    public void maximize() {
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
    
    public void maxmizeHortz() {
        frame.setExtendedState(Frame.MAXIMIZED_HORIZ);
    }
    
    public void maxmizeVert() {
        frame.setExtendedState(Frame.MAXIMIZED_VERT);
    }
    
    public void minimize() {
        frame.setState(Frame.ICONIFIED);
    }
    
    public void terminate() {
        System.exit(0);
    }
    
    public void enableDecoration() {
        util.disposeFrame();
        bool = false;
        DoTheWorkFor();
        util.enableFrame();
    }
    
    public void disableDecoration() {
        util.disposeFrame();
        bool = true;
        DoTheWorkFor();
        util.enableFrame();
    }
}
