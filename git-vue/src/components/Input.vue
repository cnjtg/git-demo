<template>
  <div>
    <input :type="type" :value="inputValue" @input="handleInput" />
  </div>
</template>

<script>
export default {
  name: "Input",
  props: {
    type: {
      type: String,
      default: 'text',
    }
  },
  data(){
    return {
      inputValue:this.value
    }
  },
  methods:{
    handleInput: function(e){
      //赋值
      this.inputValue = e.target.value;
      //通知父组件
      this.$emit("input",this.inputValue);
      //通知父组件值进行更新验证
      this.$parent.$emit("validate",this.inputValue);
    }
  }
}
</script>

<style scoped>

</style>
