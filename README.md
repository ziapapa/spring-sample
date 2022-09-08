## 실행 방법
* Java 8 버전 이상 설치
* 해당 프로젝트 root 디렉토리
  ```
  ./gradlew bootJar
  ```  
* 해당 프로젝트 root 디렉토리
  ```
  java -jar build/libs/spring-sample.jar
  ```  

## Directory
* 디렉토리 구조는 도메인형을 선호하나 빠른 개발을 위해 계층형을 선택
  
  ### controller
  * 외부에서 요청을 받고 응답을 처리, URL Mapping 및 Parameter 의 유효성 체크

  ### dto
  * 주로 Request, Response 객체들로 구성
  * common - 공통으로 사용될 Response 객체
    * 각각 따로 Response 정의하는 걸 선호하나 따른 개발 목적상 공통으로 처리
  
  ### service
  * 비지니스 로직을 처리

  ### repository
  * 실제로 DB에 접근하는 객체

  ### entity
  * Entity Class - 실제 DB 테이블고 매칭되는 클래스

  ### exception
  * 공통으로 처리되는 예외처리 정의, 에러코드
  
  ### type
  * Enum 이나 Constant를 정의 
  
---
## 전체 구조

![spring-package-flow](https://user-images.githubusercontent.com/11612221/140762220-fe1bbe86-0021-493c-86b7-d04e820a7f77.png)


---
## Schema
* 해당 파일 resources/schema.sql
```
CREATE TABLE `student` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `age` int(11) NOT NULL,
    `school_type` varchar(20) NOT NULL,
    `phone_number` varchar(13) NOT NULL,
    primary key (`id`)
);

CREATE TABLE `subject` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(12) NOT NULL,
    primary key (`id`)
);

CREATE TABLE `score` (
    `student_id` bigint(20) NOT NULL,
    `subject_id` bigint(20) NOT NULL,
    `score` int(11) NOT NULL,
    primary key (`student_id`,`subject_id`)
);

```
## ERD
![ERD](https://user-images.githubusercontent.com/11612221/140760028-ef2e95fc-5999-47e4-8424-e6be5140a5ca.PNG)
