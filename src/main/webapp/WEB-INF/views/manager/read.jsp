<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/header.jsp"%>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header card-header-primary">
						<h4 class="card-title">Edit Profile</h4>
						<p class="card-category">Complete your profile</p>
					</div>
					<div class="card-body">
						<form>
							<div class="row">
								<div class="col-md-5">
									<div class="form-group">
										<label class="bmd-label-floating">Company (disabled)</label> <input
											type="text" class="form-control" disabled>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="bmd-label-floating">UserID</label> <input
											type="text" class="form-control" readonly="readonly" value ="user147">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="bmd-label-floating">Email address</label> 
										<input type="email" class="form-control" readonly="readonly" value=asd@asda.com>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="bmd-label-floating">Fist Name</label> <input
											type="text" class="form-control" readonly="readonly" value ="user147">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="bmd-label-floating">Last Name</label> <input
											type="text" class="form-control">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="bmd-label-floating">Adress</label> <input
											type="text" class="form-control">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label class="bmd-label-floating">City</label> <input
											type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="bmd-label-floating">Country</label> <input
											type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="bmd-label-floating">Postal Code</label> <input
											type="text" class="form-control">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label>About Me</label>
										<div class="form-group">
											<label class="bmd-label-floating"> Lamborghini Mercy,
												Your chick she so thirsty, I'm in that two seat Lambo.</label>
											<textarea class="form-control" rows="5"></textarea>
										</div>
									</div>
								</div>
							</div>
							<button type="submit" class="btn btn-primary pull-right">Update
								Profile</button>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card card-profile">
					<div class="card-avatar">
						<a href="javascript:;"> <img class="img"
							src="/resources/assets/img/faces/marc.jpg" />
						</a>
					</div>
					<div class="card-body">
						<h6 class="card-category text-gray">CEO / Co-Founder</h6>
						<h4 class="card-title">Alec Thompson</h4>
						<p class="card-description">Don't be scared of the truth
							because we need to restart the human foundation in truth And I
							love you like Kanye loves Kanye I love Rick Owens’ bed design but
							the back is...</p>
						<a href="javascript:;" class="btn btn-primary btn-round">Follow</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script>
manList.sendList(${pageDTO.page} , ${pageDTO.perSheet}).then(res => res.json()).then(result => {
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
</script>

<%@ include file="../includes/footer.jsp"%>