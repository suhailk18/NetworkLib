package com.networkmodule.api;


import com.networkmodule.responsepojo.CountriesResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

interface AppServices {

  /*@POST(NetworkUtility.SUB_BASE_URL + "UserDevices")
  Call<DefaultResponsePojo> userDevices(@Body UserDeviceInputPojo userDeviceInputPojo);*/

	@GET
	Call<ResponseBody> downloadFileWithDynamicUrlSync(@Url String fileUrl);

	@GET("rest/v2/alpha/ind")
	Call<CountriesResponse> getCountries();
}
