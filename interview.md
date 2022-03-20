#### Q. 스프링이란 무엇?
좋은 객체지향 어플리케이션을 개발할 수 있도록 도와주는 프레임워크  
프로그램을 **유연**하고 **변경**에 용이하도록 함

---
#### Q. 객체지향개발(Object Oriented Programming)
추상화: 공통의 속성이나 기능을 묶어 이름을 붙이는 것  
캡슐화: 데이터 구조와 데이터를 다루는 방법들을 결합 시켜 묶는 것  
상속성: 상위 개념의 특징을 하위 개념이 물려받는 것 부모클라스:자동차라면 자식클라스:슈퍼카  
다형성: 부모 클래스에서 물려받은 가상 함수를 자식 클래스 내에서 오버라이딩 되어 사용되는 것

---

#### Q. 자바 스프링에 사용되는 템플릿 패턴 예시 2개 이상

전략 패턴: ApplicationContext. 스프링 의존관계 주입에 사용된다. 불변을 Context에, 변하는 건 Strategy 인터페이스에 넣어서 위임으로 해결
템플릿 콜백 패턴: JdbcTemplate 등 스프링에서 xxTemplate은 대부분 이 패턴사용. Context가 템플릿, Strategy가 콜백되는 변경사항이다. 전략패턴과 차이는 무조건 1개의 메서드만 가진다.

---

#### Q. 프록시 사용 이유
- 접근제어(캐싱, 지연로딩, 권한)
- 부가기능 추가
- 프록시 체인(또다른 프록시에게 요청)
---

#### Q. 리플랙션에 대해 설명

```
Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");
...
Method methodCallA = classHello.getMethod("callA");
Object result1 = methodCallA.invoke(target);
```

클래스나 메서드의 메타정보를 동적으로 획득하고, 코드도 동적으로 호출할 수 있다.  
리플렉션 기술은 런타임에 동작하기 때문에, 컴파일 시점에 오류를 잡을 수 없다.

---

#### Q. Java 동기화 방법 3가지

Volatile : 변수를 read & write 할때 cache가 아닌 main memory에다 한다고 명시적으로 선언  
Synchronized : 여러 개의 스레드가 객체에 접근하는 것을 제어하여 객체의 thread-safe를 가능케 하는 방식 (blocking)  
AtomicClass: non-blocking하면서 원자성을 보장하여 동기화 문제를 해결. 기존값과 변경값을 가지고 있는데 기존값이 메모리값과 같다면 반영하고 true, 다르다면 반영하지 않고 false 반환 -> compare and swap(CAS) 기법

---

#### Q. CGLIB에 대해 설명

CGLIB는 바이트코드를 조작해서 동적으로 클래스를 생성하는 기술을 제공하는 라이브러리이다.  
CGLIB를 사용하면 인터페이스가 없어도 구체 클래스만 가지고 동적 프록시를 만들어낼 수 있다.  
ProxyFactory가 이 기술을 편리하게 사용하게 도와준다.  
JDK 동적 프록시에서 InvocationHandler 를 제공했듯이 MethodInterceptor, Enhancer로 프록시를 제공한다.

- 제약: (상속을 사용하기 때문에)
  - 부모 클래스의 생성자를 체크해야 한다. -> CGLIB는 자식 클래스를 동적으로 생성하기 때문에 기본 생성자가 필요
  - 클래스에 final 키워드가 붙으면 상속이 불가능하다. -> CGLIB에서는 예외가 발생한다.
  - 메서드에 final 키워드가 붙으면 해당 메서드를 오버라이딩 할 수 없다. -> CGLIB에서는 프록시 로직이 동작하지 않는다.

---

#### Q. pointcut, advice, advisor에 대해 설명

왜 생겼나? : 역할과 책임을 명확하게 분리  
(프록시 버전)

- Pointcut: 부가기능을 '어디에' 적용하고 '어디에' 안하고 판단하는 필터링 로직. 주로 클래스와 메서드 이름으로 필터링. point + cut
- Advice: 프록시가 호출하는 부가기능, '어떤' 로직
- Advisor: 1 pointcut + 1 advice, '어디에' '어떤' 로직이 오는지 알고 있다.

(AOP 버전)

- 추가 예정

---

#### Q. AOP 탄생배경

핵심기능과 부가기능을 분리하고 부가기능을 한 곳에서 관리하기 위함이다.  
관점을 각각의 기능에서 횡단관심사 관점으로 본다. OOP를 대체하기 보다는 보조 목적이다.

---

#### Q. AOP 구현방식 3가지

- 컴파일 시점 (weaving) : AspectJ 제공 컴파일러 필요, 원본로직에 추가됨, 복잡
- 클래스 로딩 시점: java -javaagent 옵션 사용, 번거롭고 운영 어렵
- 런타임 시점(프록시): 스프링 채택 방식. 스프링 컨테이너, 프록시, DI, 빈 후처리기 총 동원, 조인 포인트 메서드 실행으로 제한됨

---

#### Q. AOP 사용 주의점

내부 호출 발생: 내부에서 메서드 호출이 발생하면 프록시를 거치지 않고 대상 객체를 직접 호출하는 문제 발생

```
public void external() {
    log.info("call external");
    internal();  //내부 메서드 호출(this.internal())
}
```

해결방법

1. 자기 자신 주입

- 생성자 주입은 순환 사이클을 만들어서 실패
- 수정자 주입으로 하면 오류 발생 X

```
@Autowired
public void setCallServiceV1(CallServiceV1 callServiceV1) {
    this.callServiceV1 = callServiceV1;
}

public void external() {
    log.info("call external");
    callServiceV1.internal(); //외부 메서드 호출
}
```

2. 지연 조회

- 앞서 생성자 주입이 실패하는 이유는 자기 자신을 생성하면서 주입해야 하기 때문

```
private final ObjectProvider<CallServiceV2> callServiceProvider;
```

3. 구조 변경 (권장)

- 내부 서비스 분리

---

#### Q. 스프링 mvc 탄생 배경
스프링 mvc에서 제공하는 DispatcherServlet과 웹 요청처리 관련 구현체를 사용할 수 있다.   
스프링 컨테이너, 즉 스프링 IoC를 사용해서 개발할 수 있다.  
DispatcherServlet이 HandlerMapping을 해주고 View를 강제로 분리시켜주면서 개발자는 핸들러에만 집중 할 수 있게 되었다.

---

