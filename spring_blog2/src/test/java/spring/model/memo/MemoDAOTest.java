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

public class MemoDAOTest {

		
	private static BeanFactory beans;
	private static MemoDAO medao;
	
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
		medao = (MemoDAO)beans.getBean("medao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTotal() {
		assertEquals(medao.total("title", "당첨"), 2);
	}

	@Test @Ignore
	public void testUpViewcnt() {
		fail("Not yet implemented");
	}

	@Test @Ignore
	public void testDelete() {
		assertTrue(medao.delete(8));
		
	}

	@Test  @Ignore
	public void testUpdate() {
		MemoDTO dto = new MemoDTO();
		dto.setMemono(2);
		dto.setTitle("연금당첨");
		dto.setContent("연금복권, 스피또 1등 당첨!!");
		
		assertTrue(medao.update(dto));
	}

	@Test @Ignore
	public void testRead() {
		medao.upViewcnt(501);
		MemoDTO dto = medao.read(201);
		
		assertNotNull(dto);
	}

	@Test @Ignore
	public void testCreate() {
		MemoDTO dto = new MemoDTO();
		dto.setTitle("스피또당첨");
		dto.setContent("스피또, 연금복권 당첨 1등된다");
		
		assertTrue(medao.create(dto));
	}

	@Test @Ignore
	public void testList() {
		Map map = new HashMap();
		map.put("col", "title");
		map.put("word", "화요일");
		map.put("sno", 1);
		map.put("eno", 5);
		List<MemoDTO> list = medao.list(map);
		
		assertEquals(list.size(), 4);
	}

}
