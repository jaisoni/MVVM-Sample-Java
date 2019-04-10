package dev.jai.weather.ui.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public abstract class BaseActivity<DB extends ViewDataBinding, VM extends ViewModel> extends AppCompatActivity {
    protected DB mBinding;
    protected VM mViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());

    }

    public VM provideViewModel(FragmentActivity fragmentActivity, Class<VM> modelClass) {
        return ViewModelProviders.of(fragmentActivity, viewModelFactory).get(modelClass);
    }

    void performDependencyInjection() {
        AndroidInjection.inject(this);
    }
}
