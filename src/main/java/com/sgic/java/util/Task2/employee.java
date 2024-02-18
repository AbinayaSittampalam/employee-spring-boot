package com.sgic.java.util.Task2;

import com.sgic.java.util.Task2.Task2Application;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.sql.*;

public class employee {

    public static void main(String[] args) {


        try {
            ObjectMapper mapper = new XmlMapper();

            FileInputStream inputStream = new FileInputStream(new File("C:/Users/Mithu/Downloads/Task2/Task2/src/main/java/com/sgic/java/util/Task2/employee.xml"));
            TypeReference<List<Task2Application>> typeReference = new TypeReference<List<Task2Application>>()
            {
            };
            List<Task2Application> userList = mapper.readValue(inputStream, typeReference);
            inputStream.close();


            for (Task2Application employee: userList) {
                if ("Quality Engineer".equals(employee.getPosition()))
                System.out.println(employee.getId() + " " +employee.getPosition());
                employee.Database();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}