package tn.covid19.client.covid19.ui.livetv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveTVViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public LiveTVViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is notifications fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}