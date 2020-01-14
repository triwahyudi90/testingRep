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

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Dashboard || Risk Profile</title>
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
      <span class="logo-mini"><b>AWT</b></span>
      <span class="logo-lg"><b>Report Aswata</b></span>
    </a>
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
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
        Data Risk Profile
        <small>Preview</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
        <li class="active">Risk Profile</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
    	<div class="box">
    		<div class="box-header with-border">
	        	<h3 class="box-title">Data Risk Profile</h3>
	        	<div class="box-tools pull-right">
	            	<button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
	              	<i class="fa fa-minus"></i></button>
	          	</div>
	        </div>
	        <div class="box-body">
	        	<form action="riskProfileAct.do" method="POST" name="jurnal">
		        	<div class="col-xs-2">
			    		<label>Branch Name</label>
		    		</div>
		    		<div class="col-xs-3">
		    			<select name = "branch" class="form-control select2" style="width: 100%;">
		    				<c:forEach var="branch" items="${branch}" >
		    					<option selected="selected" value ="${branch.branchId}">${branch.branchName}</option>
		    				</c:forEach>
		                </select>
		    		</div>
		    		<br><br>
		        	<div class="col-xs-2">
			    		<label>COB</label>
		    		</div>
		    		<div class="col-xs-3">
		    			<select name = "bsn" class="form-control select2" style="width: 100%;">
		    				<c:forEach var="bsn" items="${bsn}" >
		    					<option selected="selected" value ="${bsn.bsnId}">${bsn.cob}</option>
		    				</c:forEach>
		                </select>
		    		</div>
		        	<br><br>
		        	<div class="col-xs-2">
			    		<label>AS AT</label>
		    		</div>
		    		<div class="col-xs-3">
		    			<div class="input-group date">
		                  <div class="input-group-addon">
		                    <i class="fa fa-calendar"></i>
		                  </div>
		                  <input name="asat" type="text" class="form-control pull-right" id="datepicker">
		                </div>
		    		</div>
		    		<br><br>
		    		<div class="col-xs-2">
			    		<label>UW YEAR</label>
		    		</div>
		    		<div class="col-xs-3">
		    			<select name = "uwyear" class="form-control select2" style="width: 100%;">
		    				<c:forEach var = "i" begin = "2012" end = "2025">
		    					<option>
		    						<c:out value = "${i}"/>
		    					</option>
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
	          <h3 class="box-title">Data Risk Profile Tes</h3>
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
							  <th>BRANCH</th>
							  <th>POLICY NUMBER</th>
							  <th>BSN</th>
							  <th>REQ TYPE</th>
							  <th>REQ NAME</th>
							  <th>REQ PARENT</th>
							  <th>TRANSACTION DATE</th>
							  <th>START DATE</th>
							  <th>EXPIRY DATE</th>
							  <th>UR AMOUNT</th>
							  <th>ANR AMOUNT</th>
							  <th>GR AMOUNT</th>
							  <th>ACC MONTH</th>
							  <th>ACC YEAR</th>
							  <th>BUSINESS CODE</th>
							  <th>INSURED NAME</th>
							  <th>SEGMENT</th>
							  <th>TSI</th>
							  <th>PREMI</th>
							  <th>PREMI NETT</th>
							  <th>PREMI GROSS</th>
							  <th>SETTLED AMOUNT</th>
							  <th>CLAIM AMOUNT</th>
							  <th>EARNED PREMI</th>
							  <th>EARNED PREMI NETT</th>
							  <th>EARNED PREMI GROSS</th>
						  </tr>
					  </thead>
					  <tbody>
					  	  <c:set var="inc" value="0" />
						  <c:forEach var="lph" items="${lph}" >
						  		<tr>
						  			<c:set var="inc" value="${inc + 1}" />
									<td>${lph.regional}</td>
									<td>${lph.branch}</td>
									<td>${lph.policyNo}</td>
									<td>${lph.reqType}</td>
									<td>${lph.reqName}</td>
									<td>${lph.reqParent}</td>
									<td>${lph.transactionDate}</td>
									<td>${lph.regional}</td>
									<td>${lph.startDate}</td>
									<td>${lph.expiryDate}</td>
									<td>${lph.urAmt}</td>
									<td>${lph.anrAmt}</td>
									<td>${lph.grAmt}</td>
									<td>${lph.accMonth}</td>
									<td>${lph.accYear}</td>
									<td>${lph.busCode}</td>
									<td>${lph.insName}</td>
									<td>${lph.segment}</td>
									<td>${lph.tsi}</td>
									<td>${lph.premi}</td>
									<td>${lph.premiNett}</td>
									<td>${lph.premiGross}</td>
									<td>${lph.settledAmt}</td>
									<td>${lph.claimAmt}</td>
									<td>${lph.earnedPremi}</td>
									<td>${lph.earnedPremiNett}</td>
									<td>${lph.earnedPremiGross}</td>
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

<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- date-range-picker -->
<script src="bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
<script src="dist/js/demo.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>


<script>
  $(document).ready(function(){
	var table = $('#example2').DataTable({
        scrollX:        true,
        scrollCollapse: true,
		paging		: true,
		searching	: true,
		info	: true
	});
	new $.fn.dataTable.FixedColumns( table );
	});
  
  
  $(function(){
	  $('#datepicker').datepicker({
		    format: "yyyymm",
		    startView: "months",
		    minViewMode: "months",
		    endDate: "0m"
	    });
	  $('#datepicker1').datepicker({
		  format: "yyyymm",
		    startView: "months",
		    minViewMode: "months",
		    endDate: "0m"
	    });
  })
</script>
</body>
</html>