package ProductOffering.jaas.handler;


import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class LoginHandler implements CallbackHandler{

	@Override
	public void handle(Callback[] callbacks) throws IOException, 
	UnsupportedCallbackException {
		for (Callback callback : callbacks) {
            if (callback instanceof NameCallback) {
                NameCallback nameCallback = (NameCallback) callback;
                nameCallback.setName(nameCallback.getPrompt());
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callback;
                passwordCallback.setPassword(passwordCallback.getPrompt().toCharArray());
            } else {
                throw new UnsupportedCallbackException(callback);
            }
        }
	}
	
}