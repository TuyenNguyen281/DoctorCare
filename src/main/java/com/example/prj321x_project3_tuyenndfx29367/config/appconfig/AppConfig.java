package com.example.prj321x_project3_tuyenndfx29367.config.appconfig;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Configuration
@EnableWebMvc
public class AppConfig {

    //Cloudinary
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dgvs7b2zs",
                "api_key", "541115866295151",
                "api_secret", "cZHcaywf3WzAoc1cVARNUMTvcDw",
                "secure", true
        ));
        return cloudinary;
    }


}
