## KB IT's Your Life 5기 Algorithm & CS 스터디
---
## :computer:Algorithm
#### :ocean:Directory convention
```
src/{이름}/{n}주차/{플랫폼}{문제번호}_{이니셜2자}.java
ex) src/조우형/week1/boj1234_wh.java
```

#### :ocean:Source file convention
- 문제출처+문제번호_이름이니셜2자.java
  - 백준 - boj
  - 삼성 SW Expert Academy - swea
  - 프로그래머스 - pgs
  - ```ex) boj1234_wh.java```

#### :ocean:Commit convention
```
git commit -m"add : 이름/n주차/문제번호"
ex) git commit -m"add : 조우형/week1/boj1234"

수정하는 경우
git commit -m"fix : 조우형/week1/boj1234" 
```

#### :ocean:Pull Request convention
- PR 제목 ```이름/n주차/푼 문제번호(여러개면 여러개)```

   <img src=https://github.com/wxxhyeong/kb-study/assets/78301292/d44edcc2-d1dc-41c4-9870-53bc991e81ee width="600px" height="200px"/>

- <b>Add a description</b> : 문제 풀면서 어려웠던 점 or 접근 방법 or 풀지 못했다면 이유
  (ex. ~식으로 접근했는데 안됐다, 접근 방법을 모르겠다.) 를 남겨야 다른 팀원들의 코드 리뷰를 통해 해결할 수 있습니다!

##### :heavy_exclamation_mark: 주의 사항 :heavy_exclamation_mark:
- merge는 오전 9:00 또는 merge 요청에 진행
- 다른 팀원의 파일은 touch X

---

#### :smiley_cat:Git 초기 사용법
초기 설정에 시간 뺏기지 않도록 가이드라인 작성했습니다. 문제 생기거나 잘 안되는 부분 있으면 바로바로 물어보세요!

1. 저장소 fork
   
   ![image](https://github.com/wxxhyeong/kb-study/assets/78301292/68a993ed-db01-4e58-9e10-4f6eeda95245)

2. git clone하기
   
     ```git clone `원본 Repo말고 fork한 자신의 Repo주소'```
  
3. git bash 실행 or Repository 폴더에서 cmd 실행

   ![image](https://github.com/wxxhyeong/kb-study/assets/78301292/314b7dc8-7a36-4680-a1e4-1f833c7a6244)


4. 자신의 로컬 환경에서 이름으로 브랜치 생성 후 작업하기

   ```
   ex)
   git branch woohyeong // pc에 branch 생성 ※원격 Repository 환경에 생성된 것은 아님
   git checkout woohyeong // 작업할 브랜치로 전환 (main -> woohyeong)
   ```

5. 작업 후 push

   ```
   git add .   // 작업한 내용을 stage로 올리기
   git commit -m"message"   // commit message 작성
   git push origin woohyeong // 원격에 자신의 이름 branch가 있으면 거기에 push 없으면 자동으로 branch가 생성되며 push
   ```
   ![image](https://github.com/wxxhyeong/kb-study/assets/78301292/6403b0f7-3690-425e-af89-a01eb78843ab)

6. push 이후 web에서 pull request 작성
   ![image](https://github.com/wxxhyeong/kb-study/assets/78301292/1483839a-743f-4970-9098-2d962421d6d0)
