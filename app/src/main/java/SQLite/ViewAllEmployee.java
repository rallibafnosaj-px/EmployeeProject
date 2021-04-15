package SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeeproject.GlobalVariables;

import java.util.ArrayList;
import java.util.List;

import Adapter.EmployeeList;

public class ViewAllEmployee extends MainActivity {

    List<Model.EmployeeList> employeeList;
    EmployeeList employeeListAdapter;
    String query;
    Cursor cursor;
    Context context;

    public ViewAllEmployee(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    public EmployeeList ViewEmployee() {

        SQLiteDatabase db = getWritableDatabase();

        employeeList  = new ArrayList<>();
        try {

            query = "Select ID, Firstname, Lastname  from " + GlobalVariables.employeeTBL + "";

            cursor = db.rawQuery(query, null);

            if (cursor.getCount() != 0) {
                if (cursor.moveToFirst()) {

                    do {

                        String ID = cursor.getString(0);
                        String firstname = cursor.getString(1);
                        String lastname = cursor.getString(2);

                        Model.EmployeeList model = new Model.EmployeeList(ID, firstname, lastname);
                        employeeList.add(model);


                    } while (cursor.moveToNext());


                    employeeListAdapter = new EmployeeList(context, employeeList);

                    return employeeListAdapter;

                }
            } else {

            }
        } catch (Exception e) {

        }
        cursor.close();
        return employeeListAdapter;




    }
}
