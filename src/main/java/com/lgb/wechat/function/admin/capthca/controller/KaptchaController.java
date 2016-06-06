//package com.lgb.wechat.function.admin.capthca.controller;
//
//import com.google.code.kaptcha.Constants;
//import com.google.code.kaptcha.Producer;
//import com.lgb.wechat.arc.util.constants.ConstantsCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.imageio.ImageIO;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//
//@Controller
//@RequestMapping("/admin")
//public class KaptchaController {
//    private static final String RESPONSE_DATE_HEADER_KEY = "Expires";
//    private static final String RESPONSE_HEADER_CACHE_CONTROL_KEY =
//            "Cache-Control";
//    private static final String RESPONSE_HEADER_CACHE_CONTROL_VALUE_1 =
//            "no-store, no-cache, must-revalidate";
//    private static final String RESPONSE_HEADER_CACHE_CONTROL_VALUE_2 =
//            "post-check=0, pre-check=0";
//    private static final String RESPONSE_HEADER_PRAGMA_KEY = "Pragma";
//    private static final String RESPONSE_HEADER_PRAGMA_VALUE = "no-cache";
//    private static final String RESPONSE_CONTENT_TYPE_MIME = "image/jpeg";
//    private static final String IO_WRITE_IMAGE_FORMAT = "jpg";
//
//    @Autowired
//    private Producer captchaProducer = null;
//
//    public Producer getCaptchaProducer() {
//        return captchaProducer;
//    }
//
//    @Autowired
//    public void setCaptchaProducer(Producer captchaProducer) {
//        this.captchaProducer = captchaProducer;
//    }
//
//    @Autowired
//    public KaptchaController(@Qualifier("captchaProducer") Producer captchaProducer) {
//        this.captchaProducer = captchaProducer;
//    }
//
//    @RequestMapping(value = "/captchaImage")
//    public ModelAndView createKaptchaImage(HttpServletRequest request,
//                                           HttpServletResponse response) throws IOException {
//        // Set to expire far in the past.
//        response.setDateHeader(RESPONSE_DATE_HEADER_KEY, 0);
//        // Set standard HTTP/1.1 no-cache headers.
//        response.setHeader(RESPONSE_HEADER_CACHE_CONTROL_KEY, RESPONSE_HEADER_CACHE_CONTROL_VALUE_1);
//        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
//        response.addHeader(RESPONSE_HEADER_CACHE_CONTROL_KEY, RESPONSE_HEADER_CACHE_CONTROL_VALUE_2);
//        // Set standard HTTP/1.0 no-cache header.
//        response.setHeader(RESPONSE_HEADER_PRAGMA_KEY, RESPONSE_HEADER_PRAGMA_VALUE);
//
//        // return a jpeg
//        response.setContentType(RESPONSE_CONTENT_TYPE_MIME);
//
//        // create the text for the image
//        String capText = captchaProducer.createText();
//
//        // store the text in the session
//        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
//
//        // create the image with the text
//        BufferedImage bufferedImage = captchaProducer.createImage(capText);
//
//        ServletOutputStream out = response.getOutputStream();
//
//        // write the data out
//        ImageIO.write(bufferedImage, IO_WRITE_IMAGE_FORMAT, out);
//
//        try {
//            out.flush();
//        } finally {
//            out.close();
//        }
//
//        return null;
//    }
//
//    @RequestMapping("/captchaCheck")
//    public ModelAndView captchaCheckValue(HttpServletRequest request) {
//        String kaptchaExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//        String kaptchaReceived = request.getParameter("captchaCode");
//        if (kaptchaReceived != null || kaptchaReceived.equalsIgnoreCase(kaptchaExpected)) {
//            System.out.println("GOOD! The kaptcha is right");
//        }
//
//        return null;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/validateCode", method = RequestMethod.POST)
//    public boolean validateCode(HttpServletRequest request,
//                                @RequestParam("authCode") String authCode) {
//
//        return request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString().equals(authCode);
//    }
//
//}
