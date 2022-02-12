import com.nrvcer.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransTest {
    @Test
    public void test() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        BuyGoodsService bean = context.getBean(BuyGoodsService.class);
        bean.buy(1001, 4);
    }
}
