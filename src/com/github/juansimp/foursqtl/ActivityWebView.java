/**
 * Copyright 2011 Mark Wyszomierski
 */
package com.github.juansimp.foursqtl;

import com.github.juansimp.MyFoursquare;
import com.github.juansimp.foursqtl.model.bean.Authentication;
import com.github.juansimp.foursqtl.model.catalog.AuthenticationCatalog;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompleteUser;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * https://developer.foursquare.com/docs/oauth.html
 * https://foursquare.com/oauth/
 * 
 * @date May 17, 2011
 * @author Mark Wyszomierski (markww@gmail.com)
 */
public class ActivityWebView extends Activity {
    private static final String TAG = "ActivityWebView";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        
        
        
        String url =
            "https://foursquare.com/oauth2/authenticate" + 
                "?client_id=" + getString(R.string.foursquare_client_id) + 
                "&response_type=token" + 
                "&redirect_uri=" + getString(R.string.foursquare_callback_url);
        WebView webview = (WebView)findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                String fragment = "#access_token=";
                int start = url.indexOf(fragment);
                if (start > -1) {
                    String accessToken = url.substring(start + fragment.length(), url.length());
                    new GetUserTask(accessToken).execute();
                }
            }
        });
        webview.loadUrl(url);
    }
    
    private class GetUserTask extends AsyncTask<Void, Void, Void> {
    	private String accessToken;
    	private String idUser;
    	
    	public GetUserTask(String accessToken) {
    		super();
    		this.accessToken = accessToken;
    	}
    	
        @SuppressWarnings("unused")
		protected void onPostExecute(Long result) {
            finish();
        }

		@Override
		protected Void doInBackground(Void... params) {
            try {
            	MyFoursquare.api.authenticateCode(accessToken);
            	idUser = MyFoursquare.api.user("self").getResult().getId();
			} catch (FoursquareApiException e) {
				Log.e("F", e.getMessage());
			}
			
            Authentication auth = new Authentication();
            auth.setToken(accessToken);
            auth.setIdUser(Integer.parseInt(idUser));
            
            AuthenticationCatalog authenticationCatalog;
			try {
				authenticationCatalog = AuthenticationCatalog.getInstance();
				authenticationCatalog.save(auth);
			} catch (UninitializedDatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.e("F", e.getMessage());
			}

			return null;
		}
    }
}
