package com.wildanokt.trashmap.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.util.Log;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wildanokt.trashmap.R;
import com.wildanokt.trashmap.model.Trash;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeFragment extends Fragment {

    private List<Trash> mTrashes;

    public HomeFragment(List<Trash> mTrashes) {
        this.mTrashes = mTrashes;
    }

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mTrashes = new ArrayList<>();

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference data = database.child("Data");
        // Read from the database
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                mTrashes.clear();
//                for (DataSnapshot ds: dataSnapshot.getChildren()) {
////                    Trash mTrash = ds.getValue(Trash.class);
////                    mTrashes.add(mTrash);
//
//                }
                String value = dataSnapshot.child("Lokasi").getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

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

//                for (int i = 0; i < 3; i++) {
//                    Trash trash = mTrashes.get(i);
//                    mMap.addMarker(new MarkerOptions()
//                            .position(new LatLng(trash.getLat(), trash.getLng()))
//                            .title(trash.getLokasi())
//                            .snippet("Organik : "+trash.getOrganik()+"%, Anorganik : "+trash.getAnorganik()+"%, Logam : "+trash.getLogam()+"%")
//                    );
//                }

//                mMap.addMarker(new MarkerOptions()
//                        .position(new LatLng(-7.953341, 112.614669))
//                        .title("Lokasi A")
//                        .snippet("Organik : 40%, Anorganik : 10%, Logam : 5%")
//                );
//
//                mMap.addMarker(new MarkerOptions()
//                        .position(new LatLng(-7.951762, 112.616007))
//                        .title("Lokasi B")
//                        .snippet("Organik : 50%, Anorganik : 10%, Logam : 1%")
//                );
//
//                mMap.addMarker(new MarkerOptions()
//                        .position(new LatLng(-7.950158, 112.613380))
//                        .title("Lokasi C")
//                        .snippet("Organik : 5%, Anorganik : 50%, Logam : 1%")
//                );
//
//                mMap.addMarker(new MarkerOptions()
//                        .position(new LatLng(-7.952682, 112.611325))
//                        .title("Lokasi D")
//                        .snippet("Organik : 30%, Anorganik : 5%, Logam : 20%")
//                );
            }
        });

        return  rootView;
    }

}
