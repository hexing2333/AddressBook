package cn.edu.bupt.demo.filter;

import cn.edu.bupt.demo.filter.IndexFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SessionConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new IndexFilter()).addPathPatterns("/**").excludePathPatterns("/login","/*.css","/img/*");
        //拦截器 拦截除静态资源和登录界面外的所有界面
    }
}
