/**
 * 检查登录
 */
let login_info = new Vue({
	el: "#login_info",
	data: {
		nickName: ''
	},
	mounted: function(){
		axios.get("member/check",{ params:{} }).then(res => {
			if(res.data.code == 200){
				this.nickName = res.data.data.nickName;
				console.log(this.nickName);
			}else{
				this.nickName = '';
			}
		});
	}
});