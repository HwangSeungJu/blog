package spring.model.image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.utility.blog.DBClose;
import spring.utility.blog.DBOpen;


@Repository
public class ImageDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void viewcnt(int no){
		Connection con = DBOpen.open();
		PreparedStatement pstmt=null;
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE image ");
		sql.append(" SET viewcnt = viewcnt + 1 ");
		sql.append(" WHERE no=? ");
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(con, pstmt);
		}
	}
	public boolean checkRefno(int no){
		boolean flag = false;
		Connection con =DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(refno) from image ");
		sql.append(" where refno = ? ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				int cnt = rs.getInt(1);
				if(cnt>0){
					flag = true;//부모글이다.
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(con, pstmt, rs);
		}
		
		
		return flag;
	}
	public void upAno(Map map){
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		int gno = (Integer)map.get("gno");
		int ano = (Integer)map.get("ano");
		sql.append(" update image ");
		sql.append(" set ano = ano + 1 ");
		sql.append(" where gno = ? and ano > ?");
		
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, gno);
			pstmt.setInt(2, ano);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBClose.close(con, pstmt);
		}
	}
	
	public boolean createReply(ImageDTO dto){
		boolean flag = false;
		
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append(" INSERT INTO image(no, name, title, content, passwd, wdate, gno, ino, ano, refno,  filename) ");
		sql.append(" VALUES((SELECT NVL(MAX(no), 0) + 1 FROM image), ");
		sql.append(" ?, ?, ?, ?,  sysdate, ");
		sql.append(" ?, ?, ?, ? , ? )  ");
		
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setInt(5, dto.getGno()); //부모의 grpno
			pstmt.setInt(6, dto.getIno()+1); //부모의 indent + 1
			pstmt.setInt(7, dto.getAno()+1); //부모의 ansnum + 1
			pstmt.setInt(8, dto.getNo());
			pstmt.setString(9, dto.getFilename()); 
		
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) flag=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(con, pstmt);
		}
		return flag;
	}
	
	public ImageDTO readReply(int no){
		ImageDTO dto = null;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT no, title, gno, ino, ano ");
		sql.append(" FROM image ");
		sql.append(" WHERE no = ? ");
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()){
				dto = new ImageDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setGno(rs.getInt("gno"));
				dto.setIno(rs.getInt("ino"));
				dto.setAno(rs.getInt("ano"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(con, pstmt, rs);
		}
		return dto;
	}
	
	public int total(String col, String word){
		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		return sqlSession.selectOne("image.total", map);
	}
	
	public List<ImageDTO> list(Map map){
		
		return sqlSession.selectList("image.list", map);
	}
	
	public boolean passwd(Map map){
		boolean flag=false;
		Connection con=DBOpen.open();
		PreparedStatement pstmt= null;
		StringBuffer sql= new StringBuffer();
		int no = (Integer) map.get("no");
		String passwd = (String) map.get("passwd");
		ResultSet rs= null;
		sql.append(" select count(no) from image ");
		sql.append(" where no=? and passwd=? ");
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1,no);
			pstmt.setString(2,passwd);
			rs=pstmt.executeQuery();
			if(rs.next()){
				int cnt = rs.getInt(1);
				if(cnt>0){
					flag=true;
				}
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return flag;
		
	}
	public boolean delete(int no){
		boolean flag=false;
		Connection con=DBOpen.open();
		PreparedStatement pstmt= null;
		StringBuffer sql= new StringBuffer();
		sql.append(" delete from image ");
		sql.append(" where no=? ");
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1,no);
			int cnt=pstmt.executeUpdate();
			if(cnt>0){
				flag=true;
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt);
		}
		
		return flag;
	}
	
	public boolean update(ImageDTO dto){
		boolean flag = false;
		
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append(" update image set  ");
		sql.append(" name = ?,  ");
		sql.append(" title = ?,  ");
		sql.append(" content = ?,  ");
		sql.append(" passwd = ?,  ");
		sql.append(" filename = ?  ");
		sql.append(" where no = ?  ");		
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setString(5, dto.getFilename());
			pstmt.setInt(6, dto.getNo());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(con, pstmt);
		}
		
		
		return flag;
		
	}

	
	
	public boolean updateFile(ImageDTO dto){
		boolean flag = false;
		
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append(" update image set  ");
		
		sql.append(" filename = ?  ");
		sql.append(" where no = ?  ");		
		
		try {
			pstmt = con.prepareStatement(sql.toString());
		
			pstmt.setString(1, dto.getFilename());
			pstmt.setInt(2, dto.getNo());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(con, pstmt);
		}
		
		
		return flag;
		
	}
	
	public Map sumnail(int no) {

		return sqlSession.selectOne("image.sumnail", no);

		}

	public ImageDTO read(int no) {
	
		return sqlSession.selectOne("image.read", no);

	}
	public boolean create(ImageDTO dto) {
		boolean flag = false;

		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();

		sql.append(" insert into image ( no , name , title , content ,passwd  ,wdate ,filename ,gno  ) ");
		sql.append(
				" values((select nvl(max(no),0)+1 from image) , ? , ? , ? , ? , sysdate, ?,(select nvl(max(gno),0)+1 from image) )");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setString(5, dto.getFilename());

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}

		return flag;

	}

}
