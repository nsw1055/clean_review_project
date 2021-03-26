const manList = ( function(){

	function sendList(paramObj){
	
		let fd = new FormData()
		
		fd.append("page", paramObj.page);
		fd.append("perSheet", paramObj.perSheet);			
		
		
		const queryString = new URLSearchParams(fd).toString();
		
	
		return fetch("/manager/listJson?" + queryString).then(res => res.json())
	}
	
	return {sendList:sendList}
	
})()

const manGetOne = (function(){

	function sendList(page , perSheet){
	
		return fetch("/manager/listJson/"+page+"/"+perSheet ,
		
		{ method : 'get'}
		
		)	
	}
	
	return {sendList:sendList}
	
})()

const manRead = (function(){

	function sendList(page , perSheet){
	
		return fetch("/manager/listJson/"+page+"/"+perSheet ,
		
		{ method : 'get'}
		
		)	
	}
	
	return {sendList:sendList}
	
})()