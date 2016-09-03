package com.project.dayc_app;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsLunchDinner extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_lunch_dinner);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_lunchdinner);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng locations[] = new LatLng[9];
        locations[0] = new LatLng(22.3074964,70.7937879);
        locations[1] = new LatLng(22.3057666,70.8029206);
        locations[2] = new LatLng(22.2951049,70.7888623);
        locations[3] = new LatLng(22.3068, 70.7762562);
        locations[4] = new LatLng(23.0367477,72.509601);
        locations[5] = new LatLng(22.2838459,70.7657203);
        locations[6] = new LatLng(22.2922426,70.7899867);
        locations[7] = new LatLng(22.2912437,70.7808754);
        locations[8] = new LatLng(22.2963969,70.7970673);
        String titles[] = new String[]{"Radhe Thal","The Fern Residency","The Imperial Palace",
                "The Grand Thakar","Gordhan Thaal","Dr\'s Food","Anand Snacks & Catering Service",
                "K Krunchy Republic","Adingo Foods"};
//lunch and dinner

        int i;
        for(i=0; i<titles.length;i++) {
            LatLng current = locations[i];
            mMap.addMarker(new MarkerOptions().position(current).title(titles[i]));
        }
        LatLng center = new LatLng(22.2736308, 70.7512553);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 13.0f));


        /*
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_lunchdinner))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}