package com.projects.activity_prodcard.viewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.projects.activity_prodcard.repository.ResDescription;


public class ShopData extends ViewModel {

    private final MutableLiveData<ResDescription> Data = new MutableLiveData<>();

    public void setData (ResDescription resDescription){
Data.setValue(resDescription);
    }

    public LiveData<ResDescription> getData() {
        return Data;
    }
}
