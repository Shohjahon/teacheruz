package com.teacher.uz.my.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shoh Jahon on 14.05.2018.
 */
@Controller
public class ErrorController {
    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        ModelAndView mv = new ModelAndView("error");

        String errorTitle = "";
        String errorDescription = "";
        String title = "";
        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            case 400: {
                title = "400 Error Page";
                errorTitle = "You have made bad request!";
                errorDescription = "The page is not available , The result is bad request!";;
                break;
            }
            case 401: {
                title = "401 Error Page";
                errorTitle = "You are unouthorized to this Page!";
                errorDescription = "The page you are looking for is not available for your needs!";
                break;
            }
            case 404: {
                title = "404 Error Page";
                errorTitle = "The page is not constructed!";
                errorDescription = "The page you are looking for is not available now!";
                break;
            }
            case 500: {
                title = "500 Error Page";
                errorTitle = "You are faced Internal Server Error!";
                errorDescription = "Internal server error occured , you made inappropriate action to site rules!";
                break;
            }
        }
        mv.addObject("title", title);
        mv.addObject("errorTitle",errorTitle);
        mv.addObject("errorDescription",errorDescription);
        return mv;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}
