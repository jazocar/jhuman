/**
 * 
 */
package cl.jazocar.jselector.sys.front;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.icefaces.application.SessionExpiredException;

/**
 * @author Diablo
 * 
 */
@ManagedBean(name = "userFrontBean", eager = true)
@ApplicationScoped
public class UserFrontBean {

	@PostConstruct
	public void init() {

	}

	public void logoutUserListener(ActionEvent e) {
		try{
		ExternalContext ectx = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest req = (HttpServletRequest) ectx.getRequest();
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		}catch(SessionExpiredException see){
			
		}
	}
}
