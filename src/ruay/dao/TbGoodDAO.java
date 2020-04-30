package ruay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ruay.dao.impl.DAO;
import ruay.db.Database;
import ruay.model.TbGoodModel;

public class TbGoodDAO implements DAO<TbGoodModel> {

	Database db;
	
	public TbGoodDAO() {
		db = new Database();
	}
	
	@Override
	public int Add(TbGoodModel bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(TbGoodModel bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(TbGoodModel bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<TbGoodModel> FindAll() {
		String sql = "SELECT * FROM good";
		ArrayList<HashMap<String, String>> queryList = db.queryList(sql);
		ArrayList<TbGoodModel> goodList = new ArrayList<TbGoodModel>();
		for (Iterator<HashMap<String, String>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, String> next = iterator.next();
			TbGoodModel good = MappingBeans(next);
			goodList.add(good);
		}
		return goodList;
	}

	@Override
	public TbGoodModel FindByID(TbGoodModel bean) {
		String sql= "SELECT * FROM good WHERE ID =" + bean.getId();
        HashMap<String, String> map = db.querySingle(sql);
        TbGoodModel goodModel = MappingBeans(map);
        return goodModel;
	}

	@Override
	public TbGoodModel FindByID(int id) {
		String sql= "SELECT * FROM good WHERE ID =" + id;
		System.out.println(sql);
        HashMap<String, String> map = db.querySingle(sql);
        TbGoodModel goodModel = MappingBeans(map);
        return goodModel;
	}

	@Override
	public TbGoodModel FindByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbGoodModel MappingBeans(HashMap<String, String> map) {
		TbGoodModel gModel = new TbGoodModel(
				Integer.parseInt(map.get("ID")),
                map.get("NAME").toString(),
                (Double.parseDouble(map.get("UNITCOST"))),
                (Double.parseDouble(map.get("UNITPRICE"))),
                map.get("IMAGES"));

        return gModel;
	}

}
