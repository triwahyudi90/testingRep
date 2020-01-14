<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 3 | Dashboard</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="scripts/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.css">
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="dist/css/component/bootstrap-datepicker/bootstrap-datepicker.min.css">
  <link rel="stylesheet" href="plugins/timepicker/bootstrap-timepicker.min.css">
  <link rel="stylesheet" href="plugins/select2/select2.min.css"> 
  <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.aswata.report.entity.Role" %>
<%@ page import="com.aswata.report.entity.RoleMenu" %>
<%@ page import="com.aswata.report.entity.RoleSubMenu" %>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <a href="/Mars/dashboard.do" class="logo">
      <span class="logo-mini"><b>-</b></span>
      <span class="logo-lg"><b>Report Aswata</b></span>
    </a>
    <nav class="navbar navbar-static-top">
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="dist/img/download.png" class="user-image" alt="User Image">
              <span class="hidden-xs">${userlogin}</span>
            </a>
            <ul class="dropdown-menu">
              <li class="user-header">
                <img src="dist/img/download.png" class="img-circle" alt="User Image">
                <p>
                  ${userlogin} - Kode Cabang ${kodecabang}
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <li class="user-footer">
                <div class="pull-right">
                  <a href="LogoutProcess.do" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
            </li>
			<li>
				<a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
			</li>
        </ul>
      </div>
    </nav>
  </header>
  
  <aside class="main-sidebar">
    <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/download.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${userlogin}</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="menu2.jsp"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
            <li><a href="/Mars/dashboard.do"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
          </ul>
        </li>
        
        <% 
		RoleMenu header = new RoleMenu();
		RoleSubMenu subMenu = new RoleSubMenu();
		Role detail = new Role();
		ArrayList lrolesHeader = new ArrayList();
		if (request.getSession().getAttribute("lrolesHeader") !=null){
			lrolesHeader = (ArrayList) request.getSession().getAttribute("lrolesHeader");
		for (int i = 0; i < lrolesHeader.size(); i++){
			header = (RoleMenu)lrolesHeader.get(i);
		%>	
		
		<li class="treeview">
			<a href="#">
            <i class="fa fa-desktop"></i> <span><%=header.getHeaderName() %></span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
          	<%
				ArrayList lrolesSubMenu = header.getSubSubMenu();
				for (int j = 0; j < lrolesSubMenu.size(); j++){
					subMenu = (RoleSubMenu)lrolesSubMenu.get(j);
			%>
            <li class="treeview">
            	<a href="#">
            	<i class="fa fa-folder-open-o"></i><span><%=subMenu.getSubMenu() %></span>
            	<span class="pull-right-container">
              	<i class="fa fa-angle-left pull-right"></i>
            </span>
            </a>
            	<ul class="treeview-menu">
            		<%
						ArrayList lrolesDetail = subMenu.getDetail();
						for (int k = 0; k < lrolesDetail.size(); k++){
							detail = (Role)lrolesDetail.get(k);
					%>
					<li class="active"><a href='<%=detail.getFunc_act() %>'><%=detail.getFunc_nm() %></a></li>
					<%} %>
            	</ul>
            </li>
            <%} %>
          </ul>
		</li>
		<% }} %>
		<li>
			<a href="LogoutProcess.do">
			<i class="fa fa-power-off"></i> <span>Logout</span></a>
		</li>
      </ul>
    </section>
  </aside>
  
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Version 2.0</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      	<div class="row">
      		<div class="col-lg-3 col-md-6">
          		<div class="small-box bg-aqua">
            		<div class="inner">
              			<h3>${TotPremi}<sup style="font-size: 10px"></sup></h3>
              			<p>Total Premi</p>
            		</div>
	            	<div class="icon">
	              		<i class="ion ion-stats-bars"></i>
	            	</div>
            		<a href="/ReportAswata/premi.do" target="_blank" class="small-box-footer">
            		More info <i class="fa fa-arrow-circle-right"></i></a>
          		</div>
        	</div>
        	<div class="col-lg-3 col-xs-6">
	          <!-- small box -->
	        	<div class="small-box bg-green">
	            	<div class="inner">
	              		<h3>${TotTarget}<sup style="font-size: 10px"></sup></h3>
	              		<p>Total Target</p>
	            	</div>
	            	<div class="icon">
	              		<i class="ion-android-home"></i>
	            	</div>
	            	<a href="/Mars/branch.do" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
	          	</div>
	        </div>
	        <div class="col-lg-3 col-xs-6">
	          <!-- small box -->
	        	<div class="small-box bg-red">
	            	<div class="inner">
	              		<h3>${TotRasio}%<sup style="font-size: 10px"></sup></h3>
	              		<p>Loss Rasio</p>
	            	</div>
	            	<div class="icon">
	              		<i class="ion ion-stats-bars"></i>
	            	</div>
	            	<a href="/ReportAswata/riskProfile.do" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
	          	</div>
	        </div>
	        <div class="col-lg-3 col-xs-6">
          	<!-- small box -->
	        	<div class="small-box bg-red">
	            	<div class="inner">
	              		<h3>${totBranchTutup}</h3>
	              		<p>Branch Tutup</p>
	            	</div>
		            <div class="icon">
		              <i class="ion-person-stalker"></i>
		            </div>
	            	<a href="/Mars/branchTutup.do" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
	          	</div>
	        </div>
      	</div>
		<div class="row">
			<div class="col-md-12">
			<div class="box">
              <div class="card card-plain">
                <div class="card-header card-header-primary">
					<h4 class="card-title mt-0"> Table on Plain Background</h4>
					<p class="card-category"> Here is a subtitle for this table</p>
				</div>
				<div class="card-body">
					<div>
					  <table id="dtHorizontalVerticalExample" class="table table-shopping">
						  <thead>
							  <tr>
								  <th>Product</th>
								  <th class="th-description">Color</th>
								  <th class="th-description">Size</th>
								  <th class="text-right">Price</th>
								  <th class="text-right">Qty</th>
								  <th class="text-right">Amount</th>
								  <th class="text-right">Amount</th>
								  <th class="text-right">Amount</th>
								  <th>Product</th>
								  <th class="th-description">Color</th>
								  <th class="th-description">Size</th>
								  <th class="text-right">Price</th>
								  <th class="text-right">Qty</th>
								  <th class="text-right">Amount</th>
								  <th class="text-right">Amount</th>
								  <th class="text-right">Amount</th>
								  <th></th>
							  </tr>
						  </thead>
						  <tbody>
							  <tr>
								  <td class="td-name">
									  <a href="#jacket">Spring Jacket</a>
									  <br><small>by Dolce&amp;Gabbana</small>
								  </td>
								  <td>
									  Red
								  </td>
								  <td>
									  M
								  </td>
								  <td class="td-number">
									  <small>&#x20AC;</small>549
								  </td>
								  <td class="td-number">
									  1
									  <div class="btn-group">
										  <button class="btn btn-round btn-info btn-sm"> <i class="material-icons">remove</i> </button>
										  <button class="btn btn-round btn-info btn-sm"> <i class="material-icons">add</i> </button>
									  </div>
								  </td>
								  <td class="td-number">
									  <small>&#x20AC;</small>549
								  </td>
								  <td class="td-number">
									  <small>&#x20AC;</small>549
								  </td>
								  <td class="td-number">
									  <small>&#x20AC;</small>549
								  </td>
								  <td class="td-actions">
									  <button type="button" rel="tooltip" data-placement="left" title="Remove item" class="btn btn-simple">
										  <i class="material-icons">close</i>
									  </button>
								  </td>
								  <td class="td-name">
									  <a href="#jacket">Spring Jacket</a>
									  <br><small>by Dolce&amp;Gabbana</small>
								  </td>
								  <td>
									  Red
								  </td>
								  <td>
									  M
								  </td>
								  <td class="td-number">
									  <small>&#x20AC;</small>549
								  </td>
								  <td class="td-number">
									  1
									  <div class="btn-group">
										  <button class="btn btn-round btn-info btn-sm"> <i class="material-icons">remove</i> </button>
										  <button class="btn btn-round btn-info btn-sm"> <i class="material-icons">add</i> </button>
									  </div>
								  </td>
								  <td class="td-number">
									  <small>&#x20AC;</small>549
								  </td>
								  <td class="td-number">
									  <small>&#x20AC;</small>549
								  </td>
								  <td class="td-number">
									  <small>&#x20AC;</small>549
								  </td>
							  </tr>
						  </tbody>
					  </table>
					</div>
				</div>
			  </div>	
			</div>
			</div>
		</div>
		
    </section>
  </div>
</div>

<footer class="main-footer">
  <div class="pull-right hidden-xs">
    <b>Version</b> 2.3.8
  </div>
  <strong>Copyright &copy; 2019 PT Asuransi Wahana Tata</strong> All rights
  reserved.
</footer>
  
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <div class="tab-content">
      <div class="tab-pane" id="control-sidebar-home-tab"></div>
      <div class="tab-pane" id="control-sidebar-settings-tab"></div>
    </div>
  </aside>
  
  <div class="control-sidebar-bg"></div>

<script src="scripts/bootstrap/js/bootstrap.min.js"></script>
<script src="plugins/input-mask/jquery.inputmask.js"></script>
<script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<script src="plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="plugins/timepicker/bootstrap-timepicker.min.js"></script>
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="plugins/iCheck/icheck.min.js"></script>
<script src="plugins/fastclick/fastclick.js"></script>
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="js/dataTable.js"></script>
<script src="dist/js/app.min.js"></script>
<script src="dist/js/demo.js"></script>
<script src="dist/js/adminlte.min.js"></script>
<script>
	$(document).ready(function () {
		$('#dtHorizontalVerticalExample').DataTable({
		"scrollX": true,
		"scrollY": 400,
		});
	});
  </script>
</body>
</html>
