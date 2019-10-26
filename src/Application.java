import java.awt.EventQueue;

import javax.swing.UIManager;

import main.MainContract;
import main.MainFrame;
import main.MainPresenter;

public class Application {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainFrame frame = new MainFrame();
					MainPresenter  mainPresenter = new MainPresenter(frame);
					frame.setPresenter(mainPresenter);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
