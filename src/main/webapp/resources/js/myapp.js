/**
 * Created by Shoh Jahon on 10.04.2018.
 */
$(function () {
  switch (menu){
      case 'Courses': $('#courses').addClass('active');
          break;
      case 'Home': $('#home').addClass('active');
          break;
      case 'About Us': $("#aboutus").addClass('active');
         break;
      case 'Manage Groups': $('#managegroups').addClass('active');
         break;
      case 'Manage Subjects': $('#managesubjects').addClass('active');
         break;
      case 'Dashboard - User Management': $('#dashboard').addClass('active');
         break;
      case 'News': $('#news').addClass('active');
        break;
  }
  //--------------------------User datatable--------------------------------

    var $usertable = $('#userListTable');

  if ($usertable.length){
      var jsonUrl = window.contextRoot + '/json/data/all/users';

      $usertable.dataTable(
          {
              lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
              pageLength: 5,
              ajax: {
                  url: jsonUrl,
                  dataSrc:''
              },
              columns: [
                  {
                    data:'id'
                  },
                  {
                      data: 'code',
                      mRender: function (data, type, row) {
                          return '<img src="'+window.contextRoot+'/resources/images/thumbnails/'+data+'.jpg" class="adminDataTableImg"/>';
                      }
                  },
                  {
                      data:'firstName'
                  },
                  {
                      data: 'lastName'
                  },
                  {
                    data: 'role'
                  },
                  {
                      data: 'email'
                  },
                  {
                      data: 'gender'
                  },
                  {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                          var str = '';
                          str += '<label class="switch">';
                          if(data){
                              str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
                          }else {
                              str += '<input type="checkbox" value="'+row.id+'"/>';
                          }
                          str += '<div class="slider"></div></label>';
                          return str;
                      }
                  },
                  {
                      data: 'id',
                      bSortable: false,
                      mRender: function (data,type,row) {
                          var str = '';

                          str += '<a href="'+window.contextRoot+'/mydashboard/create/'+data+'/user"'+
                                  'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
                          return str;
                      }
                  }
              ],
              initComplete:function () {
                  var api = this.api();
                  api.$('.switch input[type="checkbox"]').on('change',function () {

                      var checkbox = $(this);
                      var checked = checkbox.prop('checked');
                      var dMsg = (checked)?'Do you want to activate this user?':
                          'Do you want to deactivate this user?';
                      var value = checkbox.prop('value');
                      bootbox.confirm({
                          size:'medium',
                          title:'User Activation & Deactivation',
                          message: dMsg,
                          callback: function (confirmed) {
                              if(confirmed){
                                  console.log(value);

                                  var activationUrl = window.contextRoot + '/mydashboard/user/'+value+'/activation';
                                  $.post(activationUrl,function (data) {
                                     bootbox.alert({
                                        size:'medium',
                                        title:'Information',
                                        message:data
                                     });
                                  });
                              } else{
                                  checkbox.prop('checked',!checked);
                              }
                          }
                      });

                  });
              }
          }
      );

      console.log('We are inside the admin table');
  }

  //--------------------------User datatable--------------------------------

    var $universitytable = $('#universityListTable');

    if ($universitytable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/universities';

        $universitytable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                fnCreatedRow:function (row,data,dataIndex) {
                    $(row).attr('data-id',data.id);
                },
                columns: [
                    {
                        data:'id'
                    },
                    {
                        data:'universityName'
                    },
                    {
                        data: 'address'
                    },
                    {
                        data: 'phone'
                    },
                    {
                        data: 'description'
                    },
                    {
                        data: 'webSite'
                    },
                    {
                        data: 'rector'
                    },
                    {
                        data: 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/mydashboard/create/'+data+'/university"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>&#160';
                            str += '<a href="#" id="rowId'+row.id+'" data-id="'+row.id+'" class="btn btn-danger admin_delete"><span class="glyphicon glyphicon-trash"></span></a>'

                            return str;
                        }
                    },

                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.admin_delete').click(function () {
                        var dMsg = 'Do you want to delete this university?';
                        var data_id = $(this).attr('id');
                        var posid = $(this).attr('data-id');
                        bootbox.confirm({
                            size:'medium',
                            title:'University Management',
                            message:dMsg,
                            callback: function (confirmed) {
                                if (confirmed){
                                    console.log(data_id);
                                    var removingUrl = window.contextRoot + '/mydashboard/delete/'+posid+'/university';
                                    $.post(removingUrl,function (data) {
                                       bootbox.alert({
                                           size:'middle',
                                           title:'Information',
                                           message:data
                                       });
                                    });
                                    $('#'+data_id).closest('tr').remove();
                                }
                            }
                        });
                    });
                }
            }
        );

        console.log('We are inside the admin university table');
    }

  //--------------------------University datatable--------------------------------

    //--------------------------Field datatable--------------------------------


    var $fieldtable = $('#fieldListTable');

    if ($fieldtable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/fields';

        $fieldtable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                fnCreatedRow:function (row,data,dataIndex) {
                    $(row).attr('data-id',data.id);
                },
                columns: [
                    {
                        data:'id'
                    },
                    {
                        data:'fieldCode'
                    },
                    {
                        data: 'fieldName'
                    },
                    {
                        data: 'description'
                    },
                    {
                        data: 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/mydashboard/create/'+data+'/field"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>&#160';
                            str += '<a href="#" id="rowId'+row.id+'" data-id="'+row.id+'" class="btn btn-danger admin_delete1"><span class="glyphicon glyphicon-trash"></span></a>'

                            return str;
                        }
                    },

                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.admin_delete1').click(function () {
                        var dMsg = 'Do you want to delete this field?';
                        var data_id = $(this).attr('id');
                        var posid = $(this).attr('data-id');
                        bootbox.confirm({
                            size:'medium',
                            title:'Field Management',
                            message:dMsg,
                            callback: function (confirmed) {
                                if (confirmed){
                                    console.log(data_id);
                                    var removingUrl = window.contextRoot + '/mydashboard/delete/'+posid+'/field';
                                    $.post(removingUrl,function (data) {
                                        bootbox.alert({
                                            size:'middle',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                    $('#'+data_id).closest('tr').remove();
                                }
                            }
                        });
                    });
                }
            }
        );

        console.log('We are inside the admin field table');
    }

    //--------------------------Field datatable--------------------------------


    //--------------------------University Field datatable--------------------------------

    var $universityFieldTable = $('#universityFieldListTable');

    if ($universityFieldTable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/university_fields';

        $universityFieldTable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                columns: [
                    {
                        'data':'id'
                    },
                    {
                        'data':'university.universityName'
                    },
                    {
                        'data':'field.fieldCode'
                    },
                    {
                        'data':'field.fieldName'
                    },
                    {
                        'data': 'active',
                        bSortable: false,
                        mRender: function (data, type, row) {
                            var str = '';
                            str += '<label class="switch">';
                            if(data){
                                str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
                            }else {
                                str += '<input type="checkbox" value="'+row.id+'"/>';
                            }
                            str += '<div class="slider"></div></label>';
                            return str;
                        }
                    },
                    {
                        'data': 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/mydashboard/create/'+data+'/university_field"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
                            return str;
                        }
                    }
                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.switch input[type="checkbox"]').on('change',function () {

                        var checkbox = $(this);
                        var checked = checkbox.prop('checked');
                        var dMsg = (checked)?'Do you want to activate this university field?':
                            'Do you want to deactivate this university field?';
                        var value = checkbox.prop('value');
                        bootbox.confirm({
                            size:'medium',
                            title:'University & Field Activation & Deactivation',
                            message: dMsg,
                            callback: function (confirmed) {
                                if(confirmed){
                                    console.log(value);

                                    var activationUrl = window.contextRoot + '/mydashboard/delete/'+value+'/university_field';
                                    $.post(activationUrl,function (data) {
                                        bootbox.alert({
                                            size:'medium',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                } else{
                                    checkbox.prop('checked',!checked);
                                }
                            }
                        });

                    });
                }
            }
        );

        console.log('We are inside the university field admin table');
    }

    //--------------------------University Field datatable--------------------------------

    //--------------------------University Field User datatable--------------------------------

    var $universityFieldUserTable = $('#universityFieldUserListTable');

    if ($universityFieldUserTable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/university_field_users';

        $universityFieldUserTable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                columns: [
                    {
                        'data':'id'
                    },
                    {
                        'data':'user.fullName'
                    },
                    {
                        'data':'field.fieldName'
                    },
                    {
                        'data':'field.fieldCode'
                    },
                    {
                        'data':'university.universityName'
                    },
                    {
                        data: 'active',
                        bSortable: false,
                        mRender: function (data, type, row) {
                            var str = '';
                            str += '<label class="switch">';
                            if(data){
                                str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
                            }else {
                                str += '<input type="checkbox" value="'+row.id+'"/>';
                            }
                            str += '<div class="slider"></div></label>';
                            return str;
                        }
                    },
                    {
                        'data': 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/university_field_user/create/'+data+'/university_field_user"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
                            return str;
                        }
                    }
                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.switch input[type="checkbox"]').on('change',function () {

                        var checkbox = $(this);
                        var checked = checkbox.prop('checked');
                        var dMsg = (checked)?'Do you want to activate this university & field & user?':
                            'Do you want to deactivate this university & field & user?';
                        var value = checkbox.prop('value');
                        bootbox.confirm({
                            size:'medium',
                            title:'University & Field & User Activation & Deactivation',
                            message: dMsg,
                            callback: function (confirmed) {
                                if(confirmed){
                                    console.log(value);

                                    var activationUrl = window.contextRoot + '/university_field_user/delete/'+value+'/university_field_user';
                                    $.post(activationUrl,function (data) {
                                        bootbox.alert({
                                            size:'medium',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                } else{
                                    checkbox.prop('checked',!checked);
                                }
                            }
                        });

                    });
                }
            }
        );

        console.log('We are inside the university field user admin table');
    }

    //--------------------------University Field User datatable--------------------------------

   //--------------------------Skills datatable--------------------------------

    var $skillTable = $('#skillListTable');

    if ($skillTable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/skills';

        $skillTable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                columns: [
                    {
                        'data':'id'
                    },
                    {
                        'data':'skillName'
                    },
                    {
                        'data':'skillTrend',
                        mRender: function (data,type,row) {
                            var str = '';
                            str += '<span class="badge">'+data+'</span>';
                            return str;
                        }
                    },
                    {
                        'data':'category.categoryName'
                    },
                    {
                      'data':'user.fullName'
                    },
                    {
                        data: 'active',
                        bSortable: false,
                        mRender: function (data, type, row) {
                            var str = '';
                            str += '<label class="switch">';
                            if(data){
                                str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
                            }else {
                                str += '<input type="checkbox" value="'+row.id+'"/>';
                            }
                            str += '<div class="slider"></div></label>';
                            return str;
                        }
                    },
                    {
                        'data': 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/skill/create/'+data+'/skill"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
                            return str;
                        }
                    }
                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.switch input[type="checkbox"]').on('change',function () {

                        var checkbox = $(this);
                        var checked = checkbox.prop('checked');
                        var dMsg = (checked)?'Do you want to activate this skill?':
                            'Do you want to deactivate this skill?';
                        var value = checkbox.prop('value');
                        bootbox.confirm({
                            size:'medium',
                            title:'Skill Activation & Deactivation',
                            message: dMsg,
                            callback: function (confirmed) {
                                if(confirmed){
                                    console.log(value);

                                    var activationUrl = window.contextRoot + '/skill/delete/'+value+'/skill';
                                    $.post(activationUrl,function (data) {
                                        bootbox.alert({
                                            size:'medium',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                } else{
                                    checkbox.prop('checked',!checked);
                                }
                            }
                        });

                    });
                }
            }
        );

        console.log('We are inside the skill admin table');
    }

    //--------------------------Skills datatable--------------------------------

    //-------------------------- Category datatable ----------------------------

    var $categorytable = $('#categoryListTable');

    if ($categorytable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/categories';

        $categorytable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                fnCreatedRow:function (row,data,dataIndex) {
                    $(row).attr('data-id',data.id);
                },
                columns: [
                    {
                        data:'id'
                    },
                    {
                        data:'categoryName'
                    },
                    {
                        data: 'description'
                    },
                    {
                        data: 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/category/create/'+data+'/category"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>&#160';
                            str += '<a href="#" id="rowId'+row.id+'" data-id="'+row.id+'" class="btn btn-danger admin_delete"><span class="glyphicon glyphicon-trash"></span></a>'

                            return str;
                        }
                    },

                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.admin_delete').click(function () {
                        var dMsg = 'Do you want to delete this category?';
                        var data_id = $(this).attr('id');
                        var posid = $(this).attr('data-id');
                        bootbox.confirm({
                            size:'medium',
                            title:'Category Management',
                            message:dMsg,
                            callback: function (confirmed) {
                                if (confirmed){
                                    console.log(data_id);
                                    var removingUrl = window.contextRoot + '/category/delete/'+posid+'/category';
                                    $.post(removingUrl,function (data) {
                                        bootbox.alert({
                                            size:'middle',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                    $('#'+data_id).closest('tr').remove();
                                }
                            }
                        });
                    });
                }
            }
        );

        console.log('We are inside the admin category table');
    }

    //--------------------------Category datatable -----------------------------

    //-------------------------- University History datatable -----------------------------

    var $educationhistorytable = $('#educationHistoryListTable');

    if ($educationhistorytable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/education_histories';

        $educationhistorytable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                fnCreatedRow:function (row,data,dataIndex) {
                    $(row).attr('data-id',data.id);
                },
                columns: [
                    {
                        data:'id'
                    },
                    {
                        data:'user.fullName'
                    },
                    {
                        data: 'universityDetails'
                    },
                    {
                        data: 'collegeDetails'
                    },
                    {
                        data: 'schoolDetails'
                    },
                    {
                        data: 'createdDate',
                        mRender:function (data,type,row) {
                            var date = new Date();
                            date.setTime(new Number(data));
                            return date.toLocaleDateString();
                        }
                    },
                    {
                        data: 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/education_history/create/'+data+'/education_history"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>&#160';
                            str += '<a href="#" id="rowId'+row.id+'" data-id="'+row.id+'" class="btn btn-danger admin_delete"><span class="glyphicon glyphicon-trash"></span></a>'

                            return str;
                        }
                    },

                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.admin_delete').click(function () {
                        var dMsg = 'Do you want to delete this education history?';
                        var data_id = $(this).attr('id');
                        var posid = $(this).attr('data-id');
                        bootbox.confirm({
                            size:'medium',
                            title:'Education History Management',
                            message:dMsg,
                            callback: function (confirmed) {
                                if (confirmed){
                                    console.log(data_id);
                                    var removingUrl = window.contextRoot + '/education_history/delete/'+posid+'/education_history';
                                    $.post(removingUrl,function (data) {
                                        bootbox.alert({
                                            size:'middle',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                    $('#'+data_id).closest('tr').remove();
                                }
                            }
                        });
                    });
                }
            }
        );

        console.log('We are inside the admin education history table');
    }

    //-------------------------- University History datatable -----------------------------

    //-------------------------- Subject datatable -----------------------------

    var $subjecttable = $('#subjectListTable');

    if ($subjecttable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/subjects';

        $subjecttable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                fnCreatedRow:function (row,data,dataIndex) {
                    $(row).attr('data-id',data.id);
                },
                columns: [
                    {
                        data:'id'
                    },
                    {
                        data:'subjectName'
                    },
                    {
                        data: 'description'
                    },
                    {
                        data: 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/subject/create/'+data+'/subject"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>&#160';
                            str += '<a href="#" id="rowId'+row.id+'" data-id="'+row.id+'" class="btn btn-danger admin_delete"><span class="glyphicon glyphicon-trash"></span></a>'

                            return str;
                        }
                    },

                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.admin_delete').click(function () {
                        var dMsg = 'Do you want to delete this subject';
                        var data_id = $(this).attr('id');
                        var posid = $(this).attr('data-id');
                        bootbox.confirm({
                            size:'medium',
                            title:'Subject Management',
                            message:dMsg,
                            callback: function (confirmed) {
                                if (confirmed){
                                    console.log(data_id);
                                    var removingUrl = window.contextRoot + '/subject/delete/'+posid+'/subject';
                                    $.post(removingUrl,function (data) {
                                        bootbox.alert({
                                            size:'middle',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                    $('#'+data_id).closest('tr').remove();
                                }
                            }
                        });
                    });
                }
            }
        );

        console.log('We are inside the admin subjects table');
    }

    //-------------------------- Subject datatable -----------------------------


    //-------------------------- Article datatable -----------------------------

    var $articledatable = $('#articleListTable');

    if ($articledatable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/articles';

        $articledatable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                fnCreatedRow:function (row,data,dataIndex) {
                    $(row).attr('data-id',data.id);
                },
                columns: [
                    {
                        data:'id'
                    },
                    {
                        data: 'videoUrl',
                        mRender: function (data, type, row) {
                            var str = '<video width="320" height="240" controls>' +
                                '<source src="'+contextRoot+'/resources/videos/'+data+'.mp4" type="video/mp4">' +
                                '</video>';
                            return str;
                        }
                    },
                    {
                        data:'articleHeader'
                    },
                    {
                        data: 'articleContent'
                    },
                    {
                        data: 'createdDate',
                        mRender:function (data,type,row) {
                            var date = new Date();
                            date.setTime(new Number(data));
                            return date.toLocaleDateString();
                        }
                    },
                    {
                        data:'userPoint'
                    },
                    {
                        data:"user.fullName"
                    },
                    {
                        data: 'subject.subjectName'
                    },
                    {
                        data: 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/article/create/'+data+'/article"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>&#160';
                            str += '<a href="#" id="rowId'+row.id+'" data-id="'+row.id+'" class="btn btn-danger admin_delete"><span class="glyphicon glyphicon-trash"></span></a>'

                            return str;
                        }
                    },

                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.admin_delete').click(function () {
                        var dMsg = 'Do you want to delete this article';
                        var data_id = $(this).attr('id');
                        var posid = $(this).attr('data-id');
                        bootbox.confirm({
                            size:'medium',
                            title:'Article Management',
                            message:dMsg,
                            callback: function (confirmed) {
                                if (confirmed){
                                    console.log(data_id);
                                    var removingUrl = window.contextRoot + '/article/delete/'+posid+'/article';
                                    $.post(removingUrl,function (data) {
                                        bootbox.alert({
                                            size:'middle',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                    $('#'+data_id).closest('tr').remove();
                                }
                            }
                        });
                    });
                }
            }
        );

        console.log('We are inside the admin article table');
    }

    //-------------------------- Article datatable -----------------------------

    //-------------------------- Comment datatable -----------------------------

    var $commentdatable = $('#commentListTable');

    if ($commentdatable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/comments';

        $commentdatable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                fnCreatedRow:function (row,data,dataIndex) {
                    $(row).attr('data-id',data.id);
                },
                columns: [
                    {
                        data:'id'
                    },
                    {
                        data:'comment'
                    },
                    {
                        data: 'createdDate',
                        mRender:function (data,type,row) {
                            var date = new Date();
                            date.setTime(new Number(data));
                            return date.toLocaleDateString();
                        }
                    },
                    {
                        data: 'article.articleHeader'
                    },
                    {
                        data:"user.fullName"
                    },
                    {
                        data: 'commentResponse'
                    },
                    {
                        data: 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/comment/create/'+data+'/comment"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>&#160';
                            str += '<a href="#" id="rowId'+row.id+'" data-id="'+row.id+'" class="btn btn-danger admin_delete"><span class="glyphicon glyphicon-trash"></span></a>'

                            return str;
                        }
                    },

                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.admin_delete').click(function () {
                        var dMsg = 'Do you want to delete this comment';
                        var data_id = $(this).attr('id');
                        var posid = $(this).attr('data-id');
                        bootbox.confirm({
                            size:'medium',
                            title:'Comment Management',
                            message:dMsg,
                            callback: function (confirmed) {
                                if (confirmed){
                                    console.log(data_id);
                                    var removingUrl = window.contextRoot + '/comment/delete/'+posid+'/comment';
                                    $.post(removingUrl,function (data) {
                                        bootbox.alert({
                                            size:'middle',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                    $('#'+data_id).closest('tr').remove();
                                }
                            }
                        });
                    });
                }
            }
        );

        console.log('We are inside the admin comment table');
    }


    //3 sekund o'tgach alert ni yopish
    var $alert = $('.alert');

    if($alert.length){
        setTimeout(function () {
            $alert.fadeOut('slow');
        },3000)
    }

    //-------------------------- Article datatable -----------------------------

    if (window.articleId != null){
        var likeUrl = window.contextRoot + '/article/article/'+window.articleId+'/comments';
        $.post(likeUrl,function (data) {

            var str = '';

            for(var i=0; i<data.length; i++){

                str += '<div class="w3-row w3-padding-bottom">' +
                    '<hr>' +
                    '<div class="w3-col l2 m3">' +
                    '<img src="'+window.contextRoot+'/resources/images/thumbnails/'+data[i].user.code+'.jpg" style="width:90px;">' +
                    '</div>' +
                    '<div class="w3-col l10 m9">' +
                    '<h4>'+data[i].user.firstName+' <span class="w3-opacity w3-medium">'+dataParser(data[0].createdDate)+'</span></h4>' +
                    '<p>'+data[i].comment+'</p>' +
                    '</div>' +
                    '</div>';

            }

            $('#comment_box').html(str);

        });

    }



    $('.thumbnail_delete').click(function () {
        var dMsg = 'Do you want to delete this thumbnail';
        var data_id = $(this).attr('id');
        var posid = $(this).attr('data-id');
        bootbox.confirm({
            size:'medium',
            title:'Thumbnail Management',
            message:dMsg,
            callback: function (confirmed) {
                if (confirmed){
                    console.log(data_id);
                    var removingUrl = window.contextRoot + '/thumbnail/delete/'+posid+'/thumbnail';
                    $.post(removingUrl,function (data) {
                        bootbox.alert({
                            size:'middle',
                            title:'Information',
                            message:data
                        });
                    });
                    $('#'+data_id).closest('tr').remove();
                }
            }
        });
    });

    $('.like_button').click(function () {
        var posid = $(this).attr('data-id');
        var likeUrl = window.contextRoot + '/courses/'+posid+'/course';
        $.post(likeUrl,function (data) {
            console.log(data);
            $('#'+posid).text(data+' Liked!');
        });
    });


    $('#comment').click(function () {
        var posid = $(this).attr('data-id');
        var comment = $('#commenter').text();
        var article_id = $('#commenter').attr('data-id');
        console.log(comment);
        console.log(posid);
        console.log(article_id);
        var commentUrl = window.contextRoot + '/comment/comment/'+posid+'/user';
        $.post(commentUrl,{
            comment:comment+'#'+article_id
        },function (data) {

            var str = '';

            for(var i=0; i<data.length; i++){

                str += '<div class="w3-row w3-padding-bottom">' +
                    '<hr>' +
                    '<div class="w3-col l2 m3 right-side">' +
                    '<img src="'+window.contextRoot+'/resources/images/thumbnails/'+data[i].user.code+'.jpg" style="width:90px;">' +
                    '</div>' +
                    '<div class="w3-col l10 m9">' +
                    '<h4>'+data[i].user.firstName+' <span class="w3-opacity w3-medium">'+dataParser(data[0].createdDate)+'</span></h4>' +
                    '<p>'+data[i].comment+'</p>' +
                    '</div>' +
                    '</div>';

            }

            $('#comment_box').html(str);

        });
    });



    //-------------------------- Teacher Room Lesson datatable -----------------------------

    var $troomlessondatable = $('#tRoomLessonListTable');

    if ($troomlessondatable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/teacher_rooms';

        $troomlessondatable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                fnCreatedRow:function (row,data,dataIndex) {
                    $(row).attr('data-id',data.id);
                },
                columns: [
                    {
                        data:'id'
                    },
                    {
                        data:'pair'
                    },
                    {
                        data: 'lesson.lessonName'
                    },
                    {
                        data:"group.groupNumber"
                    },
                    {
                        data: 'room.roomNumber'
                    },
                    {
                      data: 'dayOfWeek'
                    },
                    {
                      data: 'user.fullName'
                    },
                    {
                        data: 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/teacher_room_lesson/create/'+data+'/teacher_room_lesson"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>&#160';
                            str += '<a href="#" id="rowId'+row.id+'" data-id="'+row.id+'" class="btn btn-danger admin_delete"><span class="glyphicon glyphicon-trash"></span></a>'

                            return str;
                        }
                    },

                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.admin_delete').click(function () {
                        var dMsg = 'Do you want to delete this Teacher & Lesson & Room';
                        var data_id = $(this).attr('id');
                        var posid = $(this).attr('data-id');
                        bootbox.confirm({
                            size:'medium',
                            title:'Teacher & Lesson & Room Management',
                            message:dMsg,
                            callback: function (confirmed) {
                                if (confirmed){
                                    console.log(data_id);
                                    var removingUrl = window.contextRoot + '/teacher_room_lesson/delete/'+posid+'/teacher_room_lesson';
                                    $.post(removingUrl,function (data) {
                                        bootbox.alert({
                                            size:'middle',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                    $('#'+data_id).closest('tr').remove();
                                }
                            }
                        });
                    });
                }
            }
        );

        console.log('We are inside the admin Teacher Room Lesson  table');
    }

    //-------------------------- Teacher Room Lesson datatable -----------------------------



    //-------------------------- Teacher Room Lesson Personal datatable -----------------------------

    var $teacherroomlessondatable = $('#teacherRoomLessonListTable');

    if ($teacherroomlessondatable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/teacher/'+window.userId+'/room';

        $teacherroomlessondatable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                fnCreatedRow:function (row,data,dataIndex) {
                    $(row).attr('data-id',data.id);
                },
                columns: [
                    {
                        data:'id'
                    },
                    {
                        data:'pair'
                    },
                    {
                        data: 'lesson.lessonName'
                    },
                    {
                        data:"group.groupNumber"
                    },
                    {
                        data: 'room.roomNumber'
                    },
                    {
                        data: 'dayOfWeek'
                    },
                    {
                        data: 'id',
                        bSortable: false,
                        mRender: function (data,type,row) {
                            var str = '';

                            str += '<a href="'+window.contextRoot+'/teacher_room_lesson/create/'+data+'/teacher_room_lesson"'+
                                'class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>&#160';
                            str += '<a href="#" id="rowId'+row.id+'" data-id="'+row.id+'" class="btn btn-danger admin_delete"><span class="glyphicon glyphicon-trash"></span></a>'

                            return str;
                        }
                    },

                ],
                initComplete:function () {
                    var api = this.api();
                    api.$('.admin_delete').click(function () {
                        var dMsg = 'Do you want to delete this Teacher & Lesson & Room';
                        var data_id = $(this).attr('id');
                        var posid = $(this).attr('data-id');
                        bootbox.confirm({
                            size:'medium',
                            title:'Teacher & Lesson & Room Management',
                            message:dMsg,
                            callback: function (confirmed) {
                                if (confirmed){
                                    console.log(data_id);
                                    var removingUrl = window.contextRoot + '/teacher_room_lesson/delete/'+posid+'/teacher_room_lesson';
                                    $.post(removingUrl,function (data) {
                                        bootbox.alert({
                                            size:'middle',
                                            title:'Information',
                                            message:data
                                        });
                                    });
                                    $('#'+data_id).closest('tr').remove();
                                }
                            }
                        });
                    });
                }
            }
        );

        console.log('We are inside the admin Teacher Room Lesson Personal table');
    }


    $('#submitSchedule').click(function (event) {
        event.preventDefault();
        scheduleAjaxPost();
    });

    function scheduleAjaxPost() {
        var formData = {
            dayOfWeek : $('#dayOfWeek').val(),
            pair : $('#pair').val(),
            roomId: $('#room_id').find(':selected').attr('value'),
            subjectId: $('#lesson_id').find(':selected').attr('value'),
            groupId: $('#group_id').find(':selected').attr('value'),
            userId: $('#user').attr('data-id')
        }

        console.log(JSON.stringify(formData));
        $.ajax({
            type:'POST',
            contentType: 'application/json',
            url: window.contextRoot + '/save/schedule',
            data: JSON.stringify(formData),
            dataType :'json',
            success :function (result) {
                bootbox.alert({
                    size:'middle',
                    title:'Information',
                    message:result.status
                });
                setTimeout(function () {
                    location.reload();
                },10000);
            },
            error :function (e) {
                bootbox.alert({
                    size:'middle',
                    title:'Information',
                    message:result.status
                });
            }
        });
    }

    //-------------------------- Teacher Room Lesson datatable -----------------------------


    $('#submitSemester').click(function (event) {

        var data = {};
        data['password'] = $('#spassword').val();
        data['email'] = $('#semail').val();
        data['schedule_id'] = $('#sschedule_id').val();

        $.ajax({
            type:'POST',
            contentType: 'application/json',
            url: window.contextRoot+'/manage_subjects',
            data: JSON.stringify(data),
            dataType: 'json',
            success:function (data) {
                bootbox.alert({
                    size:'middle',
                    title:'Information',
                    message:data
                });
                $
            },
            error:function (e) {
                window.location.replace('http://localhost:8080/manage_subjects?message=submitted');
            }
        });

    });



    //-------------------------- Manage Subjects datatable -----------------------------

    var $managesubjectdatable = $('#manageSubjectTable');

    if ($managesubjectdatable.length){
        var jsonUrl = window.contextRoot + '/json/data/all/teacher_rooms';

        $managesubjectdatable.dataTable(
            {
                lengthMenu:[[3,5,10,-1],['3 Records','5 Records', '10 Records','All Records']],
                pageLength: 5,
                ajax: {
                    url: jsonUrl,
                    dataSrc:''
                },
                fnCreatedRow:function (row,data,dataIndex) {
                    $(row).attr('data-id',data.id);
                },
                columns: [
                    {
                        data:'id'
                    },
                    {
                        data:'user.code',
                        mRender: function (data, type, row) {
                            return '<img src="'+window.contextRoot+'/resources/images/thumbnails/'+data+'.jpg" style="width: 100px;height: 100px"/>';
                        }
                    },
                    {
                        data: 'user.fullName'
                    },
                    {
                      data: 'lesson.lessonName'
                    },
                    {
                        data:"group.groupNumber"
                    },
                    {
                      data: 'room.seats',
                      mRender:function (data, type, row) {
                          console.log(data+' '+row.numberOfStudents);
                          var remainingSeats = data - row.numberOfStudents;
                          return remainingSeats;
                      }
                    }

                ]
            }
        );

        console.log('We are inside the Manage Subjects  table');
    }
    //-------------------------- Manage Subjects datatable -----------------------------

    var panelOne = $('.form-panel.two').height(),
        panelTwo = $('.form-panel.two')[0].scrollHeight;

    $('.form-panel.two').not('.form-panel.two.active').on('click', function(e) {
        e.preventDefault();

        $('.form-toggle').addClass('visible');
        $('.form-panel.one').addClass('hidden');
        $('.form-panel.two').addClass('active');
        $('.form').animate({
            'height': panelTwo
        }, 200);
    });

    $('.form-toggle').on('click', function(e) {
        e.preventDefault();
        $(this).removeClass('visible');
        $('.form-panel.one').removeClass('hidden');
        $('.form-panel.two').removeClass('active');
        $('.form').animate({
            'height': panelOne
        }, 200);
    });
});
function dataParser(data) {
    var date = new Date();
    date.setTime(new Number(data));
    return date.toDateString() + ' ' + date.getHours()+":"+date.getMinutes();
}
function openCity(evt, cityName) {
    var i, x, tablinks;
    x = document.getElementsByClassName("city");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < x.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" w3-border-red", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.firstElementChild.className += " w3-border-red";
}
