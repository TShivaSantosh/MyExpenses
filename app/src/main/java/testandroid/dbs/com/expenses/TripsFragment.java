package testandroid.dbs.com.expenses;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TripsFragment extends BaseFragment {


    public TripsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trips, container, false);
        Button button = view.findViewById(R.id.btn_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addFragment(R.id.trip_container, AddTripFragment.newInstance(), AddTripFragment.ADD_TRIP_FRAGMENT);
                addFragment(R.id.trip_container, AddExpense.newInstance(), AddExpense.ADD_TRIP_FRAGMENT);
            }
        });

        return view;
    }

}
