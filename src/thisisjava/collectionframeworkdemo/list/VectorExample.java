package thisisjava.collectionframeworkdemo.list;

import java.util.List;
import java.util.Vector;

/**
 * ArrayList와 다른점은 Vector는 동기화된 메소드로 구성되어 있기 때문에
 * 멀티스레드가 동시에 이 메소드들을 실행할 수 없고,
 * 하나의 스레드가 실행을 완료해야만 다른 스레드를 실행할 수 있다.
 */
public class VectorExample {

    public static void main(String[] args) {

        List<Board> list = new Vector<>();

        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        list.remove(2);
        list.remove(3);

        for (Board board : list) {
            System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
        }
    }

    public static class Board {
        String subject;
        String content;
        String writer;

        Board(String subject, String content, String writer) {
            this.subject = subject;
            this.content = content;
            this.writer = writer;
        }
    }
}
