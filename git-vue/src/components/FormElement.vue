<template>
<div>
  {{formData}}
  <m-form :model = "formData" :rules="rules" >


  </m-form>
  <m-form-item label="用户名" prop="username">
    <m-input v-model="formData.username" />
  </m-form-item>
  <m-form-item label="密码" prop="password">
    <m-input type="password" v-model="formData.password" />
  </m-form-item>
</div>
</template>

<script>
import MFormItem from './FormItem';
import MInput from './Input'
import  MForm from  "./Form"
export default {
  name: "FormElement",
  components: {
    MFormItem, MInput,MForm
  },
  data() {
    return {
      formData:{
        username:'',
        password:'',
      },
      rules:{

      }
    }
  },
}
</script>

<style scoped>

</style>
