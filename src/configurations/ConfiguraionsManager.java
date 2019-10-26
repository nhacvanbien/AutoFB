package configurations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import common.Constant;
import model.ActionsConfiguration;
import model.Configuration;
import model.InteractiveTimeConfiguration;
import model.PeriodTime;

public class ConfiguraionsManager {

	public ConfiguraionsManager() {

	}

	public Configuration loadConfigurationValues() {
		Configuration configuration = new Configuration();
		configuration.setFriendUIDs(loadCurrentFriendUIds());
		configuration.setGroupIDs(loadCurrentGroupIds());
		configuration.setActionsConfiguration(loadCurrentActionConfig());
		configuration.setInteractiveTimeConfiguration(loadCurrentTimeConfig());
		return configuration;
	}

	public void saveConfiguration(Configuration configuration) {
		saveActionValues(configuration);
		saveInteractiveTime(configuration);
		saveListId("groupIDs.txt", configuration.getGroupIDs());
		saveListId("friendUIDs.txt", configuration.getFriendUIDs());
	}

	protected void saveListId(String fileName, ArrayList<String> data) {
		try {
			File file = new File(fileName);
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			int rowCount = data.size();
			for (int i = 0; i < rowCount; i++) {
				bw.write(String.valueOf(data.get(i) + "\n"));
			}
			bw.close();
		} catch (Exception e) {
		}
	}

