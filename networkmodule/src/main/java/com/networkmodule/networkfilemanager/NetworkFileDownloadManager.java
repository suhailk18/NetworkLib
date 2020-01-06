package com.networkmodule.networkfilemanager;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.networkmodule.R;
import com.networkmodule.api.INetworkInteractor;
import com.networkmodule.api.NetworkInteractor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

public class NetworkFileDownloadManager {
	private static NetworkFileDownloadManager networkFileDownloadManager = new NetworkFileDownloadManager();

	private static Context sContext;
	private String TAG = getClass().getSimpleName();

	private NetworkFileDownloadManager() {

	}

	public static NetworkFileDownloadManager getInstance(Context context) {
		sContext = context;
		return networkFileDownloadManager;
	}

	/*folderName,
	filePath,
	directory,
	downloadUrl,fileWithExt,*/
	public void downloadFile(String folderName, final String fileToDownload,
	                         final String directory, String downloadUrl, final String fileWithExt,
	                         final OnDownloadManagerCallBack onDownloadManagerCallBack) {

		new DownloadFileAsync(folderName, fileToDownload,
				directory, downloadUrl, fileWithExt,
				onDownloadManagerCallBack).execute();

	}

	private boolean writeResponseBodyToDisk(ResponseBody body, File file, OnDownloadManagerCallBack onDownloadManagerCallBack) {
		try {
			// todo change the file location/name according to your needs

			InputStream inputStream = null;
			OutputStream outputStream = null;

			try {
				byte[] fileReader = new byte[4096];

				long fileSize = body.contentLength();
				long fileSizeDownloaded = 0;
				long downloadSizeInPercent = fileSize / 100;


				inputStream = body.byteStream();
				outputStream = new FileOutputStream(file);

				while (true) {
					int read = inputStream.read(fileReader);
					if (read == -1) {
						//onDownloadManagerCallBack.onDownloadFinish();
						break;
					}
					outputStream.write(fileReader, 0, read);
					fileSizeDownloaded += read;

					Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
				}

				outputStream.flush();

				return true;
			} catch (IOException e) {
				//onDownloadManagerCallBack.onDownloadFileerror(file.getName(), e.getLocalizedMessage());
				return false;
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
			}
		} catch (IOException e) {
			return false;
		}
	}

	public interface OnDownloadManagerCallBack {
		void onDownloadProgress(long progress);

		void onDownloadStart();

		void onDownloadFinish();

		void onDownloadFileError(String fileName, String error);
	}

	private boolean isExternalStorageAvailable() {

		String state = Environment.getExternalStorageState();
		boolean externalStorageAvailable = false;
		boolean externalStorageWriteable = false;

		if (Environment.MEDIA_MOUNTED.equals(state)) {
			// We can read and write the media
			externalStorageAvailable = externalStorageWriteable = true;
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			// We can only read the media
			externalStorageAvailable = true;
			externalStorageWriteable = false;
		} else {
			// Something else is wrong. It may be one of many other states, but
			// all we need
			// to know is we can neither read nor write
			externalStorageAvailable = externalStorageWriteable = false;
		}

		return externalStorageAvailable
				&& externalStorageWriteable;
	}

	public File getFile(String fileName, String filePath, Context context) {

		File file = null;
		String root = "";

		boolean success = true;
		root = context.getFilesDir() + "/" + context.getResources()
				.getString(R.string.app_name);

		if (filePath.equalsIgnoreCase("")) {

			if (isExternalStorageAvailable()) {

				success = new File(root).mkdirs();
				file = new File(root, fileName);

				Log.v(TAG, "File created: " + file.getAbsolutePath());
			} else {
				file = new File(context.getFilesDir(), fileName);
			}

		} else {

			if (isExternalStorageAvailable()) {

				String subRoot = String.format("%s/%s", root, fileName);
				success = new File(subRoot).mkdirs();
				file = new File(subRoot, filePath);

				if (success) {
					Log.i(TAG, "success " + success);
				} else {
					Log.i(TAG, "fail " + success);
					Log.i(TAG, "path " + fileName);
				}

			} else {
				file = new File(context.getFilesDir(), filePath);
			}
		}
		return file;
	}

	public class DownloadFileAsync extends AsyncTask<String, String, String> {
		String folderName;
		String fileToDownload;
		String directory;
		String downloadUrl;
		String fileWithExt;
		OnDownloadManagerCallBack onDownloadManagerCallBack;

		public DownloadFileAsync(String folderName, final String fileToDownload,
		                         final String directory, String downloadUrl, final String fileWithExt,
		                         final OnDownloadManagerCallBack onDownloadManagerCallBack) {

			this.folderName = folderName;
			this.fileToDownload = fileToDownload;
			this.directory = directory;
			this.downloadUrl = downloadUrl;
			this.fileWithExt = fileWithExt;
			this.onDownloadManagerCallBack = onDownloadManagerCallBack;

		}

		@Override
		protected String doInBackground(String... strings) {
			onDownloadManagerCallBack.onDownloadStart();
			downloadTask(directory, downloadUrl, fileWithExt, onDownloadManagerCallBack);
			return null;
		}

		@Override
		protected void onPreExecute() {


			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String s) {
			super.onPostExecute(s);
			onDownloadManagerCallBack.onDownloadFinish();
		}

		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
		}

	}

	private void downloadTask(final String directory, String downloadUrl, final String fileWithExt,
	                          final OnDownloadManagerCallBack onDownloadManagerCallBack) {
		new NetworkInteractor().downloadByUrl(downloadUrl, new INetworkInteractor.OnDownloadSuccess() {
			@Override
			public void onSuccess(ResponseBody responseBody) {
				Log.d(TAG, "onSuccess: ");

				if (isExternalStorageAvailable()) {
					writeResponseBodyToDisk(responseBody, getFile(fileWithExt, directory, sContext), onDownloadManagerCallBack);
				}
			}

			@Override
			public void onFailed(String errorMsg) {
				Log.d(TAG, "onFailed: ");
			}

			@Override
			public void onError(String errorMsg) {
				Log.d(TAG, "onError: ");
			}
		});
	}

}
