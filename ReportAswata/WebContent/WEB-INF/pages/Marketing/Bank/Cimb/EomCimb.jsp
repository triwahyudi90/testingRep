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
  <title>Dashboard</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="scripts/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.css">
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="dist/css/component/bootstrap-datepicker/bootstrap-datepicker.min.css">
  <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
  
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Iterator" %>

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
<%--           <p>${userlogin}</p> --%>
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
        <li class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i> <span>Marketing</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="treeview">
              <a href="#"><i class="fa fa-circle-o"></i> Bank
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
              	<li><a href="#"><i class="fa fa-circle-o"></i>ALL BANK</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>BCA</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>BNI</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>BRI</a></li>
                <li><a href="cimb.do"><i class="fa fa-circle-o"></i>CIMB Niaga</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>Mandiri</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>Maybank</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>Permata</a></li>
                <li class="treeview">
                  <a href="#"><i class="fa fa-circle-o"></i> UOB Buana
                    <span class="pull-right-container">
                      <i class="fa fa-angle-left pull-right"></i>
                    </span>
                  </a>
                  <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i> Max 1 Tahun</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> Lebih dari 1 Tahun</a></li>
                  </ul>
                </li>
              </ul>
            </li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Charts</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> ChartJS</a></li>
            <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> Morris</a></li>
            <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
            <li><a href="pages/charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li>
          </ul>
        </li>
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
        Report Marketing
        <small>Preview</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Marketing</a></li>
        <li><a href="#">Bank</a></li>
        <li class="active">Cimb Niaga</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
    	<div class="box">
    		<div class="box-header with-border">
	        	<h3 class="box-title">Report CIMB Niaga</h3>
	        	<div class="box-tools pull-right">
	            	<button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
	              	<i class="fa fa-minus"></i></button>
	          	</div>
	        </div>
	        <div class="box-body">
<!-- 	        	<form action="viewRepCimbAct.do" method="POST" name="jurnal"> -->
	        	<form action="EomCimbAct.do" method="POST" name="jurnal">
	          	<div class="col-xs-2">
		    		<label>Dari Tanggal</label>
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
	    		<div class="col-xs-2">
		    		<label>Pilih Bank</label>
	    		</div>
	    		<div class="col-xs-3">
	    			<select name = "bank" class="form-control select2" style="width: 100%;">
                  		<option selected="selected">ALL BANK</option>
                  		<option>BCA</option>
                  		<option>BNI</option>
		                <option>BRI</option>
		                <option>CIMB NIAGA</option>
		                <option>MAYBANK</option>
		                <option>MANDIRI</option>
		                <option>PERMATA</option>
	                </select>
	    		</div>
	    		
	    		<br><br>
				<div class="col-xs-5">
					<button class="btn btn-default" type="button" data-dismiss="modal" onclick="document.forms['jurnal'].submit(); return valdata();">Search</button>
	        	</div>
	        	</form>
	        </div>
    	</div> 
    		
    	<div class="box">
    		<div class="box-header with-border">
	          <h3 class="box-title">Data Produksi Bank CIMB Niaga</h3>
	          	<div class="box-tools pull-right">
	           		<button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip">
	             		<i class="fa fa-minus"></i>
	             	</button>
	         	</div>
	        </div>
	        <div class="box-body">
	        	<table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
					  <thead>
						  <tr>
							  <th>NO</th>
							  <th>PERIODE</th>
							  <th>FILENAME</th>
							  <th>DESCRIPTION</th>
							  <th>DOWNLOAD</th>
						  </tr>
					  </thead>
					  <tbody>
					  	  <c:set var="inc" value="0" />
						  <c:forEach var="fn" items="${fn}" >
						  		<tr>
						  			<c:set var="inc" value="${inc + 1}" />
									<td>${inc}</td>
									<td>${fn.periode}</td>
									<td>${fn.filename}</td>
									<td>${fn.desc}</td>
									<td ><a href="/ReportAswata/downloadRptCimb.do?filename=${fn.filename}">Download</a></td>
						  		</tr>
						  </c:forEach>
					  </tbody>
				  </table>
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
<script src="dist/js/component/bootstrap-datepicker.min.js"></script>

<script src="dist/js/demo.js"></script>
<script>
	$(document).ready(function () {
		$('#dtHorizontalVerticalExample').DataTable({
		"scrollX": true
		});
		$('.dataTables_length').addClass('bs-select');
		});
	
	$(function () {
	    //Date picker
	    $('#datepicker').datepicker({
	    	format: "yyyymm",
	        startView: "months",
	        minViewMode: "months",
	        endDate: "0m"
	    })
	    $('#datepicker1').datepicker({
	    	format: "yyyymm",
	        startView: "months",
	        minViewMode: "months",
	        endDate: "0m"
	    })
	    
	  })
</script>
</body>
</html>