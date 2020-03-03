// 实例化vue对象
new Vue({
	el:"#vue-app",
	data:{
        a:0,
        b:0
	},
	methods:{

	},
    computed:{
	    addToA:function(){
	        console.log("Add to A");
	        return this.a + this.age;
        },
        addToB:function(){
	        console.log("Add to B");
	        return this.b + this.age;
        }
    }
});

/*
 * el:element 需要获取的元素，一定是html中的根容器元素
 * data: 用于数据存储
 * methods: 用于储存各种方法
 * data-binding: 给属性绑定对应的值
 */