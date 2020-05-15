function openWebSocket(id) {
	var socket;
	if( typeof(WebSocket)==undefined ){
		alert("该浏览器不支持WebSocket通信...");
		return ;
	}
	socket = new WebSocket("ws://127.0.0.1:80/wk/" + id);
	
	socket.onopen = function(){
		console.log("socket已连接...");
	}
	
	socket.onclose = function(){
		console.log("socket已断开...");
	}
	
	socket.onerror = function(){
		console.log("socket访问失败...");
	}
	
	socket.onmessage = function(msg){
		if(msg.data == "100"){	//规定，响应100，为挤退信息
			alert("对不起，您已经在其他地方登录！若非本人操作，请及时修改密码！");
			location.href = "admin/loginout";
		}else{
			console.log(msg);
		}
	}
}