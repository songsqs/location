/* 
 * Project: renren_sales
 * 
 * File Created at May 24, 2016
 *
 * @author songqingshan
 *
 */
package com.mobile.location.server.common.util.checker;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 作用在字段上. 被标记的字段,如果Checker检测到为null,则不会抛异常报错
 * 
 * @author songqingshan
 * @date May 24, 2016 2:14:05 PM
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface IgnoreNull {

}
