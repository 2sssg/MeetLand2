package com.example.meetland.controller;

import com.example.meetland.DTO.MeatDTO;
import com.example.meetland.DTO.UserDTO;
import com.example.meetland.model.Meat;
import com.example.meetland.model.User;
import com.example.meetland.repository.MeatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Slf4j
public class MainController {

    @Autowired
    MeatRepository meatRepository;

    @RequestMapping()
    public String mainController(Model model,@CookieValue(name="memberId",required = false) Long memberId){
        model.addAttribute("login",true);
        if(memberId == null){
            model.addAttribute("login",false);
        }
        return "m_main";
    }
    @RequestMapping("/m_main")
    public String mainController2(Model model,@CookieValue(name="memberId",required = false) Long memberId){
        model.addAttribute("login",true);
        if(memberId == null){
            model.addAttribute("login",false);
        }
        return "m_main";
    }


    @RequestMapping("/m_products")
    public String m_product(Model model,@CookieValue(name="memberId",required = false) Long memberId){
        model.addAttribute("login",true);
        if(memberId == null){
            model.addAttribute("login",false);
        }
        List<Meat> meats = meatRepository.findAll();
        model.addAttribute("meats",meats);
        model.addAttribute("fixMeat",new Meat());
        log.info(model.toString());
        return "m_products";
    }


    @RequestMapping("/m_contact")
    public String contact(Model model,@CookieValue(name="memberId",required = false) Long memberId){
        model.addAttribute("login",true);
        if(memberId == null){
            model.addAttribute("login",false);
        }
        return "m_contact";
    }


    @RequestMapping("/m_login")
    public String login(Model model, UserDTO userDTO,@CookieValue(name="memberId",required = false) Long memberId){
        model.addAttribute("login",true);
        if(memberId == null){
            model.addAttribute("login",false);
        }
        return "m_login";
    }


    @RequestMapping("/logout")
    public String logout(Model model ,HttpServletResponse response,@CookieValue(name="memberId",required = false) Long memberId) {
        model.addAttribute("login",false);
        expiredCookie(response, "memberId");
        return "m_main";
    }

    private void expiredCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    @RequestMapping("/fixmeat")
    public String fixmeat(Model model,@CookieValue(name="memberId",required = false) Long memberId, MeatDTO meatDTO) {
        log.info(meatDTO.toString());
        model.addAttribute("login",true);
        if(memberId == null){
            model.addAttribute("login",false);
        }
        Meat meat = meatRepository.findById( meatDTO.getId()).get();
        if(!meatDTO.getInformation().equals("")){
            meat.setInformation(meatDTO.getInformation());
        }
        if(meatDTO.getPrice()!=0){
            meat.setPrice(meatDTO.getPrice());
        }
        meatRepository.save(meat);
        List<Meat> meats = meatRepository.findAll();
        model.addAttribute("meats",meats);
        model.addAttribute("fixMeat",new Meat());
        return "m_products";
    }

}
