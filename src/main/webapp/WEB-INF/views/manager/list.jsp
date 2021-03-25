<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/header.jsp"%>

<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-primary">
						<h4 class="card-title ">Simple Table</h4>
						<p class="card-category">Here is a subtitle for this table</p>

					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table">
								<thead class=" text-primary">
									<th>LOGO</th>
									<th>ID</th>
									<th>Email</th>
									<th>Phone</th>
									<th>Enabled</th>
				  					<th>Approval</th>
									<th>RegDate</th>
									<th>UpdateDate</th>
								</thead>
								<tbody class="tableList">
								</tbody>
							</table>

							<div>
								<select  class="custom-select">
									<option ${10 == pageDTO.perSheet ? "selected" : "" } value="10">10개씩 보기</option>
									<option ${20 == pageDTO.perSheet ? "selected" : "" } value="20">20개씩 보기</option>
									<option ${30 == pageDTO.perSheet ? "selected" : "" } value="30">30개씩 보기</option>
								</select>
							</div>

							<!-- pagination -->
							<div>
								<ul class="pagination justify-content-center">
									<c:if test="${pageMaker.prev}">
										<li class="page-item"><a class="page-link"
											href="${pageMaker.start -1}" tabindex="-1"
											aria-disabled="true">Previous</a></li>
									</c:if>
									<c:forEach begin="${pageMaker.start}" end="${pageMaker.end }"
										var="num">
										<li class="page-item ${num == pageDTO.page ? 'active' : ''}"><a
											class="page-link" href="${num }">${num }</a></li>

									</c:forEach>

									<c:if test="${pageMaker.next}">
										<li class="page-item"><a class="page-link"
											href="${pageMaker.end +1}">Next</a></li>
									</c:if>
								</ul>
							</div>

						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>


<form class="actionForm" action="/manager/list" method="get">
	<input type="hidden" name="page" value="${pageDTO.page}"> <input
		type="hidden" name="perSheet" value="${pageDTO.perSheet}">
</form>


<script type="text/javascript" src="/resources/service.js"></script>

<script>

const actionForm = document.querySelector(".actionForm")

// list

const tableList = document.querySelector(".tableList")



service.sendList(${pageDTO.page} , ${pageDTO.perSheet}).then(res => res.json()).then(result => {
	for (let resultElement of result) {
		
		tableList.innerHTML += "<tr><td><img src= '"+resultElement.logoImg+"'></td>" +
		"<td onclick='sendRead("+JSON.stringify(resultElement.mid)+")'>"+resultElement.mid+"</td>" +
		"<td>"+resultElement.email+"</td>" +
		"<td>"+resultElement.phone+"</td>" +
		"<td>"+resultElement.enabled+"</td>" +
		"<td>"+resultElement.approval+"</td>" +
		"<td>"+resultElement.regdate+"</td>" +
		"<td>"+resultElement.updatedate+"</td></tr>"
	}
	
})

// pagination

document.querySelector(".pagination").addEventListener("click" , function(e){
	
	e.preventDefault()
	
	const pageNum = e.target.getAttribute("href")
	
	console.log(pageNum)
	
	if(pageNum == null){
		return
	}
	
	document.querySelector("input[name='page']").value = pageNum
	
	actionForm.submit()
	
} , false)

// persheet

document.querySelector("select").addEventListener("change" , function(e){

	console.log(e.target.value)
	
	perSheetNum = e.target.value
	
	document.querySelector("input[name='perSheet']").value = perSheetNum
	
	actionForm.submit()
	
} , false)



</script>

<script>

function sendRead(param){
	
	console.log(param)
	
	self.location="/manager/read/"+param
}




</script>
<%@ include file="../includes/footer.jsp"%>