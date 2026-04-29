<!DOCTYPE html>
<html>
    <head>
        <title>Update courses</title>
        <style>
    body{
        font-family: Arial;
        background:#0b529a;
        margin:20px; 
    }
    h2{text-align:center;
        color:#010102;
     }
    form{
        background:rgba(33, 211, 181, 0.533);
         padding:20px; 
         width:300px; 
         margin:auto;
        border-radius:8px; 
    }
    input{
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
        <h2>Update Course</h2>
    <form action="/courses/update" method="post">
    <input type="hidden" name="course_id" value="${course.course_id}"/>
    Name: <input type="text" name="course_name" value="${course.course_name}"/>
    Credits: <input type="number" name="course_credits" value="${course.course_credits}"/>
    <button type="submit">Update course details</button>
</form>
    </body>
</html>

