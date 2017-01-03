package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.AutoMarka;
import model.AutoModel;
import model.Master;
import model.Specialization;
import service.impl.MasterServiceImpl;

/**
 * Created by Pomeo on 18.10.2016.
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring-service-context.xml");

        MasterServiceImpl masterService = context.getBean(MasterServiceImpl.class);


//        Master master = masterService.findMasterById(3);
//        AutoModel autoModel = masterService.findAutoModelById(1);
//        AutoMarka autoMarka = masterService.findAutoMarkaById(3);
//        Specialization specialization = masterService.findSpecializationById(1);
//
//        System.out.println(master.getName());
//        System.out.println(autoModel);
//        System.out.println(autoMarka);
//        System.out.println(specialization);


    }


}
