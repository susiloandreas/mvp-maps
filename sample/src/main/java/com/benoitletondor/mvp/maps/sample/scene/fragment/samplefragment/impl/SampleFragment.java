package com.benoitletondor.mvp.maps.sample.scene.fragment.samplefragment.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.benoitletondor.mvp.core.presenter.loader.PresenterFactory;
import com.benoitletondor.mvp.maps.sample.R;
import com.benoitletondor.mvp.maps.sample.scene.fragment.samplefragment.SampleFragmentPresenter;
import com.benoitletondor.mvp.maps.sample.scene.fragment.samplefragment.SampleFragmentView;
import com.benoitletondor.mvp.maps.view.impl.BaseMVPMapFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Implementation of the {@link SampleFragmentView}
 *
 * @author Benoit LETONDOR
 */
public final class SampleFragment extends BaseMVPMapFragment<SampleFragmentPresenter, SampleFragmentView> implements SampleFragmentView
{
    @Inject
    PresenterFactory<SampleFragmentPresenter> mPresenterFactory;

    public SampleFragment()
    {
        super(R.id.fragment_map_container);
    }

    @Override
    public void onAttach(Context context)
    {
        AndroidSupportInjection.inject(this);

        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    protected PresenterFactory<SampleFragmentPresenter> getPresenterFactory()
    {
        return mPresenterFactory;
    }

    @Override
    public void showMapNotAvailableAlert()
    {
        new AlertDialog.Builder(getContext())
            .setTitle(R.string.maps_not_available_alert_title)
            .setMessage(R.string.maps_not_available_alert_message)
            .setPositiveButton(android.R.string.ok, null)
            .show();
    }
}
