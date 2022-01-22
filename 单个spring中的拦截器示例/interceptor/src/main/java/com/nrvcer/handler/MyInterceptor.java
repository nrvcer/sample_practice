package com.nrvcer.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class MyInterceptor implements HandlerInterceptor {
    /**
     * preHandle:预处理请求的方法
     * 参数：
     *  Object handler：表示被拦截的控制器对象
     * 返回值：
     *  true：表示请求是正确的，可以被controller处理的
     *      各方法的执行顺序：
     *      拦截器的preHandle方法执行
     *      控制器的doSome方法执行
     *      拦截器的postHandle方法执行
     *      拦截器的afterCompletion方法执行
     *   false:请求不能被处理，控制器方法不会执行。请求到此截止
     * 特点：
     * 1.预处理方法的执行时间：在控制器方法之前执行
     * 2. 可以对请求做处理，可以做登陆的检查，权限的判断，统计数据等等
     * 3. 决定请求是否执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器的preHandle方法执行");
        //return true;

        // 提示
        // 示例：如果权限检查不允许登录系统，则请求不能被控制器方法处理
         request.getRequestDispatcher("/tips.jsp").forward(request,response);
         return false;
    }

    /**
     * postHandle:后处理方法
     * 参数：
     *  Object handler：被拦截的控制器对象
     *  ModelAndView modelAndView：控制器方法的返回值（请求的执行结果）
     *  特点：
     *  1. 在控制器方法之后执行的
     *  2. 能获取到控制器方法的执行结果，可以修改原来的执行结果。可以修改数据，可以修改视图
     *  3. 可以看作对请求的二次处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器的postHandle方法执行");
        // 对请求做二次处理
        if (modelAndView != null) {
            // 修改数据
            modelAndView.addObject("mydate", new Date());
            // 修改视图
            modelAndView.setViewName("other");
        }
        return;
    }

    /**
     *   afterCompletion:最后执行的方法
     *   参数：
     *      Object handler：被拦截的控制器对象
     *      Exception ex:异常对象
     *    特点：
     *      1. 在请求处理完成之后执行的，请求处理完成的标志是视图处理完成，对视图进行forward操作之后
     *      2. 可以做程序最后要做的工作，释放内存，清理临时变量
     *      3. 方法的执行条件
     *          1. 当前所在拦截器的preHandle()方法必须执行
     *          2. preHandle()必须返回true
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器的afterCompletion方法执行");
        // 获取数据
        HttpSession session = request.getSession();
        Object attr = session.getAttribute("attr");
        System.out.println(attr);   //在controller中添加的临时数据
        // 删除数据
        session.removeAttribute("attr");
        // 确认数据是否删除
        attr = session.getAttribute("attr");
        System.out.println(attr);   // null


    }
}
