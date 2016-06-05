package cn.itcast.product.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
	// ���ڸ���û���޲ι��캯��, �����������ָ�����ø����ĸ��вεĹ��캯��
	public MyHelper(Context context) {
		super(context, "TEST.db", null, 2);
	}

	public void onCreate(SQLiteDatabase db) {
		System.out.println("onCreate");
		db.execSQL("CREATE TABLE account(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name VARCHAR(20)," + // ������
				"balance INTEGER," +
				"description VARCHAR(50),"+
				"Picture VARCHAR(20)"+")"



		); // �����
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("onUpgrade");
	}
}
