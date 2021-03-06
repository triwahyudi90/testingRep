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
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Claim</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="bower_components/bootstrap-daterangepicker/daterangepicker.css">
  <link rel="stylesheet" href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="bower_components/datatables.net-bs/css/fixedColumn.css">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">  
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.aswata.report.entity.Role" %>
<%@ page import="com.aswata.report.entity.RoleMenu" %>
<%@ page import="com.aswata.report.entity.RoleSubMenu" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="../../index2.html" class="logo">
      <span class="logo-mini"><b>AWT</b></span>
      <span class="logo-lg"><b>Report Aswata</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
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
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Data Tables
        <small>advanced tables</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Claim</a></li>
        <li><a href="#">Agent & Retail</a></li>
        <li class="active">Produksi</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
	    <div class="box">
    		<div class="box-header with-border">
	        	<h3 class="box-title">Report Data Produksi Agent & Retail</h3>
	        	<div class="box-tools pull-right">
	            	<button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
	              	<i class="fa fa-minus"></i></button>
	          	</div>
	        </div>
	        <div class="box-body">
	        	<form action="prodClaimAct.do" method="POST" name="jurnal">
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
		    		<div class="col-xs-2">
			    		<label>COB</label>
		    		</div>
		    		<div class="col-xs-3">
		    			<select name = "cob" class="form-control select2" style="width: 100%;">
		    				<c:forEach var="bsn" items="${bsn}" >
		    					<option selected="selected" value ="${bsn.bsnId}">${bsn.cob}</option>
		    				</c:forEach>
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
	          <h3 class="box-title">Data Produksi Agent & Retail</h3>
	          	<div class="box-tools pull-right">
	           		<button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip">
	             		<i class="fa fa-minus"></i>
	             	</button>
	         	</div>
	        </div>
	        <div class="box-body">
	        	<table id="example2" class="table table-bordered table-hover" width="100%">
					<thead>
						  <tr>
			                  <th>REGIONAL</th>
			                  <th>BRANCH NAME</th>
			                  <th>POLICY NUMBER</th>
			                  <th>REQ TYPE</th>
			                  <th>BUSINESS TYPE</th>
			                  <th>BUSINESS CODE</th>
			                  <th>SEGMENT</th>
			                  <th>REQ NAME</th>
			                  <th>INSURED NAME</th>
			                  <th>TRANSACTION DATE</th>
			                  <th>START DATE</th>
			                  <th>EXPIRY DATE</th>
			                  <th>SHARE ASWATA</th>
			                  <th>TSI</th>
			                  <th>PREMI NETT</th>
			                  <th>DISCOUNT</th>
			                  <th>STAMP</th>
			                  <th>FEE ADM</th>
			                  <th>COMMISION</th>
			                  <th>PREMI MARKETING</th>
						  </tr>
					  </thead>
					  <tbody>
						  <c:forEach var="lph" items="${lph}" >
					  		<tr>
								<td>${lph.policyNo}</td>
								<td>${lph.branchName}</td>
								<td>${lph.regName}</td>
								<td>${lph.reqType}</td>
								<td>${lph.busType}</td>
								<td>${lph.busCode}</td>
								<td>${lph.segment}</td>
								<td>${lph.reqName}</td>
								<td>${lph.insName}</td>
								<td>${lph.trDate}</td>
								<td>${lph.startDate}</td>
								<td>${lph.expiryDate}</td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.shareAswata}" /></td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.tsi}" /></td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.premiNett}" /></td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.disc}" /></td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.stamp}" /></td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.adm}" /></td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.comm}" /></td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${lph.premiMarketing}" /></td>
					  		</tr>
					  </c:forEach>
					  </tbody>
              	</table>
	        </div>
    	</div>
    
      
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
	  <div class="pull-right hidden-xs">
	    <b>Version</b> 2.3.8
	  </div>
	  <strong>Copyright &copy; 2019 PT Asuransi Wahana Tata</strong> All rights
	  reserved.
  </footer>

  <!-- Control Sidebar -->
  
</div>

<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="bower_components/select2/dist/js/select2.full.min.js"></script>
<script src="plugins/input-mask/jquery.inputmask.js"></script>
<script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
<script src="dist/js/demo.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.colVis.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.print.min.js"></script>

<script>
  $(document).ready(function(){
	var table = $('#example2').DataTable({
        scrollX:        true,
        scrollCollapse: true,
		paging		: true,
		searching	: true,
		info	: true,
		dom: 'Bfrtip',
        buttons: [
            {
                extend: 'copyHtml5',
                exportOptions: {
                    columns: [ 0, ':visible' ]
                }
            },
            {
                extend: 'excelHtml5',
                exportOptions: {
                    columns: ':visible'
                },
				title: 'Download'
            },
            {
				extend: 'colvis',
				collectionLayout: 'fixed two-column'
			}
        ]
	});
	new $.fn.dataTable.FixedColumns( table );
	});
  
  
  $(function(){
	  $('#datepicker').datepicker({
	      autoclose: true
	    });
	  $('#datepicker1').datepicker({
	      autoclose: true
	    });
  })
</script>

</body>
</html>
