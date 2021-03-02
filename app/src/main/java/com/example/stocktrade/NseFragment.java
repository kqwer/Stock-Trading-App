package com.example.stocktrade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.stocktrade.model.Nse;
import com.example.stocktrade.model.StockDataResponse;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class NseFragment extends Fragment {
    View view;
    String TAG = "Nse Fragment";
    DatabaseHelper mydb;
    private RecyclerView myrecylerview1;
    private RecyclerviewAdapter adapter;
    private List<StockList> stockList;
    OnStockRefreshListener onStockRefreshListener;


    public NseFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.nse_fragment, container, false);
        stockList = new ArrayList<>();
        onStockRefreshListener=(OnStockRefreshListener)getActivity();


        myrecylerview1 = (RecyclerView) view.findViewById(R.id.order_recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myrecylerview1.setLayoutManager(llm);
        mydb = new DatabaseHelper(getActivity());

        getData();
        return view;
    }

    public void getData() {
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            String URL = "https://mobaelinx.angelbroking.com/AngelService/MoversNews/Movers/1.0.0";
            JSONObject jsonBody = new JSONObject();
            JSONObject jsonrequest = new JSONObject();
            JSONObject jsonrequestData = new JSONObject();
            jsonrequestData.put("category", "TOPGAINER");
            jsonrequestData.put("sessionID", "guest");
            jsonrequestData.put("usrID", "guest");

            jsonrequest.put("appID", "f363c1745f5f63433a57e369a01c5752");
            jsonrequest.put("formFactor", "M");
            jsonrequest.put("futures", "0");
            jsonrequest.put("response_format", "json");
            jsonrequest.put("data", jsonrequestData);

            jsonBody.put("request", jsonrequest);


            final String mRequestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response != null) {
                        Gson gson = new Gson();
                        StockDataResponse result = gson.fromJson(response, StockDataResponse.class);
                        List<Nse> nse = result.getResponse().getData().getNse();
                        for (int i = 0; i < nse.size(); i++) {
                            String name = nse.get(i).getSymbolName();
                            String details=nse.get(i).getDetails();
                            //Log.d("resultVolley",name);
                            String ltp = nse.get(i).getLtp();
                            String changeper = nse.get(i).getChangePer();
                            String changeprice = nse.get(i).getChange();
                            StockList ld = new StockList(name,details, ltp, changeper, changeprice);
                            stockList.add(ld);

                        }
                        adapter = new RecyclerviewAdapter(stockList, getActivity(),onStockRefreshListener);
                        myrecylerview1.setAdapter(adapter);
                        adapter.notifyDataSetChanged();


                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    //Log.d("LOG_VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {

                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {

                    String json = "";
                    try {
                        json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    return Response.success(json, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (JSONException e) {

            e.printStackTrace();
        }
    }
}

