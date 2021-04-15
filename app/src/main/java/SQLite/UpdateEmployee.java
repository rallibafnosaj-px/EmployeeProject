package SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.employeeproject.GlobalVariables;

public class UpdateEmployee extends MainActivity {

    Cursor cursor;
    String query;


    public UpdateEmployee(@Nullable Context context) {
        super(context);
    }


    public String UpdateEmployee(String id, String firstname, String lastname) {

        SQLiteDatabase db = this.getWritableDatabase();

        query = "SELECT * from " + GlobalVariables.employeeTBL + " where ID = '" + id + "'";

        cursor = db.rawQuery(query, null);

        if (cursor.getCount() == 0) {
            return "Not existed.";
        } else {
            try {
                String queryUpdate = "Update " + GlobalVariables.employeeTBL + " set Firstname = '" + firstname + "', Lastname = '" + lastname + "' where ID = '" + id + "'";
                db.execSQL(queryUpdate);

                return "Success.";
            } catch (Exception e) {
                return "Not Successful";
            }

        }

    }

    public String DeleteEmployee(String id, String firstname, String lastname) {

        SQLiteDatabase db = this.getWritableDatabase();

        query = "SELECT * from " + GlobalVariables.employeeTBL + " where ID = '" + id + "'";

        cursor = db.rawQuery(query,null);

        if (cursor.getCount() == 0) {
            return "Not existed.";
        } else {

            try {
                String queryDelete = "Delete from " + GlobalVariables.employeeTBL + " where ID = '" + id + "'";
                db.execSQL(queryDelete);

                return "Success!.";
            } catch (Exception e) {
                return "Not Successful.";
            }
        }
    }
}
