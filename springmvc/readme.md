# Servlet & Spring MVC &

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

~/basic: only servlet, handling request and response  
~/web/frontcontroller  
~/web/frontcontroller/v4: front controller 패턴 직접 구현  
~/web/frontcontroller/v5: front controller + adapter를 추가하여 여러 controller 한번에 handling 가능
~/web/springmvc: spring mvc로 front controller 패턴 도입 (@Controller)
