package mybatis.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.BbsVO;

public class BbsDAO {

	public static BbsVO[] getList(int begin, int end, String bname) {
		
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("bname", bname);
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end) );
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		List<BbsVO> list = ss.selectList("bbs.list", map);
		
		//받은 리스트를 배열로 바꿔줍니다.
		BbsVO[] ar = null;
		if(list != null && list.size() >0) {
			ar = new BbsVO[list.size()];
			
			list.toArray(ar);
		}
		
		ss.close();
		return ar;
	}
}
