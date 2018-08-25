
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.sgc.data.DatabaseConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Edit MainClassification</title>
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


        <script>
            $(document).ready(function () {
//                alert("test");
//                $.ajax({
//                        url: 'GetMainClassificationController',
//                        complete: function (response) {
//                            var json = JSON.parse(response.responseText);
//                            var noOfList = Object.keys(json.MainClassification).length;
//
//                            option = '<option>Select Main Classification</option>';
//
//                            for (var x = 0; x < noOfList; x++) {
//                                option += '<option value="' + json.MainClassification[x].mainClassificationId + '">' + json.MainClassification[x].mainClassificationName + '</option>';
//                            }
//                            $('#mainClassificationList')
//                                    .find('option')
//                                    .remove()
//                                    .end()
//                                    .append(option)
//                                    ;
//                        },
//
//                        error: function () {
//                            //$('#id').html('Error receiving the response from json');
//                            console.log('Error receiving the response from json');
//                        },
//                    });
//                    return false;


            });
        </script>
    </head>

    <body>

        <header class="header-search">

            <div class="header-limiter">

                <h1><a href="#">Library<span  style="color:#F05283;">online</span></a></h1>

                <nav>
                    <a href="index.jsp">Home</a>
                    <!-- <a href="#" class="selected">Blog</a> -->
                    <a href="ViewBookController">Books</a>



                    <div class="dropdown">
                        <a>Classification</a>
                        <div class="dropdown-content">
                            <a href="ViewMainController">Main Classification</a><br>
                            <a href="ViewSubController">Sub Classification</a>

                        </div>
                    </div>

                </nav>

                <form method="get" action="#">
                    <input type="search" placeholder="Search!" name="search">
                </form>

            </div>

        </header>





            
                      
<!--                            <div class="modal-header">
                                
                                <h4 class="modal-title">
                                    Edit Main Classification
                                </h4>
                            </div>-->
                            <div class="modal-body">
                                <form  method="get" action="UpdateMainController" >
                                    <c:forEach items="${mainListAttribute}" var="mainList">

                                    <div class="form-group">
                                        <label for="name" > Main Classification ID</label>
                                        <input type="text"readonly class="form-control" value="${mainList.getMainClassificationId()}" id="mainid" name="mcid" required maxlength="50">

                                        <label for="name">Main Classification Name</label>
                                        <input type="text" class="form-control"value="${mainList.getMainClassificationName()}" id="mainname" name="mcname" required maxlength="50">

                                    </div>
                                        </c:forEach>
                                    <input type="submit" name="submit" value="Update">&nbsp;&nbsp;&nbsp;

                                    <!--<button type="submit" class="btn btn-lg btn-success btn-block" id="btnContactUs">Save </button>-->
                                </form>
                                <!--                            <div id="success_message" style="width:100%; height:100%; display:none; "> <h3>Sent your message successfully!</h3> </div>
                                                            <div id="error_message" style="width:100%; height:100%; display:none; "> <h3>Error</h3> Sorry there was an error sending your form. </div>-->
                            </div>
                       
         



        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script>
                            $(document).ready(function () {
                                $('.header-search form').on('click', function (e) {

                                    // If the form (which is turned into the search button) was
                                    // clicked directly, toggle the visibility of the search box.

                                    if (e.target == this) {
                                        $(this).find('input').toggle();
                                    }

                                });
                            });


        </script>


    </body>

</html>

