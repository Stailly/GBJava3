package networkserver.auth;

public interface AuthService {
    String getNickByLogNPass (String login, String password);

    void start();
    void stop();
}