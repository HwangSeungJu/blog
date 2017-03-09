package spring.model.bbs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BbsDAOTest {

	private static BeanFactory beans;
	private static BbsDAO bdao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Resource resource = new ClassPathResource("blog.xml");
		beans = new XmlBeanFactory(resource);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		bdao = (BbsDAO)beans.getBean("bdao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test @Ignore
	public void testCheckRefno() {
		assertTrue(bdao.checkRefno(7));
	}

	@Test 
	public void testTotal() {
		//assertEquals(bdao.total("", ""), 11);
		assertEquals(bdao.total("wname", "¿Õ´«ÀÌ"), 2);
	}

	@Test @Ignore
	public void testUpAnsnum() {
		fail("Not yet implemented");
	}

	@Test @Ignore
	public void testCreateReply() {
		int bbsno = 6;
		BbsDTO dto = bdao.readReply(bbsno);
		dto.setWname("´äº¯ÀÚ1");
		dto.setContent("´äº¯³»¿ëÀÌ´Ù1");
		dto.setPasswd("123");
		dto.setFilename("test.txt");
		dto.setFilesize(12345);
		Map map = new HashMap();
		map.put("grpno", dto.getGrpno());
		map.put("ansnum", dto.getAnsnum());
		bdao.upAnsnum(map);
		
		assertTrue(bdao.createReply(dto));
	}

	@Test @Ignore
	public void testReadReply() {
		int bbsno = 6;
		BbsDTO dto = bdao.readReply(bbsno);
		assertEquals(dto.getGrpno(), 6);
		assertEquals(dto.getIndent(), 0);
		assertEquals(dto.getAnsnum(), 0);
		assertEquals(dto.getTitle(), "123");
		
	}

	@Test @Ignore
	public void testDelete() {
		assertTrue(bdao.delete(5));
	}

	@Test @Ignore
	public void testUpdate() {
		BbsDTO dto = new BbsDTO();
		dto.setBbsno(4);
		dto.setWname("È«´«ÀÌ");
		dto.setTitle("Á¦¸ñº¯°æ");
		dto.setContent("³»¿ëº¯°æ");
		dto.setFilename("test.txt");
		dto.setFilesize(1234);
		
		assertTrue(bdao.update(dto));
		
	}

	@Test @Ignore
	public void testPassCheck() {
		Map map = new HashMap();
		map.put("bbsno", 4);
		map.put("passwd", "123");
		assertTrue(bdao.passCheck(map));
		
	}

	@Test 
	public void testRead() {
		bdao.upViewcnt(8);
		BbsDTO dto = bdao.read(8);
		
		assertNotNull(dto);
	}

	@Test @Ignore
	public void testUpViewcnt() {
		fail("Not yet implemented");
	}

	@Test @Ignore
	public void testList() {
		Map map = new HashMap();
		map.put("col", "wname");
		map.put("word", "¿Õ´«ÀÌ");
		map.put("sno", 1);
		map.put("eno", 5);
		List<BbsDTO> list = bdao.list(map);
		assertEquals(list.size(), 2);
	}

	@Test @Ignore
	public void testCreate() {
		BbsDTO dto = new BbsDTO();
		dto.setWname("¸Þ½Ã");
		dto.setTitle("¸Þ½Ã¹ß¸²");
		dto.setContent("¹Ù¼¿Â¯¸øÇØ");
		dto.setPasswd("123");
		dto.setFilename("test.txt");
		dto.setFilesize(100);
		
		assertTrue(bdao.create(dto));
	}

}
