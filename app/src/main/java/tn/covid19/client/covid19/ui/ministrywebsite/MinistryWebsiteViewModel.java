package tn.covid19.client.covid19.ui.ministrywebsite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MinistryWebsiteViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public MinistryWebsiteViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is dashboard fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }




}