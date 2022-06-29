package com.in.architectureapp.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.in.architectureapp.model.Country;
import com.in.architectureapp.webservices.RetrofitClient;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesViewModel extends ViewModel {
    private final MutableLiveData<List<String>> countries = new MutableLiveData<>();
    private final MutableLiveData<Boolean> countryError = new MutableLiveData<>();

    private RetrofitClient service;

    public CountriesViewModel() {
        service = new RetrofitClient();
        fetchCountries();
    }

    public LiveData<List<String>> getCountries() {
        return countries;
    }

    public LiveData<Boolean> getCountryError() {
        return countryError;
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
                countries.setValue(countryList);
                countryError.setValue(false);

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                countryError.setValue(true);
            }

        });


    }

    public void onRefresh() {
        fetchCountries();
    }

}
