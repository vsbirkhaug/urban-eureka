<%-- 
    Document   : index
    Created on : 09-Mar-2016, 16:52:19
    Author     : vilde
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
      
        <div class="make-claim-page">
              <h1>XYZ Drivers Association</h1>
            
        <div class="form">      
            
            <h2>New claim</h2>
            </br>
            <form id="make-claim-form" method="POST" action="MakeClaim.do">
              <p class="label">Claim date</p>
              <input type="date" name="date" placeholder="date"/>
              <input type="text" name="rationale" placeholder="rationale"/>
              <input type="number" step="0.01" min=0 name="amount" placeholder="amount"/>
              <input type="hidden" name="action" value="submitclaim" />  
              </br>         

            </form>
            <form id="cancel-make-claim-form" method="POST" action="MakeClaim.do">
                <input type="hidden" name="action" value="cancel" />
            </form>
            
            <ul class="choice">
                <li onclick="document.getElementById('cancel-make-claim-form').submit();" class="user-button cancel">Cancel</li>  
                <li onclick="document.getElementById('make-claim-form').submit();" class="user-button submit">Submit Claim</li>
                <div style="clear:both"></div>
            </ul>
          
        </div>
      </div>
    </body>
</html>