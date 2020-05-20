package ProductOffering.jaas.mdoule;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class ILoginModule implements LoginModule{
	
	private static final String USERNAME = "testuser";
    private static final String PASSWORD = "testpassword";
 
    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, ?> sharedState;
    private Map<String, ?> options;
     
    private boolean loginSucceeded = false;
    private Principal userPrincipal;
	
	
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		// TODO Auto-generated method stub
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;
	}

	@Override
	public boolean login() throws LoginException {
		NameCallback nameCallback = new NameCallback("username: ");
		PasswordCallback passwordCallback = new PasswordCallback("password: ", 
				false);
		try {
			callbackHandler.handle(new Callback[]{nameCallback, passwordCallback});
			String username = nameCallback.getName();
			String password = new String(passwordCallback.getPassword());
			if (USERNAME.equals(username) && PASSWORD.equals(password)) {
				loginSucceeded = true;
			}
		} catch (IOException | UnsupportedCallbackException e) {
		}
		return loginSucceeded;	}

	@Override
	public boolean commit() throws LoginException {
		if (!loginSucceeded) {
	        return false;
	    }
	    userPrincipal = new Principal() {
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return USERNAME;
			}
		};
	    subject.getPrincipals().add(userPrincipal);
	    return true;
	}

	@Override
	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}
	
}