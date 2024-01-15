package tom.study.common.config.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class RequestValidationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("필터 초기화: {}", this.getClass());
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        String secretAccessCode = request.getHeader("Secret-Access-Code");
//        if (secretAccessCode==null || secretAccessCode.isBlank()) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
        log.info(" *** testFilter *** ");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("필터 종료: {}", this.getClass());
        Filter.super.destroy();
    }
}
