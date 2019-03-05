package thisisjava.lambda;

/**
 * 모든 인터페이스를 람다식의 타겟 타입으로 사용할 수 없다.
 * 람다식은 하나의 메소드를 정의하기 때문에
 * 두 개 이상의 추상 메소드가 선언된 인터페이스는 람다식을 이용해 구현객체를 만들 수 없다.
 *
 * @FunctionalInterface는 두 개 이상의 추상메소드가 선언되지 않도록 컴파일러가 체킹해주는 기능.
 *      - 해당 어노테이션이 붙은 인터페이스에 두 개 이상의 추상 메소드가 선언되면 컴파일 오류를 발생시킨다.
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    public void method();
}
