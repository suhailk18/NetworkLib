package com.digivalet.guestapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.networkmodule.api.INetworkInteractor;
import com.networkmodule.api.NetworkInteractor;
import com.networkmodule.responsepojo.CountriesResponse;

public class SplashViewModel extends ViewModel {

	private MutableLiveData<CountriesResponse> mutableLiveData;

	public void init() {
		if (mutableLiveData != null) {
			return;
		}
		mutableLiveData = new NetworkInteractor().getAllCountries(new INetworkInteractor.OnCountriesSuccess() {
			@Override
			public void onSuccess(CountriesResponse countriesResponse) {

			}

			@Override
			public void onFailed(String errorMsg) {

			}

			@Override
			public void onError(String errorMsg) {

			}
		});
	}

	public LiveData<CountriesResponse> getCountries() {
		return mutableLiveData;
	}

}
