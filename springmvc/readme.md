# Servlet & Spring MVC

- Servlet

  - http request 파싱, response 생성 쉽게 가능
  - 처리 로직에 집중 가능
  - init(), service(), destroy()

<br>

- Spring MVC
  - Front Controller 패턴 도입 (Dispatcher Servlet)
  - DispatcherServlet은 servlet-context.xml (spring-mvc.xml)을 로딩한다.
  - 개발자는 Controller만 구현하면 됨

<br>

## Directory Description

`~/springmvc/basic`: only servlet, handling request and response  
`~/springmvc/web/frontcontroller`  
`~/springmvc/web/frontcontroller/v4`: front controller 패턴 직접 구현  
`~/springmvc/web/frontcontroller/v5`: front controller + adapter를 추가하여 여러 controller 한번에 handling 가능
~/springmvc/web/springmvc: spring mvc로 front controller 패턴 도입 (@Controller)

<br>

# AOP

- Bean 후처리기
- 핵심로직과 부가기능(횡단관심사)을 분리하여 부가기능 한 곳에서 관리, 어디에 적용할지 선택
- proxy 패턴: advisor(+@Aspect) 자동으로 찾아 proxy 생성

```java
  @Aspect
  @Around() // pointcut
  public Object execute() { // advice
  }
```

- 주의사항: inner method 실행시에는 proxy를 통해 호출되지 않아 aop가 적용되지 않음
  - 대안1: 자기자신 주입 (constructor는 순환참조이므로 setter에서)
  - 대안2: 지연 조회 (ObjectProvider)
  - 대안3: 구조 변경 (class 분리)

<br>

## Directory Description

`~/aop/exam/annotation`: 사용자 지정 aop가 발동할 annotation  
`~/aop/exam/aop`: logTrace, retry aop Aspect 구현
