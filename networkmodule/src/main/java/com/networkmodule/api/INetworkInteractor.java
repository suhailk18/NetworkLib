package com.networkmodule.api;

import androidx.lifecycle.MutableLiveData;

import com.networkmodule.responsepojo.CountriesResponse;

import okhttp3.ResponseBody;

/**
 * This interface holds api calling stuffs.
 */
public interface INetworkInteractor {

  /*void userDeviceCall(UserDeviceInputPojo userDeviceInputPojo, HeaderInfo headerInfo,
                      OnUserDeviceListener onResponseListener);

  interface OnUserDeviceListener {

    void onSuccess(UserDeviceOutputPojo userDeviceOutputPojo);

    void onFailed(String errorMsg);

    void onError(String errorMsg);
  }*/

	void downloadByUrl(String url, OnDownloadSuccess onDownloadSuccess);

	interface OnDownloadSuccess {

		void onSuccess(ResponseBody responseBody);

		void onFailed(String errorMsg);

		void onError(String errorMsg);
	}

	MutableLiveData<CountriesResponse> getAllCountries(OnCountriesSuccess onDownloadSuccess);
	interface OnCountriesSuccess {

		void onSuccess(CountriesResponse countriesResponse);

		void onFailed(String errorMsg);

		void onError(String errorMsg);
	}
}
