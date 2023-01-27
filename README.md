# 🎬 Removier
<div align="center">
<img src="https://user-images.githubusercontent.com/104367020/215094550-e1ecf2fd-387b-4c35-a5dc-1e2d10c134f0.gif" alt="main">
</div>

## 1️⃣  프로젝트 개요도

- 프로젝트 명 : 리무버 (review + movie + er)
- 개발 프로그램 명 : 최신 영화 리뷰 관련 시스템의 요구분석
- 주요기능 : 최신 영화 검색 및 리뷰작성
- 구성원 : 강희진, 고종영, 권규정, 이혜진, 장민정
- 프로젝트 개요 :

영화 티켓 16,000원 시대! 소비자들은 재미없는 영화를 보고싶어하지 않는다!<br>
다른 회원들의 영화 리뷰를 ‘리무버’를 통해 미리 확인하며 자신이 볼 영화를 선택할 수 있다.<br>
또한 자신이 남긴 리뷰를 통해서 다른 소비자에게 도움을 준다!<br>
이를 통해서 영화 관계자는 소비자들의 별점, 리뷰를 확인함으로써, 영화관계자는 회원의 니즈를 파악 할 수 있다!<br>

## 2️⃣ 개발환경

![java badge](https://img.shields.io/badge/-JAVA_11-%23F7DF1E?style=flat-square&logo=buymeacoffee&logoColor=white&color=3c679e)
![oracle badge](https://img.shields.io/badge/-Oracle_19c-%23F7DF1E?style=flat-square&logo=oracle&logoColor=white&color=e62e18)<br>
![IntelliJ IDEA badge](https://img.shields.io/badge/-IntelliJ_IDEA-%23F7DF1E?style=flat-square&logo=intellijidea&logoColor=white&color=02303A)
![eclipseide badge](https://img.shields.io/badge/-Eclipse-%23F7DF1E?style=flat-square&logo=eclipseide&logoColor=white&color=2C2255)
![notion badge](https://img.shields.io/badge/-Notion-%23F7DF1E?style=flat-square&logo=notion&logoColor=white&color=000000)

## 3️⃣ 프로젝트 실행 화면
- 프로젝트 대한 내용을 Youtube 로 영상으로 기록하였습니다.

<div align="center">

[![Video Label](http://img.youtube.com/vi/stXpZRD2sZc/0.jpg)](https://youtu.be/stXpZRD2sZc)

</div>



## 4️⃣ 시스템에 대한 기능적인 요구사항 목록

<table>
  <tr>
    <th>목록</td>
    <th>내용</td>
  </tr>
  <tr>
    <td>영화 관리</td>
    <td>-영화를 등록, 수정, 삭제, 조회 하는 기능<br>-회원이 남긴 별점, 리뷰 조회/관리 기능<br>-회원의 니즈에 맞는 영화를 조회하는 기능(메뉴 선택창에서 바로)</td>
  </tr>
  <tr>
    <td>영화 검색</td>
    <td>-영화를 장르별 검색 하는 기능<br>-찾는 영화를 조건에 따라 검색하는 기능 (장르, 주연배우)<br>-별점 순위 로 나열 되게 검색하는 기능<br>-영화 검색했을때, 관객수, 주연, 장르(정보 API로) 표시하는 기능</td>
  </tr>
  <tr>
    <td>my page</td>
    <td>-좋아하는 배우 수정/등록/삭제<br>-내가 작성한 별점,리뷰 조회/수정 (작성은 영화 검색 에서만)<br>-개인정보를 수정하는 기능</td>
  </tr>
  <tr>
    <td>회원가입</td>
    <td>-회원가입 기능(회원 정보 등록 기능, 좋아하는 배우)<br>-로그인/로그아웃 기능</td>
  </tr>
  <tr>
    <td>영화 상세페이지</td>
    <td>-영화 상세정보 (사진, 주연 배우, 줄거리 정보)<br>-다른 회원이 남긴 별점,리뷰 조회<br>-별점,리뷰 등록/수정</td>
  </tr>
  <tr>
    <td>공지사항</td>
    <td>-공지사항 등록/수정/삭제<br>-공지사항 개수 조회</td>
  </tr>
</table>


## 5️⃣ 기능별 액터 목록

<table>
  <tr>
    <th>기능범주</th>
    <th>기능</th>
    <th>사용자</th>
  </tr>
  <tr>
    <td>영화 관리</td>
    <td>-영화를 수정, 삭제, 조회 하는 기능<br>-회원의 니즈에 맞는 영화를 조회하는 기능</td>
    <td>관리자</td>
  </tr>
  <tr>
    <td rowspan="2">조회 및등록 관리</td>
    <td>-회원이 남긴 별점, 리뷰 조회/관리 기능</td>
    <td>관리자</td>
  </tr>
  <tr>
    <td>-회원 작성한 별점, 리뷰 조회/수정 (작성은 영화 검색 에서만)<br>-영화를 장르별 검색 하는 기능<br>-찾는 영화를 조건에 따라 검색하는 기능 (장르, 주연배우)<br>-별점 순위 로 나열 되게 검색하는 기능<br>-영화 검색했을때, 관객수, 주연, 장르(정보) 표시하는 기능<br>-다른 회원이 남긴 별점,리뷰 조회</td>
    <td> 회원</td>
  </tr>
  <tr>
    <td rowspan="3">운영관리</td>
    <td>-개인정보를 수정하는 기능</td>
    <td>관리자, 회원</td>
  </tr>
  <tr>
    <td>-공지사항에서 당첨자 보여주기 <br>-공지사항 등록/수정/삭제</td>
    <td>관리자</td>
  </tr>
  <tr>
    <td>-회원가입 기능(회원 정보 등록 기능)<br>-로그인/로그아웃 기능</td>
    <td>회원</td>
  </tr>
</table>



<div align="right">
written By JongYoung
</div>
