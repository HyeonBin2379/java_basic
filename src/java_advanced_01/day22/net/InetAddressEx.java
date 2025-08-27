package java_advanced_01.day22.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

// 자신의 컴퓨터의 IP 주소를 얻어내는 방법
public class InetAddressEx {

    public static void main(String[] args) {
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getLocalHost();
            System.out.println("나의 IP 주소값 " + inetAddress);

            InetAddress[] naverAddress = InetAddress.getAllByName("www.naver.com");
            Arrays.stream(naverAddress).forEach(System.out::println);

            InetAddress[] googleAddress = InetAddress.getAllByName("www.google.com");
            Arrays.stream(googleAddress).forEach(System.out::println);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
