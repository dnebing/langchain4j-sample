package com.liferay.community.langchain4j.sample.portlet;

import com.liferay.community.langchain4j.sample.constants.Langchain4jWebPortletKeys;
import com.liferay.community.langchain4j.sample.service.AITextGenerator;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author dnebinger
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Langchain4jWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + Langchain4jWebPortletKeys.LANGCHAIN4JWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Langchain4jWebPortlet extends MVCPortlet {
    @Reference
    private AITextGenerator aiTextGenerator;

	@ProcessAction(name = "processPrompt")
	@Override
    public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        String prompt = ParamUtil.getString(actionRequest, "prompt");
        if (prompt != null && !prompt.isEmpty()) {
            String aiText = aiTextGenerator.generateText(prompt);
            actionRequest.setAttribute("aiText", aiText);
			actionResponse.setRenderParameter("aiText", aiText);
        }
        actionResponse.setRenderParameter("mvcPath", "/view.jsp");
    }}