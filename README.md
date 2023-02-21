강의를 참고하여 만든 springBoot 사이트입니다!!

해당 강의에서 사용한 라이브러리 : h2 database(h2-console gui로 보여주게 하는 것), jpa(database Entity에 따라서 알아서 데이터베이스 생성시켜주는 도구) , mustache(view를 더 잘 쓸수 있게 하는 것 => 라라벨로 치면 blade Template 비슷), lombok(getter, setter, constructor를 코드 대신에 알아서 넣어주는 기능 => 쓰면 코드가 깔끔해짐), springWeb

엄청 좋다... php 쓰다가 이거 쓰니 구성해야 될게 딱딱 정해져 있어서 좋고 DDD 같은 책도 읽으면 이해가 안 되서 반 읽고 말았는데 springBoot 하니 관심사가 딱 구분이 명확해서 좋다.
라라벨 상위호환인듯하다.. 

코테 부터 공부하고... 책은 Spring Quick Start, 자바의 정석, 스프링 토비 책 1권 샀으니 쭉 읽어봐야 될듯

컨트롤러 => service 에서 entity로 데이터베이스 조작 + dto + repository 

1. mvc 패턴
2. entity로 데이터베이스 조작

3. dto를 사용하여 데이터베이스를 객체로 받아오기

4. repository로 service에서 crud 가능 , @Transactional 사용하면 transaction으로 처리함. test같은 경우 하나 만들어지고 다시 db가 원래대로 돌아감.
5. 컨트롤러는 그냥 request 만 받아오는거고 실제 수행은 service(@service로 지정)에서 상세 동작 수행
6. api는 @RestController로 따로 지정해서 수행 
7. 서비스에서 대부분 @AutoWired를 사용하여 repository를 하나 생성해서 의존성 주입 Dependency Injection(DI) 컨테이너에 일을 맡김. 
8. Ioc는 팩토리 패턴 같은거임.
9. aop는 관점 지향 프로그래밍으로 라라벨로 치면 event 같은거로 로깅같은거 구현하려면 하나하나 컨트롤러마다 구현해줘야 하는데 이거쓰면 해당 클래스, 메소드 동작을 쭉 관찰하는데 해당 클래스가 동작할 시에 알아서 로그를 만듬. 
10. annotation은 aop할 때 RunningTime 같은거 계산 할 때 커스텀으로 만들어서 사용할 수 있다는 것임.
11. TDD도 Junit을 사용해서 쉽게 가능함.
12. objectMapper 는 json -> string 형태, string -> json 형태로 만들어서 test 할 때 보기 더 편하라고 사용하는 것임.





springBoot WebSite which I made it with a video.<br>

Used Library : h2 database , jpa , mustache, lombok, springWeb<br>
I used mvc pattern with business logic, repository, dto<br>
I managed entity with jpa for database and made dto for object. <br>
I used aop, annotation, SLF4J(Simple Logging Facade for Java) for logging. <br>
I made a rest api for board and comment crud.<br>
