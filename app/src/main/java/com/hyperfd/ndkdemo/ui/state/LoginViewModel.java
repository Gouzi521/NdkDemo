package com.hyperfd.ndkdemo.ui.state;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.hyperfd.ndkdemo.request.AccountRequest;

/**
 * @Description TODO
 * @Author ma
 * @Date 2021/3/4 16:34
 */
public class LoginViewModel extends ViewModel {

    public final ObservableField<String> name=new ObservableField<>();

    public final ObservableField<String> password=new ObservableField<>();

    public final ObservableBoolean loadingVisible=new ObservableBoolean();

    public final AccountRequest accountRequest=new AccountRequest();
}
