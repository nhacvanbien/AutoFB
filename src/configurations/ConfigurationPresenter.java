package configurations;

import model.Configuration;

public class ConfigurationPresenter implements ConfigurationContract.Presenter {
	private ConfigurationContract.View view;
	private ConfiguraionsManager configuraionsManager;

	public ConfigurationPresenter(ConfigurationContract.View v) {
		this.view = v;
		configuraionsManager = new ConfiguraionsManager();
	}
	@Override
	public void loadConfigurationValues() {
		view.showConfigurationValues(configuraionsManager.loadConfigurationValues());
	}

	@Override
	public void saveConfiguration(Configuration configuration) {
		configuraionsManager.saveConfiguration(configuration);
		view.disposeFrame();
	}

}
