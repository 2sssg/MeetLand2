package com.example.meetland;

import com.example.meetland.constant.DefaultManagerId;
import com.example.meetland.constant.DefaultMeatInfo;
import com.example.meetland.model.Meat;
import com.example.meetland.model.User;
import com.example.meetland.repository.MeatRepository;
import com.example.meetland.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Component
public class InsertSQL implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MeatRepository meatRepository;
    @Override
    public void run(String... args) throws Exception {
        for (String userInfo: DefaultManagerId.userInfo){
            User user = new User();
            user.setUserId(userInfo.split(":")[0]);
            user.setUserPassword(userInfo.split(":")[1]);
            user.setUserName(userInfo.split(":")[2]);
            userRepository.save(user);
        }

        for (String meatInfo: DefaultMeatInfo.meatInfo){
            Meat meat = new Meat();
            meat.setIsVisible(Integer.parseInt(meatInfo.split(":")[0]));
            meat.setKind(meatInfo.split(":")[1]);
            meat.setPart(meatInfo.split(":")[2]);
            meat.setInformation(meatInfo.split(":")[3]);
            meat.setPrice(Integer.parseInt(meatInfo.split(":")[4]));
            meatRepository.save(meat);
        }


    }


}