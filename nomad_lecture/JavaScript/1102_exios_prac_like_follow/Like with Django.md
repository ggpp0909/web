# Like with Django

1. form태그 -> 좋아요 기능 구현한 경로로 요청
2. 이미 좋아요 되어 있으면 좋아요 관계 제거, 혹은 반대 처리를 view함수가 해주고, 
3. index 페이지로 리다이렉트 -> 전체 목록 새로고침 되면서 좋아요 수, 관계 상태 적용된 문서 반환



# Follow with AJAX

1. 요청 보내는 주체 변경 -> form action으로 요청 X, axios 요청 -> form태그의 method도 불필요
   1. post 요청 보내려면 반드시 함께 넣어줘야 하는 데이터
   2. CSRF_TOKEN -> form 태그로 요청 보내면 hidden으로 되어있는 input의 value 같이 보내지는데...
   3. axios로는 어떻게 보내는가?
2. view 함수가 하는 일은 일단은 변함 없음
3. 근데 요롷게만 하면 발생하는 문제 -> 페이지 리 렌더링 안되서 좋아요 반영 안됨
4. 응답으로 팔로우 상태 DOM에 적용 -> view가 응답한 데이터를 토대로 적용
   1. html 말고 JSON 데이터 반환하도록 변경
   2. 응답받아온 데이터 특정해서 내가 팔로우 정보 innerText 변경
   3. 버튼 특정안하고 그냥 넣어보기