package com.networkmodule.api;

import android.text.TextUtils;
import android.util.Log;


import com.google.gson.GsonBuilder;
import com.networkmodule.BuildConfig;
import com.networkmodule.networkutil.NetworkUtility;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class ServiceGenerator {

	private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	public static String BASE_URL ="https://restcountries.eu/";

	private static Retrofit.Builder builder(String BASE_URL) {
		if (BASE_URL.contains("google.com")) {
      /*if (!BASE_URL.endsWith("/")) {
        BASE_URL = BASE_URL + "/";
      }*/
		}
		return new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
						.setLenient()
						.create()));
	}


	public static <S> S createService(Class<S> serviceClass) {

		httpClient.retryOnConnectionFailure(true)
				.connectTimeout(120, TimeUnit.SECONDS)
				.readTimeout(90, TimeUnit.SECONDS)
				.writeTimeout(300, TimeUnit.SECONDS);

		if (BuildConfig.DEBUG) {
			HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
			loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
			httpClient.addInterceptor(loggingInterceptor);
		}
		return createService(serviceClass, "");
	}

	public static <S> S createService(Class<S> serviceClass, final HeaderInfo headerInfo) {
		try {
			if (headerInfo != null && !TextUtils.isEmpty(headerInfo.getApiVersionCode())) {

				httpClient.interceptors().add(new Interceptor() {
					@Override
					public okhttp3.Response intercept(Chain chain) throws IOException {
						Request original = chain.request();
						Request.Builder requestBuilder;
						if (original.url().toString().contains("favourite")) {
							// Request customization: add request headers
							requestBuilder = original.newBuilder()
									.method(original.method(), original.body());
						} else if (original.url().toString()
								.contains("google.com")) {
							requestBuilder = original.newBuilder()
									.method(original.method(), original.body());
						} else {
							// Request customization: add request headers
							requestBuilder = original.newBuilder()
									.header("Content-Type", NetworkUtility.CONTENT_TYPE)
									.header("Accept", headerInfo.getApiVersionCode())
									.method(original.method(), original.body());
						}
						Request request = requestBuilder.build();
						if (BuildConfig.DEBUG) {
							//bodyToString(request);
						}
						return chain.proceed(request);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		httpClient.sslSocketFactory(getSSLSocketFactory(), getX509TrustManager())
				.hostnameVerifier(new HostnameVerifier() {
					@Override
					public boolean verify(String s, SSLSession sslSession) {
						return true;
					}
				});

		OkHttpClient client = httpClient.build();
		BASE_URL = headerInfo.getBaseUrl();
		if (headerInfo.getBaseUrl().contains("google.com")) {
			BASE_URL = headerInfo.getBaseUrl();
		}
		Retrofit retrofit = builder(headerInfo.getBaseUrl()).client(client).build();
		return retrofit.create(serviceClass);
	}


	public static <S> S createService(Class<S> serviceClass, final String authToken) {
		try {
			if (authToken != null) {
				httpClient.interceptors().add(new Interceptor() {
					@Override
					public okhttp3.Response intercept(Chain chain) throws IOException {
						Request original = chain.request();
						// Request customization: add request headers
						Request.Builder requestBuilder = original.newBuilder()
								.header("Authorization", authToken)
								.method(original.method(), original.body());

						Request request = requestBuilder.build();

						if (BuildConfig.DEBUG) {

							//bodyToString(request);
						}

						return chain.proceed(request);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		httpClient.sslSocketFactory(getSSLSocketFactory(), getX509TrustManager());

		OkHttpClient client = httpClient.build();

		Retrofit retrofit = builder(BASE_URL).client(client).build();
		return retrofit.create(serviceClass);
	}

	public static Retrofit getRetrofit() {

		OkHttpClient client = httpClient.build();
		return builder(BASE_URL).client(client).build();
	}


	private static X509TrustManager getX509TrustManager() {
		return new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[]{};
			}

			public void checkClientTrusted(X509Certificate[] chain,
			                               String authType) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] chain,
			                               String authType) throws CertificateException {
			}
		};
	}

	private static SSLSocketFactory getSSLSocketFactory() {
		try {
			// Create a trust manager that does not validate certificate chains
			final TrustManager[] trustAllCerts = new TrustManager[]{
					new X509TrustManager() {
						@Override
						public void checkClientTrusted(X509Certificate[] chain, String authType)
								throws CertificateException {
						}

						@Override
						public void checkServerTrusted(X509Certificate[] chain, String authType)
								throws CertificateException {
						}

						@Override
						public X509Certificate[] getAcceptedIssuers() {
							return new X509Certificate[]{};
						}
					}
			};

			// Install the all-trusting trust manager
			final SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
			// Create an ssl socket factory with our all-trusting manager
			final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

			return sslSocketFactory;
		} catch (KeyManagementException | NoSuchAlgorithmException e) {
			return null;
		}

	}


	private static String bodyToString(final Request request) {

		try {
			final Request copy = request.newBuilder().build();
			final Buffer buffer = new Buffer();

			if (!copy.url().toString().contains(".apk")) {
				copy.body().writeTo(buffer);
				Log.d("bodyToString", copy.url() + "\n" + buffer.readUtf8());
			}

			return buffer.readUtf8();
		} catch (final IOException e) {
			return "did not work";
		}
	}

}
