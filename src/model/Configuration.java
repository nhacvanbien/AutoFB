package model;

import java.util.ArrayList;

public class Configuration {
	private ActionsConfiguration actionsConfiguration;
	private InteractiveTimeConfiguration interactiveTimeConfiguration;
	private ArrayList<String> friendUIDs;
	private ArrayList<String> groupIDs;
	
	public Configuration() {};
	public Configuration(ActionsConfiguration actionsConfiguration,
			InteractiveTimeConfiguration interactiveTimeConfiguration, ArrayList<String> friendUIDs,
			ArrayList<String> groupIDs) {
		super();
		this.actionsConfiguration = actionsConfiguration;
		this.interactiveTimeConfiguration = interactiveTimeConfiguration;
		this.friendUIDs = friendUIDs;
		this.groupIDs = groupIDs;
	}
	public ActionsConfiguration getActionsConfiguration() {
		return actionsConfiguration;
	}
	public void setActionsConfiguration(ActionsConfiguration actionsConfiguration) {
		this.actionsConfiguration = actionsConfiguration;
	}
	public InteractiveTimeConfiguration getInteractiveTimeConfiguration() {
		return interactiveTimeConfiguration;
	}
	public void setInteractiveTimeConfiguration(InteractiveTimeConfiguration interactiveTimeConfiguration) {
		this.interactiveTimeConfiguration = interactiveTimeConfiguration;
	}
	public ArrayList<String> getFriendUIDs() {
		return friendUIDs;
	}
	public void setFriendUIDs(ArrayList<String> friendUIDs) {
		this.friendUIDs = friendUIDs;
	}
	public ArrayList<String> getGroupIDs() {
		return groupIDs;
	}
	public void setGroupIDs(ArrayList<String> groupIDs) {
		this.groupIDs = groupIDs;
	}
	
	
	
}
