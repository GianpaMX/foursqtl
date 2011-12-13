package com.github.juansimp;

import fi.foyt.foursquare.api.FoursquareApi;

public class MyFoursquare {
	public static FoursquareApi api;
	
	public static void init(String clientId, String clientSecret, String callbackUrl) {
		api = new FoursquareApi(clientId, clientSecret, callbackUrl);
	}
}
