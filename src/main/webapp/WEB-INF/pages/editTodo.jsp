<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
    <form:form method="post" action="/editTodo" commandName="todo">
        <form:hidden path="id" />
        <table>
            <tr>
                <td><form:label path="descr">
                    Description
                </form:label></td>
                <td><form:input path="descr"/></td>
                <td><form:errors cssClass="error" path="descr"></form:errors> </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Edit TODO"/></td>
            </tr>
        </table>
    </form:form>
</t:template>
