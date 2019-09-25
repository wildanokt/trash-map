package com.wildanokt.trashmap.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wildanokt.trashmap.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                mMap.clear(); //clear old markers

                CameraPosition googlePlex = CameraPosition.builder()
                        .target(new LatLng(-7.952383, 112.614029))
                        .zoom(16)
                        .bearing(0)
                        .tilt(30)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 3500, null);

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-7.953341, 112.614669))
                        .title("Lokasi A")
                        .snippet("Organik : 30%")
                );


                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-7.951762, 112.616007))
                        .title("Masjid Raden Patah")
                        .snippet("Kapasitas terisi : 40%")
                );

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-7.950158, 112.613380))
                        .title("Fak. Teknik")
                        .snippet("kapasitas terisi : 80%")
                );

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-7.952682, 112.611325))
                        .title("Fak. Perikanan dan kelautan")
                        .snippet("kapasitas terisi : 20%")
                );
            }
        });

        return  rootView;
    }
}
