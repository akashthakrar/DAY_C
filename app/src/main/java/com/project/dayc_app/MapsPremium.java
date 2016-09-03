package com.project.dayc_app;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsPremium extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_premium);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_premium);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng locations[] = new LatLng[11];
        locations[0] = new LatLng(22.3068, 70.7762562);
        locations[1] = new LatLng(22.2728545, 70.7542481);
        locations[2] = new LatLng(22.2728983, 70.7389271);
        locations[3] = new LatLng(22.2908668, 70.7789766);
        locations[4] = new LatLng(22.2915909, 70.7868073);
        locations[5] = new LatLng(22.2966119, 70.7890483);
        locations[6] = new LatLng(22.2729288, 70.7540948);
        locations[7] = new LatLng(22.2951049, 70.7888623);
        locations[8] = new LatLng(22.3057666, 70.8029206);
        locations[9] = new LatLng(22.3518419, 70.7649532);
        locations[10] = new LatLng(22.2396178, 70.6505227);

        String titles[] = new String[]{"The Grand Thakar", "Mc Donald\'s", "Dominos Pizza", "Dominos Pizza",
                             "Apple Bite", "Bizz The Hotel", "The Yellow chilli", "The Imperial Palace",
                             "The Fern residency", "Ishwariya Post", "Heritage Khirasara Palace"};

        int i;
        for(i=0; i<titles.length;i++) {
            LatLng current = locations[i];
            mMap.addMarker(new MarkerOptions().position(current).title(titles[i]));
        }
        LatLng center = new LatLng(22.2736308, 70.7512553);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 10.0f));


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
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_premium))
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
