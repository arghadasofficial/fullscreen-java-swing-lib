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

    private JFrame frame;
    private boolean isdecorated;
    private Screen screen;
    private Utils util;
    private boolean isFullscreen = false;
    private Toolbar toolbar;

    public Fullscreen(JFrame frame, boolean isdecorated) {
        this.frame = frame;
        this.isdecorated = isdecorated;
        screen = new Screen();
        toolbar = new Toolbar();
        util = new Utils(frame);
        screen.measureScreen();
        launchSize();
        keyDetector();
    }

    public void DoTheWorkFor() {
        util.disposeFrame();
        frame.setSize(screen.getWidth(), screen.getHeight());
        frame.setUndecorated(isdecorated);
        if (isdecorated == false) {
            maximize();
            isFullscreen = true;
        }
    }

    public void enableToolbar() {

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
