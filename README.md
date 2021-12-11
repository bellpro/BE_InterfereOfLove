# 👀 연애의 참견 (Back-End)
![998](https://user-images.githubusercontent.com/87135478/145660246-125080fe-e615-434e-a9dc-032f16056348.png)


>**썸인지 아닌지 궁금하시다구요? 연애와 관련된 고민이 있으시다구요?  
>사연을 올리면 참견쟁이들이 속시원하게 해결해줄거에요!**

<br />   
  
- [\[사이트 바로가기\]](https://www.naver.com/)  
- [\[시연영상 구경하기\]](https://www.naver.com/)  

<br />

# 👥 멤버
- Back-end: [김종욱](https://github.com/bellpro), [김주란](https://github.com/joorani), [오규화](https://github.com/59-devv)
- Front-end: [신항민](https://github.com/ssinking91), [전용태](https://github.com/yong313), [정종찬](https://github.com/youHaveToDo)
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
  <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white">
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

<br />

# 🔑 페이지 설명

* 로그인 페이지  
  \- 가입된 회원의 정보와 일치하는지 확인 후, 일치할 경우 로그인 성공  
  
* 회원가입 페이지  
  \- 아이디 : 중복확인 / 영어 소문자, 숫자 혼합 3-12자  
  \- 닉네임 : 중복확인 / 영어 대소문자 숫자, 한글 3-10자  
  \- 비밀번호 : 영어 대소문자, 숫자, 특수문자 혼합 4-12자  
  \- 비밀번호 확인 : 위 비밀번호와 일치하는지 확인  
  
* 메인 페이지  
  \- 전체 게시글 조회 기능  
  
* 게시글 상세 페이지  
  \- 그린라이트 게시판 : 그린라이트 / 레드라이트 버튼을 통한 투표 기능  
  \- 고민상담 게시판 : 글쓴이의 고민 상담을 도와주는 댓글 기능  

<br />

# 💡 Trouble Shooting

<details>
  <summary> 1. 글 작성 시간이 현재 시간과 9시간 차이가 나는 문제 </summary>
  <br />
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;<b>application.properties 파일 내, Timezone 설정 추가</b>
    <div class="colorscripter-code" style="color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important; position:relative !important;overflow:auto"><table class="colorscripter-code-table" style="margin:0;padding:0;border:none;background-color:#fafafa;border-radius:4px;" cellspacing="0" cellpadding="0"><tr><td style="padding:6px;border-right:2px solid #e5e5e5"><div style="margin:0;padding:0;word-break:normal;text-align:right;color:#666;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="line-height:130%">1</div></div></td><td style="padding:6px 0;text-align:left"><div style="margin:0;padding:0;color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="padding:0 6px; white-space:pre; line-height:130%">spring.datasource.url<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>{DB주소}?serverTimezone<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>Asia<span style="color:#0086b3"></span><span style="color:#a71d5d">/</span>Seoul</div></div></td></tr></table></div>
  </div>
</details>

<details>
  <summary> 2. Swagger 접속 불가 문제 </summary>
  <br/>
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;<b>Spring Security 설정 및 JWT 설정 변경 (WebSecurityConfig.java)</b>
    <div class="colorscripter-code" style="color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important; position:relative !important;overflow:auto"><table class="colorscripter-code-table" style="margin:0;padding:0;border:none;background-color:#fafafa;border-radius:4px;" cellspacing="0" cellpadding="0"><tr><td style="padding:6px;border-right:2px solid #e5e5e5"><div style="margin:0;padding:0;word-break:normal;text-align:right;color:#666;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="line-height:130%">1</div><div style="line-height:130%">2</div><div style="line-height:130%">3</div><div style="line-height:130%">4</div><div style="line-height:130%">5</div><div style="line-height:130%">6</div><div style="line-height:130%">7</div><div style="line-height:130%">8</div><div style="line-height:130%">9</div><div style="line-height:130%">10</div><div style="line-height:130%">11</div><div style="line-height:130%">12</div><div style="line-height:130%">13</div><div style="line-height:130%">14</div></div></td><td style="padding:6px 0;text-align:left"><div style="margin:0;padding:0;color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#999999">//&nbsp;로그인&nbsp;하지&nbsp;않아도&nbsp;swagger&nbsp;접속할&nbsp;수&nbsp;있도록&nbsp;권한&nbsp;설정&nbsp;추가</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">http.authorizeRequests()</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;.antMatchers(<span style="color:#63a35c">"/swagger-ui.html"</span>,&nbsp;<span style="color:#63a35c">"/swagger/**"</span>,&nbsp;<span style="color:#63a35c">"/swagger-resources/**"</span>,&nbsp;<span style="color:#63a35c">"/webjars/**"</span>,&nbsp;<span style="color:#63a35c">"/v2/api-docs"</span>).permitAll()</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#999999">//&nbsp;JWT&nbsp;토큰이&nbsp;없어도&nbsp;접속할&nbsp;수&nbsp;있도록&nbsp;JwtAuthFilter&nbsp;설정&nbsp;추가</span></div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#a71d5d">private</span>&nbsp;JwtAuthFilter&nbsp;jwtFilter()&nbsp;<span style="color:#a71d5d">throws</span>&nbsp;Exception&nbsp;{</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;List<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span><span style="color:#066de2">String</span><span style="color:#a71d5d">&gt;</span>&nbsp;skipPathList&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;<span style="color:#a71d5d">new</span>&nbsp;ArrayList<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span><span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>();</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#999999">//&nbsp;Swagger</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;skipPathList.<span style="color:#066de2">add</span>(<span style="color:#63a35c">"GET,&nbsp;/swagger-ui.html"</span>);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;skipPathList.<span style="color:#066de2">add</span>(<span style="color:#63a35c">"GET,&nbsp;/swagger/**"</span>);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;skipPathList.<span style="color:#066de2">add</span>(<span style="color:#63a35c">"GET,&nbsp;/swagger-resources/**"</span>);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;skipPathList.<span style="color:#066de2">add</span>(<span style="color:#63a35c">"GET,&nbsp;/webjars/**"</span>);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;skipPathList.<span style="color:#066de2">add</span>(<span style="color:#63a35c">"GET,&nbsp;/v2/api-docs"</span>);</div></div></td></tr></table></div>
  </div>
</details>

<details>
  <summary> 3. JWT 적용 후 배포시 에러 현상 </summary>
  <br />
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;<b>dependency 설정 변경 (build.gradle)</b>
    <div class="colorscripter-code" style="color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important; position:relative !important;overflow:auto"><table class="colorscripter-code-table" style="margin:0;padding:0;border:none;background-color:#fafafa;border-radius:4px;" cellspacing="0" cellpadding="0"><tr><td style="padding:6px;border-right:2px solid #e5e5e5"><div style="margin:0;padding:0;word-break:normal;text-align:right;color:#666;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="line-height:130%">1</div><div style="line-height:130%">2</div><div style="line-height:130%">3</div><div style="line-height:130%">4</div><div style="line-height:130%">5</div><div style="line-height:130%">6</div><div style="line-height:130%">7</div><div style="line-height:130%">8</div><div style="line-height:130%">9</div></div></td><td style="padding:6px 0;text-align:left"><div style="margin:0;padding:0;color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#999999">//수정&nbsp;전&nbsp;코드</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">runtimeOnly&nbsp;<span style="color:#63a35c">'io.jsonwebtoken:jjwt-impl:0.11.2'</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">runtimeOnly&nbsp;<span style="color:#63a35c">'io.jsonwebtoken:jjwt-jackson:0.11.2'</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">compileOnly&nbsp;<span style="color:#63a35c">'com.auth0:java-jwt:3.13.0'</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#999999">//수정&nbsp;후&nbsp;코드</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">implementation&nbsp;<span style="color:#63a35c">'io.jsonwebtoken:jjwt-impl:0.11.2'</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">implementation&nbsp;<span style="color:#63a35c">'io.jsonwebtoken:jjwt-jackson:0.11.2'</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">implementation&nbsp;<span style="color:#63a35c">'com.auth0:java-jwt:3.13.0'</span></div></div></td></tr></table></div>
  </div>
</details>

<details>
  <summary> 4. 댓글이 있는 게시글 삭제가 되지 않는 문제 </summary>
  <br />
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;(1) Article Entity에 Comment를 Mapping(OneToMany)<br>
    &nbsp;&nbsp;&nbsp;&nbsp;(2) "mappedBy"를 통한 연관관계 주인 설정 및 casecade를 통한 결합
    <div class="colorscripter-code" style="color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important; position:relative !important;overflow:auto"><table class="colorscripter-code-table" style="margin:0;padding:0;border:none;background-color:#fafafa;border-radius:4px;" cellspacing="0" cellpadding="0"><tr><td style="padding:6px;border-right:2px solid #e5e5e5"><div style="margin:0;padding:0;word-break:normal;text-align:right;color:#666;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="line-height:130%">1</div><div style="line-height:130%">2</div></div></td><td style="padding:6px 0;text-align:left"><div style="margin:0;padding:0;color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="padding:0 6px; white-space:pre; line-height:130%">@OneToMany(mappedBy&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;<span style="color:#63a35c">"article"</span>,&nbsp;cascade&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;CascadeType.ALL)</div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#a71d5d">private</span>&nbsp;List<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span>Comment<span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>&nbsp;commentList&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">;</span></div></div></td></tr></table></div>
  </div>
</details>

<details>
  <summary> 5. CORS 설정 </summary>
  <br />
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;(1) 에러 내용<br>
    <img src="https://user-images.githubusercontent.com/87135478/145666395-7f840620-48a8-43a9-b371-ca1b0a26fee7.png"><br><br>
    &nbsp;&nbsp;&nbsp;&nbsp;(2) 해결<br>
    <div class="colorscripter-code" style="color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important; position:relative !important;overflow:auto"><table class="colorscripter-code-table" style="margin:0;padding:0;border:none;background-color:#fafafa;border-radius:4px;" cellspacing="0" cellpadding="0"><tr><td style="padding:6px;border-right:2px solid #e5e5e5"><div style="margin:0;padding:0;word-break:normal;text-align:right;color:#666;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="line-height:130%">1</div><div style="line-height:130%">2</div><div style="line-height:130%">3</div><div style="line-height:130%">4</div><div style="line-height:130%">5</div><div style="line-height:130%">6</div><div style="line-height:130%">7</div><div style="line-height:130%">8</div><div style="line-height:130%">9</div><div style="line-height:130%">10</div><div style="line-height:130%">11</div><div style="line-height:130%">12</div><div style="line-height:130%">13</div><div style="line-height:130%">14</div><div style="line-height:130%">15</div><div style="line-height:130%">16</div><div style="line-height:130%">17</div><div style="line-height:130%">18</div><div style="line-height:130%">19</div><div style="line-height:130%">20</div><div style="line-height:130%">21</div><div style="line-height:130%">22</div><div style="line-height:130%">23</div><div style="line-height:130%">24</div><div style="line-height:130%">25</div></div></td><td style="padding:6px 0;text-align:left"><div style="margin:0;padding:0;color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#999999">//WebSecureConfig.java&nbsp;파일&nbsp;내,&nbsp;CORS&nbsp;관련&nbsp;설정&nbsp;추가</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%">@Override</div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#a71d5d">protected</span>&nbsp;<span style="color:#a71d5d">void</span>&nbsp;configure(HttpSecurity&nbsp;http)&nbsp;<span style="color:#a71d5d">throws</span>&nbsp;Exception&nbsp;{</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;http</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.cors()</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.and()</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.csrf()</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.disable();</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%">@Bean</div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#a71d5d">public</span>&nbsp;CorsConfigurationSource&nbsp;corsConfigurationSource()&nbsp;{</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;UrlBasedCorsConfigurationSource&nbsp;source&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;<span style="color:#a71d5d">new</span>&nbsp;UrlBasedCorsConfigurationSource();</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;CorsConfiguration&nbsp;configuration&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;<span style="color:#a71d5d">new</span>&nbsp;CorsConfiguration();</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;configuration.addAllowedMethod(<span style="color:#63a35c">"*"</span>);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;configuration.addAllowedHeader(<span style="color:#63a35c">"*"</span>);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;configuration.addExposedHeader(<span style="color:#63a35c">"Authorization"</span>);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;configuration.setAllowCredentials(<span style="color:#0099cc">true</span>);&nbsp;<span style="color:#999999">//&nbsp;서버가&nbsp;응답할&nbsp;때&nbsp;json을&nbsp;자바스크립트에서&nbsp;처리할&nbsp;수&nbsp;있도록&nbsp;함</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;configuration.addAllowedOriginPattern(<span style="color:#63a35c">"*"</span>);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;source.registerCorsConfiguration(<span style="color:#63a35c">"/**"</span>,&nbsp;configuration);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#a71d5d">return</span>&nbsp;source;</div><div style="padding:0 6px; white-space:pre; line-height:130%">}</div></div></td></tr></table></div>
  </div>
</details>
