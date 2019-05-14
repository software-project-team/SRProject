package com.yunuscagliyan.socialreader.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.yunuscagliyan.socialreader.R;
import com.yunuscagliyan.socialreader.groups.GroupsActivity;
import com.yunuscagliyan.socialreader.groups.chatActivity;
import com.yunuscagliyan.socialreader.groups.konud;


public class MessagesFragment extends Fragment {
    private static final String TAG = "MessagesFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_groups, container, false);


        RelativeLayout konudisi = (RelativeLayout) view.findViewById(R.id.relLayout4);
        konudisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), chatActivity.class);
                intent.putExtra("group","Konu Dışı");
                getActivity().startActivity(intent);

            }
        });
        return view;
    }
}
