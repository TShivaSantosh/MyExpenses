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

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddExpense extends BaseFragment {

    public static final String ADD_TRIP_FRAGMENT = "AddTripFragment";

    @BindView(R.id.tv_category) EditText tv_trip_category;
    @BindView(R.id.tv_expense_date) EditText tv_expense_date;
    @BindView(R.id.tv_expense_amount) EditText tv_expense_amount;


    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "dd/MM/yyyy";
    DatePickerDialog.OnDateSetListener date;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

    public static AddExpense newInstance() {
        AddExpense fragment = new AddExpense();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
        return fragment;
    }


    public AddExpense() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_add_expense, container, false);
        ButterKnife.bind(this, view);
        tv_expense_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        tv_expense_date.setText(sdf.format(myCalendar.getTime()));
                    }
                }, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        tv_trip_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int titleId = R.string.app_name;
                int listId = R.array.expense_category;
                int editTextId = R.id.tv_category;
                SpinnerFragment spinnerFragment = SpinnerFragment.newInstance(titleId, listId, editTextId);
                spinnerFragment.show(getFragmentManager(), "customSpinner");

            }
        });

        return view;
    }

}
