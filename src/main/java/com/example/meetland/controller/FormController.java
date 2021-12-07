package com.example.meetland.controller;


import com.example.meetland.DTO.UserDTO;
import com.example.meetland.model.User;
import com.example.meetland.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class FormController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/loginadmin")
    public String loginadmin(Model model, UserDTO userDTO, HttpServletResponse response) throws Exception {
        model.addAttribute("login",true);
        log.info(userDTO.toString());
        try{
            User user = userRepository.findByUserId(userDTO.getUserId()).orElseThrow(
                    Exception::new
            );
            model.addAttribute(userDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        Cookie idCookie = new Cookie("memberId", String.valueOf(userDTO.getUserId().hashCode()));
        response.addCookie(idCookie);
        log.info(idCookie.getValue());
        return "m_main";
    }
}
