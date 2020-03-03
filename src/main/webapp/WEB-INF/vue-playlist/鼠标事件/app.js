// 实例化vue对象
new Vue({
	el:"#vue-app",
	data:{
		name:"墨玉麒麟",
		age:18,
		job:"boot",
		x:0,
		y:0
	},
	methods:{

		add:function(inc){
			//年龄值加等
			this.age += inc;
		},
		substract:function(dec){
			//年龄值减等
			this.age -= dec;
		},
		updateXY:function(event){
			//console.log(event);
			//设置鼠标x，y坐标
			this.x = event.offsetX;
			this.y = event.offsetY;
		},
		StopMoving:function(event){
			//停止冒泡事件
			event.stopPropagation();
		},
		alert:function(){
			alert("Hello World");

		}
	}
});

/*
 * el:element 需要获取的元素，一定是html中的根容器元素
 * data: 用于数据存储
 * methods: 用于储存各种方法
 * data-binding: 给属性绑定对应的值
 */