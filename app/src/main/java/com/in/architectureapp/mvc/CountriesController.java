package com.in.architectureapp.mvc;

import com.in.architectureapp.model.Country;
import com.in.architectureapp.webservices.RetrofitClient;


import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesController {
    private MVCActivity view;
    private RetrofitClient service;
    private RetrofitClient restApiManager;

    public CountriesController(MVCActivity view)
    {

        restApiManager = new RetrofitClient();
        this.view = view;
        service = new RetrofitClient();
        fetchCountries();
    }

    private void fetchCountries()
    {
        Call<List<Country>> call = RetrofitClient.getInstance().getMyApi().getCountry();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                List<Country> countryResponse = response.body();
                String[] onecountry = new String[countryResponse.size()];

                for (int i = 0; i < countryResponse.size(); i++) {
                    onecountry[i] = countryResponse.get(i).getCategory();
                }
                List<String> countryList = Arrays.asList(onecountry);
                view.setValues(countryList);

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
               view.onError();
            }

        });


    }

    public void onRefresh() {
        fetchCountries();
    }

}
