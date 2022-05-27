### 람다(Lambda)
---
자바 언어에서는 함수형 프로그래밍을 위해 람다식(Lambda Expression)을 제공한다. <br>
람다식은 익명함수를 생성할 때 사용되며 **함수지향 언어**에 가깝다. 

<람다식 사용의 이점>
- 코드가 매우 간결해진다. 
- 컬렉션의 요소를 필터링하거나 매핑하여 원하는 결과를 쉽게 집계할 수 있다. 
- 가독성이 좋아진다.
- 함수를 만드는 과정을 생략할 수 있어 생산성이 높아진다. 
<br>

#### 람다식 표기 방법
-----------------
```java
() -> {} // 기본 형식 
() -> 1 // 단일 실행문일 경우 괄호 생략 가능
 -> {} // 매개변수가 1개 일때, 괄호 생력 가능 

```

#### 람다식 사용 예제 
-----------------

```java
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        // ...
    }

    public void printPerson() {
        // ...
    }
}
```
위와 같은 person 클래스가 있고 새로운 메서드 ***입력인자를 person클래스를 타입으로 갖는 리스트와 출력 조건을 갖는 클래스를 입력받아 해당 리스트에서 출력 조건에 해당하면 데이터의 정보를 출력하는 메서드***를 만드려고 한다. 

```java
public static void printPersons(
    List<Person> roster, CheckPerson tester) {
    for (Person p : roster) {
        if (tester.test(p)) {
            p.printPerson();
        }
    }
}
```
위와 같이 for문과 if를 적절히 사용하여 표현할 수 있다. <br>
하지만 람다식을 사용하면 다음과 같이 간결하게 표현이 가능하다. 

```java
printPersons(
    roster,
    (Person p) -> p.getGender() == Person.Sex.MALE
        && p.getAge() >= 18
        && p.getAge() <= 25
);
```


[Reference]
 
[oracle 공식 문서](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
