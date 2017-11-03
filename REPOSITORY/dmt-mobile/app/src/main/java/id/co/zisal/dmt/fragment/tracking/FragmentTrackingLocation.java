package id.co.zisal.dmt.fragment.tracking;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


import id.co.zisal.dmt.R;
import id.co.zisal.dmt_rest.bgp.impl.BGPLocation;
import id.co.zisal.dmt_rest.dto.request.location.DTORequestLocation;
import id.co.zisal.dmt_rest.dto.response.location.DTOResponseLocation;
import id.co.zisal.dmt_rest.post.IGenericPost;
import id.co.zisal.dmt_rest.util.DMTHUDProgressDialog;
import retrofit.RetrofitError;

/**
 * Created on 1/8/2016 : 5:39 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentTrackingLocation extends FragmentActivity implements IGenericPost<List<DTOResponseLocation>> {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private List<LatLng> points;
    private MarkerOptions markerOptions;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.fragment_location_tracking);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_route))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                prepareData();
            }
        }
    }


    private void prepareData(){
        final DMTHUDProgressDialog tripoinhudProgressDialog = DMTHUDProgressDialog.show(
                this,
                "",
                false,
                null);
        new BGPLocation(this) {
            @Override
            public DTORequestLocation getDtoRequestLocation() {
                DTORequestLocation dtoRequestLocation = new DTORequestLocation();
                dtoRequestLocation.setUserId(BigInteger.ONE);
                return dtoRequestLocation;
            }

            @Override
            public Context getContext() {
                return mContext;
            }

            @Override
            public Dialog getProgressDialog() {
                return tripoinhudProgressDialog;
            }
        }.execute();
    }

    void prepareLocations(List<LatLng> locations){
        points = new ArrayList<>();
        for(LatLng latLng : locations){
            points.add(latLng);
        }
        /*LatLng location1 = new LatLng(-6.2517924, 106.761604);
        LatLng location2 = new LatLng(-6.2923574, 106.818375);
        LatLng location3 = new LatLng(-6.3189363, 106.88693);
        LatLng location4 = new LatLng(-6.3189363, 106.88693);
        LatLng location5 = new LatLng(-6.45665216445923, 106.886962890625);

        points.add(location1);
        points.add(location2);
        points.add(location3);
        points.add(location4);
        points.add(location5);*/
    }

    void prepareMarkers(List<String> locationNames){
        int counter = 0;
        for(String ln : locationNames){
            markerOptions = new MarkerOptions();
            markerOptions.position(points.get(counter));
            markerOptions.title(ln);
            markerOptions.snippet("Latitude:" + points.get(counter).latitude + "," + "Longitude:" + points.get(counter).longitude);
            mMap.addMarker(markerOptions);
            counter++;
        }
    }

    @Override
    public void onPostSuccess(List<DTOResponseLocation> p_Response) {
        List<LatLng> locations = new ArrayList<>();
        List<String> locationNames = new ArrayList<>();
        if(p_Response != null){
            for(DTOResponseLocation dtoResponseLocation : p_Response){
                Log.d("RESPONSE DATA", dtoResponseLocation.toString());
                locations.add(new LatLng(
                                Double.parseDouble(dtoResponseLocation.getLatitude()),
                                Double.parseDouble(dtoResponseLocation.getLongitude()))
                );
                locationNames.add(dtoResponseLocation.getName());
            }
        }
        prepareLocations(locations);
        prepareMarkers(locationNames);
        prepareMap();
    }

    void prepareMap(){
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(Color.RED);
        polylineOptions.width(3);
        polylineOptions.addAll(points);
        mMap.addPolyline(polylineOptions);

        CameraPosition cameraPosition =
                new CameraPosition.Builder()
                        .target(points.get(points.size() - 1))
                        .bearing(0)
                        .zoom(mMap.getCameraPosition().zoom)
                        .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    @Override
    public void onPostFailure(RetrofitError p_RetrofitError) {
        Log.e("ERROR", p_RetrofitError.getLocalizedMessage());
    }
}