	protected void saveActionValues(Configuration configuration) {
		File configFile = new File("config1.properties");

		try {
			Properties props = new Properties();
			props.setProperty(Constant.ConfigurationKeys.AUTO_COMMENT_ACTION,
					String.valueOf(configuration.getActionsConfiguration().isAutoComment()));
			props.setProperty(Constant.ConfigurationKeys.AUTO_SHARE_ACTION,
					String.valueOf(configuration.getActionsConfiguration().isAutoShare()));
			props.setProperty(Constant.ConfigurationKeys.AUTO_JOIND_GROUP_ACTION,
					String.valueOf(configuration.getActionsConfiguration().isAutoJoindGroup()));
			props.setProperty(Constant.ConfigurationKeys.AUTO_ACCEPT_FRIEND_ACTION,
					String.valueOf(configuration.getActionsConfiguration().isAutoAcceptAddFriendRequest()));
			props.setProperty(Constant.ConfigurationKeys.AUTO_ADD_SUGGESTION_FRIEND_ACTION,
					String.valueOf(configuration.getActionsConfiguration().isAutoAddFriendSugesstion()));
			props.setProperty(Constant.ConfigurationKeys.AUTO_ADD_FRIEND_UID_ACTION,
					String.valueOf(configuration.getActionsConfiguration().isAutoAddFriendByUID()));
			props.setProperty(Constant.ConfigurationKeys.AUTO_LIKE_ACTION,
					String.valueOf(configuration.getActionsConfiguration().isAutoLike()));

			FileWriter writer = new FileWriter(configFile);
			props.store(writer, "ConfigurationValues");
			writer.close();
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
	}

	protected void saveInteractiveTime(Configuration configuration) {
		File configFile = new File("config1.properties");

		try {
			Properties props = new Properties();

			props.setProperty(Constant.ConfigurationKeys.JOIN_GROUP_PERIOD_START,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getJoinGroupTime().getStart()));
			props.setProperty(Constant.ConfigurationKeys.JOIN_GROUP_PERIOD_END,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getJoinGroupTime().getEnd()));

			props.setProperty(Constant.ConfigurationKeys.COMMENT_PERIOD_START,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getCommentTime().getStart()));
			props.setProperty(Constant.ConfigurationKeys.COMMENT_PERIOD_END,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getCommentTime().getEnd()));

			props.setProperty(Constant.ConfigurationKeys.LIKE_PERIOD_START,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getLikeTime().getStart()));
			props.setProperty(Constant.ConfigurationKeys.LIKE_PERIOD_END,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getLikeTime().getEnd()));

			props.setProperty(Constant.ConfigurationKeys.INTERACT_PERIOD_START,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getInteractiveTime().getStart()));
			props.setProperty(Constant.ConfigurationKeys.INTERACT_PERIOD_END,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getInteractiveTime().getEnd()));

			props.setProperty(Constant.ConfigurationKeys.ADD_FRIEND_PERIOD_START,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getAddFriendTime().getStart()));
			props.setProperty(Constant.ConfigurationKeys.ADD_FRIEND_PERIOD_END,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getAddFriendTime().getEnd()));

			props.setProperty(Constant.ConfigurationKeys.NUMBER_JOIND_GROUP_PER_DAY,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getJoinGroupsPerDay()));
			props.setProperty(Constant.ConfigurationKeys.NUMBER_ADD_FRIEND_PER_DAY,
					String.valueOf(configuration.getInteractiveTimeConfiguration().getAddFriendsPerDay()));

			FileWriter writer = new FileWriter(configFile);
			props.store(writer, "ConfigurationValues");
			writer.close();
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
	}

	protected ArrayList<String> loadCurrentFriendUIds() {
		ArrayList<String> result = new ArrayList<>();
		File f = new File("friendUIDs.txt");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return result;
			}
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String friendUID = br.readLine();
			while (friendUID != null) {
				result.add(friendUID);
				friendUID = br.readLine();
			}
			br.close();
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
	}

	protected ArrayList<String> loadCurrentGroupIds() {
		ArrayList<String> result = new ArrayList<>();
		File f = new File("groupIds.txt");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return result;
			}
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String groupId = br.readLine();
			while (groupId != null) {
				result.add(groupId);
				groupId = br.readLine();
			}
			br.close();
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
	}

	private ActionsConfiguration loadCurrentActionConfig() {
		ActionsConfiguration actionsConfiguration = new ActionsConfiguration();
		File configFile = new File("config1.properties");
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			actionsConfiguration.setAutoComment(
					Boolean.parseBoolean(props.getProperty(Constant.ConfigurationKeys.AUTO_COMMENT_ACTION,
							Constant.DefaulConfigurationValues.AUTO_COMMENT_ACTION)));
			actionsConfiguration.setAutoJoindGroup(
					Boolean.parseBoolean(props.getProperty(Constant.ConfigurationKeys.AUTO_JOIND_GROUP_ACTION,
							Constant.DefaulConfigurationValues.AUTO_JOIND_GROUP_ACTION)));

			actionsConfiguration
					.setAutoLike(Boolean.parseBoolean(props.getProperty(Constant.ConfigurationKeys.AUTO_LIKE_ACTION,
							Constant.DefaulConfigurationValues.AUTO_LIKE_ACTION)));

			actionsConfiguration
					.setAutoShare(Boolean.parseBoolean(props.getProperty(Constant.ConfigurationKeys.AUTO_SHARE_ACTION,
							Constant.DefaulConfigurationValues.AUTO_SHARE_ACTION)));

			actionsConfiguration.setAutoAddFriendByUID(
					Boolean.parseBoolean(props.getProperty(Constant.ConfigurationKeys.AUTO_ADD_FRIEND_UID_ACTION,
							Constant.DefaulConfigurationValues.AUTO_ADD_FRIEND_UID_ACTION)));

			actionsConfiguration.setAutoAddFriendSugesstion(
					Boolean.parseBoolean(props.getProperty(Constant.ConfigurationKeys.AUTO_ADD_SUGGESTION_FRIEND_ACTION,
							Constant.DefaulConfigurationValues.AUTO_ADD_SUGGESTION_FRIEND_ACTION)));

			actionsConfiguration.setAutoAcceptAddFriendRequest(
					Boolean.parseBoolean(props.getProperty(Constant.ConfigurationKeys.AUTO_ACCEPT_FRIEND_ACTION,
							Constant.DefaulConfigurationValues.AUTO_ACCEPT_FRIEND_ACTION)));
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}

		return actionsConfiguration;
	}

	private InteractiveTimeConfiguration loadCurrentTimeConfig() {
		InteractiveTimeConfiguration timeConfiguration = new InteractiveTimeConfiguration();
		File configFile = new File("config1.properties");
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);

			timeConfiguration
					.setJoinGroupTime(
							new PeriodTime(
									Integer.valueOf(props
											.getProperty(Constant.ConfigurationKeys.JOIN_GROUP_PERIOD_START,
													Constant.DefaulConfigurationValues.JOIN_GROUP_PERIOD_START)
											.toString()),
									Integer.valueOf(props
											.getProperty(Constant.ConfigurationKeys.JOIN_GROUP_PERIOD_END,
													Constant.DefaulConfigurationValues.JOIN_GROUP_PERIOD_END)
											.toString())));

			timeConfiguration
					.setCommentTime(
							new PeriodTime(
									Integer.valueOf(props
											.getProperty(Constant.ConfigurationKeys.COMMENT_PERIOD_START,
													Constant.DefaulConfigurationValues.COMMENT_PERIOD_START)
											.toString()),
									Integer.valueOf(props
											.getProperty(Constant.ConfigurationKeys.COMMENT_PERIOD_END,
													Constant.DefaulConfigurationValues.COMMENT_PERIOD_END)
											.toString())));

			timeConfiguration.setLikeTime(new PeriodTime(
					Integer.valueOf(props.getProperty(Constant.ConfigurationKeys.LIKE_PERIOD_START,
							Constant.DefaulConfigurationValues.LIKE_PERIOD_START).toString()),
					Integer.valueOf(props.getProperty(Constant.ConfigurationKeys.LIKE_PERIOD_END,
							Constant.DefaulConfigurationValues.LIKE_PERIOD_END).toString())));

			timeConfiguration
					.setInteractiveTime(
							new PeriodTime(
									Integer.valueOf(props
											.getProperty(Constant.ConfigurationKeys.INTERACT_PERIOD_START,
													Constant.DefaulConfigurationValues.INTERACT_PERIOD_START)
											.toString()),
									Integer.valueOf(props
											.getProperty(Constant.ConfigurationKeys.INTERACT_PERIOD_END,
													Constant.DefaulConfigurationValues.INTERACT_PERIOD_END)
											.toString())));

			timeConfiguration
					.setAddFriendTime(
							new PeriodTime(
									Integer.valueOf(props
											.getProperty(Constant.ConfigurationKeys.ADD_FRIEND_PERIOD_START,
													Constant.DefaulConfigurationValues.ADD_FRIEND_PERIOD_START)
											.toString()),
									Integer.valueOf(props
											.getProperty(Constant.ConfigurationKeys.ADD_FRIEND_PERIOD_END,
													Constant.DefaulConfigurationValues.ADD_FRIEND_PERIOD_END)
											.toString())));
			timeConfiguration.setAddFriendsPerDay(
					Integer.valueOf(props.getProperty(Constant.ConfigurationKeys.NUMBER_ADD_FRIEND_PER_DAY,
							Constant.DefaulConfigurationValues.NUMBER_ADD_FRIEND_PER_DAY).toString()));
			timeConfiguration.setJoinGroupsPerDay(
					Integer.valueOf(props.getProperty(Constant.ConfigurationKeys.NUMBER_JOIND_GROUP_PER_DAY,
							Constant.DefaulConfigurationValues.NUMBER_JOIND_GROUP_PER_DAY).toString()));

			reader.close();

		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
		return timeConfiguration;
	}

}
