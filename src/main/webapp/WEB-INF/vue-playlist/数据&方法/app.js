// 实例化vue对象
new Vue({
	el:"#vue-app",
	data:{
		name:"墨玉麒麟",
		job:"boot"
	},
	methods:{
		greet:function(name){
			return "Good Morning"+name+"和"+this.name+"!";
		}
    }
});

/*
 * el:element 需要获取的元素，一定是html中的根容器元素
 * data: 用于数据存储
 * methods: 用于储存各种方法
 */