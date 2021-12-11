# 👀 연애의 참견
![998](https://user-images.githubusercontent.com/87135478/145660246-125080fe-e615-434e-a9dc-032f16056348.png)
썸인지 아닌지 궁금하시다구요? 연애와 관련된 고민이 있으시다구요?  
사연을 올리면 참견쟁이들이 속시원하게 해결해줄거에요!

- [\[사이트 바로가기\]](https://www.naver.com/)  
- [\[시연영상 구경하기\]](https://www.naver.com/)  

<br />

# 👥 멤버
- Back-end: [김종욱](https://github.com/bellpro), [김주란](https://github.com/joorani), [오규화](https://github.com/59-devv)
- Front-end: [신항민](https://www.naver.com), [전용태](https://www.naver.com), [정종찬](https://www.naver.com)
- [\[Front-End Github\]](https://github.com/youHaveToDo/FE_interfereOfLove)
<br />

# 🗓 프로젝트 기간
- 2021년 12월 6일 ~ 2021년 12월 11일 (6일 간)

<br />

# 🧩 와이어프레임
<center><img src="https://user-images.githubusercontent.com/87135478/145660015-1941ac00-d700-4a32-b5d5-b39a7e4a545c.png" width="800"></center>

<br />

# 🗺 ER Diagram
<center><img src="https://user-images.githubusercontent.com/87135478/145659978-cf2a9f3f-623a-4dc9-8549-2407e1b55d72.png" width="800"></center>

<br />

# ⚙️ 기술 스택

### Back-End

<div>
  <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">
  <img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black">
  <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white">
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

</div>  

### Front-End

<div>
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
  <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black">
  <img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white">
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
  <img src="https://img.shields.io/badge/figma-F24E1E?style=for-the-badge&logo=figma&logoColor=black">
  <img src="https://img.shields.io/badge/firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black">
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">  
  
</div>

<br />

# 📌 API 명세서

- 연애의 참견 API
    
    | 페이지 | 기능 | Method | URL | Request | Response |
    | --- | --- | --- | --- | --- | --- |
    | 메인페이지 | 게시글 조회 | GET | /home |  | \[<br/>{'article_id': article_id,<br/>"username" : username,<br/> 'type': type, <br/>'nickname': nickname,<br/> 'title': title,<br/> 'createDate': createDate},<br/>\] | 
    | 작성페이지 | 게시글 작성 | POST | /api/article | {"type": type, <br/>"title": title, <br/>"content": content} |  |
    | 상세페이지 | 게시글 수정 | PUT | /api/article/{article_id} | {"title": title,<br/> "content": content} |  |    
    |  | 게시글 상세 | GET | /article/{article_id} |  | {'article_id': article_id, <br/>'type': type, <br/>'nickname': nickname, <br/>'title': title, <br/>'content': content, <br/>'createDate': createDate, <br/>'greenCount': greenCount, <br/>'redCount': redCount} | |
    |  | 게시글 삭제 | DELETE | /api/article/{article_id} |  |  |
    |  | 그린라이트 | POST | /api/article/{article_id}/green |  |  |
    |  | 레드라이트 | POST | /api/article/{article_id}/red |  |  |
    |  | 댓글 좋아요 | POST | /api/comment/{comment_id}/like |  |  |
    |  | 댓글조회 | GET | /api/{article_id}/comment |  | [<br/>{'comment_id': comment_id,<br/>'nickname': nickname,<br/>'comment': comment,<br/>'likeCommentCount': likeCount,<br/>'createDate': createDate},<br/>] |  |
    |  | 댓글 작성 | POST | /api/commnet/{article_id} | {"comment" : comment} |  |
    |  | 댓글 삭제 | DELETE | /api/commnet/{comment_id} |  |  |
    | 로그인 |  | POST | /user/signin | {"username": username,<br/> "password" : password} |  | 
    | 로그아웃 |  |  |  |  |  |  |
    | 회원가입 | 회원가입 | POST | /user/signup | {"username" : username,<br/>"nickname" : nickname,<br/>"password" : password,<br/>"password2" : password2} |  | 
