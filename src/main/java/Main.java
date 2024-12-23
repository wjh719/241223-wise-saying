import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    WiseSaying wiseSaying = new WiseSaying();
    Scanner scanner1 = new Scanner(System.in);

    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==명언 앱 ==");
        int lastNo = 1;

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                String saying = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                wiseSaying.save(lastNo, saying, author);
                System.out.println(lastNo + "번 명언이 등록되었습니다.");
                lastNo++;
            } else if (command.equals("목록")) {
                wiseSaying.list();
            }
        }
    }

    class WiseSaying {
        HashMap<Integer, String> sayings = new HashMap<>();

        public void save(int number, String saying, String author) {
            sayings.put(number, saying + " / " + author);
        }

        public void list() {
            if (sayings.isEmpty()) {
                System.out.println("저장된 명언이 없습니다.");
            } else {
                System.out.println("== 명언 목록 ==");
                for (Integer key : sayings.keySet()) {
                    System.out.println(key + " / " + sayings.get(key));
                }
            }
        }
    }
}


