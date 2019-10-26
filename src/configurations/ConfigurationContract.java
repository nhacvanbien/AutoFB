package configurations;

import base.BasePresenter;
import base.BaseView;
import model.Configuration;

public interface ConfigurationContract {
	/**
	 * @author ADMIN
	 *
	 */
	interface View extends BaseView<Presenter>{
		void showConfigurationValues(Configuration configuration);
		void disposeFrame();
	}
	
	interface Presenter{
		void loadConfigurationValues();
		
		void saveConfiguration(Configuration configuration);
	}
}
