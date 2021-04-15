package SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.employeeproject.GlobalVariables;

public class MainActivity extends SQLiteOpenHelper {

    public MainActivity(@Nullable Context context) {
        super(context, GlobalVariables.databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        AddTables(db);
    }

    private void AddTables(SQLiteDatabase db) {

        String createTableEmployee = "CREATE TABLE IF NOT EXISTS " +GlobalVariables.employeeTBL + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Firstname VARCHAR(250), Lastname VARCHAR(250))";
        db.execSQL(createTableEmployee);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertEmployee(String firstname, String lastname) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Firstname", firstname);
        cv.put("Lastname", lastname);

        db.insert(GlobalVariables.employeeTBL, null, cv);

    }


}
