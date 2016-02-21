<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <c:if test="${!empty todos}">
        <a href="filterCompleted">Completed TODO</a>
        <a href="filterUncompleted">Uncompleted TODO</a>
        <a href="/">All TODO</a>
        <table class="todo-list-table">
            <tr>
                <th>Description</th>
                <th>Status</th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.descr}</td>
                    <td>${todo.stat}</td>
                    <td><a href="javascript:TodoUtil.deleteTodo(${todo.id})">Delete</a></td>
                    <td><a href="editTodo/${todo.id}">Edit</a></td>
                    <td>
                        <c:if test="${'Completed' != todo.stat}">
                            <a href="javascript:TodoUtil.completeTodo(${todo.id})">Complete</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <a href="addTodo">Add TODO</a>

</t:template>