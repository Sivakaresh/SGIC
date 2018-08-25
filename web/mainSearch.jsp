
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.sgc.data.DatabaseConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>



	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>MainClassification</title>
	<link rel="stylesheet" type="text/css" href="tbl.css">
	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/header-search.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="drop.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="form.css" >
        <script src="form.js"></script>
       <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
 <style type="text/css">
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Roboto', sans-serif;
            }
            .table-wrapper {
                background: #fff;
                padding: 20px;
                margin: 30px 0;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 10px;
                margin: 0 0 10px;
            }
            .table-title h2 {
                margin: 8px 0 0;
                font-size: 22px;
            }
            .search-box {
                position: relative;        
                float: right;
            }
            .search-box input {
                height: 34px;
                border-radius: 20px;
                padding-left: 35px;
                border-color: #ddd;
                box-shadow: none;
            }
            .search-box input:focus {
                border-color: #3FBAE4;
            }
            .search-box i {
                color: #a0a5b1;
                position: absolute;
                font-size: 19px;
                top: 8px;
                left: 10px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table td:last-child {
                width: 130px;
            }
            table.table td a {
                color: #a0a5b1;
                display: inline-block;
                margin: 0 5px;
            }
            table.table td a.view {
                color: #03A9F4;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #E34724;
            }
            table.table td i {
                font-size: 19px;
            }    
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 95%;
                width: 30px;
                height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 30px !important;
                text-align: center;
                padding: 0;
            }
            .pagination li a:hover {
                color: #666;
            }	
            .pagination li.active a {
                background: #03A9F4;
            }
            .pagination li.active a:hover {        
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 6px;
                font-size: 95%;
            }    
        </style>






<body>

<header class="header-search">

	<div class="header-limiter">

		<h1><a href="#">Library<span  style="color:#F05283;">online</span></a></h1>

		<nav>
			<a href="index.jsp">Home</a>
			<!-- <a href="#" class="selected">Blog</a> -->
			<a href="book.jsp">Books</a>
		
			
			
				<div class="dropdown">
				  <a>Classification</a>
				  <div class="dropdown-content">
				    <a href="mainClassification.jsp">Main Classification</a><br>
				    <a href="subClassification.jsp">Sub Classification</a>
				   
				  </div>
				</div>

		</nav>

		<form method="get" action="#">
			<input type="search" placeholder="Search!" name="search">
		</form>

	</div>

</header>



<div class="menu">
    <div data-role="main" class="ui-content">
	<h2>
		<a href="">View All</a>
                <a href="">Edit</a>
		<a href="">Search</a>
	</h2>
</div>


  <div class="container">
   
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">
                                Search Main Classification
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form  method="post" action="MCcontroller" >
                            
                                <div class="form-group">
<!--                                    <label for="name"> Main Classification ID</label>
                                    <input type="text" class="form-control" id="name" name="mcid" required maxlength="50">-->
                                
                                <label for="name">Main Classification Name</label>
                                    <input type="text" class="form-control" id="name" name="mcname" required maxlength="50">
                                
                                </div>
                                 <input type="submit" name="search" value="Search">&nbsp;&nbsp;&nbsp;
                                
                                <!--<button type="submit" class="btn btn-lg btn-success btn-block" id="btnContactUs">Save </button>-->
                            </form>
<!--                            <div id="success_message" style="width:100%; height:100%; display:none; "> <h3>Sent your message successfully!</h3> </div>
                            <div id="error_message" style="width:100%; height:100%; display:none; "> <h3>Error</h3> Sorry there was an error sending your form. </div>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <table>
        <thead>
        <tr><th>Main Classification ID</th><th>Main Classification Name</th><th>Edit</th><th>Delete</th></tr>
        </thead>
<tbody>
  <%  DatabaseConnection dbConnection=new DatabaseConnection();
        try{Connection con=dbConnection.getConnection();
        Statement statement=con.createStatement();
        String query="select * from main_class";
        ResultSet rs=statement.executeQuery(query);
        while(rs.next()){
            %>
            <tr><td><%=rs.getString("M_C_ID")%></td>
                <td><%=rs.getString("M_C_name")%></td>
              
           <td>
                <a href="" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
            </td>
            <td>
                <a href="" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
            </td>
            </tr>
             </tbody>   

            <%
        }
        } catch (Exception e) {
                        e.printStackTrace();
                    }

     %>   
</table>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>

	$(document).ready(function() {

		$('.header-search form').on('click', function(e) {

			// If the form (which is turned into the search button) was
			// clicked directly, toggle the visibility of the search box.

			if(e.target == this) {
				$(this).find('input').toggle();
			}

		});
	});

</script>


</body>

</html>

