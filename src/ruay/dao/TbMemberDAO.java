package ruay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ruay.dao.impl.DAO;
import ruay.db.Database;
import ruay.model.TbMemberModel;

public class TbMemberDAO implements DAO<TbMemberModel> {

	Database db;
	
	public TbMemberDAO() {
		db = new Database();
	}
	
	@Override
	public int Add(TbMemberModel bean) {
		String sql = "INSERT INTO tb_member (name, surname, gender) "
				+ "VALUES ('"+bean.getName()+"', "
						+ "'"+bean.getSurname()+"', "
						+ "'"+bean.getGender()+"')";
		return db.add(sql, new String[] {"id"});
	}

	@Override
	public int Delete(TbMemberModel bean) {
		String sql = "DELETE FROM tb_member WHERE id = " + bean.getId();
		return db.remove(sql);
	}

	@Override
	public int Update(TbMemberModel bean) {
		String sql = "UPDATE tb_member SET "
				+ "name = '"+bean.getName()+"', "
				+ "surname = '"+bean.getSurname()+"', "
				+ "gender = '"+bean.getGender()+"' "
				+ "WHERE id = " + bean.getId();
		return db.update(sql);
	}

	@Override
	public ArrayList<TbMemberModel> FindAll() {
		String sql = "SELECT * FROM tb_member";
		ArrayList<HashMap<String, String>> queryList = db.queryList(sql);
		ArrayList<TbMemberModel> memberList = new ArrayList<TbMemberModel>();
		for (Iterator<HashMap<String, String>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, String> next = iterator.next();
			TbMemberModel member = MappingBeans(next);
			memberList.add(member);
		}
		return memberList;
	}

	@Override
	public TbMemberModel FindByID(TbMemberModel bean) {
		String sql = "SELECT * FROM tb_member WHERE id = " + bean.getId();
		HashMap<String, String> map = db.querySingle(sql);
		TbMemberModel model = MappingBeans(map);  
		return model;
	}

	@Override
	public TbMemberModel FindByID(int id) {
		String sql = "SELECT * FROM tb_member WHERE id = " + id;
		HashMap<String, String> map = db.querySingle(sql);
		TbMemberModel model = MappingBeans(map);  
		return model;
	}

	@Override
	public TbMemberModel FindByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbMemberModel MappingBeans(HashMap<String, String> map) {
		
		TbMemberModel tbmModel = new TbMemberModel(
				Integer.parseInt(map.get("id")),
				map.get("name"),
				map.get("surname"),
				map.get("gender"),
				map.get("time_reg"));

		return tbmModel;
	}

	public TbMemberModel FindByLogin(String username, String password) {
		String sql = "SELECT * FROM tb_member WHERE name = '" + username + "' AND surname = '" + password +"'";
		HashMap<String, String> map = db.querySingle(sql);
		TbMemberModel model = new TbMemberModel();
		if (!map.isEmpty()) {
			model = MappingBeans(map);
		}
		return model;
	}
	
	public TbMemberModel FindByLoginCheck(String username) {
		String sql = "SELECT * FROM tb_member WHERE name = '" + username + "'";
		HashMap<String, String> map = db.querySingle(sql);
		TbMemberModel model = new TbMemberModel();
		if (!map.isEmpty()) {
			model = MappingBeans(map);
		}
		return model;
	}
}
