<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 12.04.2018
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
<a class="btn btn-link"  href="/mydashboard/create/user">Create New User</a>
<div class="row">
    <div class="col-xs-12">
        <div class="container-fluid" style="margin: 10px 10px 10px 10px">

            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">${title}</h3>
                </div>
                <div class="box-body">

                    <div class="table-responsive">

                        <table id="userListTable" class="table table-striped table-bordered">

                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Thumbnail</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Role</th>
                                <th>Email</th>
                                <th>Gender</th>
                                <th>Active</th>
                                <th>Edit</th>
                            </tr>
                            </thead>

                            <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Thumbnail</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Role</th>
                                <th>Email</th>
                                <th>Gender</th>
                                <th>Active</th>
                                <th>Edit</th>
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
