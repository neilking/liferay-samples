package monthly.trading.web.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.portlet.bridge.soy.SoyPortlet;

/**
 * @author Neil Zhao Jin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.application-type=full-page-application",
		"com.liferay.portlet.application-type=widget",
		"com.liferay.portlet.css-class-wrapper=monthly-trading-wrapper",
		"com.liferay.portlet.display-category=category.tools",
		"com.liferay.portlet.header-portlet-css=/MonthlyTrading.css",
		"com.liferay.portlet.layout-cacheable=false",
		"com.liferay.portlet.preferences-owned-by-group=false",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Monthly Trading",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.copy-request-parameters=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=MonthlyTrading",
		"javax.portlet.name=monthly_trading_portlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class MonthlyTradingWebPortlet extends SoyPortlet {
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

			String tradingYear = "2017";
			String pauth = AuthTokenUtil.getToken(PortalUtil.getHttpServletRequest(renderRequest));

			String portletNamespace = renderResponse.getNamespace();

			template.put("remoteURL", "/api/jsonws/banking.monthlytrading/get-monthly-trading-by-year/year/" + tradingYear + "?p_auth=" + pauth);
			template.put("tradingYear", tradingYear);
			template.put("portletNamespace", portletNamespace);
			super.render(renderRequest, renderResponse);
		}
}