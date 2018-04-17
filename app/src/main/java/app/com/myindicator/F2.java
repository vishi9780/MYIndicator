package app.com.myindicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class F2 extends Fragment{
    TextView tv_NumberofFragments;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        tv_NumberofFragments=(TextView)view.findViewById(R.id.tv_NumberofFragments);
        tv_NumberofFragments.setText("F2");
    }
}
