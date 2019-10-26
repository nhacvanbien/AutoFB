package model;

public class InteractiveTimeConfiguration {
	private PeriodTime joinGroupTime;
	private PeriodTime addFriendTime;
	private PeriodTime commentTime;
	private PeriodTime likeTime;
	private PeriodTime interactiveTime;
	
	private int joinGroupsPerDay;
	private int addFriendsPerDay;
	
	
	
	public InteractiveTimeConfiguration() {
		super();
	}
	public InteractiveTimeConfiguration(PeriodTime joinGroupTime, PeriodTime addFriendTime, PeriodTime commentTime,
			PeriodTime likeTime, PeriodTime interactiveTime) {
		super();
		this.joinGroupTime = joinGroupTime;
		this.addFriendTime = addFriendTime;
		this.commentTime = commentTime;
		this.likeTime = likeTime;
		this.interactiveTime = interactiveTime;
	}
	public PeriodTime getJoinGroupTime() {
		return joinGroupTime;
	}
	public void setJoinGroupTime(PeriodTime joinGroupTime) {
		this.joinGroupTime = joinGroupTime;
	}
	public PeriodTime getAddFriendTime() {
		return addFriendTime;
	}
	public void setAddFriendTime(PeriodTime addFriendTime) {
		this.addFriendTime = addFriendTime;
	}
	public PeriodTime getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(PeriodTime commentTime) {
		this.commentTime = commentTime;
	}
	public PeriodTime getLikeTime() {
		return likeTime;
	}
	public void setLikeTime(PeriodTime likeTime) {
		this.likeTime = likeTime;
	}
	public PeriodTime getInteractiveTime() {
		return interactiveTime;
	}
	public void setInteractiveTime(PeriodTime interactiveTime) {
		this.interactiveTime = interactiveTime;
	}
	public int getJoinGroupsPerDay() {
		return joinGroupsPerDay;
	}
	public void setJoinGroupsPerDay(int joinGroupsPerDay) {
		this.joinGroupsPerDay = joinGroupsPerDay;
	}
	public int getAddFriendsPerDay() {
		return addFriendsPerDay;
	}
	public void setAddFriendsPerDay(int addFriendsPerDay) {
		this.addFriendsPerDay = addFriendsPerDay;
	}
	
	
	
}
