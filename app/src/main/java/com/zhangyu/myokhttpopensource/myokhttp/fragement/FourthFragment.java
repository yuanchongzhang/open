package com.zhangyu.myokhttpopensource.myokhttp.fragement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.lzy.okgo.OkGo;
import com.zhangyu.myokhttpopensource.R;
import com.zhangyu.myokhttpopensource.myokhttp.adapter.LargePicAdapter2;
import com.zhangyu.myokhttpopensource.myokhttp.callback.JsonCallback2;
import com.zhangyu.myokhttpopensource.myokhttp.response.BannerResponse;

import okhttp3.Call;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FourthFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    RecyclerView rv_01;

    LargePicAdapter2 largePicAdapter2;
    private RecyclerView.LayoutManager mLayoutManager;

    public FourthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fourth, null);
        rv_01 = (RecyclerView) view.findViewById(R.id.rv_01);
        getData();
        return view;
    }


    public void getData() {
        OkGo.get("http://121.42.26.208:83/interface/json_index.php?areaid=1&page=1&uid=")//
                .tag(this)//
                .execute(new JsonCallback2<BannerResponse>() {
                    @Override
                    public void onSuccess(BannerResponse bannerResponse, Call call, Response response) {
                        mLayoutManager = new LinearLayoutManager(getActivity());
                        largePicAdapter2 = new LargePicAdapter2(bannerResponse.getBannerlist());
                        Log.d(bannerResponse.getBannerlist().size() + "", "9999999999");
                        rv_01.setLayoutManager(mLayoutManager);
                        rv_01.setAdapter(largePicAdapter2);
                    }
                });
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
