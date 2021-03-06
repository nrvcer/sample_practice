使用AOP的目的：在不改变原来的类的代码，给已经存在的类和方法，增加额外的功能。
## 使用AspectJ框架实现AOP的步骤
1. 新建Maven项目
2. pom文件中加入依赖
    1. spring依赖
    2. aspectJ依赖
3. 创建目标类：接口和它的实现类，目的给目标类中的方法增加功能
4. 创建切面类：一个普通的类
    1. 在类的上面加入@Aspect注解，表示当前类是切面类
    2. 在类中定义方法，方法就是切面要执行的功能代码。在方法的
上面加入AspectJ的通知注解，例如@Before，在通知注解的属性value中指定
切入点表达式。
5. 创建Spring的配置文件：声明对象，将对象交给容器统一管理（声明对象可以使用注解或者XML配置文件方式）
   1. 声明目标对象
   2. 声明切面类对象
   3. 声明AspectJ框架中的自动代理生成器标签
      自动代理生成器：用来完成代理对象的自动创建功能的
6. 创建测试类：从spring容器中获取目标对象（实际上是代理对象）
   通过代理对象执行方法，实现AOP的功能增强。