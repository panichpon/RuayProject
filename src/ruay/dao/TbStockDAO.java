package ruay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ruay.dao.impl.DAO;
import ruay.db.Database;
import ruay.model.TbGoodModel;
import ruay.model.TbStockModel;

public class TbStockDAO implements DAO<TbStockModel> {

	Database db;
	
	public TbStockDAO() {
		db = new Database();
	}
	
	@Override
	public int Add(TbStockModel bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(TbStockModel bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(TbStockModel bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<TbStockModel> FindAll() {
		String sql = "SELECT * FROM stock";
		ArrayList<HashMap<String, String>> queryList = db.queryList(sql);
		ArrayList<TbStockModel> stockList = new ArrayList<TbStockModel>();
		for (Iterator<HashMap<String, String>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, String> next = iterator.next();
			TbStockModel stock = MappingBeans(next);
			stockList.add(stock);
		}
		return stockList;
	}

	@Override
	public TbStockModel FindByID(TbStockModel bean) {
		String sql= "SELECT * FROM stock WHERE id =" + bean.getId();
        HashMap<String, String> map =db.querySingle(sql);
        TbStockModel stockModel = MappingBeans(map);
        return stockModel;
	}

	@Override
	public TbStockModel FindByID(int id) {
		String sql= "SELECT * FROM stock WHERE id =" + id;
        HashMap<String, String> map =db.querySingle(sql);
        TbStockModel stokModel = MappingBeans(map);
        return stokModel;
	}

	@Override
	public TbStockModel FindByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbStockModel MappingBeans(HashMap<String, String> map) {
		TbGoodModel goodModel = new TbGoodDAO().FindByID(Integer.parseInt(map.get("GOOD_ID")));

		TbStockModel stockModel = new TbStockModel(
				Integer.parseInt(map.get("ID")),
				Integer.parseInt(map.get("GOOD_ID")),
				goodModel,
                Integer.parseInt(map.get("QUANTITY")),
                Integer.parseInt(map.get("REPLENISH")));

        return stockModel;
	}

}
