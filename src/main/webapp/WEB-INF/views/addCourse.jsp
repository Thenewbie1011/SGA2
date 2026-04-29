<!DOCTYPE html>
<html>
    <head>
        <title>Add course</title>
        <style>
    body 
    {
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
         padding:25px;
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
        color:black;
        border:none; }
</style>
    </head>
    <body>
        <h2>Add Course</h2>
        <form action="/courses" method="post">
            Name: <input type="text" name="course_name" required/>
            Credits: <input type="number" name="course_credits"/>
            <button type="submit">Add new course</button>
        </form>
    </body>
</html>