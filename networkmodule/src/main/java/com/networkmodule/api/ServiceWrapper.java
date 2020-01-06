package com.networkmodule.api;




import com.networkmodule.responsepojo.CountriesResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * <p/>
 * This Wrapper class will be mediator of service interface and calling class. Whatever the features
 * of retrofit and okhttp api will implement, need to be put into this class. We can put common
 * webservice security features to this class so that we can increase the reusability of code.
 */
public class ServiceWrapper {

	public static AppServices service;/*= ServiceGenerator.createService(AppServices.class);*/
	private static ServiceWrapper serviceWrapper = new ServiceWrapper();

	private ServiceWrapper() {

	}

	public static ServiceWrapper getInstance() {

		if (service == null) {
			service = ServiceGenerator.createService(AppServices.class);
		}

		return serviceWrapper;
	}

  /*public Call<DefaultResponsePojo> userDeviceAPI(UserDeviceInputPojo userDeviceInputPojo) {
    return service.userDevices(userDeviceInputPojo);
  }*/
	public Call<ResponseBody> downloadFileWithDynamicUrlSync(String url){
		return service.downloadFileWithDynamicUrlSync(url);
	}

	public Call<CountriesResponse> getCountries(){
		return service.getCountries();
	}

}