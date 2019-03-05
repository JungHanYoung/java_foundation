package thisisjava.lambda;

/**
 * 람다식의 바깥 클래스의 필드나 메소드는 제한없이 사용 가능하나,
 * 메소드의 매개 변수 또는 로컬 변수를 사용하면 해당 변수는 final의 특성을 가져야한다.
 */
public class UsingLocalVariable {

    void method(int arg) {
        int localVar = 40;

//        arg = 31;         // 아래의 람다식에 의해 수정 불가
//        localVar = 41;

        MyFunctionalInterface5 fi = () -> {
            System.out.println("arg: " + arg);
            System.out.println("localVar: " + localVar);
        };
        fi.method();
    }
}
