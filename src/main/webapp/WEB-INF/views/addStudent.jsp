<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add student</title>
        <style>
    body{
        font-family: Arial; 
        background:#114476; 
        margin:20px; 
    }
    h2{ 
        text-align:center; 
        color:#010102; 
    }
    form{
        background:rgba(33, 211, 181, 0.533); 
        padding:25px; 
        width:300px; 
        margin:auto;
        border-radius:8px;
        box-shadow:0 0 10px rgba(0,0,0,0.1); 
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
    .warning{
        color:red;
        text-align:center;
        font-weight:bold;
        margin-bottom:15px;
    }
    </style>
</head>
<body>
    <h2>Add Student</h2>
<c:choose>
    <c:when test="${empty courses}">
        <div class="warning">
             No courses are present in the database. Please add at least one course before proceeding
        </div>
        <div style="text-align:center;">
        <a href="/courses/new" style="
            display:inline-block;
            padding:10px 15px;
            background:#d36458;
            color:#1c5792;
            text-decoration:none;
            border-radius:5px;
            margin-top:10px;
        ">
            Go to Add Course
        </a>
    </div>
    </c:when>
    <c:otherwise>
        <form action="/students" method="post">
            Name: <input type="text" name="student_name" required/>
            Email: <input type="text" name="student_email" required/>
            Gender: <input type="text" name="student_gender"/>
            Age: <input type="number" name="student_age"/>
            Courses:
            <select name="courses" multiple>
                <c:forEach var="c" items="${courses}">
                    <option value="${c.course_id}">${c.course_name}</option>
                </c:forEach>
            </select>
            <button type="submit">Submit student details</button>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>