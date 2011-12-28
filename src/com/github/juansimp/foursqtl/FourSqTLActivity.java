package com.github.juansimp.foursqtl;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.github.juansimp.MyDatePicker;
import com.github.juansimp.MyDateTime;
import com.github.juansimp.MyDateTimeUpdatable;
import com.github.juansimp.MyFoursquare;
import com.github.juansimp.MyTimePicker;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.Checkin;
import fi.foyt.foursquare.api.entities.CheckinGroup;

public class FourSqTLActivity extends MapActivity {
	final public static int LOGIN_ACTIVITY_REQUEST_CODE = 1;
	
	private static final int DIALOG_CHECKINS_ERROR_GETTING = 0;
	
	private MyDateTime dateFrom, dateTo;
	private MyDatePicker dateFromPicker, dateToPicker;
	private MyTimePicker timeFromPicker, timeToPicker;
		
	private Button dateFromButton, timeFromButton, dateToButton, timeToButton;
	
	private Checkin[] mCheckins;
	
	private List<Overlay> mapOverlays;
	private MapOverlay itemizedoverlay;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		setupActionBar();
		
		new UserBarSetupTask().execute();
		new LoadCheckinsTask().execute();
		
	    final MapView mapView = (MapView) findViewById(R.id.mapview);	    
	    
	    mapOverlays = mapView.getOverlays();
	    Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
	    itemizedoverlay = new MapOverlay(drawable);
	    
	    ListView timeLineList = (ListView)findViewById(R.id.timeLineList);
	    timeLineList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				MapController mc = mapView.getController();
				
				// Location represented in micro degrees, multiplying it by 1e6
				GeoPoint p = new GeoPoint(
						(int) (mCheckins[position].getVenue().getLocation().getLat().doubleValue() * 1E6),
						(int) (mCheckins[position].getVenue().getLocation().getLng().doubleValue() * 1E6)
				);
				mc.animateTo(p);
				mc.setZoom(17); 
				mapView.invalidate();
			}
	    });
	}
	
	private class MapOverlay extends ItemizedOverlay {
		private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
		
		public MapOverlay(Drawable defaultMarker) {
			super(boundCenterBottom(defaultMarker));
		}
		
		public void addOverlay(OverlayItem overlay) {
		    mOverlays.add(overlay);
		    populate();
		}

		@Override
		protected OverlayItem createItem(int i) {
			return mOverlays.get(i);
		}

		@Override
		public int size() {
			return mOverlays.size();
		}
		
	}
	
	private class UserBarSetupTask extends AsyncTask<Void, Void, Boolean> {
		Bitmap userPhoto;
		
		@Override
		protected void onPreExecute() {
			TextView userTextView = (TextView) findViewById(R.id.userTextView);
			userTextView.setText(MyFoursquare.self.getFirstName() + " " + MyFoursquare.self.getLastName());
		}
		
		@Override
		protected Boolean doInBackground(Void... params) {
			String url = MyFoursquare.self.getPhoto();
			userPhoto = MyFoursquare.Photo.loadPhotoBitmap(url);
			return true;
		}
		@Override
		protected void onPostExecute (Boolean result) {
			ImageView userImage = (ImageView) findViewById(R.id.userImage);
			userImage.setImageBitmap(userPhoto);
		}
	}
	
	private class LoadCheckinsTask extends AsyncTask<Void, Void, Boolean> {
		ProgressDialog dialog;
		CheckinGroup checkins;
		
		@Override
		protected void onPreExecute() {
			dialog = ProgressDialog.show(FourSqTLActivity.this, "", "Getting checkins. Please wait...", true);
		}
		
		@Override
		protected Boolean doInBackground(Void... params) {
			try {
				Result<CheckinGroup> result = MyFoursquare.api.usersCheckins(MyFoursquare.self.getId(), null, null, null, null);
				if (result.getMeta().getCode() == 200) {
					checkins = result.getResult();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		@Override
		protected void onPostExecute (Boolean result) {
			dialog.dismiss();
			if(result) {
				mCheckins = checkins.getItems();
				ListView timeLineList = (ListView) FourSqTLActivity.this.findViewById(R.id.timeLineList);
				timeLineList.setAdapter(new CheckinViewAdapter(FourSqTLActivity.this, mCheckins));
				
				for (Checkin checkin : mCheckins) {
					GeoPoint p = new GeoPoint(
							(int) (checkin.getVenue().getLocation().getLat().doubleValue() * 1E6),
							(int) (checkin.getVenue().getLocation().getLng().doubleValue() * 1E6)
					);
					OverlayItem overlayitem = new OverlayItem(p, checkin.getVenue().getName(), checkin.getShout());
					itemizedoverlay.addOverlay(overlayitem);
				}
				mapOverlays.add(itemizedoverlay);
			} else {
				showDialog(FourSqTLActivity.DIALOG_CHECKINS_ERROR_GETTING);
			}
		}
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
		flags = ActionBar.DISPLAY_SHOW_CUSTOM;

		int change = bar.getDisplayOptions() ^ flags;
		bar.setDisplayOptions(change, flags);
	}	

	private void updateDisplay() {
		dateFromButton.setText(dateFrom.toDateString());
		timeFromButton.setText(dateFrom.toTimeString());
		dateToButton.setText(dateTo.toDateString());
		timeToButton.setText(dateTo.toTimeString());
	}
	
    protected Dialog onCreateDialog(int id) {
        Dialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        
        switch(id) {
	        case FourSqTLActivity.DIALOG_CHECKINS_ERROR_GETTING:
	        	builder.setMessage("Error getting checkins")
	        	       .setCancelable(false)
	        	       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	        	           public void onClick(DialogInterface dialog, int id) {
	        	                FourSqTLActivity.this.finish();
	        	           }
	        	       });
	        	dialog = builder.create();
	            break;
	        default:
	            dialog = null;
        }
        
        return dialog;
    }

    
    
    private class CheckinView extends LinearLayout {
        public CheckinView(Context context, Checkin checkin) {
            super(context);
            View.inflate(context, R.layout.checkin_view, this);
            setCheckin(checkin);
        }

        public CheckinView(Context context, AttributeSet attrs) {
        	super( context, attrs );
        }

        public CheckinView(Context context, AttributeSet attrs, int defStyle) {
        	super( context, attrs, defStyle );
        }
        
		public void setCheckin(Checkin checkin) {
            TextView tmp;
            
            tmp = (TextView) findViewById(R.id.venueName);
            tmp.setText(checkin.getVenue().getName());
            
            tmp = (TextView) findViewById(R.id.checkinShout);
            tmp.setText(checkin.getShout());			
		}

        private TextView mTitle;
        private TextView mDialogue;
    }
    
    private class CheckinViewAdapter extends BaseAdapter {
    	private Context mContext;
    	Checkin checkins[];
    	
    	public CheckinViewAdapter(Context context, Checkin checkins[]) {
    		mContext = context;
    		this.checkins = checkins;
    	}
    	
		@Override
		public int getCount() {
			return checkins.length;
		}

		@Override
		public Object getItem(int position) {
			return checkins[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
            CheckinView cv;
            if (convertView == null) {
                cv = new CheckinView(mContext, checkins[position]);
            } else {
                cv = (CheckinView) convertView;
                cv.setCheckin(checkins[position]);
            }

            return cv;
		}
    	
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
