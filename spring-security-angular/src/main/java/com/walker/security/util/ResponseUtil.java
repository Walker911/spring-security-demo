package com.walker.security.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walker.security.common.ResultBean;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author walker
 * @date 2019/3/1
 */
public class ResponseUtil {

    public static void writeResponse(HttpServletResponse response, ResultBean resultBean) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter out = response.getWriter();
        out.write(objectMapper.writeValueAsString(resultBean));
        out.flush();
        out.close();
    }
}
