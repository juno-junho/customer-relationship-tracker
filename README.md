# :pushpin: CRM
> 회원 개인 정보 관리 페이지

</br>

## 1. 제작 기간 & 참여 인원
- 2022년 10월 ~ 
- 개인 프로젝트

</br>

## 2. 사용 기술
#### `Back-end`
  - Java 11
  - Spring BooT
  - Gradle
  - Spring Data JPA
  - MySQL
  - Spring Security
#### `Front-end`
  - udemy 학습시 사용한 템플릿 수정

</br>

## 3. ERD 설계
<!--  -->


## 4. 핵심 기능
이 서비스의 핵심 기능은 회원 가입과 
회원의 정보를 삭제하고 변경할 수 있는 권한을 부여와 개인 정보의 CRUD 기능 구현입니다.

## 5. 핵심 트러블 슈팅
### 5.1. WebSecurityConfigurerAdapter 문제
- 2022년 5월 16일부터 Spring Security 5.7이 출시되어 WebSecurityConfigurerAdapter가 DEPRECATED 되었기 때문에, 학습했던 방식과 
다른 방식으로 구을 해야 했습니다.
