package id.co.zisal.dmt.fragment.notification;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindString;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_common.constant.GeneralConstant;

/**
 * Created on 3/5/2016 : 3:33 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentWorkshopLocation extends Fragment {

    /*@BindString(R.string.location)
    String strLocation;*/

    MapView mapView;

    /*@BindString(R.string.app_name)
    String appName;*/

    @BindString(R.string.message_enable_google_location_service)
    String messageEnableGLC;

    private LocationManager m_lm;
    private LocationListener m_ll;
    private Location mCurrentLocation;
    private String Address;
    private GoogleMap mMap;
    private Marker mMarker;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_workshop_location, container,false);
        mapView = (MapView) view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        //mMap = ((SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.mapview)).getMap();
        try{
            try {
                retrieveMap();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            Toast.makeText( getActivity(), "Error retrieving map", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    public void retrieveMap( ) throws GooglePlayServicesNotAvailableException {
        mMap = mapView.getMap();
        mMap.setMyLocationEnabled(false);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        mMap.setMyLocationEnabled(false);

        //add a marker
        mMarker = mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Hello!"));
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);

        //LocationManager, Listener
        m_lm = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
        String strAddress = "";
        List<Address> list;
        List<String> proList = m_lm.getAllProviders();
        String provider0 = proList.get(0);
        mCurrentLocation = m_lm.getLastKnownLocation(provider0);
        updateToNewLocation(mCurrentLocation);

        Geocoder gc = new Geocoder(getActivity(), Locale.getDefault());
        //reverse geocode and show address
        try {
            if(gc.isPresent()){
                //use current location
                if(mCurrentLocation != null){
                    double LatPoint = mCurrentLocation.getLatitude();
                    double LngPoint = mCurrentLocation.getLongitude();

                    list = gc.getFromLocation(LatPoint, LngPoint,1);
                    Address address = list.get(0);
                    if (list.size() > 0) {
                        for (int i=0; i<address.getMaxAddressLineIndex(); i++)
                            strAddress += address.getAddressLine(i) + "\n";
                    }
                    setAddress(strAddress);
                    Toast.makeText(getActivity().getApplicationContext(), strAddress, Toast.LENGTH_LONG).show();
                }
                else
                    Log.i(ApplicationConstant.LogTag.DMT_INFO, "Current Location is null");
            }
            else{
                Log.i(ApplicationConstant.LogTag.DMT_INFO, "Reverse GeoCoding is not Available");
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getActivity().getApplicationContext(), messageEnableGLC, Toast.LENGTH_LONG).show();
        }

        // Setting a custom info window adapter for the google map
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }
            @Override
            public View getInfoContents(Marker arg0) {
                View v = getActivity().getLayoutInflater().inflate(R.layout.info_map_workshop_location, null);
                LatLng latLng = arg0.getPosition();
                TextView tvLatLong = (TextView) v.findViewById(R.id.tv_latLong);
                TextView tvAddress = (TextView) v.findViewById(R.id.tv_address);
                TextView tvDevId = (TextView) v.findViewById(R.id.tv_devId);
                tvDevId.setText("Detail Location :");
                tvLatLong.setText(GeneralConstant.Punctuation.LEFT_PARENTHESES.concat(GeneralConstant.Punctuation.SLASH).concat(String.valueOf(latLng.latitude)).concat(GeneralConstant.Punctuation.COMMA).concat(String.valueOf(latLng.longitude)).concat(GeneralConstant.Punctuation.RIGHT_PARENTHESES));
                tvAddress.setText(getAddress());
                return v;
            }
        });
        MapsInitializer.initialize(this.getActivity());
        //drag map to the current location
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude()))
                .bearing(0)
                .zoom(17)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        m_ll = new MyLocationListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        m_lm = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
        if( m_lm == null ){
            try{
                mCurrentLocation = m_lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }catch (Exception e){
                mCurrentLocation = m_lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
        }else{
            m_ll = new MyLocationListener();
            boolean isGPSEnabled = m_lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean isNetworkEnabled = m_lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            if (!isGPSEnabled && !isNetworkEnabled){
                // no network provider is enabled
            }else {
                if (isGPSEnabled) {
                    m_lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, m_ll);
                }else if( isNetworkEnabled ){
                    m_lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 2000, 1, m_ll);
                }
            }
        }
        mapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (m_lm != null) {
            m_lm.removeUpdates(m_ll);
        }
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        /*mapView.onLowMemory();*/
    }


    /**
     * update to new location
     */
    public void updateToNewLocation(Location loc){
        mMap.clear();
        double lat = 0;
        double lng = 0;
        if(loc != null) {
            lat = loc.getLatitude();
            lng = loc.getLongitude();
        }
        MarkerOptions mMarkerOpts = new MarkerOptions();
        mMarkerOpts.position(new LatLng(lat, lng));
        mMarkerOpts.draggable(false);
        mMarkerOpts.visible(true);
        mMarkerOpts.anchor(0.5f, 0.5f);
        mMarkerOpts.snippet("");
        mMarker = mMap.addMarker(mMarkerOpts);

    }

    /**
     * MyLocationListener, keep updating location
     * by location manager
     */
    private class MyLocationListener implements LocationListener    {
        @Override
        public void onLocationChanged(Location location){
            //check location
            if(location == null) {
                Toast.makeText(getActivity(), "Current location is temporarily unavailable", Toast.LENGTH_SHORT).show();
            }
            else{
                //update current location
                mCurrentLocation = location;
            }
        }

        @Override
        public void onProviderDisabled(String provider){
        }

        @Override
        public void onProviderEnabled(String provider){
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras){
        }
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

}
