# SpringBoot-MyBatis-Project-BomoBomo
스프링부트-마이바티스 프로젝트
<br>


## 🖥️ 프로젝트 소개
베이비시터 매칭 플랫폼, 아이들을 위한 이벤트 서비스 제공 플랫폼
<br>


## 🕰️ 개발 기간
* 2023.9 - 2023.10

### 🧑‍🤝‍🧑 맴버구성
 - 팀장: 김성찬 : 관리자 페이지
 - 부팀장: 복영헌 : 메인페이지, 커뮤니티, 에러페이지 
 - 팀원1: 임형준 : 마이페이지
 - 팀원2: 공병문 : 회사소개, 이벤트 페이지
 - 팀원3: 이중근 : 로그인, 회원가입, 계정찾기, 씨터찾기


### ⚙️ 개발 환경
- **IDE** : IntelliJ IDEA
- **Framework** : Springboot(3.x), MyBatis
- **Database** : Oracle DB(11xe)

### 📌포트폴리오 

[BOMOBOMO 포트폴리오.pdf](https://github.com/bokkaa/SpringBoot-BomoBomo/files/14415618/BOMOBOMO.pdf)

## 📌 내가 맡은 기능
### <h2>마이페이지</h2> 
#### 시터 매칭  <a href="https://github.com/HyeongJunIm/BomoBomo-Spring/wiki/%EB%B2%A0%EC%9D%B4%EB%B9%84%EC%8B%9C%ED%84%B0-%EB%A7%A4%EC%B9%AD-%EB%B0%8F-%EA%B2%B0%EC%A0%9C" >상세보기 - WIKI 이동</a>
   - 매칭 시터 목록 
   - 매칭 시터 상태 상세보기('면접대기','결제대기')
   - 매칭 시터 결제  
#### 결제내역 <a href="https://github.com/bokkaa/SpringBoot-BomoBomo/wiki/%EA%B3%B5%EC%A7%80%EC%82%AC%ED%95%AD-%EA%B2%8C%EC%8B%9C%ED%8C%90" >상세보기 - WIKI 이동</a>
- 시터 결재 및 이벤트 결제 목록  
- 리뷰 작성 
- 리뷰 상세 보기 

#### 리뷰 작성 <a href="https://github.com/bokkaa/SpringBoot-BomoBomo/wiki/%EB%8F%8C%EB%B4%84-%ED%9B%84%EA%B8%B0-%EA%B2%8C%EC%8B%9C%ED%8C%90" >상세보기 - WIKI 이동</a>
- 시터 및 이벤트 결제 리뷰 작성 가능(평점 및 파일첨부)
- 메인 페이지 항목별 작성 리뷰 목록

#### 회원정보 수정, 탈퇴 <a href="https://github.com/HyeongJunIm/BomoBomo-Spring/wiki/%ED%9A%8C%EC%9B%90%EC%A0%95%EB%B3%B4-%EC%88%98%EC%A0%95-%EB%B0%8F-%ED%9A%8C%EC%9B%90-%ED%83%88%ED%87%B4" >상세보기 - WIKI 이동</a>
- 회원정보 수정
- 회원탈퇴 
#### 자녀 신상정보 작성,수정 <a href="https://github.com/HyeongJunIm/BomoBomo-Spring/wiki/%EC%9C%A0%EC%A0%80-%EC%9E%90%EB%85%80%EC%8B%A0%EC%83%81%EC%A0%95%EB%B3%B4-%EC%9E%91%EC%84%B1-%EB%B0%8F-%EC%88%98%EC%A0%95" >상세보기 - WIKI 이동</a>
- 자녀 신상정보 작성 페이지
- 자녀 신상정보 수정 



<hr>

## 📌느낀점

처음 SPRING BOOT를 접했을 때 이전 JSP에서는 수동으로 처리했던 코드들을 어노테이션(@) 하나로 모두 처리하는 것을 보고 일종의 희열을 느꼈었다. <br><br>
JSP와 스프링의 데이터 흐름은 데이터베이스에서 mapper.xml까지는 동일하지만 JSP는 DAO와 컨트롤러, 프론트 컨트롤러를 거쳐야 했고, <br> 스프링은 Mapper 인터페이스와 서비스, 컨트롤러를 거쳐야 했는데, 가독성적인 측면이나 유지보수 측면이나 비즈니스 핵심 로직을 담당하는 서비스 계층(비즈니스 계층)이 존재하는 스프링이 개인적으로는 더 눈에 띄었다.<br><br>
또한 이전 JSP에서는 하나하나 값을 넣어보거나 서버를 돌려보는 등 번거로웠다면 스프링은 단위테스트인 JUnit의 Assert 메소드와 Mockito 등을 활용하여 테스트 클래스에서 원하고자 하는 테스트를 원활히 진행할 수 있었다. <br><br>
테스팅 코드를 적절히 활용을 할 수만 있다면 개발 시간 단축 등, 어플리케이션의 신뢰도, 성능 모두 잡을 수 있지 않을까 싶다.
