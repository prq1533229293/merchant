new Vue({
    el:"#vue-app",
    data:{
        src:"../../../../resources/static/imgs/初始图.png",
        HP:100
    },
    methods:{
        sleep: function(time){
            var now = new Date();
            var exitTime = now.getTime() + time;
            while (true) {
                now = new Date();
                if (now.getTime() > exitTime)
                return;
            }
        },
        attack:function(number) {
            if(this.HP <= 0){
                console.log(this.HP);
            }else{
                this.HP = this.HP - number;
                console.log(this.HP);
            }

            if(this.HP > 0){
                this.src = "../../../../resources/static/imgs/攻击图.gif";
            }
            if(this.HP <= 0){
                this.src = "../../../../resources/static/imgs/击杀图.gif";
            }
        },
        reset:function(){
            this.HP = 100;
            this.src = "../../../../resources/static/imgs/初始图.png";
        }


    },
    computed:{

    }

});