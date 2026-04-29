<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Course List</title>
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
    table{
        width:90%; 
        margin:auto; 
        border-collapse:collapse;
        background:rgba(169, 236, 102, 0.512); 
    }
    th{
        background:#59afe8; 
        color:rgba(0, 0, 0, 0.671); 
        padding:10px; 
    }
    td{
        padding:10px; 
        border:1px solid #40d6d671; 
        text-align:center; 
    }
    a{
        background:#2ecc71; 
        color:rgba(0, 0, 0, 0.586); 
        padding:6px 10px; 
        border-radius:4px; 
        text-decoration:none;
        margin:5px;
    }
    .center{
        text-align:center;
        margin-bottom:15px; 
    }
</style>
    </head>
    <body>
        <h2>Courses</h2>
<div class="center">
    <a href="/courses/new">Add Course</a>
    <a href="/students">Back to Students</a>
</div>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Credits</th>
        <th>Students Enrolled</th>
        <th>Action(s)</th>
    </tr>
    <c:forEach var="c" items="${courses}">
        <tr>
            <td>${c.course_id}</td>
            <td>${c.course_name}</td>
            <td>${c.course_credits}</td>
            <td>
                <c:forEach var="s" items="${c.students}">
                    ${s.student_name}<br>
                </c:forEach>
            </td>
            <td>
                <a href="/courses/edit/${c.course_id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
    </body>
</html>

