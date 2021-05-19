<template>
  <div>
    <ul>
      <li v-for="(item,index) in goods" :key="item.id">
        {{ index + 1 }}、{{ item.title }} ￥{{ item.price }}
        <el-button type="success" @click="addCart(index)">添加购物车</el-button>
      </li>
    </ul>
    <Cart :good="goods"></Cart>
  </div>
</template>


<script>
import Cart from '@/components/Cart';

export default {
  name: "App",
  components: {
    Cart
  }, data() {
    return {
      goods: [],
      title: '电脑商城'
    }
  },
  async created() {
    this.$http.get("/good/list").then(res => {
      this.goods = res.data.data;
    }).catch(err => {
      console.log(err)
    })
  },
  methods:{
    addCart: function(index){
      this.$bus.$emit("addCart", this.goods[index])
    }
  }
}
</script>


<style scoped>
.logo {
  width: 100px;
  height: 100px;
}

p {
  background-color: aliceblue;
}
</style>
