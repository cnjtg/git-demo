<template>
  <div>
    <slot></slot>
  </div>
</template>

<script>
// 1.声明props 获取数据模型(model)
export default {
  name: "Form",
  provide() {
    return {
      form: this
    }
  },
  props: {
    model: {
      type: Object,
      required: true
    },
    rules: {
      type: Object
    }
  }
}
</script>

<style scoped>

</style>
