import com.geekerstar.ssm.dao.StudentDao;
import com.geekerstar.ssm.pojo.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDaoTest extends BaseTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testQueryById(){
        Integer id = 101;
        Student student = studentDao.queryById(id);
        System.out.println(student);
    }

}
