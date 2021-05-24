package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.util.DigestUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jt on 6/16/20.
 */
public class PasswordEncodingTests {

    static final String PASSWORD = "password";

    @Test
    void testSh256() {
        PasswordEncoder encoder = new StandardPasswordEncoder();
        System.out.println(encoder.encode(PASSWORD));
        System.out.println(encoder.encode(PASSWORD));

    }

    @Test
    void hashingExampleMD5() {
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));

        String salted = PASSWORD + "ThisIsMySALTVALUE";
        System.out.println(DigestUtils.md5DigestAsHex(salted.getBytes()));
    }

    @Test
    void hashingExampleLdap() {

        LdapShaPasswordEncoder ldapEncoder = new LdapShaPasswordEncoder();
        System.out.println(ldapEncoder.encode(PASSWORD));
        System.out.println(ldapEncoder.encode(PASSWORD));

        String ldapEncodedPass = ldapEncoder.encode(PASSWORD);
        assertTrue(ldapEncoder.matches(PASSWORD,ldapEncodedPass ));
    }
}
