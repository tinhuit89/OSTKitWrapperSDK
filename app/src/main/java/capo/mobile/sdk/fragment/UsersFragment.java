package capo.mobile.sdk.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import capo.mobile.sdk.R;

/**
 * Created by TinhVC on 5/14/18.
 */

public class UsersFragment  extends Fragment {

    public UsersFragment() {
        // UsersFragment empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.transactions_main, container, false);
    }

}
