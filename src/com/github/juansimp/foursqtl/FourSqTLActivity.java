package com.github.juansimp.foursqtl;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

import com.github.juansimp.MyDatePicker;
import com.github.juansimp.MyDateTime;
import com.github.juansimp.MyDateTimeUpdatable;
import com.github.juansimp.MyFoursquare;
import com.github.juansimp.MyTimePicker;
import com.github.juansimp.foursqtl.model.Database;
import com.github.juansimp.foursqtl.model.catalog.AuthenticationCatalog;
import com.github.juansimp.foursqtl.model.collection.AuthenticationCollection;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class FourSqTLActivity extends Activity {
	private MyDateTime dateFrom, dateTo;
	private MyDatePicker dateFromPicker, dateToPicker;
	private MyTimePicker timeFromPicker, timeToPicker;
		
	private Button dateFromButton, timeFromButton, dateToButton, timeToButton;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		setupDatabase();
		setupFoursqureApi();
		setupActionBar();
		
		try {
			login();
		} catch (UninitializedDatabaseException e) {
			Log.e("F", e.getMessage());
		}
	}
	
	private void login() throws UninitializedDatabaseException {
		AuthenticationCatalog authenticationCatalog = AuthenticationCatalog.getInstance();
		AuthenticationCollection auths = authenticationCatalog.fetchAll();
		
		if(auths.size() == 0) {
            Intent intent = new Intent(this, ActivityWebView.class);
            startActivity(intent);
		}
		Log.d("F", "size = " + auths.size());
	}

	private void setupDatabase() {
		Database.init(getApplicationContext());
	}

	private void setupFoursqureApi() {
		MyFoursquare.init(getString(R.string.foursquare_client_id), getString(R.string.foursquare_client_secret), getString(R.string.foursquare_callback_url));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.display_options_actions, menu);
		
		dateFromButton = (Button) findViewById(R.id.dateFrom);
		timeFromButton = (Button) findViewById(R.id.timeFrom);
		dateToButton = (Button) findViewById(R.id.dateTo);
		timeToButton = (Button) findViewById(R.id.timeTo);
		
		setupDateTimePickers();
		
		return true;
	}
	
	private void setupDateTimePickers() {
		dateFrom = new MyDateTime();
		dateTo = new MyDateTime();

		dateFromPicker = new MyDatePicker(this, dateFromButton, dateFrom, myUpdateDisplay);
		timeFromPicker = new MyTimePicker(this, timeFromButton, dateFrom, myUpdateDisplay);
		
		dateToPicker = new MyDatePicker(this, dateToButton, dateTo, myUpdateDisplay);
		timeToPicker = new MyTimePicker(this, timeToButton, dateTo, myUpdateDisplay);
		
		updateDisplay();
	}
	
	private MyDateTimeUpdatable myUpdateDisplay = new MyDateTimeUpdatable() {
		@Override
		public void dateTimeChanged(MyDateTime dateTime) {
			updateDisplay();
		} 
	};

	private void setupActionBar() {
		View mCustomView = getLayoutInflater().inflate(
				R.layout.action_bar_date_interval_selector, null);
		final ActionBar bar = getActionBar();
		bar.setCustomView(mCustomView, new ActionBar.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		int flags = 0;
		flags = ActionBar.DISPLAY_HOME_AS_UP ^ ActionBar.DISPLAY_SHOW_CUSTOM;

		int change = bar.getDisplayOptions() ^ flags;
		bar.setDisplayOptions(change, flags);
	}	

	private void updateDisplay() {
		dateFromButton.setText(dateFrom.toDateString());
		timeFromButton.setText(dateFrom.toTimeString());
		dateToButton.setText(dateTo.toDateString());
		timeToButton.setText(dateTo.toTimeString());
	}
}
