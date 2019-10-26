package common;

public class Constant {
	
	public static class  ConfigurationKeys{
		public static final String JOIN_GROUP_PERIOD_START = "JOIN_GROUP_PERIOD_START";
		public static final String JOIN_GROUP_PERIOD_END = "JOIN_GROUP_PERIOD_END";
		public static final String ADD_FRIEND_PERIOD_START = "ADD_FRIEND_PERIOD_START";
		public static final String ADD_FRIEND_PERIOD_END = "ADD_FRIEND_PERIOD_END";
		public static final String COMMENT_PERIOD_START = "COMMENT_PERIOD_START";
		public static final String COMMENT_PERIOD_END = "COMMENT_PERIOD_END";
		public static final String LIKE_PERIOD_START = "LIKE_PERIOD_START";
		public static final String LIKE_PERIOD_END = "LIKE_PERIOD_END";
		public static final String INTERACT_PERIOD_START = "INTERACT_PERIOD_START";
		public static final String INTERACT_PERIOD_END = "INTERACT_PERIOD_END";
		
		public static final String NUMBER_JOIND_GROUP_PER_DAY = "NUMBER_JOIND_GROUP_PER_DAY";
		public static final String NUMBER_ADD_FRIEND_PER_DAY = "NUMBER_ADD_FRIEND_PER_DAY";
		
		public static final String AUTO_COMMENT_ACTION = "AUTO_COMMENT_ACTION";
		public static final String AUTO_SHARE_ACTION = "AUTO_SHARE_ACTION";
		public static final String AUTO_JOIND_GROUP_ACTION = "AUTO_JOIND_GROUP_ACTION";
		public static final String AUTO_LIKE_ACTION = "AUTO_LIKE_ACTION";
		public static final String AUTO_ACCEPT_FRIEND_ACTION = "AUTO_ACCEPT_FRIEND_ACTION";
		public static final String AUTO_ADD_SUGGESTION_FRIEND_ACTION = "AUTO_ADD_SUGGESTION_FRIEND";
		public static final String AUTO_ADD_FRIEND_UID_ACTION = "AUTO_ADD_FRIEND_UID";
	}
	
	public static class DefaulConfigurationValues{
		public static final String JOIN_GROUP_PERIOD_START = String.valueOf(60);
		public static final String JOIN_GROUP_PERIOD_END = String.valueOf(60);
		public static final String ADD_FRIEND_PERIOD_START = String.valueOf(60);
		public static final String ADD_FRIEND_PERIOD_END = String.valueOf(60);
		public static final String COMMENT_PERIOD_START = String.valueOf(120);
		public static final String COMMENT_PERIOD_END = String.valueOf(300);
		public static final String LIKE_PERIOD_START = String.valueOf(60);
		public static final String LIKE_PERIOD_END = String.valueOf(60);
		public static final String INTERACT_PERIOD_START = String.valueOf(200);
		public static final String INTERACT_PERIOD_END = String.valueOf(300);
		
		public static final String NUMBER_JOIND_GROUP_PER_DAY = String.valueOf(10);
		public static final String NUMBER_ADD_FRIEND_PER_DAY = String.valueOf(50);
		
		public static final String AUTO_COMMENT_ACTION = "true";
		public static final String AUTO_SHARE_ACTION = "true";
		public static final String AUTO_JOIND_GROUP_ACTION = "true";
		public static final String AUTO_LIKE_ACTION = "true";
		public static final String AUTO_ACCEPT_FRIEND_ACTION = "true";
		public static final String AUTO_ADD_SUGGESTION_FRIEND_ACTION = "true";
		public static final String AUTO_ADD_FRIEND_UID_ACTION = "true";
	}
	
}
