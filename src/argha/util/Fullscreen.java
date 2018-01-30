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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Fullscreen implements KeyListener {

    //Variables
    private JFrame frame;
    private boolean isdecorated;
    private Screen screen;
    private Utils util;
    private boolean isFullscreen = false;

    /**
     *
     * The constructor takes to parameter one for the JFrame to be initialising
     * and the decoration enabling/disabling.
     *
     * @param frame pass the JFrame here
     *
     * @param isdecorated set it to false if you don't want the JFrame to be
     * undecorated, or true if you want it to be undecorated.
     */
    public Fullscreen(JFrame frame, boolean isdecorated) {
        this.frame = frame;
        this.isdecorated = isdecorated;
        screen = new Screen();
        util = new Utils(frame);
        screen.measureScreen();
        launchSize();
        keyDetector();
    }

    /**
     * This is the Automatic fullscreen enabler method, Call it and it will
     * first check Decorated (true/false), and then it makes the JFrame's window
     * to Fullscreen view.
     */
    public void DoTheWorkFor() {
        util.disposeFrame();
        frame.setSize(screen.getWidth(), screen.getHeight());
        frame.setUndecorated(isdecorated);
        if (isdecorated == false) {
            maximize();
            isFullscreen = true;
        }
    }

    private void keyDetector() {
        frame.addKeyListener(this);
    }

    private void launchSize() {
        frame.setSize(500, 500);
    }

    public void centered() {
        frame.setLocationRelativeTo(null);
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

    public void enableDecoration() {
        util.disposeFrame();
        isdecorated = false;
        DoTheWorkFor();
        util.enableFrame();
    }

    public void disableDecoration() {
        util.disposeFrame();
        isdecorated = true;
        DoTheWorkFor();
        util.enableFrame();
    }

    public void terminate() {
        System.exit(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        fullscreenToggle(e);
    }

    private void fullscreenToggle(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F11) {
            if (isFullscreen) {
                enableDecoration();
                isFullscreen = false;
            } else if (!isFullscreen) {
                disableDecoration();
                isFullscreen = true;
            }
        }
    }
}
