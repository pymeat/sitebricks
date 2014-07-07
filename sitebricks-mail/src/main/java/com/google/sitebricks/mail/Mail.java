package com.google.sitebricks.mail;

import com.google.sitebricks.mail.oauth.OAuth2Config;
import com.google.sitebricks.mail.oauth.OAuthConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author dhanji@gmail.com (Dhanji R. Prasanna)
 */
public interface Mail {
  AuthBuilder clientOf(String host, int port);

  public enum Auth { PLAIN, SSL, OAUTH, OAUTH2 }

  public static interface AuthBuilder {
    AuthBuilder timeout(long amount, TimeUnit unit);

    AuthBuilder executors(ExecutorService bossPool, ExecutorService workerPool);

    MailClient prepare(Auth authType, String username, String password);


    MailClient prepareOAuth(String username, OAuthConfig config);

    MailClient prepareOAuth2(String username, OAuth2Config config);
  }
}
