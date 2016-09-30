/* 
 * Project: renren_sales
 * 
 * File Created at May 24, 2016
 *
 * @author songqingshan
 *
 */
package com.mobile.location.server.common.util.checker;

import java.lang.reflect.Field;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.mobile.location.server.common.exception.ProjectException;
import com.mobile.location.server.common.util.RES_STATUS;

/**
 * 检查操作工具类,一般是检查字段非空
 * 
 * @author songqingshan
 * @date May 24, 2016 2:02:00 PM
 *
 */
public class Checker {

    private static final String ENTITY_CAN_NOT_BE_NULL = "Entity can't be null";
    private static final String FIELD_NAME_CAN_NOT_BE_NULL = "%s can't be null";

    private static Logger logger = LoggerFactory.getLogger(Checker.class);

    /**
     * 检查对象o的字段是否为空,如果对象o为空或者o的字段为空抛出异常<br/>
     * 被标记了@IgnoreNull的字段将会被忽略,即可以为null而不抛出异常
     * 
     * @param o
     */
    public static void checkFieldsNotNull(Object o) {
        if (o == null) {
			throw new ProjectException(ENTITY_CAN_NOT_BE_NULL, RES_STATUS.BAD_PARAM);
        }

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field fieldT : fields) {
            IgnoreNull ignoreNull = fieldT.getAnnotation(IgnoreNull.class);
            if (ignoreNull != null) {
                continue;
            }

            fieldT.setAccessible(true);
            Object value = null;
            try {
                value = fieldT.get(o);
            } catch (Exception e) {
                logger.error("checkFieldsNotNull service error", e);
                continue;
            }

            if (value == null) {
                String fieldName = fieldT.getName();
				throw new ProjectException(String.format(FIELD_NAME_CAN_NOT_BE_NULL, fieldName),
                        RES_STATUS.BAD_PARAM);
            }
        }
    }

    /**
     * 检查对象o的字段是否为空,如果对象o为空或者o的字段为空抛出异常<br/>
     * 被标记了@IgnoreNull的字段将会被忽略,即可以为null而不抛出异常<br />
     * 检查的字段需在fieldList里,不在fieldList里不检查
     * 
     * @param o
     * @param fieldList
     */
    public static void checkFieldInListNotNull(Object o, List<String> fieldList) {
        if (CollectionUtils.isEmpty(fieldList)) {
            return;
        }

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field fieldT : fields) {
            String fieldName = fieldT.getName();
            if (fieldList.contains(fieldName) == false) {
                continue;
            }

            IgnoreNull ignoreNull = fieldT.getAnnotation(IgnoreNull.class);
            if (ignoreNull != null) {
                continue;
            }

            fieldT.setAccessible(true);
            Object value = null;
            try {
                value = fieldT.get(o);
            } catch (Exception e) {
                logger.error("checkFieldInListNotNull service error", e);
                continue;
            }

            if (value == null) {
				throw new ProjectException(String.format(FIELD_NAME_CAN_NOT_BE_NULL, fieldName),
                        RES_STATUS.BAD_PARAM);
            }
        }
    }

}
