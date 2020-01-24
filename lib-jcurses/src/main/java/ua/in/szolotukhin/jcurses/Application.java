package ua.in.szolotukhin.jcurses;

import jcurses.event.ItemEvent;
import jcurses.event.ItemListener;
import jcurses.layout.DefaultLayoutManager;
import jcurses.widgets.WidgetsConstants;
import jcurses.widgets.component.menu.MenuList;
import jcurses.widgets.component.menu.PopUpMenu;
import jcurses.widgets.window.Window;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
	public static void main(String[] args) throws InterruptedException {
		log.info("lib path: [{}]", System.getProperty("java.library.path"));

		Window window = new Window(100, 50, true, "Hai hai!");

		DefaultLayoutManager mgr = new DefaultLayoutManager();
		mgr.bindToContainer(window.getRootPanel());

		/*TextArea textArea = new TextArea();
		String text = "The runtime configuration has been deprecated for resolution. \n";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			sb.append(text);
		}
		textArea.setText(sb.toString());

		mgr.addWidget(textArea, 2, 2, 50, 20,
				WidgetsConstants.ALIGNMENT_CENTER, WidgetsConstants.ALIGNMENT_CENTER);
*/

		MenuList menu = new MenuList();
		menu.add("Command 1");
		menu.add("Command 2");
		menu.add("Command 3");
		menu.addListener(new ItemListener() {
			@Override
			public void stateChanged(ItemEvent event) {
				PopUpMenu popUpMenu = new PopUpMenu(0, 0, "Event");
				popUpMenu.add("Item selected " + event.getType() + " " + event.getItem());
				popUpMenu.show();
			}
		});

		mgr.addWidget(menu, 0, 1, 50, 20,
				WidgetsConstants.ALIGNMENT_LEFT, WidgetsConstants.ALIGNMENT_TOP);

		window.show();

		Thread.currentThread();
		Thread.sleep(30000);

		window.close();
	}
}
