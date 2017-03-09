package spring.model.memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service 
public class MemoService {
       @Autowired
       // private BbsDAO dao;
          private MemoDAO dao;
       @Autowired
        private MemoReplyDAO mdao;
 
      public void delete(int memono) throws Exception{
 
             mdao.mdelete(memono);
             dao.delete(memono);
      }
}