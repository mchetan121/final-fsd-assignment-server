package com.example.projectMGMT.service;


import java.util.List;



public interface ObjectMapperUtility {

    public static final String encGenKey = "bizmobiabizmobia";

    public <T> String objectToJson(T obj);

    public <T> T jsonToObject(String jsonString, Class<T> clazz);

    public <T> List<T> jsonArrayToObjectList(List<?> resplist, Class<T> reqclass);

    public void nullAwareBeanCopy(Object dest, Object source);

    public String getNumber();
}
