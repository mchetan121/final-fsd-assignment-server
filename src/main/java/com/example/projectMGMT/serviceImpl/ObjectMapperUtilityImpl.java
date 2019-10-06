package com.example.projectMGMT.serviceImpl;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.projectMGMT.service.ObjectMapperUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;


@Service
public class ObjectMapperUtilityImpl implements ObjectMapperUtility {

    private static final Logger logger = LoggerFactory.getLogger(ObjectMapperUtilityImpl.class);

    public static ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> String objectToJson(T obj) {
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(obj);
            logger.info("ObjectMapperUtilityImpl.class", "objectToJson()", "Success");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ObjectMapperUtilityImpl.class", "objectToJson()", "Plese try after Sometime " + e.getMessage());
        }
        return jsonString;
    }

    @Override
    public <T> T jsonToObject(String jsonString, Class<T> clazz) {
        T obj = null;
        try {
            obj = mapper.readValue(jsonString, clazz);
            logger.info("ObjectMapperUtilityImpl.class", "jsonToObject()", "Success");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ObjectMapperUtilityImpl.class", "jsonToObject()", "Plese try after Sometime " + e.getMessage());
        }
        return obj;
    }

    @Override
    public <T> List<T> jsonArrayToObjectList(List<?> resplist, Class<T> reqclass) {
        List<T> objlist = null;
        try {
            objlist = new ObjectMapper().readValue(new Gson().toJson(resplist),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, reqclass));
            logger.info("ObjectMapperUtilityImpl.class", "jsonArrayToObjectList()", "Success");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("ObjectMapperUtilityImpl.class", "jsonArrayToObjectList()", "Plese try after Sometime " + e.getMessage());
        }
        return objlist;
    }

    @Override
    public void nullAwareBeanCopy(Object dest, Object source) {
        try {
            new BeanUtilsBean() {
                @Override
                public void copyProperty(Object dest, String name, Object value)
                        throws IllegalAccessException, InvocationTargetException {
                    if (value != null) {
                        super.copyProperty(dest, name, value);
                    }
                }
            }.copyProperties(dest, source);
            logger.info("ObjectMapperUtilityImpl.class", "nullAwareBeanCopy()", "Success");
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error("ObjectMapperUtilityImpl.class", "nullAwareBeanCopy()", "Plese try after Sometime " + e.getMessage());
        }
    }

    static final private String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    final private Random rng = new SecureRandom();

    char randomChar() {
        return ALPHABET.charAt(rng.nextInt(ALPHABET.length()));
    }

    public String randomUUID(int length, int spacing, char spacerChar) {
        StringBuilder sb = new StringBuilder();
        int spacer = 0;
        while (length > 0) {
            if (spacer == spacing) {
                sb.append(spacerChar);
                spacer = 0;
            }
            length--;
            spacer++;
            sb.append(randomChar());
        }
        return sb.toString();
    }

    @Override
    public String getNumber() {
        String str = "";
        try {
            str = randomUUID(10, 1, 'o');
            logger.info("ObjectMapperUtilityImpl.class", "nullAwareBeanCopy()", "Success");
        } catch (Exception e) {
            logger.error("ObjectMapperUtilityImpl.class", "nullAwareBeanCopy()", "Plese try after Sometime " + e.getMessage());
        }
        return str;
    }

}
