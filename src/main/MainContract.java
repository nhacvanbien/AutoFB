package main;

import base.BasePresenter;
import model.Account;

public interface MainContract {
	interface View extends BasePresenter{

		void setPresenter(Presenter presenter);

		void showAllAccounts(Object[][] data, Object[] columns);
	}

	interface Presenter {
		void start(Account account);

		void loadAccount();

		void deleteAllAccount();
	}
}
