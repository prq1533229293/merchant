// 实例化vue对象
new Vue({
	el:"#vue-app",
	data:{
		test:false,
        changeColor:false,
        changeLength:false
	},
	methods:{

	},
	// 计算属性
    computed:{
		compClasses:function(){
			return{
				changeColor:this.changeColor,
				changeLength:this.changeLength
			}
		}
    }
});

/*
 * el:element 需要获取的元素，一定是html中的根容器元素
 * data: 用于数据存储
 * methods: 用于储存各种方法
 * data-binding: 给属性绑定对应的值
 */