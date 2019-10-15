package com.teacher.uz.my.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by Shoh Jahon on 13.04.2018.
 */
public class reflectionBuilder {
    private Class<?> c;

    public reflectionBuilder(Class<?> c) {
        this.c = c;
    }

    private Field[] getFields(Class c){
        return c.getDeclaredFields();
    }

    public ArrayList<String> getFieldTypes(Class c){
        ArrayList<String> types = new ArrayList<>();
        Field[] fields = getFields(c);
        for(Field f:fields){
            Class<?> type = f.getType();
            String typeName = type.getSimpleName();
            types.add(typeName);
        }
        return types;
    }

    public ArrayList<String> getFieldNames(Class c){
        ArrayList<String> names =  new ArrayList<>();
        Field[] fields = c.getDeclaredFields();
        for (Field f:fields) {
            String fieldName = f.getName();
            names.add(fieldName);
        }
        return names;
    }

    public int getFieldCount(Class c){
        return (getFields(c).length+1);
    }

}
