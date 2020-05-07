<html>
   <head>
      <title>Welcome!</title>
      <style>
      h1 {
      text-allign: center;
      }
      body {
        background-color: lightblue;
      }
      input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
      }
      input[type=email], select {
              width: 100%;
              padding: 12px 20px;
              margin: 8px 0;
              display: inline-block;
              border: 1px solid #ccc;
              border-radius: 4px;
              box-sizing: border-box;
            }
      input[type=id], select {
              width: 100%;
              padding: 12px 20px;
              margin: 8px 0;
              display: inline-block;
              border: 1px solid #ccc;
              border-radius: 4px;
              box-sizing: border-box;
            }


      input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
      }

      input[type=submit]:hover {
        background-color: #45a049;
      }
      div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
        border-style: double;
        outline: #4CAF50 solid 10px;
      }
      </style>
   </head>
   <body>
      <h1>Welcome ${user}!</h1>
      <div>
      <form action="/resource/enterData" method="post">
         <h1>Enter Data</h1>
         <label><b>Full name</b></label>
         <input type="text" placeholder="full name" name="full_name" required>
         <label><b>Id</b></label>
         <input type="id" placeholder="Enter Id" name="id" required>
         <label><b>Email</b></label>
         <input type="email" placeholder="Email" name="email" required>
         <label><b>Address</b></label>
         <input type="text" placeholder="address" name="address" required>
         <label><b>Date of birth</b></label>
         <input type="text" placeholder="dd/mm/yy" name="dob" required>
         <button type="submit">Enter Data</button>
      </form>
      </div>
      <div>
      <form action="/resource/showDetails" method="post">
         <h1>Enter Employee Id to find detail</h1>
         <label><b>Emp Id</b></label>
         <input type="text" placeholder="id" name="id" required>
         <button type="submit">Find Data</button>
      </form>
      </div>
      <div>

      <form action="/resource/deleteDetails" method="post">
               <h1>Enter Employee Id to delete details</h1>
               <label><b>Emp Id</b></label>
               <input type="text" placeholder="id" name="id" required>
               <button type="submit">Delete Data</button>
            </form>
      </div>

      <div>
      <h1>Enter new details to update data</h1>
      <form action="/resource/updateName" method="post">
      <h3>Enter Employee Id to update name</h3>
      <label><b>Emp Id</b></label>
      <input type="text" placeholder="id" name="id" >
      <label><b>Full name</b></label>
      <input type="text" placeholder="full name" name="full_name" required>
      <button type="submit">Update Name</button>
      </form>

      <form action="/resource/updateEmail" method="post">
            <h3>Enter Employee Id to update email</h3>
            <label><b>Emp Id</b></label>
            <input type="text" placeholder="id" name="id" >
            <label><b>Email</b></label>
            <input type="email" placeholder="email" name="email">
            <button type="submit">Update Email</button>
            </form>

            <form action="/resource/updateDob" method="post">
                  <h3>Enter Employee Id to update date of birth</h3>
                  <label><b>Emp Id</b></label>
                  <input type="text" placeholder="id" name="id" >
                  <label><b>Date of Birth</b></label>
                  <input type="text" placeholder="dob" name="dob">
                  <button type="submit">Update DOB</button>
                  </form>

                  <form action="/resource/updateAddress" method="post">
                        <h3>Enter Employee Id to update address</h3>
                        <label><b>Emp Id</b></label>
                        <input type="text" placeholder="id" name="id" >
                        <label><b>Address</b></label>
                        <input type="text" placeholder="address" name="address" required>
                        <button type="submit">Update Address</button>
                        </form>

      </div>

   </body>
</html>