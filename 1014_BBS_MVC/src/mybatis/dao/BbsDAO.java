package mybatis.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

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
	
	public static int totalCount(String bname) {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		int cnt = ss.selectOne("bbs.totalCount", bname);
		
		//if(aa != null)
		
		ss.close();
		return cnt;
		
	}
	
	public static void add(String subject, String writer, String content, String fname,
			String ip, String bname) {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("subject", subject);
		map.put("writer", writer);
		map.put("content", content);
		map.put("file_name", fname);
		map.put("ip", ip);
		map.put("bname", bname);
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		int cnt = ss.insert("bbs.add", map);
		if(cnt > 0)
			ss.commit();
		else
			ss.rollback();
		
		ss.close();
	}
	
	public static BbsVO getBbs(String b_idx) {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		BbsVO vo = ss.selectOne("bbs.getBbs", b_idx);
		ss.close();
		
		return vo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
