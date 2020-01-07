package com.digivalet.guestapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;
import com.networkmodule.networkfilemanager.NetworkFileDownloadManager;
import com.networkmodule.responsepojo.CountriesResponse;

public class SplashActivity extends AppCompatActivity {

	private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 7001;
	private String url = "https://sample-videos.com/img/Sample-jpg-image-5mb.jpg";
	private Context mContext;

	private ProgressBar progressBar;

	private SplashViewModel splashViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		mContext = this;

		TextView textview = findViewById(R.id.textview);
		progressBar = findViewById(R.id.progressBar);

		splashViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
		splashViewModel.init();

		splashViewModel.getCountries().observe(this, new Observer<CountriesResponse>() {
			@Override
			public void onChanged(CountriesResponse countriesResponse) {
				String sCountry = new Gson().toJson(countriesResponse);
				Log.d("SplashActivity", sCountry);
			}
		});

		//checkPermission(mContext);

		textview.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

			}
		});


	}

	void downloadFiles() {
		NetworkFileDownloadManager.getInstance(mContext).downloadFile(url, "", "" +
				"", "", "", new NetworkFileDownloadManager.OnDownloadManagerCallBack() {
			@Override
			public void onDownloadProgress(long progress) {
				progressBar.setVisibility(View.GONE);
			}

			@Override
			public void onDownloadStart() {
				progressBar.setVisibility(View.VISIBLE);
			}

			@Override
			public void onDownloadFinish() {
				progressBar.setVisibility(View.GONE);
			}

			@Override
			public void onDownloadFileError(String fileName, String error) {

			}
		});
	}

	void checkPermission(Context context) {
		// Here, thisActivity is the current activity

		if (ContextCompat.checkSelfPermission(context,
				Manifest.permission.WRITE_EXTERNAL_STORAGE)
				!= PackageManager.PERMISSION_GRANTED) {

			// Permission is not granted
			// Should we show an explanation?
			if (ActivityCompat.shouldShowRequestPermissionRationale(this,
					Manifest.permission.READ_CONTACTS)) {
				// Show an explanation to the user *asynchronously* -- don't block
				// this thread waiting for the user's response! After the user
				// sees the explanation, try again to request the permission.
			} else {
				// No explanation needed; request the permission
				ActivityCompat.requestPermissions(this,
						new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
						REQUEST_WRITE_EXTERNAL_STORAGE);

				// REQUEST_WRITE_EXTERNAL_STORAGE is an
				// app-defined int constant. The callback method gets the
				// result of the request.
			}
		} else {
			// Permission has already been granted
			downloadFiles();
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
	                                       String[] permissions, int[] grantResults) {
		switch (requestCode) {
			case REQUEST_WRITE_EXTERNAL_STORAGE: {
				// If request is cancelled, the result arrays are empty.
				if (grantResults.length > 0
						&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					// permission was granted, yay! Do the
					// storage-related task you need to do.
					downloadFiles();
				} else {
					// permission denied, boo! Disable the
					// functionality that depends on this permission.
				}
				return;
			}

			// other 'case' lines to check for other
			// permissions this app might request.
				//dacfbbc0d5fb7c318e70b60cd8791c5861cac228
		}
	}
}
