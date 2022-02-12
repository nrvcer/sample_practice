import com.nrvcer.service.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void testBefore() {
        String config = "applicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        // 从容器中获取目标对象
        SomeService proxy = (SomeService)app.getBean("someservice");
        // 使用的JDK动态代理，com.sun.proxy.$Proxy7
        System.out.println(proxy.getClass().getName());
        // 通过代理对象执行方法，实现目标方法执行时增强功能
        proxy.dosome("李四", 22);
        proxy.doOnther("张三",23);
        String res = proxy.doFirst("王五", 35);
        System.out.println(res);
    }
}
