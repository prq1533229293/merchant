// 实例化vue对象
new Vue({
	el:"#vue-app",
	data:{
		name:"墨玉麒麟",
		age:18,
		job:"boot"
	},
	methods:{
        enter:function(){
            console.log("按下了回车键");
        },
        del:function(){
		    console.log("按下了删除键");
        },
		logName:function(){
		    console.log("按下了键盘");
			this.name = this.$refs.name.value;
		},
		logAge:function(){
		    console.log("松开了键盘");
			this.age = this.$refs.age.value;
		}
	}
});

/*
 * el:element 需要获取的元素，一定是html中的根容器元素
 * data: 用于数据存储
 * methods: 用于储存各种方法
 * data-binding: 给属性绑定对应的值
 */