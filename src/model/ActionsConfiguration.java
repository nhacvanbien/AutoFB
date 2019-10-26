package model;

public class ActionsConfiguration {

	private boolean autoComment;
	private boolean autoShare;
	private boolean autoJoindGroup;
	private boolean autoAcceptAddFriendRequest;
	private boolean autoAddFriendSugesstion;
	private boolean autoAddFriendByUID;

	private boolean autoLike;
	public ActionsConfiguration() {
		super();
	}
	public ActionsConfiguration(boolean autoComment, boolean autoShare, boolean autoJoindGroup,
			boolean autoAcceptAddFriendRequest, boolean autoAddFriendSugesstion, boolean autoAddFriendByUID) {
		super();
		this.autoComment = autoComment;
		this.autoShare = autoShare;
		this.autoJoindGroup = autoJoindGroup;
		this.autoAcceptAddFriendRequest = autoAcceptAddFriendRequest;
		this.autoAddFriendSugesstion = autoAddFriendSugesstion;
		this.autoAddFriendByUID = autoAddFriendByUID;
	}
	public boolean isAutoComment() {
		return autoComment;
	}
	public void setAutoComment(boolean autoComment) {
		this.autoComment = autoComment;
	}
	public boolean isAutoShare() {
		return autoShare;
	}
	public void setAutoShare(boolean autoShare) {
		this.autoShare = autoShare;
	}
	public boolean isAutoJoindGroup() {
		return autoJoindGroup;
	}
	public void setAutoJoindGroup(boolean autoJoindGroup) {
		this.autoJoindGroup = autoJoindGroup;
	}
	public boolean isAutoAcceptAddFriendRequest() {
		return autoAcceptAddFriendRequest;
	}
	public void setAutoAcceptAddFriendRequest(boolean autoAcceptAddFriendRequest) {
		this.autoAcceptAddFriendRequest = autoAcceptAddFriendRequest;
	}
	public boolean isAutoAddFriendSugesstion() {
		return autoAddFriendSugesstion;
	}
	public void setAutoAddFriendSugesstion(boolean autoAddFriendSugesstion) {
		this.autoAddFriendSugesstion = autoAddFriendSugesstion;
	}
	public boolean isAutoAddFriendByUID() {
		return autoAddFriendByUID;
	}
	public void setAutoAddFriendByUID(boolean autoAddFriendByUID) {
		this.autoAddFriendByUID = autoAddFriendByUID;
	}
	public boolean isAutoLike() {
		return autoLike;
	}
	public void setAutoLike(boolean autoLike) {
		this.autoLike = autoLike;
	}
	
}
