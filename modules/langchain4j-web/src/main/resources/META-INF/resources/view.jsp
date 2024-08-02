<%@ include file="/init.jsp" %>

<h1>AI Generated Text</h1>

<portlet:actionURL var="submitPromptURL">
    <portlet:param name="javax.portlet.action" value="processPrompt" />
</portlet:actionURL>

<aui:form action="${submitPromptURL}" method="post">
    <aui:input name="prompt" label="Enter your prompt" />
    <aui:button type="submit" value="Generate Text" />
</aui:form>

<c:if test="<%= renderRequest.getAttribute("aiText") != null %>">
    <h2>Generated Text:</h2>
    <p><%= renderRequest.getAttribute("aiText") %></p>
</c:if>
