<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student List</title>
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
        width:80%; 
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
    a:hover{
        background:#27ae60;
    }
    .center{
        text-align:center;
        margin-bottom:15px; 
    }
</style>
    </head>
    <body>
        <h2>Students</h2>
<div class="center">
    <a href="/students/new">Add Student</a>
    <a href="/courses">View Courses</a>
    <a href="/courses/new">Add Course</a>
</div>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Age</th>
        <th>Courses</th>
        <th>Action(s)</th>
    </tr>
    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.student_id}</td>
            <td>${s.student_name}</td>
            <td>${s.student_email}</td>
            <td>${s.student_gender}</td>
            <td>${s.student_age}</td>
            <td>
                <c:forEach var="c" items="${s.courses}">
                    ${c.course_name}<br>
                </c:forEach>
            </td>
            <td>
                <a href="/students/edit/${s.student_id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
    </body>
</html>

