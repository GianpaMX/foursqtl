/**
 * Copyright 2011 Mark Wyszomierski
 */
package com.github.juansimp.foursqtl;

import com.github.juansimp.MyFoursquare;
import com.github.juansimp.foursqtl.model.Database;
import com.github.juansimp.foursqtl.model.bean.Authentication;
import com.github.juansimp.foursqtl.model.catalog.AuthenticationCatalog;
import com.github.juansimp.foursqtl.model.collection.AuthenticationCollection;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompleteUser;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
public class LoginActivity extends Activity {
    private static final String TAG = "ActivityWebView";
    
    private static final int DIALOG_AUTH_ERROR_ID = 0;

	private static final int DIALOG_DATABASE_ERROR_ID = 1;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        
		setupDatabase();
		setupFoursqureApi();
		
		AuthenticationCatalog authenticationCatalog;
		try {
			authenticationCatalog = AuthenticationCatalog.getInstance();
		} catch (UninitializedDatabaseException e) {
			Log.e("F", e.getMessage());
			finish();
			return;
		}
		AuthenticationCollection auths = authenticationCatalog.fetchAll();
		
		if(auths.size() == 0) {
			showAuthenticate();
		} else {
			String code = auths.get(0).getToken();
			new SetAuthenticateCode(code).execute();
		}
        
    }
    
    private void showAuthenticate() {
        String url = MyFoursquare.api.getAuthenticationUrl();
        WebView webview = (WebView)findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                String fragment = "?code=";
                int start = url.indexOf(fragment);
                if (start > -1) {
                    String code = url.substring(start + fragment.length(), url.length());
                    new GetUserTask(code).execute();
                }
            }
        });
        webview.loadUrl(url);
    }
    
	private class SetAuthenticateCode extends AsyncTask<Void, Void, Boolean> {
		private String code;
		
		public SetAuthenticateCode(String code) {
			super();
			this.code = code;
		}

		@Override
		protected Boolean doInBackground(Void... arg0) {
	        try {
	        	MyFoursquare.api.authenticateCode(code);
			} catch (FoursquareApiException e) {
				return false;
			}
			
			return true;
		}
		
		@Override
		protected void onPostExecute (Boolean result) {
			if(result) {
				LoginActivity.this.startApp();
			} else {
				showAuthenticate();
			}
		}
	}
	
	private void startApp() {
		finish();
		Intent intent = new Intent(this, FourSqTLActivity.class);
		startActivity(intent);
	}
    
	private void setupDatabase() {
		Database.init(getApplicationContext());
	}

	private void setupFoursqureApi() {
		MyFoursquare.init(getString(R.string.foursquare_client_id), getString(R.string.foursquare_client_secret), getString(R.string.foursquare_callback_url));
	}

    
    private class GetUserTask extends AsyncTask<Void, Void, Boolean> {
    	private String code;
    	private String idUser;
    	private Authentication auth;
    	private int dialogId;
    	
    	public GetUserTask(String accessToken) {
    		super();
    		this.code = accessToken;
    	}
    	
		@Override
		protected Boolean doInBackground(Void... params) {
            try {
            	MyFoursquare.api.authenticateCode(code);
            	idUser = MyFoursquare.api.user("self").getResult().getId();
			} catch (FoursquareApiException e) {
				Log.e("F", e.getMessage());
				dialogId = LoginActivity.DIALOG_AUTH_ERROR_ID;
				return false;
			}
			
            auth = new Authentication();
            auth.setToken(code);
            auth.setIdUser(Integer.parseInt(idUser));
            
            AuthenticationCatalog authenticationCatalog;
			try {
				authenticationCatalog = AuthenticationCatalog.getInstance();
				authenticationCatalog.deleteAll();
				authenticationCatalog.insert(auth);
			} catch (UninitializedDatabaseException e) {
				Log.e("F", e.getMessage());
				dialogId = LoginActivity.DIALOG_DATABASE_ERROR_ID;
				auth = null;
				return false;
			}

			return true;
		}
		@Override
		protected void onPostExecute (Boolean result) {
			if(result) {
				LoginActivity.this.startApp();
			} else {
				showDialog(dialogId);
			}
		}

    }
    
    protected Dialog onCreateDialog(int id) {
        Dialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        
        switch(id) {
	        case LoginActivity.DIALOG_AUTH_ERROR_ID:
	        	builder.setMessage("Authenticate Error")
	        	       .setCancelable(false)
	        	       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	        	           public void onClick(DialogInterface dialog, int id) {
	        	                LoginActivity.this.finish();
	        	           }
	        	       });
	        	dialog = builder.create();
	            break;
	        case LoginActivity.DIALOG_DATABASE_ERROR_ID:
	        	builder.setMessage("Database Error")
	        	       .setCancelable(false)
	        	       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	        	           public void onClick(DialogInterface dialog, int id) {
	        	                LoginActivity.this.finish();
	        	           }
	        	       });
	        	dialog = builder.create();
	            break;
	        default:
	            dialog = null;
        }
        
        return dialog;
    }
    
}
