import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Nomes: Rodrigo Braga Guimarães Brito
//		  Pedro Henrique Botelho de Lima

@WebServlet(name = "saveExchangeRatesServlet",
		urlPatterns = {"/save-exchange-rates-pair"},
		loadOnStartup = 1)
public class AddExchangeRateCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final String currencyPairKey = "currencyPair";
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
		
	    String thePair = req.getParameter(currencyPairKey);
	    if (thePair != null) {
	        Cookie cookie = new Cookie(currencyPairKey, thePair);
	        cookie.setMaxAge(30 * 24 * 60 * 60);
	        resp.addCookie(cokie);
	        
	        resp.sendRedirect("/servlet-cookie-example/exchange-rate");
	    }
	}
}
