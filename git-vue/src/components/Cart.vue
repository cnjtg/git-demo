<template>
  <div>
    <h2>{{ title }}</h2>
    <table border="1">
      <tr>
        <th>#</th>
        <th>商品</th>
        <th>单价</th>
        <th>数量</th>
        <th>总价</th>
      </tr>
      <tbody>
      <tr v-for="(item,index) in goods" :key="item.id">
        <td><input type="checkbox" v-model="item.active"></td>
        <td>{{ item.title }}</td>
        <td>{{ item.price }}</td>
        <td>
          <button @click="sub(index)">-</button>
          {{ item.count }}
          <button @click="add(index)">+</button>
        </td>
        <td>{{ item.price * item.count }}</td>
      </tr>
      <tr>
        <td></td>
        <td colspan="2">{{ activeCount }}/{{ count }}</td>
        <td colspan="2">总价：{{ total }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'cart',
  props: ['title', 'good'],
  data() {
    return {
      goods: []
    }
  },
  created() {
    this.$bus.$on("addCart", good => {
      let res = this.goods.find(v => v.id === good.id);
      if (!res) {
        //MARK 需要用push方式把count和active值初始化
        this.goods.push({
          ...good,
          count:1,
          active: true
        })
      }else{
        res.count++;
      }
    });
  },
  watch:{
    cart:{
      handler(n,o){
        this.goods.setLocalData(n)
      },
      deep:true
    }
  },
  computed: {
    count() {
      return this.goods.length;
    },
    activeCount() {
      return this.goods.filter(v => v.active).length;
    },
    total() {
      //计算总价
      return this.goods.reduce((sum, c) => {
        if (c.active) {
          sum += c.price * c.count
        }
        return sum
      }, 0)
    }
  },
  methods: {
    remove(i) {
      if (window.confirm('确认删除该商品吗？')) {
        this.goods.splice(i, 1);
      }
    },
    add(i) {
      console.info(this.goods)
      this.goods[i].count++;
    },
    sub(i) {
      let count = this.goods[i].count;
      if (count > 1) {
        this.goods[i].count--;
      } else {
        this.remove(i);
      }
    },
    setLocalData(n){
      //TODO 存储购物车
      console.log(JSON.stringify(n))
    }
  },
}
</script>

<style scoped>
table {
  border: 1px solid #fff;
  width: 500px;
}

td {
  text-align: center;
}
</style>
