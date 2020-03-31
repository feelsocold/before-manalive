package com.bohan.manalive.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션이 생성될 수 있는 위치를 지정
// PARAMETER로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용할 수 있다.
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
// 이 파일을 어노테이션 클래스로 지정
// LoginUser라는 이름을 가진 어노테이션을 생성한다.
public @interface LoginUser {
}