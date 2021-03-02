package com.example.stocktrade;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
    OnStockRefreshListener onStockRefreshListener;
    LayoutInflater layoutInflater;
    Context context;
    List<StockList> stockList;
    EditText amtqty, priceval;
    TextView name1, details1,ltp1, qty1, changeprice1, changeper1, price1 ;
    DatabaseHelper mydb;

    public RecyclerviewAdapter(List<StockList> stockList, Context context, OnStockRefreshListener listener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.stockList = stockList;
        this.onStockRefreshListener=listener;



    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.stocklist_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(stockList.get(position).getName());
        holder.details.setText(stockList.get(position).getDetails());
        holder.ltp.setText(stockList.get(position).getLtp());
        holder.changeper.setText(stockList.get(position).getChangeper());
        holder.changeprice.setText(stockList.get(position).getChangeprice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
                View view = LayoutInflater.from(context).inflate(R.layout.buysell_bottombar, null);

                amtqty = view.findViewById(R.id.qty);
                priceval = view.findViewById(R.id.price);
                priceval.setText(stockList.get(position).getLtp());
                view.findViewById(R.id.buy).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = stockList.get(position).getName();
                        String details=stockList.get(position).getDetails();
                        String ltp = stockList.get(position).getLtp();
                        String changeper = stockList.get(position).getChangeper();
                        String changeprice = stockList.get(position).getChangeprice();
                        String priceValue = priceval.getText().toString();
                        String qty = amtqty.getText().toString();

                        if (qty.trim().equals("")) {
                            Toast.makeText(context, "please enter Quantity ", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (priceValue.trim().equals("")){
                            Toast.makeText(context, "please enter  Price ", Toast.LENGTH_SHORT).show();
                            return;
                        }


                        mydb = new DatabaseHelper(context);
                        boolean inserted = mydb.insertData(name,details, ltp, changeper, changeprice, qty, priceValue);
                        if (inserted == true) {

                            if (onStockRefreshListener!=null){
                                onStockRefreshListener.onRefresh();
                            }


                            //Toast.makeText(context, "Product Buy Successfully", Toast.LENGTH_SHORT).show();

                            //Toast.makeText(getItemViewType(),"Data Inserted",Toast.LENGTH_SHORT).show();

                        } else {
                            // Toast.makeText(getApplicationContext(),"Data not Inserted",Toast.LENGTH_SHORT).show();
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        }
                        //Toast.makeText(v.getContext(), "product Buy successfully", Toast.LENGTH_SHORT).show();


                        bottomSheetDialog.dismiss();
                        BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(context);
                        View view1 = LayoutInflater.from(context).inflate(R.layout.success_bottombar, null);
                        //name1 = view1.findViewById(R.id.getname);
                        //name1.setText("Name:"+name);
                        //details1=view1.findViewById(R.id.getdetails);
                        //details1.setText("Details"+details);
                        //ltp1 = view1.findViewById(R.id.getltp);
                        //ltp1.setText("Ltp"+ltp);
                        //changeper1 = view1.findViewById(R.id.getchangeper);
                        //changeper1.setText("Changeper"+changeper);
                        //changeprice1 = view1.findViewById(R.id.getchangeprice);
                        //changeprice1.setText("Ch%"+changeprice);
                        //qty1 = view1.findViewById(R.id.getqty);
                        //qty1.setText("Quantity"+qty);
                        //price1 = view1.findViewById(R.id.getprice);
                        //price1.setText("PriceAmount"+priceValue);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                bottomSheetDialog1.dismiss();
                                MainActivity mainActivity = (MainActivity) context;
                                TabLayout tabLayout = mainActivity.getTabLayout();
                                tabLayout.selectTab(tabLayout.getTabAt(1));
                            }
                        }, 4000);

                        bottomSheetDialog1.setContentView(view1);
                        bottomSheetDialog1.setCanceledOnTouchOutside(false);
                        bottomSheetDialog1.show();


                    }
                });
                view.findViewById(R.id.sell).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = stockList.get(position).getName();
                        String details=stockList.get(position).getDetails();
                        String ltp = stockList.get(position).getLtp();
                        String changeper = stockList.get(position).getChangeper();
                        String changeprice = stockList.get(position).getChangeprice();
                        String priceValue = priceval.getText().toString();
                        String qty = amtqty.getText().toString();

                        if (qty.trim().equals("")) {
                            Toast.makeText(context, "please enter Quantity ", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (priceValue.trim().equals("")){
                            Toast.makeText(context, "please enter Price ", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        // if (qty.charAt(0)!=null&& qty.)
                        mydb = new DatabaseHelper(context);
                        boolean inserted = mydb.insertData(name, details,ltp, changeper, changeprice, qty, priceValue);
                        if (inserted == true) {
                            if (onStockRefreshListener!=null){
                                onStockRefreshListener.onRefresh();
                            }

                            Toast.makeText(context, "Product Sell Successfully", Toast.LENGTH_SHORT).show();

                            //Toast.makeText(getItemViewType(),"Data Inserted",Toast.LENGTH_SHORT).show();

                        } else {
                            // Toast.makeText(getApplicationContext(),"Data not Inserted",Toast.LENGTH_SHORT).show();
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        }
                        //Toast.makeText(v.getContext(), "product Buy successfully", Toast.LENGTH_SHORT).show();



                        bottomSheetDialog.dismiss();
                        BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(context);
                        View view1 = LayoutInflater.from(context).inflate(R.layout.success_bottombar, null);
                        //name1 = view1.findViewById(R.id.getname);
                        //name1.setText(name);
                        //details1=view1.findViewById(R.id.getdetails);
                        //details1.setText(details);
                        //ltp1 = view1.findViewById(R.id.getltp);
                        //ltp1.setText(ltp);
                        //changeper1 = view1.findViewById(R.id.getchangeper);
                        //changeper1.setText(changeper);
                        //changeprice1 = view1.findViewById(R.id.getchangeprice);
                        //changeprice1.setText(changeprice);
                        //qty1 = view1.findViewById(R.id.getqty);
                        //qty1.setText(qty);
                        //price1 = view1.findViewById(R.id.getprice);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                bottomSheetDialog1.dismiss();
                                MainActivity mainActivity = (MainActivity) context;
                                TabLayout tabLayout = mainActivity.getTabLayout();
                                tabLayout.selectTab(tabLayout.getTabAt(1));
                            }
                        }, 4000);

                        bottomSheetDialog1.setContentView(view1);
                        bottomSheetDialog1.setCanceledOnTouchOutside(false);
                        bottomSheetDialog1.show();



                    }
                });

                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.setCanceledOnTouchOutside(false);
                bottomSheetDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,details, ltp, changeper, changeprice;
        EditText amtqty, price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            ltp = itemView.findViewById(R.id.LTP);
            details=itemView.findViewById(R.id.details);
            changeper = itemView.findViewById(R.id.change_per);
            changeprice = itemView.findViewById(R.id.change_price);
            amtqty = itemView.findViewById(R.id.qty);
            price = itemView.findViewById(R.id.price);

        }
    }

}
