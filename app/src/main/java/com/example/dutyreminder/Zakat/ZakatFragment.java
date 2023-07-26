package com.example.dutyreminder.Zakat;

import static java.lang.Float.parseFloat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dutyreminder.Adapter.DailyAdapter;
import com.example.dutyreminder.Model.ModelClassPrayer;
import com.example.dutyreminder.R;
import com.example.dutyreminder.Retrofit.ApiClient;
import com.example.dutyreminder.Retrofit.ApiInterface;
import com.example.dutyreminder.databinding.FragmentArabicMonth1Binding;
import com.example.dutyreminder.databinding.FragmentZakatBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ZakatFragment extends Fragment {
private FragmentZakatBinding binding;
    float p, q, a, b, x, y, cash, sumGold, sumSilver, sumCash, zakat;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentZakatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


/*gold price=a;
silver price=b;
user have gold=x;
or
user have silver=y;
or
user have cash= cash;


কত gram gold জাকাত দিতে হবে =sumgold;

        কত gram silver জাকাত দিতে হবে =sumsilver;
        কত gram cash জাকাত দিতে হবে =sumcash;
        জাকাত=zakat
                */


        binding.btcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (binding.priceGold.getText().toString().isEmpty() || binding.priceSilver.getText().toString().isEmpty() || binding.cash.getText().toString().isEmpty() || binding.userGold.getText().toString().isEmpty() || binding.usersilver.getText().toString().isEmpty()) {
                    // Inflate the layout for this fragment
                    Toast.makeText(getContext(), "please fill up", Toast.LENGTH_SHORT).show();

                } else {
                    //for gold
                    a = parseFloat(binding.priceGold.getText().toString());
                    b = parseFloat((binding.priceSilver.getText().toString()));


                    x = parseFloat((binding.userGold.getText().toString()));
                    y = parseFloat((binding.usersilver.getText().toString()));
                    cash = parseFloat((binding.cash.getText().toString()));
                    p += a * 85;//gold
                    q += b * 525;//silver
                    if (cash < p) {
                        binding.CashText.setText("আপনার নগদ টাকা তে জাকাত ফরজ হয়নি");
                        sumCash+=0;

                    }
                    else {
                        sumCash += (cash * 2.5) / 100;
                        binding.CashText.setText("আপনার " + "" + sumCash + " টাকা জাকাত ফরজ হয়েছে ");

                    }

                    if (x < 85) {
                        binding.goldText.setText("আপনার  স্বর্ণ তে জাকাত ফরজ হয়নি");
                        sumGold+=0;

                    }
                    else {
                        sumGold += (x * 2.5) / 100;
                        binding.goldText.setText("আপনার  " + "" + sumGold + " গ্রাম স্বর্ণ বা "+""+(a*sumGold)+" টাকা জাকাত ফরজ হয়েছে ");

                    }
                    if (y < 525) {
                        binding.silverText.setText("আপনার রুপাতে জাকাত ফরজ হয়নি");
                        sumSilver +=0;
                    }
                    else {
                        sumSilver += (y * 2.5) / 100;
                        binding.silverText.setText("আপনার  " + "" + sumSilver + " গ্রাম রুপা বা "+""+(b*sumSilver)+" টাকা জাকাত ফরজ হয়েছে ");

                    }


                    zakat += ((a * sumGold) + (b * sumSilver) + sumCash);
                    binding.ZakatText.setText("আপনার সর্বমোট  "+""+zakat+" টাকা জাকাত ফরজ হয়েছে");
                }

            }

        });


        binding.btclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.priceGold.setText("");
                binding.priceSilver.setText("");
                binding.cash.setText("");
                binding.userGold.setText("");
                binding.usersilver.setText("");
                binding.CashText.setText("");
                binding.goldText.setText("");
                binding.silverText.setText("");
                binding.CashText.setText("");
                binding.ZakatText.setText("");
            }
        });



        return root;




    }






}