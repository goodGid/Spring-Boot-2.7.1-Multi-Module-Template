# Spring-Boot-2.7.1-Multi-Module-Template

## Goal

* Spring Boot 2.7.1 && Gradle 7.4.1 환경에서 Multi Module + DB 설정

## Spec

* Java 11
* Spring Boot 2.7.1
* Gradle 7.4.1
* MySQL
* JPA

## Module

* module-api

* module-common




### module간 의존성 설정 방법

* module-api에 위치하는 `build.gradle` 파일 수정

``` java
## 2.7.1 방법
dependencies {
	implementation project(':module-common') // root project -> settings.gradle에 선언한 값과 같아야함.
	...
}

## Legacy 방법
project(':module-api') {
    dependencies {
        compile project(':module-common')
    }
} 
```


## Reference

* [goodGid/Spring-Boot-2.4.4-Multi-Module-Template](https://github.com/goodGid/Spring-Boot-2.4.4-Multi-Module-Template)