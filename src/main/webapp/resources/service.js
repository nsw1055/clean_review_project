const service = (function(){

	function sendList(page , perSheet){
	
		return fetch("/manager/listJson/"+page+"/"+perSheet ,
		
		{ method : 'get'}
		
		)	
	}
	
	return {sendList:sendList}
	
})()