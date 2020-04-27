package ruay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ruay.dao.impl.DAO;
import ruay.db.Database;
import ruay.model.TbCustomerModel;
import ruay.model.TbInvoiceModel;

public class TbInvoiceDAO implements DAO<TbInvoiceModel> {

	Database db;
	
	public TbInvoiceDAO() {
		db = new Database();
	}
	
	@Override
	public int Add(TbInvoiceModel bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(TbInvoiceModel bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(TbInvoiceModel bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<TbInvoiceModel> FindAll() {
		String sql = "SELECT * FROM invoice";
        ArrayList<HashMap<String, String>> queryList = db.queryList(sql);
        ArrayList<TbInvoiceModel> invoiceList = new ArrayList<TbInvoiceModel>();
        for (Iterator<HashMap<String, String>> iterator = queryList.iterator(); iterator.hasNext();) {
            HashMap<String, String> next = iterator.next();
            TbInvoiceModel invoice = MappingBeans(next);
            invoiceList.add(invoice);
        }
        return invoiceList;
	}

	@Override
	public TbInvoiceModel FindByID(TbInvoiceModel bean) {
		String sql = "SELECT * FROM invoice WHERE ID = "+ bean.getId();
		HashMap<String, String> map = db.querySingle(sql);
		TbInvoiceModel model = MappingBeans(map);
        return model;
	}

	@Override
	public TbInvoiceModel FindByID(int id) {
		String sql = "SELECT * FROM invoice WHERE ID = "+ id;
		HashMap<String, String> map = db.querySingle(sql);
		TbInvoiceModel model = MappingBeans(map);
        return model;
	}

	@Override
	public TbInvoiceModel FindByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbInvoiceModel MappingBeans(HashMap<String, String> map) {
		
		// FindById in Customer table
		TbCustomerModel custModel = new TbCustomerDAO().FindByID(Integer.parseInt(map.get("CUSTOMER_ID")));
		
		TbInvoiceModel tbivModel = new TbInvoiceModel(
				Integer.parseInt(map.get("ID")), 
				custModel, 
				Integer.parseInt(map.get("CUSTOMER_ID")), 
				map.get("INVOICE_DATE"), 
				Double.parseDouble(map.get("TOTAL_AMOUNT")));
		
		
		return tbivModel;
	}

}
