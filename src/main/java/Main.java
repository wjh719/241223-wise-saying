import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {

    public void run() {

        Scanner scanner = new Scanner(System.in);
        int lastId = 0;
        int wiseSayingSize = 0;
        WiseSaying[] wiseSayingList = new WiseSaying[3];

        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if(command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if(command.equals("등록")) {

                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                WiseSaying wiseSaying = new WiseSaying();

                wiseSaying.id = ++lastId;
                wiseSaying.content = content;
                wiseSaying.author = author;

                wiseSayingList[wiseSayingSize++] = wiseSaying;

                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
            } else if(command.equals("목록")) {

                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

//                for(int i = 0; i < wiseSayingSize; i++) {
//                    WiseSaying wiseSaying = wiseSayingList[i];
//                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
//                }
                for(WiseSaying wiseSaying : wiseSayingList) {
                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
                }
            }
        }
    }
}

class WiseSaying {
    int id;
    String content;
    String author;
}