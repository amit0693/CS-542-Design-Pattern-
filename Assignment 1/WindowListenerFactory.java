package textviewer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.function.Consumer;
//Structure proposed by lead Java 8 developer Brian Goetz on
//https://stackoverflow.com/questions/25299653/java-idiom-for-
//lambdas-with-non-sam-interfaces

public class WindowListenerFactory {

	/**
	 * Adapter to execute the specified behavior for a window closing event.
	 * @param c expected lambda expression that will have access to the 
	 * context where the code needs to execute. 
	 * @return a WindowAdapter that has a specific behavior for closing
	 * the Component that contains the lambda expression argument
	 */
	static WindowListener windowClosingFactory(Consumer<WindowEvent> c) {
		return new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				c.accept(e);
			}
		};
	}

	static WindowListener windowActivatedFactory(Consumer<WindowEvent> c) {
		return new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				c.accept(e);
			}
		};
	}

	static WindowListener windowClosedFactory(Consumer<WindowEvent> c) {
		return new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				c.accept(e);
			}
		};
	}

	static WindowListener windowDeactivatedFactory(Consumer<WindowEvent> c) {
		return new WindowAdapter() {
			public void windowDeactivated(WindowEvent e) {
				c.accept(e);
			}
		};
	}

	static WindowListener windowDeiconifiedFactory(Consumer<WindowEvent> c) {
		return new WindowAdapter() {
			public void windowDeiconified(WindowEvent e) {
				c.accept(e);
			}
		};
	}

	static WindowListener windowIconifiedFactory(Consumer<WindowEvent> c) {
		return new WindowAdapter() {
			public void windowIconified(WindowEvent e) {
				c.accept(e);
			}
		};
	}

	static WindowListener windowOpenedFactory(Consumer<WindowEvent> c) {
		return new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				c.accept(e);
			}
		};
	}
}
