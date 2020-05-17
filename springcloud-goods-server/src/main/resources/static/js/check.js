/**
 * 检查登录
 */
let login_info = new Vue({
	el: "#login_info",
	data: {
		nickName:'',
		goodsCount: 0,
		loginId:"",
		carts:{},
	},
	mounted: function(){
		axios.get("member/check", {params:{}}).then(result => {
			if(result.data.code == 200) {
				this.nickName = result.data.data.member.nickName;
				this.loginId = result.data.data.member.mno;
				if (result.data.data.carts) { 
					this.carts = result.data.data.carts;
					this.goodsCount = result.data.data.carts.length;
				}
			} else {
				this.nickName == '';
			}
		})  
	}
})