import com.xxl.commom.PostConstructService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author lixin
 * @date 2019-01-02 17:43
 **/
public class CommonTest extends BaseSpringTest{

    @Resource
    private PostConstructService postConstructService;

    @Test
    public void postContructTest(){
        postConstructService.sout();
    }

    public static void main(String[] args) {
        PostConstructService postConstructService = new PostConstructService();
        postConstructService.sout();
    }


}
