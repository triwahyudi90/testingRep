<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Maybank</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
 
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="bower_components/bootstrap-daterangepicker/daterangepicker.css">
  <link rel="stylesheet" href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
  <link rel="stylesheet" href="bower_components/datatables.net-bs/css/fixedColumn.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.aswata.report.entity.Role" %>
<%@ page import="com.aswata.report.entity.RoleMenu" %>
<%@ page import="com.aswata.report.entity.RoleSubMenu" %>

<body class="hold-transition skin-blue sidebar-mini">
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
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MAIN NAVIGATION</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../../index.html"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
            <li><a href="../../index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
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
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <section class="content-header">
      <h1>
        Data Produksi
        <small>Bank Maybank</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Marketing</a></li>
        <li><a href="#">Produksi</a></li>
        <li class="active">Maybank</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
	
	<div class="box">
   		<div class="box-header with-border">
        	<h3 class="box-title">Report Bank Maybank</h3>
        	<div class="box-tools pull-right">
            	<button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              	<i class="fa fa-minus"></i></button>
          	</div>
        </div>
        <div class="box-body">
        	<form action="maybankAct.do" method="POST" name="jurnal">
	          	<div class="col-xs-2">
		    		<label>Dari Tanggal </label>
	    		</div>
	    		<div class="col-xs-3">
	    			<div class="input-group date">
	                  <div class="input-group-addon">
	                    <i class="fa fa-calendar"></i>
	                  </div>
	                  <input name="dt1" type="text" class="form-control pull-right" id="datepicker">
	                </div>
	    		</div>
	    		<br><br>
	    		<div class="col-xs-2">
		    		<label>Hingga Tanggal </label>
	    		</div>
	    		<div class="col-xs-3">
	    			<div class="input-group date">
	                  <div class="input-group-addon">
	                    <i class="fa fa-calendar"></i>
	                  </div>
	                  <input name="dt2" type="text" class="form-control pull-right" id="datepicker1">
	                </div>
	    		</div>
	    		<br><br>	
				<div class="col-xs-5">
					<button class="btn btn-default" type="button" data-dismiss="modal" onclick="document.forms['jurnal'].submit(); return valdata();">Search</button>
<!-- 		        		<button onclick="exportToExcel('dtHorizontalVerticalExample', 'Testing Excel')" class="btn btn-success">Export Table Data To Excel File</button> -->
	        	</div>
        	</form>
        </div>
		<div class="box">
    		<div class="box-header with-border">
	          <h3 class="box-title">Data Produksi Bank Maybank</h3>
	          	<div class="box-tools pull-right">
	           		<button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip">
	             		<i class="fa fa-minus"></i>
	             	</button>
	         	</div>
	        </div>
	        <div class="box-body">
	        	<table id="example2" class="table table-shopping" cellspacing="0" width="100%">
					<thead>
						  <tr>
						  	  <th>NO</th>
							  <th>TRANSACTION DATE</th>
							  <th>POLICY NO</th>
							  <th>BRANCH</th>
							  <th>BSN</th>
							  <th>REQ NAME</th>
							  <th>QQ</th>
							  <th>START DATE</th>
							  <th>END DATE</th>
							  <th>PREMI GROSS</th>
							  <th>MATERAI</th>
							  <th>ADM</th>
							  <th>KOMISI</th>
							  <th>JASA</th>
							  <th>PREMI NETT</th>
						  </tr>
					  </thead>
					  <tbody>
					  	  <c:set var="inc" value="0" />
						  <c:forEach var="lph" items="${lph}" >
						  		<tr>
						  			<c:set var="inc" value="${inc + 1}" />
									<td>${inc}</td>
									<td>${lph.transactionDate}</td>
									<td>${lph.policyNo}</td>
									<td>${lph.branch}</td>
									<td>${lph.cob}</td>
									<td>${lph.reqName}</td>
									<td>${lph.qq}</td>
									<td>${lph.startDate}</td>
									<td>${lph.endDate}</td>
									<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.premiGross}" /></td>
									<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.stmp}" /></td>
									<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.cPol}" /></td>
									<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.comm}" /></td>
									<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.jasa}" /></td>
									<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.premiNett}" /></td>
						  		</tr>
						  </c:forEach>
					  </tbody>
              	</table>
	        </div>
    	</div>
    </div>
	</section>
</div>
<footer class="main-footer">
  <div class="pull-right hidden-xs">
    <b>Version</b> 1.0.1
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

<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="bower_components/select2/dist/js/select2.full.min.js"></script>
<script src="bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.colVis.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.print.min.js"></script>
<script src="dist/js/demo.js"></script>
<script>
	$(document).ready(function () {
		$('#example2').DataTable({
			scrollX:        true,
	        scrollCollapse: true,
			paging		: true,
			searching	: true,
			info	: true,
// 		"scrollX": true,
//		"scrollY": 600
		});
// 		$('.dataTables_length').addClass('bs-select');
		
	});
	$(function () {
	    //Date picker
	    $('#datepicker').datepicker({
	      format: 'dd/mm/yyyy',
	      autoclose: true
	    })
	    
	    $('#datepicker1').datepicker({
	      format: 'dd/mm/yyyy',
	      autoclose: true
	    })
	  })
  </script>

</body>
</html>
