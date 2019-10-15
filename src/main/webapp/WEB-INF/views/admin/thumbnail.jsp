<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 13.05.2018
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <a class="btn btn-link"  href="/thumbnail/create/thumbnail">Create New Thumbnail</a>
    <div class="row">
        <div class="col-xs-12">
            <div class="container-fluid" style="margin: 10px 10px 10px 10px">

                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">${title}</h3>
                    </div>
                    <div class="box-body">

                        <div class="table-responsive">

                            <table  class="table table-striped table-bordered">

                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Thumbnails</th>
                                    <th>Article Name</th>>
                                    <th>Edit/Delete</th>
                                </tr>
                                </thead>

                                <c:if test="${not empty thumbnails}">

                                <c:forEach var="thumbnail" items="${thumbnails.pageList}">

                                    <tr>
                                        <td>${thumbnail.id}</td>
                                        <td><img
                                                style="width: 100px;height: 100px"
                                                src="${contextRoot}/resources/thumbs/${thumbnail.fileName}.jpg" class=".dataTableImg"></td>
                                        <td>${thumbnail.article.articleHeader}</td>
                                        <td>
                                            <a class="btn btn-warning" href="/thumbnail/create/${thumbnail.id}/create"><span class="fa fa-edit"></span></a>&#160;
                                            <a class="btn btn-danger thumbnail_delete" id="rowId${thumbnail.id}" data-id="${thumbnail.id}"><span class="fa fa-trash"></span></a>
                                        </td>
                                    </tr>

                                </c:forEach>
                                </c:if>

                                <tfoot>
                                <tr>
                                    <th>#</th>
                                    <th>Thumbnails</th>
                                    <th>Article Name</th>>
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