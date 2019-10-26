package configurations;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import common.Constant;
import configurations.ConfigurationContract.Presenter;
import model.ActionsConfiguration;
import model.Configuration;
import model.InteractiveTimeConfiguration;
import model.PeriodTime;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class ConfigurationsFrame extends JFrame implements ConfigurationContract.View {

	private JPanel contentPane;
	private JSpinner spInteractPeriodStart;
	private JSpinner spInteractPeriodEnd;
	private JSpinner spLikePeriodEnd;
	private JSpinner spLikePeriodStart;
	private JSpinner spCommentPeriodEnd;
	private JSpinner spCommentPeriodStart;
	private JSpinner spAddFriendPeriodEnd;
	private JSpinner spAddFriendPeriodStart;
	private JSpinner spJoindGroupPeriodEnd;
	private JSpinner spJoindGroupPeriodStart;
	private JCheckBox cbAutoComment;
	private JCheckBox cbAutoAcceptFriend;
	private JCheckBox cbAutoShare;
	private JCheckBox cbAutoAddFriendSuggestion;
	private JCheckBox cbJoinGroup;
	private JCheckBox cbAddFriendByUID;
	private JCheckBox cbAutoLike;
	private JTable groupIDsTable;
	private JTable friendUIDTable;
	private JSpinner spJoinGrPerDay;
	private JSpinner spAddFriendPerDay;

	private ConfigurationContract.Presenter presenter;

	/**
	 * Create the frame.
	 */
	public ConfigurationsFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1166, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel chTuongTac = new JPanel();
		chTuongTac.setBorder(new TitledBorder(null, "C\u1EA5u h\u00ECnh t\u01B0\u01A1ng t\u00E1c", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		chTuongTac.setBounds(0, 0, 540, 304);
		panel.add(chTuongTac);
		chTuongTac.setLayout(null);

		JLabel lblThiGianCh = new JLabel("Th\u1EDDi gian ch\u1EDD m\u1ED7i l\u1EA7n k\u1EBFt b\u1EA1n");
		lblThiGianCh.setBounds(24, 72, 201, 14);
		chTuongTac.add(lblThiGianCh);

		JLabel label = new JLabel("Th\u1EDDi gian ch\u1EDD m\u1ED7i l\u1EA7n tham gia nh\u00F3m");
		label.setBounds(24, 29, 201, 14);
		chTuongTac.add(label);

		JLabel lblThiGianCh_1 = new JLabel("Th\u1EDDi gian ch\u1EDD m\u1ED7i l\u1EA7n comment");
		lblThiGianCh_1.setBounds(24, 115, 201, 14);
		chTuongTac.add(lblThiGianCh_1);

		JLabel lblThiGianCh_2 = new JLabel("Th\u1EDDi gian ch\u1EDD m\u1ED7i l\u1EA7n like");
		lblThiGianCh_2.setBounds(24, 158, 201, 14);
		chTuongTac.add(lblThiGianCh_2);

		JLabel lblThiGianCh_3 = new JLabel("Th\u1EDDi gian ch\u1EDD m\u1ED7i l\u1EA7n t\u01B0\u01A1ng t\u00E1c");
		lblThiGianCh_3.setBounds(24, 201, 201, 14);
		chTuongTac.add(lblThiGianCh_3);

		JLabel lblGiy = new JLabel("Gi\u00E2y");
		lblGiy.setBounds(488, 29, 49, 14);
		chTuongTac.add(lblGiy);

		JLabel label_4 = new JLabel("Gi\u00E2y");
		label_4.setBounds(488, 72, 49, 14);
		chTuongTac.add(label_4);

		JLabel label_5 = new JLabel("Gi\u00E2y");
		label_5.setBounds(488, 115, 49, 14);
		chTuongTac.add(label_5);

		JLabel label_6 = new JLabel("Gi\u00E2y");
		label_6.setBounds(488, 158, 49, 14);
		chTuongTac.add(label_6);

		JLabel label_8 = new JLabel("Gi\u00E2y");
		label_8.setBounds(488, 201, 49, 14);
		chTuongTac.add(label_8);

		spInteractPeriodStart = new JSpinner();
		spInteractPeriodStart.setBounds(268, 198, 75, 20);
		chTuongTac.add(spInteractPeriodStart);

		spInteractPeriodEnd = new JSpinner();
		spInteractPeriodEnd.setBounds(390, 198, 75, 20);
		chTuongTac.add(spInteractPeriodEnd);

		spLikePeriodEnd = new JSpinner();
		spLikePeriodEnd.setBounds(390, 155, 75, 20);
		chTuongTac.add(spLikePeriodEnd);

		spLikePeriodStart = new JSpinner();
		spLikePeriodStart.setBounds(268, 155, 75, 20);
		chTuongTac.add(spLikePeriodStart);

		spCommentPeriodEnd = new JSpinner();
		spCommentPeriodEnd.setBounds(390, 112, 75, 20);
		chTuongTac.add(spCommentPeriodEnd);

		spCommentPeriodStart = new JSpinner();
		spCommentPeriodStart.setBounds(268, 112, 75, 20);
		chTuongTac.add(spCommentPeriodStart);

		spAddFriendPeriodEnd = new JSpinner();
		spAddFriendPeriodEnd.setBounds(390, 69, 75, 20);
		chTuongTac.add(spAddFriendPeriodEnd);

		spAddFriendPeriodStart = new JSpinner();
		spAddFriendPeriodStart.setBounds(268, 69, 75, 20);
		chTuongTac.add(spAddFriendPeriodStart);

		spJoindGroupPeriodEnd = new JSpinner();
		spJoindGroupPeriodEnd.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spJoindGroupPeriodEnd.setBounds(390, 26, 75, 20);
		chTuongTac.add(spJoindGroupPeriodEnd);

		spJoindGroupPeriodStart = new JSpinner();
		spJoindGroupPeriodStart.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spJoindGroupPeriodStart.setBounds(268, 26, 75, 20);
		chTuongTac.add(spJoindGroupPeriodStart);

		JLabel label_1 = new JLabel("->");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(353, 201, 27, 14);
		chTuongTac.add(label_1);

		JLabel label_2 = new JLabel("->");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(353, 158, 27, 14);
		chTuongTac.add(label_2);

		JLabel label_3 = new JLabel("->");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(353, 115, 27, 14);
		chTuongTac.add(label_3);

		JLabel label_7 = new JLabel("->");
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(353, 72, 27, 14);
		chTuongTac.add(label_7);

		JLabel label_9 = new JLabel("->");
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(353, 29, 27, 14);
		chTuongTac.add(label_9);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "H\u00E0nh \u0111\u1ED9ng cho ph\u00E9p", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 306, 540, 132);
		panel.add(panel_1);
		panel_1.setLayout(null);

		cbAutoComment = new JCheckBox("T\u1EF1 \u0111\u1ED9ng Comment");
		cbAutoComment.setSelected(true);
		cbAutoComment.setBounds(40, 26, 143, 23);
		panel_1.add(cbAutoComment);

		cbAutoAcceptFriend = new JCheckBox("Ch\u1EA5p nh\u1EADn k\u1EBFt b\u1EA1n ");
		cbAutoAcceptFriend.setSelected(true);
		cbAutoAcceptFriend.setBounds(40, 66, 143, 23);
		panel_1.add(cbAutoAcceptFriend);

		cbAutoShare = new JCheckBox("T\u1EF1 \u0111\u1ED9ng Share");
		cbAutoShare.setSelected(true);
		cbAutoShare.setBounds(206, 26, 143, 23);
		panel_1.add(cbAutoShare);

		cbAutoAddFriendSuggestion = new JCheckBox("K\u1EBFt b\u1EA1n theo g\u1EE3i \u00FD");
		cbAutoAddFriendSuggestion.setSelected(true);
		cbAutoAddFriendSuggestion.setBounds(206, 66, 143, 23);
		panel_1.add(cbAutoAddFriendSuggestion);

		cbJoinGroup = new JCheckBox("T\u1EF1 \u0111\u1ED9ng v\u00E0o nh\u00F3m");
		cbJoinGroup.setSelected(true);
		cbJoinGroup.setBounds(372, 26, 150, 23);
		panel_1.add(cbJoinGroup);

		cbAddFriendByUID = new JCheckBox("K\u1EBFt b\u1EA1n theo UID");
		cbAddFriendByUID.setSelected(true);
		cbAddFriendByUID.setBounds(372, 66, 143, 23);
		panel_1.add(cbAddFriendByUID);

		cbAutoLike = new JCheckBox("T\u1EF1 \u0111\u1ED9ng like");
		cbAutoLike.setSelected(true);
		cbAutoLike.setBounds(40, 102, 143, 23);
		panel_1.add(cbAutoLike);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Danh s\u00E1ch nh\u00F3m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(550, 0, 285, 438);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 265, 342);
		panel_2.add(scrollPane);

		groupIDsTable = new JTable();
		scrollPane.setViewportView(groupIDsTable);

		JLabel lblMiTiKhon = new JLabel("M\u1ED7i t\u00E0i kho\u1EA3n tham gia");
		lblMiTiKhon.setBounds(10, 376, 127, 14);
		panel_2.add(lblMiTiKhon);

		JLabel lblNhmNgy = new JLabel("nh\u00F3m/1 ng\u00E0y");
		lblNhmNgy.setBounds(193, 376, 82, 14);
		panel_2.add(lblNhmNgy);

		JButton btnDeleteAllGroupIds = new JButton("Xo\u00E1 t\u1EA5t c\u1EA3");
		btnDeleteAllGroupIds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllGroupIds();
			}
		});
		btnDeleteAllGroupIds.setBounds(10, 404, 127, 23);
		panel_2.add(btnDeleteAllGroupIds);

		JButton btnThmIdNhm = new JButton("Th\u00EAm ID nh\u00F3m");
		btnThmIdNhm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openGroupIds();
			}
		});
		btnThmIdNhm.setBounds(147, 404, 128, 23);
		panel_2.add(btnThmIdNhm);

		spJoinGrPerDay = new JSpinner();
		spJoinGrPerDay.setModel(new SpinnerNumberModel(5, 1, 100, 1));
		spJoinGrPerDay.setBounds(131, 373, 52, 20);
		panel_2.add(spJoinGrPerDay);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch UID k\u1EBFt b\u1EA1n",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(845, 0, 285, 438);
		panel.add(panel_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 25, 265, 340);
		panel_3.add(scrollPane_1);

		friendUIDTable = new JTable();
		scrollPane_1.setViewportView(friendUIDTable);

		JLabel lblMiTiKhon_1 = new JLabel("M\u1ED7i t\u00E0i kho\u1EA3n k\u1EBFt");
		lblMiTiKhon_1.setBounds(10, 376, 127, 14);
		panel_3.add(lblMiTiKhon_1);

		JLabel lblBnNgy = new JLabel("b\u1EA1n /1 ng\u00E0y");
		lblBnNgy.setBounds(203, 376, 82, 14);
		panel_3.add(lblBnNgy);

		JButton btnDeleteAllFriendUIDs = new JButton("Xo\u00E1 t\u1EA5t c\u1EA3");
		btnDeleteAllFriendUIDs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllFriendUIds();
			}
		});
		btnDeleteAllFriendUIDs.setBounds(10, 404, 127, 23);
		panel_3.add(btnDeleteAllFriendUIDs);

		JButton btnAddUIDsFriend = new JButton("Th\u00EAm UID b\u1EA1n");
		btnAddUIDsFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFriendUIDs();
			}
		});
		btnAddUIDsFriend.setBounds(147, 404, 128, 23);
		panel_3.add(btnAddUIDsFriend);

		spAddFriendPerDay = new JSpinner();
		spAddFriendPerDay.setModel(new SpinnerNumberModel(5, 5, 100, 1));
		spAddFriendPerDay.setBounds(141, 373, 52, 20);
		panel_3.add(spAddFriendPerDay);

		JButton btnSaveAllConfigurations = new JButton("L\u01B0u c\u1EA5u h\u00ECnh");
		btnSaveAllConfigurations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.saveConfiguration(readAllValuesFromView());
			}
		});
		btnSaveAllConfigurations.setBounds(10, 449, 137, 40);
		panel.add(btnSaveAllConfigurations);

		JButton btnExit = new JButton("Tho\u00E1t kh\u00F4ng l\u01B0u");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(178, 449, 137, 40);
		panel.add(btnExit);
	}

	protected Configuration readAllValuesFromView() {
		Configuration configuration = new Configuration();

		ActionsConfiguration actionsConfiguration = new ActionsConfiguration();
		actionsConfiguration.setAutoComment(cbAutoComment.isSelected());
		actionsConfiguration.setAutoShare(cbAutoShare.isSelected());
		actionsConfiguration.setAutoJoindGroup(cbJoinGroup.isSelected());
		actionsConfiguration.setAutoAcceptAddFriendRequest(cbAutoAcceptFriend.isSelected());
		actionsConfiguration.setAutoComment(cbAutoComment.isSelected());
		actionsConfiguration.setAutoAddFriendByUID(cbAddFriendByUID.isSelected());
		actionsConfiguration.setAutoAddFriendSugesstion(cbAutoAddFriendSuggestion.isSelected());
		actionsConfiguration.setAutoLike(cbAutoLike.isSelected());
		configuration.setActionsConfiguration(actionsConfiguration);

		InteractiveTimeConfiguration timeConfiguration = new InteractiveTimeConfiguration();
		timeConfiguration.setCommentTime(new PeriodTime(Integer.valueOf(spCommentPeriodStart.getValue().toString()),
				Integer.valueOf(spCommentPeriodEnd.getValue().toString())));
		timeConfiguration
				.setJoinGroupTime(new PeriodTime(Integer.valueOf(spJoindGroupPeriodStart.getValue().toString()),
						Integer.valueOf(spJoindGroupPeriodEnd.getValue().toString())));
		timeConfiguration.setAddFriendTime(new PeriodTime(Integer.valueOf(spAddFriendPeriodStart.getValue().toString()),
				Integer.valueOf(spAddFriendPeriodEnd.getValue().toString())));

		timeConfiguration
				.setInteractiveTime(new PeriodTime(Integer.valueOf(spInteractPeriodStart.getValue().toString()),
						Integer.valueOf(spInteractPeriodEnd.getValue().toString())));
		timeConfiguration.setAddFriendsPerDay(Integer.valueOf(spAddFriendPerDay.getValue().toString()));
		timeConfiguration.setJoinGroupsPerDay(Integer.valueOf(spJoinGrPerDay.getValue().toString()));

		timeConfiguration.setLikeTime(new PeriodTime(Integer.valueOf(spLikePeriodStart.getValue().toString()),
				Integer.valueOf(spLikePeriodEnd.getValue().toString())));
		configuration.setInteractiveTimeConfiguration(timeConfiguration);

		ArrayList<String> friendUIDs = getFriendUIdsFromTable();
		configuration.setFriendUIDs(friendUIDs);
		ArrayList<String> groupIds = getGroupIDsFromTable();
		configuration.setGroupIDs(groupIds);

		return configuration;
	}

	private ArrayList<String> getFriendUIdsFromTable() {
		DefaultTableModel tableModel = (DefaultTableModel) friendUIDTable.getModel();
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			result.add(String.valueOf(tableModel.getValueAt(i, 1)));
		}
		return result;
	}

	private ArrayList<String> getGroupIDsFromTable() {
		DefaultTableModel tableModel = (DefaultTableModel) groupIDsTable.getModel();
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			result.add(String.valueOf(tableModel.getValueAt(i, 1)));
		}
		return result;
	}

	protected void deleteAllGroupIds() {
		DefaultTableModel groupIdModel = new DefaultTableModel(null, new String[] { "STT", "Group IDs" });
		groupIDsTable.setModel(groupIdModel);
	}

	protected void deleteAllFriendUIds() {
		DefaultTableModel friendUIDModel = new DefaultTableModel(null, new String[] { "STT", "Friends UID" });
		friendUIDTable.setModel(friendUIDModel);
	}

	protected void openGroupIds() {
		JFileChooser chooser = new JFileChooser();
		int filename = chooser.showOpenDialog(null);
		if (filename == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			System.out.println(f.getName());
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String groupId = br.readLine();
				int idNumber = 0;
				DefaultTableModel groupIdModel = new DefaultTableModel(null, new String[] { "STT", "Group IDs" });
				while (groupId != null) {
					idNumber++;
					groupId = br.readLine();
					groupIdModel.addRow(new String[] { String.valueOf(idNumber), groupId });
				}
				br.close();
				groupIDsTable.setModel(groupIdModel);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void openFriendUIDs() {
		JFileChooser chooser = new JFileChooser();
		int filename = chooser.showOpenDialog(null);
		if (filename == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			System.out.println(f.getName());
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String friendUID = br.readLine();
				int idNumber = 0;
				DefaultTableModel friendUIDModel = new DefaultTableModel(null, new String[] { "STT", "Friends UID" });
				while (friendUID != null) {
					idNumber++;
					friendUID = br.readLine();
					friendUIDModel.addRow(new String[] { String.valueOf(idNumber), friendUID });
				}
				br.close();
				friendUIDTable.setModel(friendUIDModel);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		presenter.loadConfigurationValues();
	}

	@Override
	public void showConfigurationValues(Configuration configuration) {
		System.out.println("showConfigurationValues");
		DefaultTableModel groupIdModel = new DefaultTableModel(null, new String[] { "STT", "Group ID" });
		for (int i = 0; i < configuration.getGroupIDs().size(); i++) {
			groupIdModel.addRow(new String[] { "" + (i + 1), configuration.getGroupIDs().get(i) });
		}
		groupIDsTable.setModel(groupIdModel);

		DefaultTableModel friendUIDModel = new DefaultTableModel(null, new String[] { "STT", "Friend UID" });
		for (int i = 0; i < configuration.getFriendUIDs().size(); i++) {
			friendUIDModel.addRow(new String[] { "" + (i + 1), configuration.getFriendUIDs().get(i) });
		}
		friendUIDTable.setModel(friendUIDModel);

		spJoindGroupPeriodStart.setValue(configuration.getInteractiveTimeConfiguration().getJoinGroupTime().getStart());
		spJoindGroupPeriodEnd.setValue(configuration.getInteractiveTimeConfiguration().getJoinGroupTime().getEnd());

		spCommentPeriodStart.setValue(configuration.getInteractiveTimeConfiguration().getCommentTime().getStart());
		spCommentPeriodEnd.setValue(configuration.getInteractiveTimeConfiguration().getCommentTime().getEnd());

		spLikePeriodStart.setValue(configuration.getInteractiveTimeConfiguration().getLikeTime().getStart());
		spLikePeriodEnd.setValue(configuration.getInteractiveTimeConfiguration().getLikeTime().getEnd());

		spInteractPeriodStart.setValue(configuration.getInteractiveTimeConfiguration().getInteractiveTime().getStart());
		spInteractPeriodEnd.setValue(configuration.getInteractiveTimeConfiguration().getInteractiveTime().getEnd());

		spAddFriendPeriodStart.setValue(configuration.getInteractiveTimeConfiguration().getAddFriendTime().getStart());
		spAddFriendPeriodEnd.setValue(configuration.getInteractiveTimeConfiguration().getAddFriendTime().getEnd());

		spJoinGrPerDay.setValue(configuration.getInteractiveTimeConfiguration().getJoinGroupsPerDay());
		spAddFriendPerDay.setValue(configuration.getInteractiveTimeConfiguration().getAddFriendsPerDay());

		cbAutoComment.setSelected(configuration.getActionsConfiguration().isAutoComment());
		cbAutoShare.setSelected(configuration.getActionsConfiguration().isAutoShare());
		cbJoinGroup.setSelected(configuration.getActionsConfiguration().isAutoJoindGroup());
		cbAutoAcceptFriend.setSelected(configuration.getActionsConfiguration().isAutoAcceptAddFriendRequest());
		cbAutoAddFriendSuggestion.setSelected(configuration.getActionsConfiguration().isAutoAddFriendSugesstion());
		cbAddFriendByUID.setSelected(configuration.getActionsConfiguration().isAutoAddFriendByUID());
		cbAutoLike.setSelected(configuration.getActionsConfiguration().isAutoLike());
	}

	@Override
	public void disposeFrame() {
		dispose();
	}

}
