package app.com.myindicator.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import app.com.myindicator.R;

public class F2 extends Fragment {
    TextView tv_NumberofFragments;
    CheckBox cb_checkbox;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f2,container,false);
        initViews(view);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            boolean checked = savedInstanceState.getBoolean("CHECK_BOX_STATE", false);
            cb_checkbox.setChecked(checked);
        }
        return view;
    }

    private void initViews(View view) {
        tv_NumberofFragments=(TextView)view.findViewById(R.id.tv_NumberofFragments);
        cb_checkbox=(CheckBox) view.findViewById(R.id.cb_checkbox);
        tv_NumberofFragments.setText("F2");
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("CHECK_BOX_STATE", cb_checkbox.isChecked());
        Log.e("40",">>"+cb_checkbox.isChecked());
    }

}
