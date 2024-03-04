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

[BOMOBOMO.pdf](https://github.com/HyeongJunIm/BomoBomo-Spring/files/14471813/BOMOBOMO.pdf)


## 📌 내가 맡은 기능
### <h2>마이페이지</h2> 
#### 시터 매칭  <a href="https://github.com/HyeongJunIm/BomoBomo-Spring/wiki/%EB%B2%A0%EC%9D%B4%EB%B9%84%EC%8B%9C%ED%84%B0-%EB%A7%A4%EC%B9%AD-%EB%B0%8F-%EA%B2%B0%EC%A0%9C" >상세보기 - WIKI 이동</a>
   - 매칭 시터 목록 
   - 매칭 시터 상태 상세보기('면접대기','결제대기')
   - 매칭 시터 결제  
#### 결제내역 <a href="https://github.com/HyeongJunIm/BomoBomo-Spring/wiki/%EA%B2%B0%EC%A0%9C%EB%82%B4%EC%97%AD" >상세보기 - WIKI 이동</a>
- 시터 결재 및 이벤트 결제 목록  
- 리뷰 작성 
- 리뷰 상세 보기 

#### 리뷰 작성 <a href="https://github.com/HyeongJunIm/BomoBomo-Spring/wiki/%EA%B2%B0%EC%A0%9C-%EB%A6%AC%EB%B7%B0-%EC%9E%91%EC%84%B1-%EB%B0%8F-%EB%A6%AC%EB%B7%B0%EB%AA%A9%EB%A1%9D" >상세보기 - WIKI 이동</a>
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

처음 spring boot를 접했을때 jsp에서는 직접 코드를 작성함으로써 사용해야했던 기능들을 어노테이션(@)을 활용하여 처리할수 있다는 편리함을 가장 크게 느꼈다.

jsp에서는 DAO와 각각에 컨트롤러, 프론트컨트롤러를 통해 데이터 베이스에 도달하였지만 스프링은 mapper와 서비스 하나의 컨트롤러를 통해 접근하고 가독성이 편리하다는 측면에서 오류가 발생하였을때 좀더 빠르게 오류가 발생한 부분을 찾을수 있다는 면에서 편리함을 느꼈다.

또한 jsp에서는 내가 작성한 코드가 잘 동작하는지 여부를 서버를 돌려가버 계속 확인을 해야하는 어려움이 있었지만 스프링에서는 Assert와 Mokito 등 test를 활용하여 사전에 코드 실행 여부를 확인할수 있어서 코드 작성시 정확성과 시간을 단축 할 수 있었다.

전체적으로 개발에 있어 코드의 가독성, 시간 단축, 정확성 등을 높여줄수 있다는 것을 알수 있었다. 
