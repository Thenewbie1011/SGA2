<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Update student details</title>
        <style>
    body{
        font-family: Arial;
        background:#0b529a;
        margin:20px;
    }
    h2{
        text-align:center;
        color:#010102;
    }
    form{
        background:rgba(33, 211, 181, 0.533);
        padding:20px;
        width:300px;
        margin:auto;
        border-radius:8px;
    }
    input, select{
        width:100%;
        padding:8px;
        margin:8px 0;
        border-radius: 5px;
        border: none;
        box-sizing: border-box;
    }
    button{
        width:100%;
        padding:10px;
        background:#74db34;
        color:white;
        border:none;
    }
</style>
    </head>
    <body>
        <h2>Update Student</h2>
<form action="/students/update" method="post">
    <input type="hidden" name="student_id" value="${student.student_id}"/>
    Name: <input type="text" name="student_name" value="${student.student_name}"/>
    Email: <input type="text" name="student_email" value="${student.student_email}"/>
    Gender: <input type="text" name="student_gender" value="${student.student_gender}"/>
    Age: <input type="number" name="student_age" value="${student.student_age}"/>
    Courses:
    <select name="courses" multiple>
        <c:forEach var="c" items="${courses}">
            <option value="${c.course_id}"
                <c:forEach var="sc" items="${student.courses}">
                    <c:if test="${sc.course_id==c.course_id}">selected</c:if>
                </c:forEach>
            >
                ${c.course_name}
            </option>
        </c:forEach>
    </select>
    <button type="submit">Update student details</button>
</form>
    </body>
</html>

