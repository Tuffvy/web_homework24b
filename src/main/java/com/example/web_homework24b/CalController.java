package com.example.web_homework24b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CalController {
    int count = 0;

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/acc")
    @ResponseBody
    public String useSession(int para){
        HttpSession session = request.getSession();
        if(count==0){
            session.setAttribute("para",0);
        }
        count += 1;
        int parameter1 = (int)session.getAttribute("para");
        session.setAttribute("para",para+parameter1);
        int parameter2 = (int)session.getAttribute("para");
        return String.valueOf(parameter2);
    }
}
