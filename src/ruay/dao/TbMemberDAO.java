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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(TbMemberModel bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<TbMemberModel> FindAll() {
		String sql = "SELECT * FROM tb_member";
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<TbMemberModel> memberList = new ArrayList<TbMemberModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			TbMemberModel member = MappingBeans(next);
			memberList.add(member);
		}
		return memberList;
	}

	@Override
	public TbMemberModel FindByID(TbMemberModel bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbMemberModel FindByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbMemberModel FindByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbMemberModel MappingBeans(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
