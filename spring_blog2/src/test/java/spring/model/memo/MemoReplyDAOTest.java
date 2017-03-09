package spring.model.memo;

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

public class MemoReplyDAOTest {
	
	private static BeanFactory beans;
	private static MemoReplyDAO mdao;

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
		mdao = (MemoReplyDAO)beans.getBean("mdao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test @Ignore
	public void testRcount() {
		assertEquals(mdao.rcount(2), 3);
	}

	@Test @Ignore
	public void testCreate() {
		MemoReplyDTO dto = new MemoReplyDTO();
		dto.setId("user1");
		dto.setContent("댓글입니다.111");
		dto.setMemono(2);
		assertTrue(mdao.create(dto));
	}

	@Test @Ignore
	public void testRead() {
		MemoReplyDTO dto = mdao.read(11);
		
		assertNotNull(dto);
		
	}

	@Test @Ignore
	public void testUpdate() {
		MemoReplyDTO dto = new MemoReplyDTO();
		dto.setRnum(11);
		dto.setContent("연금복권!!");
		
		assertTrue(mdao.update(dto));
	}

	@Test @Ignore
	public void testList() {
		Map map = new HashMap();
		map.put("memono", 2);
		map.put("sno", 1);
		map.put("eno", 5);
		List<MemoReplyDTO> list = mdao.list(map);
		assertEquals(list.size(), 3);
	}

	@Test @Ignore
	public void testTotal() {
		assertEquals(mdao.total(2), 3);
	}

	@Test @Ignore
	public void testDelete() {
		assertTrue(mdao.delete(15));
	}

	@Test @Ignore
	public void testMdelete() {
		assertTrue(mdao.delete(202));
	}

}
