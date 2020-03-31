package com.bohan.manalive.web.controller;
import com.bohan.manalive.config.auth.LoginUser;
import com.bohan.manalive.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    Logger logger = LoggerFactory.getLogger(getClass());
    //private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        logger.info("INDEX()");

        //SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());
            logger.info(user.getRole().getKey());
            if(user.getRole().getKey().equals("ROLE_GUEST")){
                return "redirect:/register";
            }
        }

        return "index";
    }
    @GetMapping("/register")
    public void register(Model model, @LoginUser SessionUser user) {
        model.addAttribute("userName", user.getName());

    }

    @GetMapping("/main")
    public String main() {


        return "index2";
    }

}
