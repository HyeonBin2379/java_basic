package java_advanced_01.day14;

// AutoClosable 인터페이스를 구현한 MyResource 리소스를 try-with-resources 블록을 사용하여 관리
public class TryWithResourceEx {

    public static void main(String[] args) {
        try (MyResource resource = new MyResource("AAA")) {
            String data1 = resource.read1();
            int value1 = Integer.parseInt(data1);
            System.out.println(value1);
        } catch (Exception e) {
            System.out.println("예외 처리 : " + e.getMessage());
        }

        try (MyResource resource = new MyResource("AAA")) {
            String data2 = resource.read2();
            int value2 = Integer.parseInt(data2);
            System.out.println(value2);
        } catch (Exception e) {
            System.out.println("예외 처리 : " + e.getMessage());
        }

        MyResource resource1 = new MyResource("BBB");
        MyResource resource2 = new MyResource("CCC");
        try (resource1;resource2) {
            String data1 = resource1.read1();
            System.out.println(data1);
            String data2 = resource2.read2();
            System.out.println(data2);
        } catch (Exception e) {
            System.out.println("예외처리 : " + e.getMessage());
        }
    }
}
