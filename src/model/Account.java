package model;

public class Account {
		private int id;
		private String username;
		private String password;
		private String displayName;
		private String birthday;
		private int friends;
		private int groups;
		private String token;
		private String cookie;
		private String staus;
		
		
		public Account() {
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getDisplayName() {
			return displayName;
		}
		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
		public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		public int getFriends() {
			return friends;
		}
		public void setFriends(int friends) {
			this.friends = friends;
		}
		public int getGroups() {
			return groups;
		}
		public void setGroups(int groups) {
			this.groups = groups;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getCookie() {
			return cookie;
		}
		public void setCookie(String cookie) {
			this.cookie = cookie;
		}
		public String getStaus() {
			return staus;
		}
		public void setStaus(String staus) {
			this.staus = staus;
		}
		
}
