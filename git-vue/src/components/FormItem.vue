<template>
  <div>

    <label v-if="label">{{label}}</label>
    <!-- 插槽作用 放入Input组件 -->
    <slot></slot>
    <!-- 显示错误信息 -->
    <p v-if="validateStatus === 'error'" class="error">{{errorMessage}}</p>
<!--    <m-input v-model="formData.username"></m-input>-->

<!--    <m-input type="password" v-model="formData.password"></m-input>-->

  </div>
</template>

<script>
import schema from 'async-validator';
//0、label 和 prop属性
//1、获取当前输入框的规则
//2、如果输入框和rule不匹配 显示错误信息
//3、Input组件中输入内容时，通知FormItem做校验
//4、使用async-validator 做校验
export default {
  name: "FormItem",
  components: {
    schema
  },
  data() {
    return {
      validateStatus:'',
      errorMessage:'',
    }
  },
  props: {
    label: {
      type: String,
      default: ""
    },
    prop: {
      type: String,
      default: ''
    }
  },
  inject:["form"],
  methods:{
    validate(val){
      console.info(val)
      // let descriptor  = {};
      // //获取校验对象
      // descriptor[this.prop] = this.form.rules[this.prop];
      const descriptor = {[this.prop]:this.form.rules[this.prop]}

      const validator = new schema(descriptor);
      let obj  = {};
      obj[this.prop] = val;
      validator.validate({[this.prop]:val},error=>{
        if(error){
          this.validateStatus = 'error';
          this.errorMessage = error[0].message;
        }else{
          this.validateStatus = '';
          this.errorMessage = '';
        }
      })
    }
  },
  created() {
    this.$on("validate",this.validate)
  }
}
</script>

<style scoped>
.error{
  color: red;
}
</style>
