package com.trusdom.fdip.common;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanUtils.class);
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void copyProperties(Object source, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target,
                getNullPropertyNames(source));
    }

    public static void copyProperties(Object source, Object target,
                                      String[] ingore) {
        List<String> list = new LinkedList<>(Arrays.asList(ingore));
        list.addAll(Arrays.asList(getNullPropertyNames(source)));
        String[] all = new String[list.size()];
        list.toArray(all);
        org.springframework.beans.BeanUtils.copyProperties(source, target, all);
    }

    public static <T> List<T> castEntity(List<Object[]> list, Class<T> clazz) {
        List<T> returnList = new ArrayList<>();
        if(list.size() > 0 ) {
            Object[] co = list.get(0);
            Class[] c2 = new Class[co.length];

            for (int i = 0; i < co.length; i++) {
                c2[i] = co[i].getClass();
            }

            for (Object[] o : list) {
                Constructor<T> constructor;
                try {
                    constructor = clazz.getConstructor(c2);
                    returnList.add(constructor.newInstance(o));
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    LOGGER.error("构建" + clazz.getName() + "失败", e);
                }
            }
        }
        return returnList;
    }
}
