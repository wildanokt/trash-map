package com.wildanokt.trashmap.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wildanokt.trashmap.R;
import com.wildanokt.trashmap.fragment.HelpFragment;
import com.wildanokt.trashmap.fragment.HomeFragment;
import com.wildanokt.trashmap.model.Trash;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigation;

//    private List<Trash> mTrashes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

//        mTrashes = new ArrayList<>();
//
//        DatabaseReference database = FirebaseDatabase.getInstance().getReference("Data");
//        // Read from the database
//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                mTrashes.clear();
//                for (DataSnapshot ds: dataSnapshot.getChildren()) {
//                    Trash mTrash = ds.getValue(Trash.class);
//                    mTrashes.add(mTrash);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });

        loadFragment(new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.navigation_map:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_about:
                fragment = new HelpFragment();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
