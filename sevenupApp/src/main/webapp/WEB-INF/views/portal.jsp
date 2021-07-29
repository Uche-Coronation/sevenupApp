<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" />
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<title>portal</title>
</head>
<body>
<div align="center">
<div align="right">
<p><a href="${pageContext.request.contextPath }/portal/logout"> Logout </a></p>
</div>
<h2>Payment Details</h2>
<table id="paymentDetails" class="table table-striped">
<thead>
<tr>
<td>Dealer Code</td>
<td>Dealer Name</td>
<td>Amount</td>
<td>Commission</td>
<td>Balance</td>
<td>Teller Number</td>
<td>Payment Mode</td>
<td>Trans Date</td>
<td>Value Date</td>
<td>Branch</td>
<td>Status</td>
<td>Payment Reference</td>
<td>Customer Region Code</td>
<td>Customer Region Name</td>
<td>Action</td>
</tr>
</thead>
<tfoot>
<tr>
<td>Dealer Code</td>
<td>Dealer Name</td>
<td>Amount</td>
<td>Commission</td>
<td>Balance</td>
<td>Teller Number</td>
<td>Payment Mode</td>
<td>Trans Date</td>
<td>Value Date</td>
<td>Branch</td>
<td>Status</td>
<td>Payment Reference</td>
<td>Customer Region Code</td>
<td>Customer Region Name</td>
<td>Action</td>
</tr>
</tfoot>
</table>
</div>
<script type="text/javascript">
var base_url = '<%= request.getContextPath() %>';
var region = '<%= session.getAttribute("region")%>';
	$(document).ready( function () {
		
		$('#paymentDetails tfoot th').not(":eq(14)").each(function () {
			var title = $(this).text();
			$(this).html('<input type="text" placeholder="Filter ' + title + '" />');
			});
		
		 var table = $('#paymentDetails').DataTable({
			"sAjaxSource": base_url + "/portal/getPaymentDetails",
			"sAjaxDataProp": "",
			"order": [[ 5, "desc" ]],
			"columns": [
				{ "data": "dealerCode"},
				{ "data": "dealerName"},
				{ "data": "amount"},
				{ "data": "commission"},
				{ "data": "balance"},
				{ "data": "tellerNumber"},
				{ "data": "paymentMode"},
				{ "data": "transDate"},
				{ "data": "valueDate"},
				{ "data": "branch"},
				{ "data": "status"},
				{ "data": "paymentReference"},
				{ "data": "customerRegionCode"},
				{ "data": "customerRegionName"},
				//{ defaultContent: "<a href='javascript:void(0);'  onclick=\"+ confirmNotification('"+ this +"')\">Confirm Notification</a>"}
				{"data": "paymentReference",
                    "render": function ( data, type, row, meta ) { 
                        return '<button data-id="'+data+'" onclick="confirmNotification(event)">Confirm Notification</button>'
                        } }
			]
		 });
		 
		// Apply the search
		 table.columns().every(function () {
		 var that = this;

		  $('input', this.footer()).on('keyup change', function () {
		 if (that.search() !== this.value) {
		 that
		 .search(this.value)
		 .draw();
		 }
		 });
		 });
		 
	 });
	//<a title='View User Issues' href='javascript:void(0);' class='fe fe-eye fe-lg' onclick=\"+ viewAllIssue('"+t.getById()+"')\"></a>
		// $('#paymentDetails').on('click', '.notify', function () {
			function confirmNotification(e){
			 console.log("Inside onclick function " + region);
			 var id = e.target.getAttribute('data-id')
			 if(region === "national"){
				 $.ajax({
				        type: 'GET',	        
				        url: base_url+'/portal/confirm/'+id,
				        data: 'id='+id,
				        beforeSend: function () { 
				            $('.loading-overlay').show();
				        },
				        success:function(data){ 
				        	alert("Status Updated");
				        	location.reload(true);     
				        }
				    });
			  console.log("Notification Updated");
		 }else{
			 console.log("User not allowed to confirm a notification");
			 alert("User not allowed to confirm a notification");
		 }
			}
		// });
	</script>
</body>
</html>