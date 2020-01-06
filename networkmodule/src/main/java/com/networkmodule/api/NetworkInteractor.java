package com.networkmodule.api;

import androidx.lifecycle.MutableLiveData;

import com.networkmodule.responsepojo.CountriesResponse;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkInteractor implements INetworkInteractor {

	@Override
	public void downloadByUrl(String url, OnDownloadSuccess onDownloadSuccess) {
		final Call<ResponseBody> downloadFileCall = ServiceWrapper
				.getInstance().downloadFileWithDynamicUrlSync(url);
		try {
			Response responseBody = downloadFileCall.execute();
			if (responseBody != null) {
				if (responseBody.isSuccessful()) {
					onDownloadSuccess.onSuccess((ResponseBody) responseBody.body());
				} else {
					onDownloadSuccess.onError(responseBody.message());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MutableLiveData<CountriesResponse> getAllCountries(final OnCountriesSuccess onDownloadSuccess) {
		final MutableLiveData<CountriesResponse> responseMutableLiveData = new MutableLiveData<>();
		final Call<CountriesResponse> responseBodyCall = ServiceWrapper
				.getInstance().getCountries();
		responseBodyCall.enqueue(new Callback<CountriesResponse>() {
			@Override
			public void onResponse(Call<CountriesResponse> call, Response<CountriesResponse> response) {
				if (response.isSuccessful()) {
					responseMutableLiveData.setValue(response.body());
					onDownloadSuccess.onSuccess(response.body());
				}else {
					onDownloadSuccess.onError(response.message());
				}
			}
			@Override
			public void onFailure(Call<CountriesResponse> call, Throwable t) {
				responseMutableLiveData.setValue(null);
				onDownloadSuccess.onFailed(t.getLocalizedMessage());
			}
		});
		return responseMutableLiveData;
	}
}