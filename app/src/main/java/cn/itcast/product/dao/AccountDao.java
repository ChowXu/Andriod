package cn.itcast.product.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.itcast.product.bean.Account;

public class AccountDao {
	private MyHelper helper;
	public AccountDao(Context context) {
		helper = new MyHelper(context); // ����Daoʱ, ����Helper
	}
	public void insert(Account account) {
		SQLiteDatabase db = helper.getWritableDatabase(); // ��ȡ���ݿ����
            // ����װ��Ҫ��������ݵ� Map<����, �е�ֵ>
		ContentValues values = new ContentValues();		
         values.put("name", account.getName());
		values.put("balance", account.getBalance());
		values.put("description", account.getDesc());
		values.put("picture", account.getPic());


		long id = db.insert("account", null, values); // ��account���������values,
		account.setId(id);  // �õ�id
		db.close();         // �ر����ݿ�
	}
     //����id ɾ������
	public int delete(long id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		// ������ɾ��ָ�����е�����, ������Ӱ�������
		int count = db.delete("account", "_id=?", new String[] { id + "" });
		db.close();
		return count;
	}
     //��������
	public int update(Account account) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues(); // Ҫ�޸ĵ�����
		values.put("name", account.getName());
		values.put("balance", account.getBalance());
		values.put("description", account.getDesc());
		values.put("picture", account.getPic());
		int count = db.update("account", values, "_id=?",
				new String[] { account.getId() + "" }); // ���²��õ�����
		db.close();
		return count;
	}
    //��ѯ�������ݵ�������
	public List<Account> queryAll() {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.query("account", null, null, null, null, null,
				"balance DESC");
		List<Account> list = new ArrayList<Account>();
		while (c.moveToNext()) {
			long id = c.getLong(c.getColumnIndex("_id")); // ���Ը���������ȡ����
			String name = c.getString(1);
			int balance = c.getInt(2);
			String desc = c.getString(3);
			String pic = c.getString(4);
			list.add(new Account(id, name, balance,desc,pic));
		}
		c.close();
		db.close();
		return list;
	}
}


