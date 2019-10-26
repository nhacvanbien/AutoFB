package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import configurations.ConfigurationPresenter;
import configurations.ConfigurationsFrame;
import main.MainContract.Presenter;

public class MainFrame extends JFrame implements MainContract.View {

	private MainContract.Presenter presenter;
	
	private JPanel contentPane;
	private JTextField hmaPathField;
	private JTable accountsTable;
	private JTextField threadsCount;

	private JButton btnStart;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel actionsPanel = new JPanel();
		actionsPanel
				.setBorder(new TitledBorder(null, "Actions", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		actionsPanel.setBounds(10, 16, 961, 109);
		panel.add(actionsPanel);
		actionsPanel.setLayout(null);

		JButton btnLoadAccount = new JButton("Load Account");
		btnLoadAccount.setBounds(22, 23, 127, 50);
		actionsPanel.add(btnLoadAccount);

		JButton btnDeleteAllAccounts = new JButton("Delete all Accounts");
		btnDeleteAllAccounts.setBounds(171, 23, 127, 50);
		actionsPanel.add(btnDeleteAllAccounts);

		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationsFrame frame = new ConfigurationsFrame();
				ConfigurationPresenter presenter = new ConfigurationPresenter(frame);
				frame.setPresenter(presenter);
				frame.setResizable(false);
				frame.setVisible(true);
			}
		});
		btnSettings.setBounds(618, 23, 127, 50);
		actionsPanel.add(btnSettings);

		JButton btnDeleteDieAccount = new JButton("Delete die account");
		btnDeleteDieAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.deleteAllAccount();
			}
		});

		btnDeleteDieAccount.setBounds(320, 23, 127, 50);
		actionsPanel.add(btnDeleteDieAccount);

		JButton btnCheckLive = new JButton("Check Live");
		btnCheckLive.setBounds(469, 23, 127, 50);
		actionsPanel.add(btnCheckLive);

		threadsCount = new JTextField();
		threadsCount.setFont(new Font("Tahoma", Font.BOLD, 14));
		threadsCount.setHorizontalAlignment(SwingConstants.CENTER);
		threadsCount.setText("1");
		threadsCount.setBounds(871, 32, 63, 29);
		actionsPanel.add(threadsCount);
		threadsCount.setColumns(10);

		JLabel lblThreads = new JLabel("Threads Count");
		lblThreads.setForeground(Color.BLUE);
		lblThreads.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThreads.setBackground(Color.BLUE);
		lblThreads.setBounds(779, 41, 82, 14);
		actionsPanel.add(lblThreads);

		JPanel accountInfoPanel = new JPanel();
		accountInfoPanel.setBorder(
				new TitledBorder(null, "Account Infos", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		accountInfoPanel.setBounds(10, 136, 961, 345);
		panel.add(accountInfoPanel);

		accountInfoPanel.setLayout(null);

		accountsTable = new JTable();
		accountsTable.setBounds(20, 38, 941, 284);

		JScrollPane scrollPane = new JScrollPane(accountsTable);
		scrollPane.setBounds(10, 23, 941, 311);
		accountInfoPanel.add(scrollPane);

		// Internet panel
		JPanel internetConfigPanel = new JPanel();
		internetConfigPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Internet Configurations", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		internetConfigPanel.setBounds(10, 492, 465, 114);
		panel.add(internetConfigPanel);
		internetConfigPanel.setLayout(null);

		JRadioButton rdbtnNone = new JRadioButton("NONE");
		rdbtnNone.setBounds(28, 22, 109, 23);
		internetConfigPanel.add(rdbtnNone);

		JRadioButton rdbtnDcom = new JRadioButton("DCOM");
		rdbtnDcom.setBounds(28, 48, 69, 23);
		internetConfigPanel.add(rdbtnDcom);

		JRadioButton rdbtnHma = new JRadioButton("HMA");
		rdbtnHma.setBounds(28, 74, 69, 23);
		internetConfigPanel.add(rdbtnHma);

		hmaPathField = new JTextField();
		hmaPathField.setBounds(103, 74, 262, 20);
		internetConfigPanel.add(hmaPathField);
		hmaPathField.setColumns(10);

		JPanel startedPanel = new JPanel();
		startedPanel.setBounds(485, 492, 486, 114);
		panel.add(startedPanel);
		startedPanel.setLayout(null);

		btnStart = new JButton("Start");
		btnStart.setBounds(10, 11, 100, 92);
		startedPanel.add(btnStart);

		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(SystemColor.controlHighlight);
		statusPanel.setBounds(120, 11, 356, 92);
		startedPanel.add(statusPanel);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.start(null);
			}
		});
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		presenter.loadAccount();
	}

	@Override
	public void showAllAccounts(Object[][] data, Object[] columns) {
		TableModel model = new DefaultTableModel(data, columns);
		accountsTable.setModel(model);
	}
	
}