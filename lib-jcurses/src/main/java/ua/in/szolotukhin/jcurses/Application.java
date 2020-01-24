package ua.in.szolotukhin.jcurses;

import jcurses.widgets.DefaultLayoutManager;
import jcurses.widgets.TextArea;
import jcurses.widgets.WidgetsConstants;
import jcurses.widgets.Window;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
	public static void main(String[] args) throws InterruptedException {
		log.info("lib path: [{}]", System.getProperty("java.library.path"));

		Window w = new Window(100, 50, true, "Hai hai!");
		TextArea textArea = new TextArea();

		DefaultLayoutManager mgr = new DefaultLayoutManager();
		mgr.bindToContainer(w.getRootPanel());
		mgr.addWidget(textArea, 2, 2, 50, 20,
				WidgetsConstants.ALIGNMENT_CENTER, WidgetsConstants.ALIGNMENT_CENTER);

		String text = "The runtime configuration has been deprecated for resolution. \n";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			sb.append(text);
		}

		textArea.setText(sb.toString());

		w.show();

		Thread.currentThread();
		Thread.sleep(30000);

		w.close();
	}
}
