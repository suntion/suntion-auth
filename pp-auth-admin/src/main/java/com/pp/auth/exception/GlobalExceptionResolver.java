package com.pp.auth.exception;

import com.pp.common.exception.GlobalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


/**
 * HandlerExceptionResolver handler 就是controller类
 * AbstractHandlerMethodExceptionResolver handler 就是 handlerMethod
 * ExceptionHandlerExceptionResolver 处理@ExceptionHandler 和 @ControllerAdvice
 *
 * @author long
 */
public class GlobalExceptionResolver extends AbstractHandlerExceptionResolver {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    private static final String VORESULTCLASSNAME = "com.pp.auth.utils.page.VoResult";
    private static final String TABLERESULTCLASSNAME = "com.pp.auth.utils.page.TableResult";
    private static final String PAGLERESULTCLASSNAME = "com.pp.auth.utils.page.PageResult";

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                if (!VORESULTCLASSNAME.equals(handlerMethod.getMethod().getReturnType().getName()) &&
                        !TABLERESULTCLASSNAME.equals(handlerMethod.getMethod().getReturnType().getName()) &&
                        !PAGLERESULTCLASSNAME.equals(handlerMethod.getMethod().getReturnType().getName())) {
                    return new ModelAndView();
                }
            }

            String code = "500";
            String message;

            //获取状态码
            if (ex instanceof GlobalException) {
                message = ex.getMessage();
                String state = ((GlobalException) ex).getState();
                if (state != null) {
                    code = state;
                }
                if (log.isDebugEnabled()) {
                    log.debug("GlobalExceptionResolver [message]:{}", message);
                } else if (log.isInfoEnabled()) {
                    log.info("GlobalExceptionResolver [message]:{}", message);
                }
            } else {
                message = ex.getMessage();
                log.error("GlobalExceptionResolver [message]:", ex);
            }

            Map<String, Object> attributes = new HashMap<>(2);
            attributes.put("message", message);
            attributes.put("code", code);
            attributes.put("success", false);

            MappingJackson2JsonView view = new MappingJackson2JsonView();
            view.setAttributesMap(attributes);

            ModelAndView mv = new ModelAndView();
            mv.setView(view);
            return mv;
        } catch (Exception e) {
            try {
                log.error("ExceptionResolver 解析出错", e);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
            } catch (Exception handlerException) {
                log.error(String.format("Handling of [%s] resulted in Exception", ex.getClass().getName()), handlerException);
            }
        }

        return new ModelAndView();
    }

}
