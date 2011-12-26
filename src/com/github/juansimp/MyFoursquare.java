package com.github.juansimp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.entities.CompleteUser;

public class MyFoursquare {
	public static FoursquareApi api;
	public static CompleteUser self;

	public static void init(String clientId, String clientSecret,
			String callbackUrl) {
		api = new FoursquareApi(clientId, clientSecret, callbackUrl);
	}

	public static class Photo {
		private static final int IO_BUFFER_SIZE = 4 * 1024;

		public static Bitmap loadPhotoBitmap(String photoUrl) {
			Bitmap bitmap = null;
			InputStream in = null;
			BufferedOutputStream out = null;

			try {
				in = new BufferedInputStream(new URL(photoUrl).openStream(), IO_BUFFER_SIZE);
				bitmap = BitmapFactory.decodeStream(in);
			} catch (IOException e) {
				Log.e("F", "Could not load photo", e);
			} finally {
				closeStream(in);
				closeStream(out);
			}

			return bitmap;
		}
		
	    private static void closeStream(Closeable stream) {
	        if (stream != null) {
	            try {
	                stream.close();
	            } catch (IOException e) {
	                android.util.Log.e("F", "Could not close stream", e);
	            }
	        }
	    }

	}
}
