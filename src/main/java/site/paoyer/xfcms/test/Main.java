package site.paoyer.xfcms.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder(16).encode("root"));
    }
}
