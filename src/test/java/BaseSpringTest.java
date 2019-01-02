import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lixin
 * @date 2019-01-02 17:43
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class BaseSpringTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseSpringTest.class);

    @BeforeClass
    public static void beforeClass(){
        logger.info("单元测试执行前打印输出");
    }

    @AfterClass
    public static void afterClass(){
        logger.info("单元测试执行后打印输出");
    }
}
