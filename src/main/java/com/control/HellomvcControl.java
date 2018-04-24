package com.control;

import com.entity.Person;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/hello")
public class HellomvcControl {

    private org.slf4j.Logger logger= LoggerFactory.getLogger("HellomvcControl");

    @RequestMapping("/home")
    public String hello(){
        return "home";
    }

    @RequestMapping("/page")
    public String showUploadPage(){
        return "file";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String doUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            logger.info("上传文件中");
//           文件复制的工具类,这里添加了时间戳,这里还要特别注意new  File(文件夹路径,文件名)
            FileUtils.copyInputStreamToFile( file.getInputStream(),new File("D:"+File.separator+"copy"+File.separator,file.getName()+System.currentTimeMillis()));
       }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/person")
    public Person init(){
        Person person=new Person();
        person.setId(2);
        person.setName("aaaa");
        return person;
    }
}
