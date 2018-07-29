package testandroid.dbs.com.expenses;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTripFragment extends BaseFragment {
    public static final String ADD_TRIP_FRAGMENT = "AddTripFragment";

    @BindView(R.id.add_trip_name) EditText tv_trip_name;
    @BindView(R.id.tv_trip_start_date) EditText tv_start_date;
    @BindView(R.id.tv_trip_end_date) EditText tv_end_date;
    @BindView(R.id.add_trip_pc_code) EditText tv_pc_code;
    @BindView(R.id.add_trip_cuurency) EditText tv_pc_currency;




    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "dd/MM/yyyy";
    DatePickerDialog.OnDateSetListener date;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);


    public static AddTripFragment newInstance() {
        AddTripFragment fragment = new AddTripFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
        return fragment;
    }

    public AddTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_add_trip, container, false);
        ButterKnife.bind(this, view);


        tv_start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        tv_start_date.setText(sdf.format(myCalendar.getTime()));
                    }
                }, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        tv_end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        tv_end_date.setText(sdf.format(myCalendar.getTime()));
                    }
                }, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        tv_pc_currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int titleId = R.string.app_name;
                int listId = R.array.currencies;
                int editTextId = R.id.add_trip_cuurency;
                SpinnerFragment spinnerFragment = SpinnerFragment.newInstance(titleId, listId, editTextId);
                spinnerFragment.show(getFragmentManager(), "customSpinner");

            }
        });

        return view;
    }


    private void updateDate() {
        tv_start_date.setText(sdf.format(myCalendar.getTime()));
    }
}
