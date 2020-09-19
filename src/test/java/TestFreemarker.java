import com.freemark.util.FreemarkerUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaha
 * @Description 测试
 * @create 2020-09-19 19:45
 */
public class TestFreemarker {
    private FreemarkerUtil freemarkerUtil;
    private Map<String, Object> rootMap = null;
    @Before
    public void setUp(){
        freemarkerUtil = new FreemarkerUtil();
        rootMap = new HashMap<String, Object>();
    }
    @Test
    public void test01(){
        //填充数据
        rootMap.put("username","zblog");
        //打印到控制台
        freemarkerUtil.print("demo.ftl",rootMap);
        //输出到文件
        freemarkerUtil.tempPrint("demo.ftl",rootMap,"demo01.html");
    }
}
