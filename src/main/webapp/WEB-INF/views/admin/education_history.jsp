<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 10.05.2018
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <a class="btn btn-link"  href="/education_history/create/education_history">Create New Education History</a>
    <div class="row">
        <div class="col-xs-12">
            <div class="container-fluid" style="margin: 10px 10px 10px 10px">

                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">${title}</h3>
                    </div>
                    <div class="box-body">

                        <div class="table-responsive">

                            <table id="educationHistoryListTable" class="table table-striped table-bordered">

                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>User's Full Name</th>
                                    <th>University Details</th>
                                    <th>College Details</th>
                                    <th>School Details</th>
                                    <th>Created Date</th>
                                    <th>Edit/Delete</th>
                                </tr>
                                </thead>

                                <tfoot>
                                <tr>
                                    <th>#</th>
                                    <th>User's Full Name</th>
                                    <th>University Details</th>
                                    <th>College Details</th>
                                    <th>School Details</th>
                                    <th>Created Date</th>
                                    <th>Edit/Delete</th>
                                </tr>
                                </tfoot>

                            </table>

                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
