package com.darwinsys.swingui;

import java.awt.Window;
import java.awt.event.*;

/** A WindowCloser - watch for Window Closing events, and
 * follow them up with setVisible(false), dispose(), and optionally
 * ends (it all) with a System.exit(0).
 * <p>
 * @deprecated For simple closing, just use JFrame.setDefaultCloseOperation().
 * @author Ian F. Darwin
 * @version $Id: WindowCloser.java,v 1.7 2003/05/29 18:06:31 ian Exp $
 */
public class WindowCloser extends WindowAdapter {

	/** The window we are to close */
	Window win;

	/** True if we are to exit as well. */
	boolean doExit = false;

	/** Construct a WindowCloser that doesn't exit, just closes the window */
	public WindowCloser(Window w) {
		this(w, false);
	}

	/** Construct a WindowCloser with control over whether it exits */
	public WindowCloser(Window w, boolean exit) {
		win = w;
		doExit = exit;
	}

	/** Called by AWT when the user tries to close the window */
	public void windowClosing(WindowEvent e) {
		win.setVisible(false);
		win.dispose();
		if (doExit)
			System.exit(0);
	}
}
