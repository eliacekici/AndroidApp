// LocationFragment.java
package com.example.myunyt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class LocationFragment extends Fragment {

    public LocationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);

        View mapButtonContainer = view.findViewById(R.id.mapButtonContainer);
        mapButtonContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }
    private void openMap() {
        try {
            String mapsUrl = "https://maps.app.goo.gl/91qxxDaMHDsBHaFH9";
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapsUrl));
            mapIntent.setPackage("com.google.android.apps.maps");

            if (mapIntent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapsUrl));
                startActivity(browserIntent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}