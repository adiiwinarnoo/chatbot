package com.example.smklabusta.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smklabusta.R;
import com.example.smklabusta._sliders.FragmentSlider;
import com.example.smklabusta._sliders.SliderIndicator;
import com.example.smklabusta._sliders.SliderPagerAdapter;
import com.example.smklabusta._sliders.SliderView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private SliderPagerAdapter Adapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    private CardView card1, card2, card3, card4;
    TextView alamat2,guru2;
    EditText editText;
    private BottomNavigationView bottomNavigationView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        sliderView = (SliderView) view.findViewById(R.id.sliderview);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.containeer);
        card1 = view.findViewById(R.id.cd1);
        alamat2 = view.findViewById(R.id.tv_alamat);
        guru2 = view.findViewById(R.id.guru_tv);
        bottomNavigationView = view.findViewById(R.id.navView);
;

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getParentFragment(getContext()), ChattFragment.class));

                String alamat = alamat2.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Message", alamat);
                alamat2.setText(alamat);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransactionChat = fragmentManager.beginTransaction();
                ChattFragment chatFragment = new ChattFragment();
                chatFragment.setArguments(bundle);
                fragmentTransactionChat.replace(R.id.controller, chatFragment).commit();

                

            }
        });
        card2 = view.findViewById(R.id.cd2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), MainActivity2.class));
                String guru = guru2.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Message", guru);
                guru2.setText(guru);

                ChattFragment chattFragment = new ChattFragment();
                FragmentTransaction fragmentTransactionChat = getParentFragmentManager().beginTransaction();
                chattFragment.setArguments(bundle);
                fragmentTransactionChat.replace(R.id.controller, chattFragment);
                fragmentTransactionChat.commit();

            }
        });

        setupSlider();
        return view;
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("labusta2"));
        fragments.add(FragmentSlider.newInstance("donwload"));

        Adapter = new SliderPagerAdapter(getParentFragmentManager(), fragments);
        sliderView.setAdapter(Adapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicatorcircle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}