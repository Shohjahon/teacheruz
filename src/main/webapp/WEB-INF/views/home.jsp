<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 10.04.2018
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <section id="carousel-section" class="section-global-wrapper">
        <div class="container-fluid-kamn">
            <div class="row">
                <div id="carousel-1" class="carousel slide" data-ride="carousel">

                    <!-- Indicators -->
                    <ol class="carousel-indicators visible-lg">
                        <li data-target="#carousel-1" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-1" data-slide-to="1"></li>
                        <li data-target="#carousel-1" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <!-- Begin Slide 1 -->
                        <div class="item active">
                            <img src="${contextRoot}/resources/images/glasses.jpg" height="400" alt="Image of first carousel">
                            <div class="carousel-caption">
                                <h3 class="carousel-title hidden-xs">Teacher.uz interaktiv o'quv web ilovasi</h3>
                                <p class="carousel-body">Programmistlarni qo'llab quvvatlash maqsadida ishlab chiqildi</p>
                            </div>
                        </div>
                        <!-- End Slide 1 -->

                        <!-- Begin Slide 2 -->
                        <div class="item">
                            <img src="${contextRoot}/resources/images/students.jpg" height="400" alt="Image of second carousel">
                            <div class="carousel-caption">
                                <h3 class="carousel-title hidden-xs">Teacher.uz interaktiv o'quv web ilovasi</h3>
                                <p class="carousel-body">Programmistlarni qo'llab quvvatlash maqsadida ishlab chiqildi</p>
                            </div>
                        </div>
                        <!-- End Slide 2 -->

                        <!-- Begin Slide 3 -->
                        <div class="item">
                            <img src="${contextRoot}/resources/images/skills.jpg" height="400" alt="Image of third carousel">
                            <div class="carousel-caption">
                                <h3 class="carousel-title hidden-xs">Teacher.uz interaktiv o'quv web ilovasi</h3>
                                <p class="carousel-body">Programmistlarni qo'llab quvvatlash maqsadida ishlab chiqildi</p>
                            </div>
                        </div>
                        <!-- End Slide 3 -->
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-1" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-1" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
        </div>
    </section>
    <!-- End #carousel-section -->


    <!-- Begin #services-section -->
    <section id="services" class="services-section section-global-wrapper">
        <div class="container">
            <div class="row">
                <div class="services-header">
                    <h3 class="services-header-title">Our Mission</h3>
                    <p class="services-header-body"><em> Thing we provide teachers and students </em>  </p><hr>
                </div>
            </div>

            <!-- Begin Services Row 1 -->
            <div class="row services-row services-row-head services-row-1">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="services-group wow animated fadeInLeft" data-wow-offset="40">
                        <p class="services-icon"><span class="fa fa-android fa-5x"></span></p>
                        <h4 class="services-title">Android Courses</h4>
                        <p class="services-body">Android is the most trending OS for modern mobile phones , tablets and some PCs, It is great opportunity to learn how to code in Android Studio. So offer our students</p>
                        <p class="services-more"><a href="#">Find Out More</a></p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="services-group wow animated zoomIn" data-wow-offset="40">
                        <p class="services-icon"><i class="fa fa-apple fa-5x"></i></p>
                        <h4 class="services-title">IOS Courses</h4>
                        <p class="services-body">Apple IOS is the most trending OS for modern mobile phones , tablets and some PCs, It is great opportunity to learn how to code in Apple IOS. So offer our students</p>
                        <p class="services-more"><a href="#">Find Out More</a></p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="services-group wow animated fadeInRight" data-wow-offset="40">
                        <p class="services-icon"><i class="fa fa-rocket fa-5x"></i></p>
                        <h4 class="services-title">Robototechnics</h4>
                        <p class="services-body">There are some professors who are going to release brand new video tutorial in roboto technology in python prgramming language</p>
                        <p class="services-more"><a href="#">Find Out More</a></p>
                    </div>
                </div>
            </div>
            <!-- End Serivces Row 1 -->

            <!-- Begin Services Row 2 -->
            <div class="row services-row services-row-tail services-row-2">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="services-group wow animated fadeInLeft" data-wow-offset="40">
                        <p class="services-icon"><span class="fa fa-windows fa-5x"></span></p>
                        <h4 class="services-title">Windows Phone and Desktop Courses</h4>
                        <p class="services-body">Windows Phone and Desktop is the most trending OS for modern mobile phones , tablets and some PCs, It is great opportunity to learn how to code</p>
                        <p class="services-more"><a href="#">Find Out More</a></p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="services-group wow animated zoomIn" data-wow-offset="40">
                        <p class="services-icon"><i class="fa fa-eye fa-5x"></i></p>
                        <h4 class="services-title">RETINA READY</h4>
                        <p class="services-body">Windows Phone and Desktop is the most trending OS for modern mobile phones , tablets and some PCs, It is great opportunity to learn how to code.</p>
                        <p class="services-more"><a href="#">Find Out More</a></p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="services-group wow animated fadeInRight" data-wow-offset="40">
                        <p class="services-icon"><i class="fa fa-cube fa-5x"></i></p>
                        <h4 class="services-title">Cubic</h4>
                        <p class="services-body">Windows Phone and Desktop is the most trending OS for modern mobile phones , tablets and some PCs, It is great opportunity to learn how to code.</p>
                        <p class="services-more"><a href="#">Find Out More</a></p>
                    </div>
                </div>
            </div>
            <!-- End Serivces Row 2 -->

        </div>
    </section>

