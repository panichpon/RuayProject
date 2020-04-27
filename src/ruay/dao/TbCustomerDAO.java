package ruay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ruay.dao.impl.DAO;
import ruay.db.Database;
import ruay.model.TbCustomerModel;

public class TbCustomerDAO implements DAO<TbCustomerModel>{
	Database db;

	public TbCustomerDAO() {
		db = new Database();
	}
	
	@Override
	public int Add(TbCustomerModel bean) {
		String sql = "INSERT INTO customer (id, name, surname, username, password, address, postcode, bank_acct, balance, verified ) "
				+ "VALUES ('"+ bean.getId() +"','" + bean.getName() + "', '"
				+ bean.getSurname() + "', '" + bean.getUsername() + "','"
				+ bean.getPassword() + "','" + bean.getAddress() + "','"
				+ bean.getPostcode() + "','" + bean.getBank_acct() + "','"
				+ bean.getBalance() + "','" + bean.getVerified() +"')";

		return db.add(sql, new String[] { "id" });
	}

	@Override
	public int Delete(TbCustomerModel bean) {
		String sql_delete = "DELETE FROM customer WHERE ID = "+ bean.getId();
		return db.remove(sql_delete);
	}

	@Override
	public int Update(TbCustomerModel bean) {
		String sql_update = "UPDATE customer SET NAME='" + bean.getName() + "', SURNAME='" + bean.getSurname()
		+ "', USERNAME ='" + bean.getUsername() + "', PASSWORD = '"+ bean.getPassword() +"', ADDRESS = " + bean.getAddress() 
		+ ", POSTCODE =" + bean.getPostcode() + ", BANK_ACCT = "+ bean.getBank_acct() 
		+ ", BALANCE =" + bean.getBalance() + ", VERIFIED = " + bean.getVerified() + " WHERE id= " + bean.getId();
		return db.update(sql_update);
	}

	@Override
	public ArrayList<TbCustomerModel> FindAll() {
		String sql = "SELECT * FROM customer";
        ArrayList<HashMap<String, String>> queryList = db.queryList(sql);
        ArrayList<TbCustomerModel> customerList = new ArrayList<TbCustomerModel>();
        for (Iterator<HashMap<String, String>> iterator = queryList.iterator(); iterator.hasNext();) {
            HashMap<String, String> next = iterator.next();
            TbCustomerModel customer = MappingBeans(next);
            customerList.add(customer);
        }
        return customerList;
	}

	@Override
	public TbCustomerModel FindByID(TbCustomerModel bean) {
		String sql = "SELECT * FROM customer WHERE ID = "+ bean.getId();
		HashMap<String, String> map = db.querySingle(sql);
		TbCustomerModel model = MappingBeans(map);
        return model;
	}

	@Override
	public TbCustomerModel FindByID(int id) {
		String sql = "SELECT * FROM customer WHERE ID = "+ id;
		HashMap<String, String> map = db.querySingle(sql);
		TbCustomerModel model = MappingBeans(map);
        return model;
	}

	@Override
	public TbCustomerModel FindByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbCustomerModel MappingBeans(HashMap<String, String> map) {
		int id = Integer.parseInt(map.get("ID").toString());
		int address = Integer.parseInt(map.get("ADDRESS").toString());
		int postcode = Integer.parseInt(map.get("POSTCODE").toString());
		int bank_acct = Integer.parseInt(map.get("BANK_ACCT").toString());
		Double balancce = Double.parseDouble(map.get("BALANCE").toString());
		int verified = Integer.parseInt(map.get("VERIFIED").toString());
		TbCustomerModel tbcModel = new TbCustomerModel(
				id,
                map.get("NAME").toString(),
                map.get("SURNAME").toString(),
                map.get("USERNAME").toString(),
                map.get("PASSWORD").toString(),
                address,
                postcode,
                bank_acct,
                balancce,
                verified);
		return tbcModel;
	}
}
